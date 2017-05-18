/**
 * 
 */
package sgbr.regras.funcionario;

import sgbr.cadastros.sql.DAOFuncionario;
import sgbr.cadastros.sql.DAOPessoa;
import sgbr.util.OTDFuncionario;

/**
 * @author Reinaldo
 *
 */
public class RNAlterarFuncionario {
	


	private static RNAlterarFuncionario aRNAlterarFuncionario = new RNAlterarFuncionario();

	/**
	 * Cria um novo objeto RNAlterarFuncionario.
	 */
	private RNAlterarFuncionario() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNAlterarFuncionario getInstancia() {
		if (RNAlterarFuncionario.aRNAlterarFuncionario == null) {
			RNAlterarFuncionario.aRNAlterarFuncionario = new RNAlterarFuncionario();
		}

		return RNAlterarFuncionario.aRNAlterarFuncionario;
	}

	public void processar(OTDFuncionario pOtdFuncionario) {

		try {
			DAOPessoa.getInstancia().alterar(null);

			DAOFuncionario.getInstancia().alterar(null);

		} catch (Exception e) {
			// TODO Auto-generated catch block

			// TODO gerar erro generico
			e.printStackTrace();
		}
	}

}
