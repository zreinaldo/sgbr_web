/**
 * 
 */
package sgbr.regras.promocao;

import java.util.ArrayList;

import sgbr.cadastros.sql.DAOPromocao;
import sgbr.cadastros.sql.DAOPromocaoDiaSemana;
import sgbr.entidades.Promocao;
import sgbr.entidades.PromocaoDiaSemana;
import sgbr.util.OTDPromocao;

/**
 * @author Reinaldo
 *
 */
public class RNAlterarPromocao {

	private static RNAlterarPromocao aRNAlterarPromocao = new RNAlterarPromocao();

	/**
	 * Cria um novo objeto RNAlterarPromocao.
	 */
	private RNAlterarPromocao() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNAlterarPromocao getInstancia() {
		if (RNAlterarPromocao.aRNAlterarPromocao == null) {
			RNAlterarPromocao.aRNAlterarPromocao = new RNAlterarPromocao();
		}

		return RNAlterarPromocao.aRNAlterarPromocao;
	}

	public void processar(OTDPromocao pOtdPromocao) throws Exception {

		try {

			Promocao promocao = new Promocao();
			promocao.setCdPromocao(pOtdPromocao.getCdPromocao());
			promocao.setCdItemCardapio(pOtdPromocao.getCdItemCardapio());
			promocao.setVlPromocao(pOtdPromocao.getVlPromocao());
			promocao.setDtInicioPromocao(pOtdPromocao.getDtInicioPromocao());
			promocao.setDtFimPromocao(pOtdPromocao.getDtFimPromocao());

			DAOPromocao.getInstancia().alterar(promocao);

			ArrayList<Integer> listaDiasBase = DAOPromocaoDiaSemana.getInstancia()
					.consultaPromocaoDiasSemana(pOtdPromocao.getCdPromocao());
			ArrayList<Integer> listaTela = this.getColecaoComoInteger(pOtdPromocao.getListaDiasSemanaPromocao());

			PromocaoDiaSemana promocaoDiaSemana = new PromocaoDiaSemana();

			for (Integer aDiaBase : listaDiasBase) {

				if (!listaTela.contains(aDiaBase)) {
					DAOPromocaoDiaSemana.getInstancia().excluir(promocao.getCdPromocao(), aDiaBase);
				}
			}

			for (Integer aDiaTela : listaTela) {

				if (!listaDiasBase.contains(aDiaTela)) {
					promocaoDiaSemana = new PromocaoDiaSemana(promocao.getCdPromocao(), Integer.valueOf(aDiaTela));
					DAOPromocaoDiaSemana.getInstancia().incluir(promocaoDiaSemana);
				}
			}

			//

		} catch (Exception e) {

			// FIXME deveria tratar caso seja levantada uma chave duplicada
			e.printStackTrace();
			// throw e;
		}
	}

	private ArrayList<Integer> getColecaoComoInteger(String[] pListaDiaSemana) {
		ArrayList<Integer> lista = new ArrayList<Integer>();

		for (int aI = 0; aI < pListaDiaSemana.length; aI++) {
			if (!pListaDiaSemana[aI].isEmpty()) {
				lista.add(Integer.valueOf(pListaDiaSemana[aI]));
			}

		}

		return lista;
	}
}
