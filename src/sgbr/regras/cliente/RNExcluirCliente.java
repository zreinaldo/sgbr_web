/**
 * 
 */
package sgbr.regras.cliente;

import sgbr.cadastros.sql.DAOCliente;
import sgbr.cadastros.sql.DAOPessoa;
import sgbr.cadastros.sql.DAOPessoaDocumento;
import sgbr.entidades.Cliente;
import sgbr.entidades.Pessoa;
import sgbr.entidades.PessoaDocumento;
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
		Cliente	cliente = new Cliente();
		PessoaDocumento pessoaDocumento = new PessoaDocumento();
		try {

//			// DAOPessoaDocumento.getInstancia().consultarPorChavePrimaria(pPessoaDocumento);
			try {

				pessoaDocumento.setCdPessoa(pOtdCliente.getCdPessoa());
				pessoaDocumento.setNuDocumento(pOtdCliente.getNuCPF());
				pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_CPF);
				DAOPessoaDocumento.getInstancia().excluir(pessoaDocumento);

			} catch (Exception aE) {
				// TODO: handle exception
			}
//			try {
//				pessoaDocumento = new PessoaDocumento();
//				pessoaDocumento.setCdPessoa(pOtdFuncionario.getCdPessoa());
//				pessoaDocumento.setNuDocumento(pOtdFuncionario.getNuRG());
//				pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_RG);
//				DAOPessoaDocumento.getInstancia().excluir(pessoaDocumento);
//			} catch (Exception aE) {
//				// TODO: handle exception
//			}
//			try {
//				pessoaDocumento = new PessoaDocumento();
//				pessoaDocumento.setCdPessoa(pOtdFuncionario.getCdPessoa());
//				pessoaDocumento.setNuDocumento(pOtdFuncionario.getNuCarteira());
//				pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_CARTEIRA_TRABALHO);
//				DAOPessoaDocumento.getInstancia().excluir(pessoaDocumento);
//
//			} catch (Exception aE) {
//				// TODO: handle exception
//			}
			cliente.setCdPessoa(pOtdCliente.getCdPessoa());
			cliente.setCdCliente(pOtdCliente.getCdCliente());
			DAOCliente.getInstancia().excluir(cliente);

			pessoa.setCdPessoa(pOtdCliente.getCdPessoa());
			DAOPessoa.getInstancia().excluir(pessoa);

		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}



}
