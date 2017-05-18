
package sgbr.cadastros;

import java.sql.SQLException;

import sgbr.entidades.Pessoa;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOPessoa {

	/**
	 * @param pPessoa
	 * @return o Codigo da pessoa incluida
	 */
	public Pessoa incluir(Pessoa pPessoa) throws SQLException;

	/**
	 * @param pPessoa
	 */
	public void alterar(Pessoa pPessoa) throws SQLException;

	/**
	 * @param pPessoa
	 */
	public void excluir(Pessoa pPessoa) throws SQLException;

	/**
	 * @param pPessoa
	 * @return
	 */
	public Pessoa consultarPorChavePrimaria(Pessoa pPessoa) throws SQLException;
}
