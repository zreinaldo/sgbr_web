/**
 * 
 */
package sgbr.regras.conta;

import java.util.ArrayList;

import sgbr.cadastros.sql.DAOConta;
import sgbr.entidades.Conta;
import sgbr.util.OTDContaItemCardapio;

/**
 * @author Reinaldo
 *
 */
public class RNExcluirConta {


	private static RNExcluirConta aRNEncerrarConta = new RNExcluirConta();

	/**
	 * Cria um novo objeto RNEncerrarConta.
	 */
	private RNExcluirConta() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNExcluirConta getInstancia() {
		if (RNExcluirConta.aRNEncerrarConta == null) {
			RNExcluirConta.aRNEncerrarConta = new RNExcluirConta();
		}

		return RNExcluirConta.aRNEncerrarConta;
	}

	public void processar(Conta pConta) {

		try {
			
			ArrayList<OTDContaItemCardapio> colecao = DAOConta.getInstancia().consultarTodosItensConta(pConta.getCdConta());
			
			
			
			
			if (colecao.isEmpty()){
				DAOConta.getInstancia().excluir(pConta);
			} 
			
			
		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}
}
