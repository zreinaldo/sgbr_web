/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.entidades.Usuario;
import sgbr.util.OTDUsuario;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOUsuario {

	
	public Usuario incluir(Usuario pUsuario) throws SQLException;

	public void alterar(Usuario pUsuario) throws SQLException;

	public void excluir(Usuario pUsuario) throws SQLException;
	
	public Collection<Usuario> consultaTodosRegistros( boolean pInRetornarApenasVigentes)  throws SQLException;
	
	public ArrayList<OTDUsuario> consultaTelaManterUsuario(String pLoginUsuario, String pTpUsuario,
			String pCdFuncionario, String pInBloqueioUsuario) throws SQLException;
	
	public Usuario consultaPorChavePrimaria(Usuario pUsuario) throws SQLException;

	public OTDUsuario consultaDadosUsuario (Integer pCdUsuario) throws SQLException;
	
	public OTDUsuario consultaUsuarioSenha(String pLoginUsuario, String pSenhaUsuario) throws SQLException;
}
