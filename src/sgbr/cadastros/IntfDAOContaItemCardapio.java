/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.ArrayList;

import sgbr.entidades.ContaItemCardapio;
import sgbr.util.OTDContaItemCardapio;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOContaItemCardapio {

	public ContaItemCardapio incluir(ContaItemCardapio pContaItemCardapio) throws SQLException;

	public void alterar(ContaItemCardapio pContaItemCardapio) throws SQLException;

	public ArrayList<OTDContaItemCardapio> consultaTelaManterPedido(String pCdMesa, String pCdComanda)
			throws SQLException;

	public OTDContaItemCardapio consultaDetalharPedido(String pCdPedido) throws SQLException;

}
