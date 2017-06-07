/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.sql.DAOConta;
import sgbr.entidades.Comanda;
import sgbr.entidades.Mesa;
import sgbr.util.OTDConta;

/**
 * @author Reinaldo
 *
 */
public class ControladorConta {

	private static ControladorConta aControladorConta = new ControladorConta();

	/**
	 * Cria um novo objeto ControladorConta.
	 */
	private ControladorConta() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorConta getInstancia() {
		if (ControladorConta.aControladorConta == null) {
			ControladorConta.aControladorConta = new ControladorConta();
		}

		return ControladorConta.aControladorConta;
	}

	public Collection<Comanda> consultaComandaConta(boolean pInUso) throws SQLException {
		return DAOConta.getInstancia().consultaComandaConta(pInUso);
	}

	public Collection<Mesa> consultaMesaConta(boolean pInUso) throws SQLException {
		return DAOConta.getInstancia().consultaMesaConta(pInUso);
	}

	public ArrayList<OTDConta> consultaTelaManterConta(String pCdMesa, String pCdComanda, String pSiConta)
			throws SQLException {
		return DAOConta.getInstancia().consultaTelaManterConta(pCdMesa, pCdComanda, pSiConta);
	}

}
