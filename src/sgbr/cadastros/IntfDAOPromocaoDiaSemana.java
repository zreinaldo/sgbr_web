/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;

import sgbr.entidades.Promocao;
import sgbr.entidades.PromocaoDiaSemana;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOPromocaoDiaSemana {
	
	public void incluir(PromocaoDiaSemana pPromocaoDiaSemana) throws SQLException;

	public void excluir(Integer pCdPromocao) throws SQLException;

	public PromocaoDiaSemana consultaPorChavePrimaria(PromocaoDiaSemana pPromocaoDiaSemana) throws SQLException;

}
