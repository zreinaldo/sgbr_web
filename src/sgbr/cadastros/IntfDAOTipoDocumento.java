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

	public Collection<TipoDocumento> consultaTodosRegistros(boolean pInRetornarApenasVigentes) throws SQLException;

}
