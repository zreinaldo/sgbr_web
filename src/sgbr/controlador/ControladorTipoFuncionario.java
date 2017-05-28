/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.sql.DAOTipoFuncionario;
import sgbr.cadastros.sql.DAOTipoFuncionario;
import sgbr.entidades.TipoFuncionario;
import sgbr.entidades.TipoFuncionario;
import sgbr.util.OTDTipoFuncionario;

/**
 * @author Reinaldo
 *
 */
/**
 * @author Reinaldo
 *
 */
public class ControladorTipoFuncionario {

	private static ControladorTipoFuncionario aControladorTipoFuncionario = new ControladorTipoFuncionario();

	/**
	 * Cria um novo objeto ControladorTipoFuncionario.
	 */
	private ControladorTipoFuncionario() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorTipoFuncionario getInstancia() {
		if (ControladorTipoFuncionario.aControladorTipoFuncionario == null) {
			ControladorTipoFuncionario.aControladorTipoFuncionario = new ControladorTipoFuncionario();
		}

		return ControladorTipoFuncionario.aControladorTipoFuncionario;
	}
	
	
	/**
	 * retorna todos os registros da tabela tipo_funcionario
	 * 
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<TipoFuncionario> consultaTodosRegistrosTipoFuncionario(boolean pInRetornarApenasVigentes) throws SQLException {
		return DAOTipoFuncionario.getInstancia().consultaTodosRegistros(pInRetornarApenasVigentes);
	}

	/**
	 * utilizada na tela de consultar TipoFuncionario
	 * @param pCodigo
	 * @param pSituacao
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OTDTipoFuncionario> consultaTelaManterTipoFuncionario(String pCdTipoFuncionario, String pDsTipoFuncionario) throws SQLException {

		return DAOTipoFuncionario.getInstancia().consultaTelaManterTipoFuncionario(pCdTipoFuncionario,pDsTipoFuncionario);
	}
	
	public void incluir (TipoFuncionario pTipoFuncionario) throws SQLException {		
		 DAOTipoFuncionario.getInstancia().incluir(pTipoFuncionario);
	}
	
	public void alterar (TipoFuncionario pTipoFuncionario) throws SQLException {		
		 DAOTipoFuncionario.getInstancia().alterar(pTipoFuncionario);
	}

	public void excluir (TipoFuncionario pTipoFuncionario) throws SQLException {		
		DAOTipoFuncionario.getInstancia().excluir(pTipoFuncionario);
	}
	
	public TipoFuncionario consultaPorChavePrimaria (TipoFuncionario pTipoFuncionario) throws SQLException {
		return DAOTipoFuncionario.getInstancia().consultaPorChavePrimaria(pTipoFuncionario);
	}
}
