/**
 * 
 */
package sgbr.fachada;

import sgbr.controlador.ControladorFuncionario;
import sgbr.util.OTDFuncionario;

/**
 * @author Reinaldo
 *
 */
public class FachadaSGBR {
	
	private static FachadaSGBR aFachadaSGBR = new FachadaSGBR();

	/**
	 * Cria um novo objeto FachadaSGBR.
	 */
	private FachadaSGBR() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static FachadaSGBR getInstancia() {
		if (FachadaSGBR.aFachadaSGBR == null) {
			FachadaSGBR.aFachadaSGBR = new FachadaSGBR();
		}

		return FachadaSGBR.aFachadaSGBR;
	}
	
	
	public void incluirFuncionario(OTDFuncionario pOTDFuncionario) {
		ControladorFuncionario.getInstancia().incluirFuncionario(pOTDFuncionario);
	}

}
