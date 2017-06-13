/**
 * 
 */
package sgbr.regras.funcionario;

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
public class RNExcluirFuncionario {

	private static RNExcluirFuncionario aRNExcluirFuncionario = new RNExcluirFuncionario();

	/**
	 * Cria um novo objeto RNExcluirFuncionario.
	 */
	private RNExcluirFuncionario() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNExcluirFuncionario getInstancia() {
		if (RNExcluirFuncionario.aRNExcluirFuncionario == null) {
			RNExcluirFuncionario.aRNExcluirFuncionario = new RNExcluirFuncionario();
		}

		return RNExcluirFuncionario.aRNExcluirFuncionario;
	}

	public void processar(OTDFuncionario pOtdFuncionario) {
		Pessoa pessoa = new Pessoa();
		Funcionario funcionario = new Funcionario();
		PessoaDocumento pessoaDocumento = new PessoaDocumento();
		PessoaTelefone pessoaTelefone = new PessoaTelefone();
		try {

			try {

				pessoaDocumento.setCdPessoa(pOtdFuncionario.getCdPessoa());
				pessoaDocumento.setNuDocumento(pOtdFuncionario.getNuCPF());
				pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_CPF);
				DAOPessoaDocumento.getInstancia().excluir(pessoaDocumento);

			} catch (Exception aE) {
				// caso a pessoa seja cliente nao deve excluir...
			}
			try {
				pessoaDocumento = new PessoaDocumento();
				pessoaDocumento.setCdPessoa(pOtdFuncionario.getCdPessoa());
				pessoaDocumento.setNuDocumento(pOtdFuncionario.getNuRG());
				pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_RG);
				DAOPessoaDocumento.getInstancia().excluir(pessoaDocumento);
			} catch (Exception aE) {
				// caso a pessoa seja cliente nao deve excluir...
			}
			try {
				pessoaDocumento = new PessoaDocumento();
				pessoaDocumento.setCdPessoa(pOtdFuncionario.getCdPessoa());
				pessoaDocumento.setNuDocumento(pOtdFuncionario.getNuCarteira());
				pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_CARTEIRA_TRABALHO);
				DAOPessoaDocumento.getInstancia().excluir(pessoaDocumento);

			} catch (Exception aE) {
				// caso a pessoa seja cliente nao deve excluir...
			}

			funcionario.setCdPessoa(pOtdFuncionario.getCdPessoa());
			funcionario.setCdFuncionario(pOtdFuncionario.getCdFuncionario());
			DAOFuncionario.getInstancia().excluir(funcionario);

			try {

				pessoaTelefone.setCdPessoa(pOtdFuncionario.getCdPessoa());
				pessoaTelefone.setTpTelefone(Constantes.CD_TIPO_TELEFONE_CELULAR);
				DAOPessoaTelefone.getInstancia().excluir(pessoaTelefone);
			} catch (Exception aE) {
				// caso a pessoa seja cliente nao deve excluir...
			}

			try {
				pessoaTelefone.setCdPessoa(pOtdFuncionario.getCdPessoa());
				pessoaTelefone.setTpTelefone(Constantes.CD_TIPO_TELEFONE_CONVENCIONAL);
				DAOPessoaTelefone.getInstancia().excluir(pessoaTelefone);
			} catch (Exception aE) {
				// caso a pessoa seja cliente nao deve excluir...
			}
			
			try {

				pessoa.setCdPessoa(pOtdFuncionario.getCdPessoa());
				DAOPessoa.getInstancia().excluir(pessoa);
			} catch (Exception aE) {
				// caso a pessoa seja cliente nao deve excluir...
			}

		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}

}
