/**
 * 
 */
package sgbr.regras.cliente;

import sgbr.cadastros.sql.DAOPessoa;
import sgbr.entidades.Pessoa;
import sgbr.util.OTDCliente;

/**
 * @author Reinaldo
 *
 */
public class RNAlterarCliente {

	


	private static RNAlterarCliente aRNAlterarCliente = new RNAlterarCliente();

	/**
	 * Cria um novo objeto RNAlterarCliente.
	 */
	private RNAlterarCliente() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNAlterarCliente getInstancia() {
		if (RNAlterarCliente.aRNAlterarCliente == null) {
			RNAlterarCliente.aRNAlterarCliente = new RNAlterarCliente();
		}

		return RNAlterarCliente.aRNAlterarCliente;
	}

	public void processar(OTDCliente pOtdFuncionario) {

		try {
			Pessoa pessoa = new Pessoa();

			pessoa.setCdPessoa(pOtdFuncionario.getCdPessoa());
			pessoa.setNmPessoa(pOtdFuncionario.getNmCliente());
			pessoa.setDtNascPessoa(pOtdFuncionario.getDtNascimento());
			pessoa.setEePessoa(pOtdFuncionario.getEmail());

			DAOPessoa.getInstancia().alterar(pessoa);
			
			//FIXME alterar o pessoaDocumento

			
		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}



}
