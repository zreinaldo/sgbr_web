/**
 * 
 */
package sgbr.controlador;

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

}
