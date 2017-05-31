/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import sgbr.cadastros.sql.DAOCliente;
import sgbr.regras.cliente.RNAlterarCliente;
import sgbr.regras.cliente.RNExcluirCliente;
import sgbr.regras.cliente.RNIncluirCliente;
import sgbr.util.OTDCliente;
import sgbr.util.OTDFuncionario;

/**
 * @author Reinaldo
 *
 */
public class ControladorCliente {

	private static ControladorCliente aControladorCliente = new ControladorCliente();

	/**
	 * Cria um novo objeto ControladorCliente.
	 */
	private ControladorCliente() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorCliente getInstancia() {
		if (ControladorCliente.aControladorCliente == null) {
			ControladorCliente.aControladorCliente = new ControladorCliente();
		}

		return ControladorCliente.aControladorCliente;
	}

	public void incluir(OTDCliente pOtdCliente) {

		RNIncluirCliente.getInstancia().processar(pOtdCliente);

	}

	public void alterar(OTDCliente pOtdCliente) {

		RNAlterarCliente.getInstancia().processar(pOtdCliente);

	}
	
	public void excluir(OTDCliente pOtdCliente) {

		RNExcluirCliente.getInstancia().processar(pOtdCliente);

	}

	public ArrayList<OTDCliente> consultaTelaManterCliente(String pNome, String pTpDocumento, String pNuDocumento)
			throws SQLException {
		return DAOCliente.getInstancia().consultaTelaManterCliente(pNome, pTpDocumento, pNuDocumento);
	}

	public OTDCliente consultarDadosCliente(Integer pCdCliente, Integer pCdPessoa) throws SQLException {
		return DAOCliente.getInstancia().consultarDadosCliente(pCdCliente, pCdPessoa);
	}

}
