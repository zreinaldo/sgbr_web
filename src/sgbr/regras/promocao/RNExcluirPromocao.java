/**
 * 
 */
package sgbr.regras.promocao;

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

	public void processar(Integer pCdPromocao) throws Exception  {

		try {

			DAOPromocaoDiaSemana.getInstancia().excluir(pCdPromocao);

			DAOPromocao.getInstancia().excluir(pCdPromocao);
			

		} catch (Exception e) {
			
			e.printStackTrace();
//			throw e;
		}
	}
}
