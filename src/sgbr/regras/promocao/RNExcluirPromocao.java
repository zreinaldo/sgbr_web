/**
 * 
 */
package sgbr.regras.promocao;

import java.util.ArrayList;

import sgbr.cadastros.sql.DAOPromocao;
import sgbr.cadastros.sql.DAOPromocaoDiaSemana;

/**
 * @author Reinaldo
 *
 */
public class RNExcluirPromocao {

	private static RNExcluirPromocao aRNExcluirPromocao = new RNExcluirPromocao();

	/**
	 * Cria um novo objeto RNExcluirPromocao.
	 */
	private RNExcluirPromocao() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNExcluirPromocao getInstancia() {
		if (RNExcluirPromocao.aRNExcluirPromocao == null) {
			RNExcluirPromocao.aRNExcluirPromocao = new RNExcluirPromocao();
		}

		return RNExcluirPromocao.aRNExcluirPromocao;
	}

	public void processar(Integer pCdPromocao) throws Exception {

		try {

			ArrayList<Integer> listaDias = DAOPromocaoDiaSemana.getInstancia().consultaPromocaoDiasSemana(pCdPromocao);

			
			for (Integer aDiaBase : listaDias) {

				DAOPromocaoDiaSemana.getInstancia().excluir(pCdPromocao, aDiaBase);

			}

			DAOPromocao.getInstancia().excluir(pCdPromocao);

		} catch (Exception e) {

			e.printStackTrace();
			// throw e;
		}
	}
}
