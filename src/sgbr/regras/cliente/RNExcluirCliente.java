/**
 * 
 */
package sgbr.regras.cliente;

import sgbr.cadastros.sql.DAOCliente;
import sgbr.cadastros.sql.DAOPessoa;
import sgbr.cadastros.sql.DAOPessoaDocumento;
import sgbr.cadastros.sql.DAOPessoaTelefone;
import sgbr.entidades.Cliente;
import sgbr.entidades.Pessoa;
import sgbr.entidades.PessoaDocumento;
import sgbr.entidades.PessoaTelefone;
import sgbr.util.Constantes;
import sgbr.util.OTDCliente;

/**
 * @author Reinaldo
 *
 */
public class RNExcluirCliente {

	private static RNExcluirCliente aRNExcluirCliente = new RNExcluirCliente();

	/**
	 * Cria um novo objeto RNExcluirCliente.
	 */
	private RNExcluirCliente() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNExcluirCliente getInstancia() {
		if (RNExcluirCliente.aRNExcluirCliente == null) {
			RNExcluirCliente.aRNExcluirCliente = new RNExcluirCliente();
		}

		return RNExcluirCliente.aRNExcluirCliente;
	}

	public void processar(OTDCliente pOtdCliente) {
		Pessoa pessoa = new Pessoa();
		Cliente cliente = new Cliente();
		PessoaTelefone pessoaTelefone = new PessoaTelefone();
		PessoaDocumento pessoaDocumento = new PessoaDocumento();
		try {

			try {
				pessoaDocumento.setCdPessoa(pOtdCliente.getCdPessoa());
				pessoaDocumento.setNuDocumento(pOtdCliente.getNuCPF());
				pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_CPF);
				DAOPessoaDocumento.getInstancia().excluir(pessoaDocumento);

			} catch (Exception aE) {
			}

			try {
				
				pessoaTelefone.setCdPessoa(pOtdCliente.getCdPessoa());
				pessoaTelefone.setTpTelefone(Constantes.CD_TIPO_TELEFONE_CELULAR);
				DAOPessoaTelefone.getInstancia().excluir(pessoaTelefone);				
			} catch (Exception aE) {
			}

			cliente.setCdPessoa(pOtdCliente.getCdPessoa());
			cliente.setCdCliente(pOtdCliente.getCdCliente());
			DAOCliente.getInstancia().excluir(cliente);
			
			try {
				pessoa.setCdPessoa(pOtdCliente.getCdPessoa());
				DAOPessoa.getInstancia().excluir(pessoa);
			} catch (Exception aE) {
				// caso a pessoa seja funcionario nao deve excluir...
			}

		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}

}
