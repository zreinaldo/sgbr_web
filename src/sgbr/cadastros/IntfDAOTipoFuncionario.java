/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.entidades.TipoFuncionario;
import sgbr.util.OTDTipoFuncionario;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOTipoFuncionario {

	
	public TipoFuncionario incluir(TipoFuncionario pTipoFuncionario) throws SQLException;

	public void alterar(TipoFuncionario pTipoFuncionario) throws SQLException;

	public void excluir(TipoFuncionario pTipoFuncionario) throws SQLException;
	
	public Collection<TipoFuncionario> consultaTodosRegistros( boolean pInRetornarApenasVigentes)  throws SQLException;
	
	public ArrayList<OTDTipoFuncionario> consultaTelaManterTipoFuncionario(String pCdTipoFuncionario, String pDsTipoFuncionario) throws SQLException;
	
	public TipoFuncionario consultaPorChavePrimaria(TipoFuncionario pTipoFuncionario) throws SQLException;
	
}
