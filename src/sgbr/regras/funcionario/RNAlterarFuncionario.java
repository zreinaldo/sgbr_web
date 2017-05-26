/**
 * 
 */
package sgbr.regras.funcionario;

import sgbr.cadastros.sql.DAOFuncionario;
import sgbr.cadastros.sql.DAOPessoa;
import sgbr.entidades.Funcionario;
import sgbr.entidades.Pessoa;
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
			Pessoa pessoa = new Pessoa();

			pessoa.setCdPessoa(pOtdFuncionario.getCdPessoa());
			pessoa.setNmPessoa(pOtdFuncionario.getNmFuncionario());
			pessoa.setDtNascPessoa(pOtdFuncionario.getDtNascimento());
			pessoa.setEePessoa(pOtdFuncionario.getEmail());
			pessoa.setNmBairro(pOtdFuncionario.getNmBairro());
			pessoa.setNmCidade(pOtdFuncionario.getNmCidade());
			pessoa.setNmLogradouro(pOtdFuncionario.getNmLogradouro());
			pessoa.setNmUF(pOtdFuncionario.getNmUF());
			pessoa.setNuLogradouro(pOtdFuncionario.getNuLogradouro());

			DAOPessoa.getInstancia().alterar(pessoa);
			
			Funcionario funcionario = new Funcionario();
			
			funcionario.setCdPessoa(pOtdFuncionario.getCdPessoa());
			funcionario.setCdFuncionario(pOtdFuncionario.getCdFuncionario());
			funcionario.setVlSalario(pOtdFuncionario.getVlSalario());
			funcionario.setTpFuncionario( pOtdFuncionario.getTpFuncionario());
			funcionario.setDtAdmissao(pOtdFuncionario.getDtAdmissao());
			funcionario.setNuBancoAgencia(pOtdFuncionario.getNuAgencia());
			funcionario.setNuBancoConta(pOtdFuncionario.getNuCC());
			funcionario.setNuBancoAgencia(pOtdFuncionario.getNuAgencia());
			funcionario.setNmBanco(pOtdFuncionario.getNmBanco());			
			DAOFuncionario.getInstancia().alterar(funcionario);



		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}

}
