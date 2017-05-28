/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import sgbr.cadastros.sql.DAOComanda;
import sgbr.entidades.Comanda;
import sgbr.regras.comanda.RNIncluirComanda;
import sgbr.util.OTDComanda;

/**
 * @author Reinaldo
 *
 */
public class ControladorComanda {
	

	private static ControladorComanda aControladorComanda = new ControladorComanda();

	/**
	 * Cria um novo objeto ControladorComanda.
	 */
	private ControladorComanda() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorComanda getInstancia() {
		if (ControladorComanda.aControladorComanda == null) {
			ControladorComanda.aControladorComanda = new ControladorComanda();
		}

		return ControladorComanda.aControladorComanda;
	}

	/**
	 * utilizada na tela de consultar comanda
	 * @param pCodigo
	 * @param pSituacao
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OTDComanda> consultaTelaManterComanda(String pCodigo, String pSituacao) throws SQLException {

		return DAOComanda.getInstancia().consultaTelaManterComanda(pCodigo,pSituacao);
	}
	
	public void incluir (Integer pQtdComanda) throws SQLException {		
		 RNIncluirComanda.getInstancia().processar(pQtdComanda);
	}
	
	public void alterar (Comanda pComanda) throws SQLException {		
		 DAOComanda.getInstancia().alterar(pComanda);
	}

	public Comanda consultaPorChavePrimaria (Comanda pComanda) throws SQLException {
		return DAOComanda.getInstancia().consultaPorChavePrimaria(pComanda);
	}
	
	public void excluir (Comanda pComanda) throws SQLException {		
		DAOComanda.getInstancia().excluir(pComanda);
	}
	
}
