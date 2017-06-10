/**
 * 
 */
package sgbr.regras.conta;

import sgbr.cadastros.sql.DAOConta;
import sgbr.entidades.Conta;

/**
 * @author Reinaldo
 *
 */
public class RNEncerrarConta {


	private static RNEncerrarConta aRNEncerrarConta = new RNEncerrarConta();

	/**
	 * Cria um novo objeto RNEncerrarConta.
	 */
	private RNEncerrarConta() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNEncerrarConta getInstancia() {
		if (RNEncerrarConta.aRNEncerrarConta == null) {
			RNEncerrarConta.aRNEncerrarConta = new RNEncerrarConta();
		}

		return RNEncerrarConta.aRNEncerrarConta;
	}

	public void processar(Conta pConta) {

		try {			
			
			DAOConta.getInstancia().alterar(pConta);
			
			
		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}
}
