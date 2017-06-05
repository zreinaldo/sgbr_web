/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.Collection;

import sgbr.cadastros.sql.DAOTipoUsuario;
import sgbr.entidades.TipoUsuario;

/**
 * @author Reinaldo
 *
 */
/**
 * @author Reinaldo
 *
 */
public class ControladorTipoUsuario {

	private static ControladorTipoUsuario aControladorTipoUsuario = new ControladorTipoUsuario();

	/**
	 * Cria um novo objeto ControladorTipoUsuario.
	 */
	private ControladorTipoUsuario() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorTipoUsuario getInstancia() {
		if (ControladorTipoUsuario.aControladorTipoUsuario == null) {
			ControladorTipoUsuario.aControladorTipoUsuario = new ControladorTipoUsuario();
		}

		return ControladorTipoUsuario.aControladorTipoUsuario;
	}
	
	
	/**
	 * retorna todos os registros da tabela tipo_usuario
	 * 
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<TipoUsuario> consultaTodosRegistrosTipoUsuario(boolean pInRetornarApenasVigentes) throws SQLException {
		return DAOTipoUsuario.getInstancia().consultaTodosRegistros(pInRetornarApenasVigentes);
	}

	
	public TipoUsuario consultaPorChavePrimaria (TipoUsuario pTipoUsuario) throws SQLException {
		return DAOTipoUsuario.getInstancia().consultaPorChavePrimaria(pTipoUsuario);
	}
}
