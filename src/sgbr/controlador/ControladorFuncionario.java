package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.sql.DAOFuncionario;
import sgbr.regras.funcionario.RNAlterarFuncionario;
import sgbr.regras.funcionario.RNConsultarDadosFuncionario;
import sgbr.regras.funcionario.RNExcluirFuncionario;
import sgbr.regras.funcionario.RNIncluirFuncionario;
import sgbr.util.OTDFuncionario;

/**
 * @author Reinaldo
 *
 */
public class ControladorFuncionario {

	private static ControladorFuncionario aControladorFuncionario = new ControladorFuncionario();

	/**
	 * Cria um novo objeto ControladorFuncionario.
	 */
	private ControladorFuncionario() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorFuncionario getInstancia() {
		if (ControladorFuncionario.aControladorFuncionario == null) {
			ControladorFuncionario.aControladorFuncionario = new ControladorFuncionario();
		}

		return ControladorFuncionario.aControladorFuncionario;
	}

	public void incluirFuncionario(OTDFuncionario pOTDFuncionario) {

		RNIncluirFuncionario.getInstancia().processar(pOTDFuncionario);

	}

	public void alterarFuncionario(OTDFuncionario pOTDFuncionario) {
		RNAlterarFuncionario.getInstancia().processar(pOTDFuncionario);

	}

	public void excluirFuncionario(OTDFuncionario pOTDFuncionario) {
		RNExcluirFuncionario.getInstancia().processar(pOTDFuncionario);
	}

	/**
	 * responsavel por retonar as informações relativas a um funcionario
	 * 
	 * @param pCdFuncionario
	 * @param pCdPessoa
	 * @return
	 * @throws SQLException
	 */
	public OTDFuncionario consultarDadosFuncionario(Integer pCdFuncionario, Integer pCdPessoa) throws SQLException {

		return RNConsultarDadosFuncionario.getInstancia().processar(pCdFuncionario, pCdPessoa);
	}

	/**
	 * 
	 * consulta utilizada para retornar os campos da tela de consulta de
	 * funcionarios
	 * 
	 * @param pNome
	 * @param pTpDocumento
	 * @param pNuDocumento
	 * @param pTpFuncionario
	 * @param pInAtivos
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OTDFuncionario> consultaTelaManterFuncionario(String pNome, String pTpDocumento,
			String pNuDocumento, String pTpFuncionario, boolean pInAtivos) throws SQLException {

		return DAOFuncionario.getInstancia().consultaTelaManterFuncionario(pNome, pTpDocumento, pNuDocumento,
				pTpFuncionario, pInAtivos);
	}
	
	
	public Collection<OTDFuncionario> consultaTodosRegistrosFuncionario(Boolean pIsFuncionarioSemUsuario) throws SQLException{
		return  DAOFuncionario.getInstancia().consultaTodosRegistrosFuncionario(pIsFuncionarioSemUsuario);
		
	}

}
