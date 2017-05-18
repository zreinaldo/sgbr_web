/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;

import sgbr.entidades.Funcionario;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOFuncionario {

	/**
	 * @param pFuncionario
	 * @return o Codigo da Funcionario incluida
	 */
	public Funcionario incluir(Funcionario pFuncionario) throws SQLException;

	/**
	 * @param pFuncionario
	 */
	public void alterar(Funcionario pFuncionario) throws SQLException;

	/**
	 * @param pFuncionario
	 */
	public void excluir(Funcionario pFuncionario) throws SQLException;

	/**
	 * @param pFuncionario
	 * @return
	 */
	public Funcionario consultarPorChavePrimaria(Funcionario pFuncionario) throws SQLException;
}
