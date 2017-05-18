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
public class RNIncluirFuncionario {

	private static RNIncluirFuncionario aRNIncluirFuncionario = new RNIncluirFuncionario();

	/**
	 * Cria um novo objeto RNIncluirFuncionario.
	 */
	private RNIncluirFuncionario() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNIncluirFuncionario getInstancia() {
		if (RNIncluirFuncionario.aRNIncluirFuncionario == null) {
			RNIncluirFuncionario.aRNIncluirFuncionario = new RNIncluirFuncionario();
		}

		return RNIncluirFuncionario.aRNIncluirFuncionario;
	}

	public void processar(OTDFuncionario pOtdFuncionario) {

		try {
			DAOPessoa.getInstancia().incluir(null);

			DAOFuncionario.getInstancia().incluir(null);

		} catch (Exception e) {
			// TODO Auto-generated catch block

			// TODO gerar erro generico
			e.printStackTrace();
		}
	}
}
