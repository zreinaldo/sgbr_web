/**
 * 
 */
package sgbr.regras.cliente;

import java.sql.SQLException;

import sgbr.cadastros.sql.DAOPessoa;
import sgbr.cadastros.sql.DAOPessoaDocumento;
import sgbr.cadastros.sql.DAOPessoaTelefone;
import sgbr.entidades.Pessoa;
import sgbr.entidades.PessoaDocumento;
import sgbr.entidades.PessoaTelefone;
import sgbr.util.Constantes;
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

	public void processar(OTDCliente pOtdCliente) {

		try {
			Pessoa pessoa = new Pessoa();

			pessoa.setCdPessoa(pOtdCliente.getCdPessoa());
			pessoa.setNmPessoa(pOtdCliente.getNmCliente());
			pessoa.setDtNascPessoa(pOtdCliente.getDtNascimento());
			pessoa.setEePessoa(pOtdCliente.getEmail());

			DAOPessoa.getInstancia().alterar(pessoa);

			this.alterarPessoaTelefone(pOtdCliente);

			this.alterarPessoaDocumento(pOtdCliente.getCdPessoa(), pOtdCliente.getNuCPF(),
					Constantes.CD_TIPO_DOCUMENTO_CPF);

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

	private void alterarPessoaTelefone(OTDCliente pOTDCliente) throws SQLException {
		boolean inExclusao = false;
		PessoaTelefone pessoaTelefone = new PessoaTelefone();
		pessoaTelefone.setTpTelefone(Constantes.CD_TIPO_TELEFONE_CELULAR);
		pessoaTelefone.setCdPessoa(pOTDCliente.getCdPessoa());
		pessoaTelefone.setNuDDDTelefone(pOTDCliente.getDddTelefone());
		pessoaTelefone.setNuTelefone(pOTDCliente.getNuTelefone());

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
