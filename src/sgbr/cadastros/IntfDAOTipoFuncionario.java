/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;

import sgbr.entidades.TipoFuncionario;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOTipoFuncionario {

	
	public TipoFuncionario incluir(TipoFuncionario pTipoFuncionario) throws SQLException;

	public void alterar(TipoFuncionario pTipoFuncionario) throws SQLException;

	public void excluir(TipoFuncionario pTipoFuncionario) throws SQLException;
	
}
