/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.sql.DAOConta;
import sgbr.entidades.Comanda;
import sgbr.entidades.Conta;
import sgbr.entidades.Mesa;
import sgbr.util.OTDCliente;
import sgbr.util.OTDConta;

/**
 * @author Reinaldo
 *
 */
public class ControladorConta {

	private static ControladorConta aControladorConta = new ControladorConta();

	/**
	 * Cria um novo objeto ControladorConta.
	 */
	private ControladorConta() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorConta getInstancia() {
		if (ControladorConta.aControladorConta == null) {
			ControladorConta.aControladorConta = new ControladorConta();
		}

		return ControladorConta.aControladorConta;
	}

	public Collection<Comanda> consultaComandaConta(String pInUso, String pCdTipoConta) throws SQLException {
		return DAOConta.getInstancia().consultaComandaConta(pInUso, pCdTipoConta);
	}

	public Collection<Mesa> consultaMesaConta(String pInUso, String pCdTipoConta) throws SQLException {
		return DAOConta.getInstancia().consultaMesaConta(pInUso, pCdTipoConta);
	}

	public ArrayList<OTDConta> consultaTelaManterConta(String pCdMesa, String pCdComanda, String pSiConta, String pCdCliente)
			throws SQLException {
		return DAOConta.getInstancia().consultaTelaManterConta(pCdMesa, pCdComanda, pSiConta, pCdCliente);
	}
	
	public OTDConta consultaDetalharConta(String pCdConta) throws SQLException {
		return DAOConta.getInstancia().consultaDetalharConta(pCdConta);
	}
	
	public void alterarClienteConta(Conta pConta) throws SQLException {
		DAOConta.getInstancia().alterar(pConta);
	}
	
	

	public Collection<OTDCliente> consultaClienteConta(boolean pInUso) throws SQLException {
		return DAOConta.getInstancia().consultaClienteConta(pInUso);

	}

	public void incluir(Conta pConta) throws SQLException {
		DAOConta.getInstancia().incluir(pConta);
	}
	

	public void excluir(Conta pConta) throws SQLException {
		DAOConta.getInstancia().excluir(pConta);
	}
}
