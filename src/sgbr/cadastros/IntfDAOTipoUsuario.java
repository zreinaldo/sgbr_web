/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.Collection;

import sgbr.entidades.TipoUsuario;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOTipoUsuario {

			
	public Collection<TipoUsuario> consultaTodosRegistros( boolean pInRetornarApenasVigentes)  throws SQLException;
	
	public TipoUsuario consultaPorChavePrimaria(TipoUsuario pTipoUsuario) throws SQLException;

	
}
