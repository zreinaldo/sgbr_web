/**
 * 
 */
package sgbr.regras.funcionario;

import java.sql.SQLException;

import sgbr.cadastros.sql.DAOFuncionario;
import sgbr.cadastros.sql.DAOPessoaDocumento;
import sgbr.entidades.PessoaDocumento;
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

		return otdFuncionario;

	}

	/**
	 * @param otdFuncionario
	 * @throws SQLException
	 */
	private void setDocumentosFuncionario(OTDFuncionario otdFuncionario) throws SQLException {
		PessoaDocumento pessoaDocumento = new PessoaDocumento(otdFuncionario.getCdPessoa(),
				Constantes.CD_TIPO_DOCUMENTO_CPF);

		pessoaDocumento = DAOPessoaDocumento.getInstancia().consultarPorChavePrimaria(pessoaDocumento);
		otdFuncionario.setNuCPF(pessoaDocumento.getNuDocumento());

		pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_CARTEIRA_TRABALHO);
		pessoaDocumento = DAOPessoaDocumento.getInstancia().consultarPorChavePrimaria(pessoaDocumento);
		otdFuncionario.setNuCarteira(pessoaDocumento.getNuDocumento());

		pessoaDocumento.setTpDocumento(Constantes.CD_TIPO_DOCUMENTO_RG);
		pessoaDocumento = DAOPessoaDocumento.getInstancia().consultarPorChavePrimaria(pessoaDocumento);
		otdFuncionario.setNuRG(pessoaDocumento.getNuDocumento());
	}
}
