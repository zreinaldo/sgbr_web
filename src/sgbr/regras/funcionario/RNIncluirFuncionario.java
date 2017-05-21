/**
 * 
 */
package sgbr.regras.funcionario;

import sgbr.cadastros.sql.DAOFuncionario;
import sgbr.cadastros.sql.DAOPessoa;
import sgbr.entidades.Funcionario;
import sgbr.entidades.Pessoa;
import sgbr.util.OTDFuncionario;
import sgbr.util.Util;

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
		Pessoa pessoa = new Pessoa();
		Funcionario funcionario = new Funcionario();
		try {

			pessoa.setNmPessoa(pOtdFuncionario.getNmFuncionario());
			pessoa.setDtNascPessoa(Util.formataData(pOtdFuncionario.getDtNascimento()));
			pessoa.setEePessoa(pOtdFuncionario.getEmail());
			pessoa.setNmBairro(pOtdFuncionario.getNmBairro());
			pessoa.setNmCidade(pOtdFuncionario.getNmCidade());
			pessoa.setNmLogradouro(pOtdFuncionario.getNmLogradouro());
			pessoa.setNmUF(pOtdFuncionario.getNmUF());
			pessoa.setNuLogradouro(pOtdFuncionario.getNuLogradouro());


			pessoa = DAOPessoa.getInstancia().incluir(pessoa);

			funcionario.setCdPessoa(pessoa.getCdPessoa());
			funcionario.setVlSalario(pOtdFuncionario.getVlSalario());
			funcionario.setTpFuncionario( pOtdFuncionario.getTpFuncionario());
			funcionario.setDtAdmissao(Util.formataData(pOtdFuncionario.getDtAdmissao()));
			funcionario.setNuBancoAgencia(pOtdFuncionario.getNuAgencia());
			funcionario.setNuBancoConta(pOtdFuncionario.getNuCC());
			funcionario.setNuBancoAgencia(pOtdFuncionario.getNuAgencia());
			funcionario.setNmBanco(pOtdFuncionario.getNmBanco());			
			DAOFuncionario.getInstancia().incluir(funcionario);

		} catch (Exception e) {
			// TODO Auto-generated catch block

			// TODO gerar erro generico
			e.printStackTrace();
		}
	}
}
