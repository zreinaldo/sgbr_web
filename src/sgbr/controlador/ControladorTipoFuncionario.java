/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.Collection;

import sgbr.cadastros.sql.DAOTipoFuncionario;
import sgbr.entidades.TipoFuncionario;

/**
 * @author Reinaldo
 *
 */
/**
 * @author Reinaldo
 *
 */
public class ControladorTipoFuncionario {

	private static ControladorTipoFuncionario aControladorTipoFuncionario = new ControladorTipoFuncionario();

	/**
	 * Cria um novo objeto ControladorTipoFuncionario.
	 */
	private ControladorTipoFuncionario() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorTipoFuncionario getInstancia() {
		if (ControladorTipoFuncionario.aControladorTipoFuncionario == null) {
			ControladorTipoFuncionario.aControladorTipoFuncionario = new ControladorTipoFuncionario();
		}

		return ControladorTipoFuncionario.aControladorTipoFuncionario;
	}
	
	
	/**
	 * retorna todos os registros da tabela tipo_funcionario
	 * 
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<TipoFuncionario> consultaTodosRegistrosTipoFuncionario(boolean pInRetornarApenasVigentes) throws SQLException {
		return DAOTipoFuncionario.getInstancia().consultaTodosRegistros(pInRetornarApenasVigentes);
	}
	
}
