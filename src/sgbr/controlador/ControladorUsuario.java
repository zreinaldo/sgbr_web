/**
 * 
 */
package sgbr.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.sql.DAOUsuario;
import sgbr.entidades.Usuario;
import sgbr.util.OTDUsuario;

/**
 * @author Reinaldo
 *
 */
/**
 * @author Reinaldo
 *
 */
public class ControladorUsuario {

	private static ControladorUsuario aControladorUsuario = new ControladorUsuario();

	/**
	 * Cria um novo objeto ControladorUsuario.
	 */
	private ControladorUsuario() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorUsuario getInstancia() {
		if (ControladorUsuario.aControladorUsuario == null) {
			ControladorUsuario.aControladorUsuario = new ControladorUsuario();
		}

		return ControladorUsuario.aControladorUsuario;
	}
	
	
	/**
	 * retorna todos os registros da tabela usuario
	 * 
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<Usuario> consultaTodosRegistrosUsuario(boolean pInRetornarApenasVigentes) throws SQLException {
		return DAOUsuario.getInstancia().consultaTodosRegistros(pInRetornarApenasVigentes);
	}

	/**
	 * utilizada na tela de consultar Usuario
	 * @param pCodigo
	 * @param pSituacao
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OTDUsuario> consultaTelaManterUsuario(String pLoginUsuario, String pTpUsuario,
			String pCdFuncionario, String pInBloqueioUsuario) throws SQLException {

		return DAOUsuario.getInstancia().consultaTelaManterUsuario(pLoginUsuario, pTpUsuario,pCdFuncionario, pInBloqueioUsuario);
	}
	
	public void incluir (Usuario pUsuario) throws SQLException {		
		 DAOUsuario.getInstancia().incluir(pUsuario);
	}
	
	public void alterar (Usuario pUsuario) throws SQLException {		
		 DAOUsuario.getInstancia().alterar(pUsuario);
	}

	public void excluir (Usuario pUsuario) throws SQLException {		
		DAOUsuario.getInstancia().excluir(pUsuario);
	}
	
	public Usuario consultaPorChavePrimaria (Usuario pUsuario) throws SQLException {
		return DAOUsuario.getInstancia().consultaPorChavePrimaria(pUsuario);
	}
	
	public OTDUsuario consultaDadosUsuario (Integer pCdUsuario) throws SQLException {
		return DAOUsuario.getInstancia().consultaDadosUsuario(pCdUsuario);
	}
	
	public OTDUsuario consultaUsuarioSenha(String pLoginUsuario, String pSenhaUsuario) throws SQLException{
		return DAOUsuario.getInstancia().consultaUsuarioSenha(pLoginUsuario, pSenhaUsuario);
	}
}
