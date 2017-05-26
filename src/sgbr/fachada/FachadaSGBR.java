/**
 * 
 */
package sgbr.fachada;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.controlador.ControladorFuncionario;
import sgbr.controlador.ControladorTipoDocumento;
import sgbr.controlador.ControladorTipoFuncionario;
import sgbr.entidades.TipoDocumento;
import sgbr.entidades.TipoFuncionario;
import sgbr.util.OTDFuncionario;

/**
 * @author Reinaldo
 *
 */
public class FachadaSGBR {

	private static FachadaSGBR aFachadaSGBR = new FachadaSGBR();

	/**
	 * Cria um novo objeto FachadaSGBR.
	 */
	private FachadaSGBR() {

		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static FachadaSGBR getInstancia() {
		if (FachadaSGBR.aFachadaSGBR == null) {
			FachadaSGBR.aFachadaSGBR = new FachadaSGBR();
		}

		return FachadaSGBR.aFachadaSGBR;
	}

	public void incluirFuncionario(OTDFuncionario pOTDFuncionario) {
		ControladorFuncionario.getInstancia().incluirFuncionario(pOTDFuncionario);
	}

	/**
	 * consulta todos os dados de um funcionario
	 * 
	 * @param pCdFuncionario
	 * @param pCdPessoa
	 * @return
	 * @throws SQLException
	 */
	public OTDFuncionario consultarDadosFuncionario(Integer pCdFuncionario, Integer pCdPessoa) throws SQLException {
		return ControladorFuncionario.getInstancia().consultarDadosFuncionario(pCdFuncionario, pCdPessoa);
	}

	/**
	 * 
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<TipoFuncionario> consultaTodosRegistrosTipoFuncionario(boolean pInRetornarApenasVigentes)
			throws SQLException {
		return ControladorTipoFuncionario.getInstancia()
				.consultaTodosRegistrosTipoFuncionario(pInRetornarApenasVigentes);
	}

	/**
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<TipoDocumento> consultaTodosRegistrosTipoDocumento(boolean pInRetornarApenasVigentes)
			throws SQLException {
		return ControladorTipoDocumento.getInstancia().consultaTodosRegistrosTipoDocumento(pInRetornarApenasVigentes);
	}


	public ArrayList<OTDFuncionario> consultaTelaManterFuncionario(String pNome, String pTpDocumento,
			String pNuDocumento, String pTpFuncionario, boolean pInAtivos) throws SQLException {
		return ControladorFuncionario.getInstancia().consultaTelaManterFuncionario(pNome, pTpDocumento, pNuDocumento,
				pTpFuncionario, pInAtivos);
	}
	
	public void alterarFuncionario(OTDFuncionario pOTDFuncionario) {
		ControladorFuncionario.getInstancia().alterarFuncionario(pOTDFuncionario);		
	}

}
