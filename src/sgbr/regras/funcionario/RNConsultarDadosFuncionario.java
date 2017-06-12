/**
 * 
 */
package sgbr.regras.funcionario;

import java.sql.SQLException;

import sgbr.cadastros.sql.DAOFuncionario;
import sgbr.cadastros.sql.DAOPessoaDocumento;
import sgbr.cadastros.sql.DAOPessoaTelefone;
import sgbr.entidades.PessoaDocumento;
import sgbr.entidades.PessoaTelefone;
import sgbr.util.Constantes;
import sgbr.util.OTDFuncionario;

/**
 * 
 * regra de negocio responsavel por consultar as informcoes do funcionario
 * 
 * @author Reinaldo
 *
 */
public class RNConsultarDadosFuncionario {
	private static RNConsultarDadosFuncionario aRNConsultarFuncionario = new RNConsultarDadosFuncionario();

	/**
	 * Cria um novo objeto RNConsultarFuncionario.
	 */
	private RNConsultarDadosFuncionario() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNConsultarDadosFuncionario getInstancia() {
		if (RNConsultarDadosFuncionario.aRNConsultarFuncionario == null) {
			RNConsultarDadosFuncionario.aRNConsultarFuncionario = new RNConsultarDadosFuncionario();
		}

		return RNConsultarDadosFuncionario.aRNConsultarFuncionario;
	}

	/**
	 * @param pCdFuncionario
	 * @param pCdPessoa
	 * @return
	 * @throws SQLException
	 */
	public OTDFuncionario processar(Integer pCdFuncionario, Integer pCdPessoa) throws SQLException {

		OTDFuncionario otdFuncionario = DAOFuncionario.getInstancia().consultarDadosFuncionario(pCdFuncionario,
				pCdPessoa);

		this.setDocumentosFuncionario(otdFuncionario);
		this.setTelefonesFuncionario(otdFuncionario);

		return otdFuncionario;

	}

	private void setTelefonesFuncionario(OTDFuncionario otdFuncionario) throws SQLException {

		PessoaTelefone pessoaTelefone = this.getPessoaTelefone(otdFuncionario.getCdPessoa(),
				Constantes.CD_TIPO_TELEFONE_CELULAR);

		if (pessoaTelefone != null) {
			otdFuncionario.setNuTelefoneCelular(pessoaTelefone.getNuTelefone());
			otdFuncionario.setDddTelefoneCelular(pessoaTelefone.getNuDDDTelefone());
		}

		pessoaTelefone = this.getPessoaTelefone(otdFuncionario.getCdPessoa(), Constantes.CD_TIPO_TELEFONE_CONVENCIONAL);

		if (pessoaTelefone != null) {
			otdFuncionario.setNuTelefoneConvencional(pessoaTelefone.getNuTelefone());
			otdFuncionario.setDddTelefoneConvencional(pessoaTelefone.getNuDDDTelefone());
		}

	}

	/**
	 * @param otdFuncionario
	 * @throws SQLException
	 */
	private void setDocumentosFuncionario(OTDFuncionario otdFuncionario) throws SQLException {

		otdFuncionario.setNuCPF(this.getNuDocumento(otdFuncionario.getCdPessoa(), Constantes.CD_TIPO_DOCUMENTO_CPF));
		otdFuncionario.setNuCarteira(
				this.getNuDocumento(otdFuncionario.getCdPessoa(), Constantes.CD_TIPO_DOCUMENTO_CARTEIRA_TRABALHO));

		otdFuncionario.setNuRG(this.getNuDocumento(otdFuncionario.getCdPessoa(), Constantes.CD_TIPO_DOCUMENTO_RG));
	}

	private String getNuDocumento(Integer pCdPessoa, Integer pTpDocumento) throws SQLException {

		String retorno = "";
		PessoaDocumento pessoaDocumento = new PessoaDocumento(pCdPessoa, pTpDocumento);

		pessoaDocumento = DAOPessoaDocumento.getInstancia().consultarPorChavePrimaria(pessoaDocumento);

		if (pessoaDocumento != null) {
			retorno = pessoaDocumento.getNuDocumento();
		}

		return retorno;
	}

	private PessoaTelefone getPessoaTelefone(Integer pCdPessoa, Integer pTpTelefone) throws SQLException {

		PessoaTelefone pessoaDocumento = new PessoaTelefone(pCdPessoa, pTpTelefone);

		return DAOPessoaTelefone.getInstancia().consultarPorChavePrimaria(pessoaDocumento);

	}
}
