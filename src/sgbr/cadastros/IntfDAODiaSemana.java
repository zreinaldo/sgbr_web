/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;
import java.util.ArrayList;

import sgbr.entidades.DiaSemana;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAODiaSemana {
	
	
	public ArrayList<DiaSemana> consultaTodosRegistros() throws SQLException;

}
