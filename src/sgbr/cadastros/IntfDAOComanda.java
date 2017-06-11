/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.ArrayList;

import sgbr.entidades.Comanda;
import sgbr.util.OTDComanda;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOComanda {

	public void incluir(Comanda pComanda) throws SQLException;

	public void alterar(Comanda pComanda) throws SQLException;

	public void excluir(Comanda pComanda) throws SQLException;

	public ArrayList<OTDComanda> consultaTelaManterComanda(String pCodigo, String pInVigentes) throws SQLException;

	public Comanda consultaPorChavePrimaria(Comanda pComanda) throws SQLException;

}
