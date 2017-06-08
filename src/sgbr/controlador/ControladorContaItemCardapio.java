/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.sql.DAOContaItemCardapio;
import sgbr.cadastros.sql.DAOItemCardapio;
import sgbr.entidades.ContaItemCardapio;
import sgbr.entidades.ItemCardapio;
import sgbr.util.OTDContaItemCardapio;

/**
 * @author Reinaldo
 *
 */
/**
 * @author Reinaldo
 *
 */
public class ControladorContaItemCardapio {

	private static ControladorContaItemCardapio aControladorItemCardapio = new ControladorContaItemCardapio();

	/**
	 * Cria um novo objeto ControladorItemCardapio.
	 */
	private ControladorContaItemCardapio() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorContaItemCardapio getInstancia() {
		if (ControladorContaItemCardapio.aControladorItemCardapio == null) {
			ControladorContaItemCardapio.aControladorItemCardapio = new ControladorContaItemCardapio();
		}

		return ControladorContaItemCardapio.aControladorItemCardapio;
	}
	
	
	/**
	 * retorna todos os registros da tabela Item_Cardapio
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
	public ArrayList<OTDContaItemCardapio> consultaTelaManterPedido(String pCdMesa, String pCdComanda) throws SQLException{

		return DAOContaItemCardapio.getInstancia().consultaTelaManterPedido(pCdMesa, pCdComanda);
	}
	
	public void incluir (ContaItemCardapio pContaItemCardapio) throws SQLException {		
		 DAOContaItemCardapio.getInstancia().incluir(pContaItemCardapio);
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
