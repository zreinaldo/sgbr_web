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
public class RNAlterarClienteConta {

	private static RNAlterarClienteConta aRNAlterarClienteConta = new RNAlterarClienteConta();

	/**
	 * Cria um novo objeto RNAlterarClienteConta.
	 */
	private RNAlterarClienteConta() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNAlterarClienteConta getInstancia() {
		if (RNAlterarClienteConta.aRNAlterarClienteConta == null) {
			RNAlterarClienteConta.aRNAlterarClienteConta = new RNAlterarClienteConta();
		}

		return RNAlterarClienteConta.aRNAlterarClienteConta;
	}

	public void processar(Integer pCdConta, Integer pCdCliente) {

		try {
			Conta conta = new Conta();
			conta.setCdConta(pCdConta);
			conta = DAOConta.getInstancia().consultaPorChavePrimaria(conta);

			conta.setCdCliente(pCdCliente);

			DAOConta.getInstancia().alterar(conta);

		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}
}
