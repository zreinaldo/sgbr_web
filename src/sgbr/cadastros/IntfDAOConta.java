/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.Collection;

import sgbr.entidades.Conta;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOConta {

	public void incluir(Conta pConta) throws SQLException;

	public void alterar(Conta pConta) throws SQLException;

	public void excluir(Conta pConta) throws SQLException;

	public Collection<Conta> consultaTodosRegistros(boolean pInRetornarApenasVigentes) throws SQLException;

	public Conta consultaPorChavePrimaria(Conta pConta) throws SQLException;

}
