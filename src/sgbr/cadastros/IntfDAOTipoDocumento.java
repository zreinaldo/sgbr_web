/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.Collection;

import sgbr.entidades.TipoDocumento;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOTipoDocumento {

	public TipoDocumento incluir(TipoDocumento pTipoDocumento) throws SQLException;

	public void alterar(TipoDocumento pTipoDocumento) throws SQLException;

	public void excluir(TipoDocumento pTipoDocumento) throws SQLException;

	public Collection<TipoDocumento> consultaTodosRegistros(boolean pInRetornarApenasVigentes) throws SQLException;

}
