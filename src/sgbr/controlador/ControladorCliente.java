/**
 * 
 */
package sgbr.controlador;

import sgbr.regras.cliente.RNIncluirCliente;
import sgbr.util.OTDCliente;

/**
 * @author Reinaldo
 *
 */
public class ControladorCliente {
	
	private static ControladorCliente aControladorCliente = new ControladorCliente();

	/**
	 * Cria um novo objeto ControladorCliente.
	 */
	private ControladorCliente() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorCliente getInstancia() {
		if (ControladorCliente.aControladorCliente == null) {
			ControladorCliente.aControladorCliente = new ControladorCliente();
		}

		return ControladorCliente.aControladorCliente;
	}

	public void incluirCliente(OTDCliente pOtdCliente) {

		RNIncluirCliente.getInstancia().processar(pOtdCliente);

	}

}
