/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.sql.DAOItemCardapio;
import sgbr.entidades.ItemCardapio;
import sgbr.util.OTDItemCardapio;

/**
 * @author Reinaldo
 *
 */
/**
 * @author Reinaldo
 *
 */
public class ControladorItemCardapio {

	private static ControladorItemCardapio aControladorItemCardapio = new ControladorItemCardapio();

	/**
	 * Cria um novo objeto ControladorItemCardapio.
	 */
	private ControladorItemCardapio() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorItemCardapio getInstancia() {
		if (ControladorItemCardapio.aControladorItemCardapio == null) {
			ControladorItemCardapio.aControladorItemCardapio = new ControladorItemCardapio();
		}

		return ControladorItemCardapio.aControladorItemCardapio;
	}
	
	
	/**
	 * retorna todos os registros da tabela tipo_funcionario
	 * 
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<ItemCardapio> consultaTodosRegistrosItemCardapio(boolean pInRetornarApenasVigentes) throws SQLException {
		return DAOItemCardapio.getInstancia().consultaTodosRegistros(pInRetornarApenasVigentes);
	}

	/**
	 * utilizada na tela de consultar ItemCardapio
	 * @param pCodigo
	 * @param pSituacao
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OTDItemCardapio> consultaTelaManterItemCardapio(String pCdItemCardapio, String pDsItemCardapio, String pSiItemCardapio) throws SQLException {

		return DAOItemCardapio.getInstancia().consultaTelaManterItemCardapio(pCdItemCardapio,pDsItemCardapio, pSiItemCardapio);
	}
	
	public void incluir (ItemCardapio pItemCardapio) throws SQLException {		
		 DAOItemCardapio.getInstancia().incluir(pItemCardapio);
	}
	
	public void alterar (ItemCardapio pItemCardapio) throws SQLException {		
		 DAOItemCardapio.getInstancia().alterar(pItemCardapio);
	}

	public void excluir (ItemCardapio pItemCardapio) throws SQLException {		
		DAOItemCardapio.getInstancia().excluir(pItemCardapio);
	}
	
	public ItemCardapio consultaPorChavePrimaria (ItemCardapio pItemCardapio) throws SQLException {
		return DAOItemCardapio.getInstancia().consultaPorChavePrimaria(pItemCardapio);
	}
}
