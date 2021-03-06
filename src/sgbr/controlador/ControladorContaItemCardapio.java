/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import sgbr.cadastros.sql.DAOContaItemCardapio;
import sgbr.entidades.ContaItemCardapio;
import sgbr.regras.pedido.RNIncluirPedido;
import sgbr.util.OTDContaItemCardapio;

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
	public void incluir (OTDContaItemCardapio pOTDContaItemCardapio) throws SQLException {		
		RNIncluirPedido.getInstancia().processar(pOTDContaItemCardapio);
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
