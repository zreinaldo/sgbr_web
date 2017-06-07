/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.Collection;

import sgbr.entidades.Comanda;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOComanda {

	public void incluir(Comanda pComanda) throws SQLException;

	public void alterar(Comanda pComanda) throws SQLException;

	public void excluir(Comanda pComanda) throws SQLException;

	//public Collection<Comanda> consultaTodosRegistros(boolean pInRetornarApenasVigentes) throws SQLException;

	public Comanda consultaPorChavePrimaria(Comanda pComanda) throws SQLException;

}
