/**
 * 
 */
package sgbr.regras.funcionario;

import java.sql.SQLException;

import sgbr.cadastros.sql.DAOFuncionario;
import sgbr.cadastros.sql.DAOPessoa;
import sgbr.cadastros.sql.DAOPessoaDocumento;
import sgbr.cadastros.sql.DAOPessoaTelefone;
import sgbr.entidades.Funcionario;
import sgbr.entidades.Pessoa;
import sgbr.entidades.PessoaDocumento;
import sgbr.entidades.PessoaTelefone;
import sgbr.util.Constantes;
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

			this.alterarPessoa(pOtdFuncionario);

			this.alterarFuncionario(pOtdFuncionario);

			this.alterarPessoaTelefone(pOtdFuncionario.getCdPessoa(), pOtdFuncionario.getDddTelefoneCelular(),
					pOtdFuncionario.getNuTelefoneCelular(), Constantes.CD_TIPO_TELEFONE_CELULAR);

			this.alterarPessoaTelefone(pOtdFuncionario.getCdPessoa(), pOtdFuncionario.getDddTelefoneConvencional(),
					pOtdFuncionario.getNuTelefoneConvencional(), Constantes.CD_TIPO_TELEFONE_CONVENCIONAL);

			this.alterarPessoaDocumento(pOtdFuncionario.getCdPessoa(), pOtdFuncionario.getNuCPF(),
					Constantes.CD_TIPO_DOCUMENTO_CPF);

			this.alterarPessoaDocumento(pOtdFuncionario.getCdPessoa(), pOtdFuncionario.getNuRG(),
					Constantes.CD_TIPO_DOCUMENTO_RG);

			this.alterarPessoaDocumento(pOtdFuncionario.getCdPessoa(), pOtdFuncionario.getNuCarteira(),
					Constantes.CD_TIPO_DOCUMENTO_CARTEIRA_TRABALHO);

		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}

	private void alterarPessoaDocumento(Integer pCdPessoa, String pNuDocumento, Integer pTpDocumento)
			throws SQLException {
		PessoaDocumento pessoaDocumento = new PessoaDocumento();
		pessoaDocumento.setCdPessoa(pCdPessoa);
		pessoaDocumento.setTpDocumento(pTpDocumento);
		pessoaDocumento.setNuDocumento(pNuDocumento);

		PessoaDocumento pessoaDocumentoBase = DAOPessoaDocumento.getInstancia()
				.consultarPorChavePrimaria(pessoaDocumento);

		if (pessoaDocumentoBase == null) {
			DAOPessoaDocumento.getInstancia().incluir(pessoaDocumento);
		} else {
			DAOPessoaDocumento.getInstancia().alterar(pessoaDocumento);
		}

	}

	/**
	 * @param pOtdFuncionario
	 * @throws SQLException
	 */
	private void alterarFuncionario(OTDFuncionario pOtdFuncionario) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setCdPessoa(pOtdFuncionario.getCdPessoa());
		funcionario.setCdFuncionario(pOtdFuncionario.getCdFuncionario());
		funcionario.setVlSalario(pOtdFuncionario.getVlSalario());
		funcionario.setTpFuncionario(pOtdFuncionario.getTpFuncionario());
		funcionario.setDtAdmissao(pOtdFuncionario.getDtAdmissao());
		funcionario.setDtDemissao(pOtdFuncionario.getDtDemissao());
		funcionario.setNuBancoAgencia(pOtdFuncionario.getNuAgencia());
		funcionario.setNuBancoConta(pOtdFuncionario.getNuCC());
		funcionario.setNuBancoAgencia(pOtdFuncionario.getNuAgencia());
		funcionario.setNmBanco(pOtdFuncionario.getNmBanco());
		DAOFuncionario.getInstancia().alterar(funcionario);
	}

	/**
	 * @param pOtdFuncionario
	 * @throws SQLException
	 */
	private void alterarPessoa(OTDFuncionario pOtdFuncionario) throws SQLException {
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
		pessoa.setNuCEP(pOtdFuncionario.getNuCEP());
		DAOPessoa.getInstancia().alterar(pessoa);
	}

	private void alterarPessoaTelefone(Integer pCdPessoa, String pDddTelefone, String pNuTelefone, Integer pTpTelefone)
			throws SQLException {
		boolean inExclusao = false;

		PessoaTelefone pessoaTelefone = new PessoaTelefone();
		pessoaTelefone.setCdPessoa(pCdPessoa);
		pessoaTelefone.setNuDDDTelefone(pDddTelefone);
		pessoaTelefone.setNuTelefone(pNuTelefone);
		pessoaTelefone.setTpTelefone(pTpTelefone);

		if (pessoaTelefone.getNuDDDTelefone().isEmpty() && pessoaTelefone.getNuDDDTelefone().isEmpty()) {
			DAOPessoaTelefone.getInstancia().excluir(pessoaTelefone);
			inExclusao = true;
		}

		if (!inExclusao) {
			PessoaTelefone pessoaTelefoneBase = DAOPessoaTelefone.getInstancia()
					.consultarPorChavePrimaria(pessoaTelefone);
			if (pessoaTelefoneBase == null) {
				DAOPessoaTelefone.getInstancia().incluir(pessoaTelefone);

			} else {

				DAOPessoaTelefone.getInstancia().alterar(pessoaTelefone);
			}
		}

	}

}
