/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.sql.DAOContaItemCardapio;
import sgbr.entidades.ContaItemCardapio;
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
	public Collection<ContaItemCardapio> consultaTodosRegistrosItemCardapio(boolean pInRetornarApenasVigentes) throws SQLException {
		return DAOContaItemCardapio.getInstancia().consultaTodosRegistros(pInRetornarApenasVigentes);
	}

	/**
	 * utilizada na tela de consultar Pedido
	 * @param pCodigo
	 * @param pSituacao
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OTDContaItemCardapio> consultaTelaManterPedido(String pCdMesa, String pCdComanda) throws SQLException{

		return DAOContaItemCardapio.getInstancia().consultaTelaManterPedido(pCdMesa, pCdComanda);
	}
	public OTDContaItemCardapio consultaDetalharPedido(String pCdPedido) throws SQLException{

		return DAOContaItemCardapio.getInstancia().consultaDetalharPedido(pCdPedido);
	}
	public void incluir (ContaItemCardapio pContaItemCardapio) throws SQLException {		
		 DAOContaItemCardapio.getInstancia().incluir(pContaItemCardapio);
	}
	
	public void alterar (ContaItemCardapio pContaItemCardapio) throws SQLException {		
		 DAOContaItemCardapio.getInstancia().alterar(pContaItemCardapio);
	}

	public void excluir (String pCdContaItemCardapio) throws SQLException {		
		DAOContaItemCardapio.getInstancia().excluir(pCdContaItemCardapio);
	}
	
	public ContaItemCardapio consultaPorChavePrimaria (ContaItemCardapio pContaItemCardapio) throws SQLException {
		return DAOContaItemCardapio.getInstancia().consultaPorChavePrimaria(pContaItemCardapio);
	}
}
