/**
 * 
 */
package sgbr.regras.funcionario;

import sgbr.cadastros.sql.DAOFuncionario;
import sgbr.cadastros.sql.DAOPessoa;
import sgbr.cadastros.sql.DAOPessoaDocumento;
import sgbr.entidades.Funcionario;
import sgbr.entidades.Pessoa;
import sgbr.entidades.PessoaDocumento;
import sgbr.util.Constantes;
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
		PessoaDocumento pessoaDocumento = new PessoaDocumento();
		try {

			pessoa.setNmPessoa(pOtdFuncionario.getNmFuncionario());
			pessoa.setDtNascPessoa(pOtdFuncionario.getDtNascimento());
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
			funcionario.setDtAdmissao(pOtdFuncionario.getDtAdmissao());
			funcionario.setNuBancoAgencia(pOtdFuncionario.getNuAgencia());
			funcionario.setNuBancoConta(pOtdFuncionario.getNuCC());
			funcionario.setNuBancoAgencia(pOtdFuncionario.getNuAgencia());
			funcionario.setNmBanco(pOtdFuncionario.getNmBanco());			
			DAOFuncionario.getInstancia().incluir(funcionario);
			
			
			pessoaDocumento.setCdPessoa(pessoa.getCdPessoa());
			pessoaDocumento.setNuDocumento(pOtdFuncionario.getNuCPF());
			pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_CPF);			
			DAOPessoaDocumento.getInstancia().incluir(pessoaDocumento);

			pessoaDocumento = new PessoaDocumento();
			pessoaDocumento.setCdPessoa(pessoa.getCdPessoa());
			pessoaDocumento.setNuDocumento(pOtdFuncionario.getNuRG());
			pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_RG);			
			DAOPessoaDocumento.getInstancia().incluir(pessoaDocumento);
			
			pessoaDocumento = new PessoaDocumento();
			pessoaDocumento.setCdPessoa(pessoa.getCdPessoa());
			pessoaDocumento.setNuDocumento(pOtdFuncionario.getNuCarteira());
			pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_CARTEIRA_TRABALHO);
			
			DAOPessoaDocumento.getInstancia().incluir(pessoaDocumento);
		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}
}
