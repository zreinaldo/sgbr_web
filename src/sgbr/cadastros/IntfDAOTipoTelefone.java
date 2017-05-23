/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;

import sgbr.entidades.TipoTelefone;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOTipoTelefone {

	public TipoTelefone incluir(TipoTelefone pTipoTelefone) throws SQLException;

	public void alterar(TipoTelefone pTipoTelefone) throws SQLException;

	public void excluir(TipoTelefone pTipoTelefone) throws SQLException;

}
