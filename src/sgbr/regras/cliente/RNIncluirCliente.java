/**
 * 
 */
package sgbr.regras.cliente;

import java.sql.SQLException;

import sgbr.cadastros.sql.DAOCliente;
import sgbr.cadastros.sql.DAOFuncionario;
import sgbr.cadastros.sql.DAOPessoa;
import sgbr.cadastros.sql.DAOPessoaDocumento;
import sgbr.entidades.Cliente;
import sgbr.entidades.Funcionario;
import sgbr.entidades.Pessoa;
import sgbr.entidades.PessoaDocumento;
import sgbr.util.Constantes;
import sgbr.util.OTDCliente;

/**
 * @author Reinaldo
 *
 */
public class RNIncluirCliente {

	private static RNIncluirCliente aRNIncluirCliente = new RNIncluirCliente();

	/**
	 * Cria um novo objeto RNIncluirCliente.
	 */
	private RNIncluirCliente() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNIncluirCliente getInstancia() {
		if (RNIncluirCliente.aRNIncluirCliente == null) {
			RNIncluirCliente.aRNIncluirCliente = new RNIncluirCliente();
		}

		return RNIncluirCliente.aRNIncluirCliente;
	}

	public void processar(OTDCliente pOTDCliente) {
		Pessoa pessoa = null;

		try {

			pessoa = incluirPessoa(pOTDCliente);

			this.incluirCliente(pessoa);

			incluirPessoaDocumento(pOTDCliente, pessoa);

		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}

	/**
	 * @param pOTDCliente
	 * @param pessoa
	 * @throws SQLException
	 */
	private void incluirPessoaDocumento(OTDCliente pOTDCliente, Pessoa pessoa) throws SQLException {
		PessoaDocumento pessoaDocumento;
		pessoaDocumento = new PessoaDocumento();
		pessoaDocumento.setCdPessoa(pessoa.getCdPessoa());
		pessoaDocumento.setNuDocumento(pOTDCliente.getNuCPF());
		pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_CPF);
		DAOPessoaDocumento.getInstancia().incluir(pessoaDocumento);
	}

	/**
	 * @param pessoa
	 * @throws SQLException
	 */
	private void incluirCliente(Pessoa pessoa) throws SQLException {
		Cliente cliente;
		cliente = new Cliente();
		cliente.setCdPessoa(pessoa.getCdPessoa());
		DAOCliente.getInstancia().incluir(cliente);
	}

	/**
	 * @param pOTDCliente
	 * @return
	 * @throws SQLException
	 */
	private Pessoa incluirPessoa(OTDCliente pOTDCliente) throws SQLException {
		Pessoa pessoa;
		pessoa = new Pessoa();
		pessoa.setNmPessoa(pOTDCliente.getNmCliente());
		pessoa.setDtNascPessoa(pOTDCliente.getDtNascimento());
		pessoa.setEePessoa(pOTDCliente.getEmail());
		pessoa = DAOPessoa.getInstancia().incluir(pessoa);
		return pessoa;
	}

}
