/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.entidades.ContaItemCardapio;
import sgbr.entidades.ItemCardapio;
import sgbr.util.OTDItemCardapio;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOContaItemCardapio {

	
	public ContaItemCardapio incluir(ContaItemCardapio pContaItemCardapio) throws SQLException ;
//
//	public void alterar(ItemCardapio pItemCardapio) throws SQLException;
//
//	public void excluir(ItemCardapio pItemCardapio) throws SQLException;
//	
//	public Collection<ItemCardapio> consultaTodosRegistros( boolean pInRetornarApenasVigentes)  throws SQLException;
//	
//	public ArrayList<OTDItemCardapio> consultaTelaManterItemCardapio(String pCdItemCardapio, String pDsItemCardapio, String pSiItemCardapio ) throws SQLException;
//	
//	public ItemCardapio consultaPorChavePrimaria(ItemCardapio pItemCardapio) throws SQLException;
	
}
