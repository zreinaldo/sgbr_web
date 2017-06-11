/**
 * 
 */
package sgbr.regras.cliente;

import java.sql.SQLException;

import sgbr.cadastros.sql.DAOPessoa;
import sgbr.cadastros.sql.DAOPessoaTelefone;
import sgbr.entidades.Pessoa;
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

	public void processar(OTDCliente pOtdFuncionario) {

		try {
			Pessoa pessoa = new Pessoa();

			pessoa.setCdPessoa(pOtdFuncionario.getCdPessoa());
			pessoa.setNmPessoa(pOtdFuncionario.getNmCliente());
			pessoa.setDtNascPessoa(pOtdFuncionario.getDtNascimento());
			pessoa.setEePessoa(pOtdFuncionario.getEmail());

			DAOPessoa.getInstancia().alterar(pessoa);

			pessoaTelefone(pOtdFuncionario, pessoa);

		} catch (Exception e) {
			// TODO gerar erro generico
			e.printStackTrace();
		}
	}

	private void pessoaTelefone(OTDCliente pOTDCliente, Pessoa pessoa) throws SQLException {

		PessoaTelefone pessoaTelefone = new PessoaTelefone();
		pessoaTelefone.setTpTelefone(Constantes.CD_TIPO_TELEFONE_CELULAR);
		pessoaTelefone.setCdPessoa(pessoa.getCdPessoa());
		pessoaTelefone.setNuDDDTelefone(pOTDCliente.getDddTelefone());
		pessoaTelefone.setNuTelefone(pOTDCliente.getNuTelefone());

		PessoaTelefone pessoaTelefoneBase = DAOPessoaTelefone.getInstancia().consultarPorChavePrimaria(pessoaTelefone);

		if (pessoaTelefoneBase == null) {
			DAOPessoaTelefone.getInstancia().incluir(pessoaTelefone);

		} else {

			DAOPessoaTelefone.getInstancia().alterar(pessoaTelefone);
		}
		
		//FIXME - EXCLUIR

	}

}
