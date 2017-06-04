/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.Collection;

import sgbr.entidades.Funcionario;
import sgbr.util.OTDFuncionario;

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

	public Collection<OTDFuncionario> consultaTodosRegistrosFuncionario(Boolean pIsFuncionarioSemUsuario) throws SQLException;
	
}
