/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;

import sgbr.entidades.Cliente;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOCliente {

	/**
	 * @param pCliente
	 * @return o Codigo da Cliente incluida
	 */
	public Cliente incluir(Cliente pCliente) throws SQLException;

	/**
	 * @param pCliente
	 */
	public void alterar(Cliente pCliente) throws SQLException;

	/**
	 * @param pCliente
	 */
	public void excluir(Cliente pCliente) throws SQLException;

	/**
	 * @param pCliente
	 * @return
	 */
	public Cliente consultarPorChavePrimaria(Cliente pCliente) throws SQLException;
}
