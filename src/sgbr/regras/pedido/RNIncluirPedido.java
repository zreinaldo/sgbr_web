/**
 * 
 */
package sgbr.regras.pedido;

import java.sql.SQLException;
import java.util.ArrayList;

import sgbr.cadastros.sql.DAOConta;
import sgbr.cadastros.sql.DAOContaItemCardapio;
import sgbr.entidades.ContaItemCardapio;
import sgbr.util.Constantes;
import sgbr.util.OTDConta;
import sgbr.util.OTDContaItemCardapio;

/**
 * @author Reinaldo
 *
 */
public class RNIncluirPedido {

	private static RNIncluirPedido aRNIncluirPedido = new RNIncluirPedido();

	/**
	 * Cria um novo objeto RNIncluirPedido.
	 */
	private RNIncluirPedido() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNIncluirPedido getInstancia() {
		if (RNIncluirPedido.aRNIncluirPedido == null) {
			RNIncluirPedido.aRNIncluirPedido = new RNIncluirPedido();
		}

		return RNIncluirPedido.aRNIncluirPedido;
	}

	public void processar(OTDContaItemCardapio pOTDContaItemCardapio) {
		ContaItemCardapio contaItemCardapio = null;
		ArrayList<OTDConta> arraysConta = null;
		try {

			contaItemCardapio = new ContaItemCardapio();

			if (pOTDContaItemCardapio.getCdConta() == null) {
				arraysConta = DAOConta.getInstancia().consultaTelaManterConta(
						pOTDContaItemCardapio.getCdMesa() != null ? pOTDContaItemCardapio.getCdMesa().toString() : "",
						pOTDContaItemCardapio.getCdComanda() != null ? pOTDContaItemCardapio.getCdComanda().toString()
								: "",
						Constantes.SI_CONTA_SITUACAO_ABERTA);

			}

			contaItemCardapio.setCdConta(pOTDContaItemCardapio.getCdConta() == null ? arraysConta.get(0).getCdConta()
					: pOTDContaItemCardapio.getCdConta());
			contaItemCardapio.setCdItemCardapio(pOTDContaItemCardapio.getCdItemCardapio());
			contaItemCardapio.setQtdContaItemCardapio(pOTDContaItemCardapio.getQtdItemCardapio());
			contaItemCardapio.setObsContaItemCardapio(pOTDContaItemCardapio.getObsItemCardapio());
			contaItemCardapio.setCdFuncionario(pOTDContaItemCardapio.getCdFuncionario());

			DAOContaItemCardapio.getInstancia().incluir(contaItemCardapio);

		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}

}
