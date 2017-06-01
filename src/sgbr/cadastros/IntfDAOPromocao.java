/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.entidades.Promocao;
import sgbr.util.OTDPromocao;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOPromocao {

	
	public Promocao incluir(Promocao pPromocao) throws SQLException;

	public void alterar(Promocao pPromocao) throws SQLException;

	public void excluir(Promocao pPromocao) throws SQLException;
	
	public Collection<Promocao> consultaTodosRegistros( String pInRetornarApenasVigentes)  throws SQLException;
	
	public ArrayList<OTDPromocao> consultaTelaManterPromocao(String pCdItemCardapio,
			String pInRetornarApenasVigentes,  String pDiaSemanaPromocao) throws SQLException;
	
	public Promocao consultaPorChavePrimaria(Promocao pPromocao) throws SQLException;
	
}
