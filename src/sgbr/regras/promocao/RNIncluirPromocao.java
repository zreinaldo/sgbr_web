/**
 * 
 */
package sgbr.regras.promocao;

import sgbr.cadastros.sql.DAOPromocao;
import sgbr.cadastros.sql.DAOPromocaoDiaSemana;
import sgbr.entidades.Promocao;
import sgbr.entidades.PromocaoDiaSemana;
import sgbr.util.OTDPromocao;

/**
 * @author Reinaldo
 *
 */
public class RNIncluirPromocao {

	private static RNIncluirPromocao aRNIncluirPromocao = new RNIncluirPromocao();

	/**
	 * Cria um novo objeto RNIncluirPromocao.
	 */
	private RNIncluirPromocao() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNIncluirPromocao getInstancia() {
		if (RNIncluirPromocao.aRNIncluirPromocao == null) {
			RNIncluirPromocao.aRNIncluirPromocao = new RNIncluirPromocao();
		}

		return RNIncluirPromocao.aRNIncluirPromocao;
	}

	public void processar(OTDPromocao pOtdPromocao) throws Exception {

		try {

			Promocao promocao = new Promocao();
			promocao.setCdItemCardapio(pOtdPromocao.getCdItemCardapio());
			promocao.setVlPromocao(pOtdPromocao.getVlPromocao());
			promocao.setDtInicioPromocao(pOtdPromocao.getDtInicioPromocao());
			promocao.setDtFimPromocao(pOtdPromocao.getDtFimPromocao());

			promocao = DAOPromocao.getInstancia().incluir(promocao);

			for (int aI = 0; aI < pOtdPromocao.getListaDiasSemanaPromocao().length; aI++) {

				String diaSemana = pOtdPromocao.getListaDiasSemanaPromocao()[aI];
				PromocaoDiaSemana promocaoDiaSemana = new PromocaoDiaSemana(promocao.getCdPromocao(),
						Integer.valueOf(diaSemana));
				DAOPromocaoDiaSemana.getInstancia().incluir(promocaoDiaSemana);
			}

		} catch (Exception e) {
			// FIXME deveria tratar caso seja levantada uma chave duplicada
			e.printStackTrace();

		}
	}
}
