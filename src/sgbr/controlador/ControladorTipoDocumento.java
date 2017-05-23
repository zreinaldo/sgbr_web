/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.Collection;

import sgbr.cadastros.sql.DAOTipoDocumento;
import sgbr.entidades.TipoDocumento;

/**
 * @author Reinaldo
 *
 */
public class ControladorTipoDocumento {
	private static ControladorTipoDocumento aControladorTipoDocumento = new ControladorTipoDocumento();

	/**
	 * Cria um novo objeto ControladorTipoDocumento.
	 */
	private ControladorTipoDocumento() {
		super();
	}

	/**
	 * - pega instancia do controlador, padrao singleton
	 *
	 * @return
	 */
	public static ControladorTipoDocumento getInstancia() {
		if (ControladorTipoDocumento.aControladorTipoDocumento == null) {
			ControladorTipoDocumento.aControladorTipoDocumento = new ControladorTipoDocumento();
		}

		return ControladorTipoDocumento.aControladorTipoDocumento;
	}

	public Collection<TipoDocumento> consultaTodosRegistrosTipoDocumento(boolean pInRetornarApenasVigentes) throws SQLException {

		return DAOTipoDocumento.getInstancia().consultaTodosRegistros(pInRetornarApenasVigentes);
	}

}
