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
		Pessoa pessoa = null;

		try {

			pessoa = this.incluirPessoa(pOtdFuncionario);

			this.incluirFuncionario(pOtdFuncionario, pessoa);

			this.incluirPessoaDocumento(pessoa.getCdPessoa(), pOtdFuncionario.getNuCPF(),
					Constantes.CD_TIPO_DOCUMENTO_CPF);

			this.incluirPessoaDocumento(pessoa.getCdPessoa(), pOtdFuncionario.getNuRG(),
					Constantes.CD_TIPO_DOCUMENTO_RG);

			this.incluirPessoaDocumento(pessoa.getCdPessoa(), pOtdFuncionario.getNuCarteira(),
					Constantes.CD_TIPO_DOCUMENTO_CARTEIRA_TRABALHO);

			this.incluirPessoaTelefone(pessoa.getCdPessoa(), pOtdFuncionario.getDddTelefoneConvencional(),
					pOtdFuncionario.getNuTelefoneConvencional(), Constantes.CD_TIPO_TELEFONE_CONVENCIONAL);

			this.incluirPessoaTelefone(pessoa.getCdPessoa(), pOtdFuncionario.getDddTelefoneCelular(),
					pOtdFuncionario.getNuTelefoneCelular(), Constantes.CD_TIPO_TELEFONE_CELULAR);
		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}

	/**
	 * inclui na tabela pessoa doccumento
	 * 
	 * @param pCdPessoa
	 * @param pNuDocumento
	 * @param pTpDocumento
	 * @throws SQLException
	 */
	private void incluirPessoaDocumento(Integer pCdPessoa, String pNuDocumento, Integer pTpDocumento)
			throws SQLException {
		PessoaDocumento pessoaDocumento = new PessoaDocumento();
		pessoaDocumento.setCdPessoa(pCdPessoa);
		pessoaDocumento.setNuDocumento(pNuDocumento);
		pessoaDocumento.setTpDocumento(pTpDocumento);
		DAOPessoaDocumento.getInstancia().incluir(pessoaDocumento);
	}

	/**
	 * inclu na tabela pessoa telefone
	 * 
	 * @param pCdPessoa
	 * @param pDddTelefone
	 * @param pNuTelefone
	 * @param pTpTelefone
	 * @throws SQLException
	 */
	private void incluirPessoaTelefone(Integer pCdPessoa, String pDddTelefone, String pNuTelefone, Integer pTpTelefone)
			throws SQLException {
		PessoaTelefone pessoaTelefone = new PessoaTelefone();
		pessoaTelefone.setCdPessoa(pCdPessoa);
		pessoaTelefone.setNuDDDTelefone(pDddTelefone);
		pessoaTelefone.setNuTelefone(pNuTelefone);
		pessoaTelefone.setTpTelefone(pTpTelefone);
		DAOPessoaTelefone.getInstancia().incluir(pessoaTelefone);
	}

	/**
	 * @param pOtdFuncionario
	 * @param pPessoa
	 * @param funcionario
	 * @throws SQLException
	 */
	private void incluirFuncionario(OTDFuncionario pOtdFuncionario, Pessoa pPessoa) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setCdPessoa(pPessoa.getCdPessoa());
		funcionario.setVlSalario(pOtdFuncionario.getVlSalario());
		funcionario.setTpFuncionario(pOtdFuncionario.getTpFuncionario());
		funcionario.setDtAdmissao(pOtdFuncionario.getDtAdmissao());
		funcionario.setNuBancoAgencia(pOtdFuncionario.getNuAgencia());
		funcionario.setNuBancoConta(pOtdFuncionario.getNuCC());
		funcionario.setNuBancoAgencia(pOtdFuncionario.getNuAgencia());
		funcionario.setNmBanco(pOtdFuncionario.getNmBanco());
		DAOFuncionario.getInstancia().incluir(funcionario);
	}

	/**
	 * @param pOtdFuncionario
	 * @param pessoa
	 * @return
	 * @throws SQLException
	 */
	private Pessoa incluirPessoa(OTDFuncionario pOtdFuncionario) throws SQLException {
		Pessoa pessoa = new Pessoa();

		pessoa.setNmPessoa(pOtdFuncionario.getNmFuncionario());
		pessoa.setDtNascPessoa(pOtdFuncionario.getDtNascimento());
		pessoa.setEePessoa(pOtdFuncionario.getEmail());
		pessoa.setNmBairro(pOtdFuncionario.getNmBairro());
		pessoa.setNmCidade(pOtdFuncionario.getNmCidade());
		pessoa.setNmLogradouro(pOtdFuncionario.getNmLogradouro());
		pessoa.setNmUF(pOtdFuncionario.getNmUF());
		pessoa.setNuLogradouro(pOtdFuncionario.getNuLogradouro());
		pessoa.setNuCEP(pOtdFuncionario.getNuCEP());

		pessoa = DAOPessoa.getInstancia().incluir(pessoa);
		return pessoa;
	}
}
