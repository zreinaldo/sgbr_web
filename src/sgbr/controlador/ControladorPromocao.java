/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.sql.DAOPromocao;
import sgbr.entidades.Promocao;
import sgbr.regras.promocao.RNIncluirPromocao;
import sgbr.util.OTDPromocao;

/**
 * @author Reinaldo
 *
 */
/**
 * @author Reinaldo
 *
 */
public class ControladorPromocao {

	private static ControladorPromocao aControladorPromocao = new ControladorPromocao();

	/**
	 * Cria um novo objeto ControladorPromocao.
	 */
	private ControladorPromocao() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorPromocao getInstancia() {
		if (ControladorPromocao.aControladorPromocao == null) {
			ControladorPromocao.aControladorPromocao = new ControladorPromocao();
		}

		return ControladorPromocao.aControladorPromocao;
	}
	
	
	/**
	 * retorna todos os registros da tabela tipo_funcionario
	 * 
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<Promocao> consultaTodosRegistrosPromocao(String pInRetornarApenasVigentes) throws SQLException {
		return DAOPromocao.getInstancia().consultaTodosRegistros(pInRetornarApenasVigentes);
	}

	/**
	 * utilizada na tela de consultar Promocao
	 * @param pCodigo
	 * @param pSituacao
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OTDPromocao> consultaTelaManterPromocao(String pCdItemCardapio,
			String pInRetornarApenasVigentes,  String pDiaSemanaPromocao) throws SQLException {

		return DAOPromocao.getInstancia().consultaTelaManterPromocao( pCdItemCardapio, pInRetornarApenasVigentes, pDiaSemanaPromocao);
	}
	
	public void incluir (OTDPromocao pOtdPromocao) throws SQLException {		
		RNIncluirPromocao.getInstancia().processar(pOtdPromocao);
	}
	
	public void alterar (Promocao pPromocao) throws SQLException {		
		 DAOPromocao.getInstancia().alterar(pPromocao);
	}

	public void excluir (Promocao pPromocao) throws SQLException {		
		DAOPromocao.getInstancia().excluir(pPromocao);
	}
	
	public Promocao consultaPorChavePrimaria (Promocao pPromocao) throws SQLException {
		return DAOPromocao.getInstancia().consultaPorChavePrimaria(pPromocao);
	}
}
