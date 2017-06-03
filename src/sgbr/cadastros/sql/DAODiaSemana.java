/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sgbr.cadastros.IntfDAODiaSemana;
import sgbr.entidades.DiaSemana;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAODiaSemana extends DAO_MYSQL implements IntfDAODiaSemana {
	
	private static DAODiaSemana aDAODiaSemana = new DAODiaSemana();

	/**
	 * Cria um novo objeto DAODiaSemana.
	 */
	private DAODiaSemana() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAODiaSemana getInstancia() {
		if (DAODiaSemana.aDAODiaSemana == null) {
			DAODiaSemana.aDAODiaSemana = new DAODiaSemana();
		}

		return DAODiaSemana.aDAODiaSemana;
	}


	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAODiaSemana#consultaTodosRegistros(sgbr.entidades.DiaSemana)
	 */
	@Override
	public ArrayList<DiaSemana> consultaTodosRegistros() throws SQLException {



		Connection conexao = null;
		DiaSemana diaSemana = null;
		ArrayList<DiaSemana> aDiaSemana = new ArrayList<>();

		conexao = this.getConection();

		String sql = "select * from mydb.dia_semana";


		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			diaSemana = new DiaSemana();
			diaSemana.setCdDiaSemana(rs.getInt(DiaSemana.NM_COLUNA_DIA_SEMANA_CD));
			diaSemana.setDsDiaSemana(rs.getString(DiaSemana.NM_COLUNA_DIA_SEMANA_DS));
			aDiaSemana.add(diaSemana);

		}

		rs.close();
		stm.close();
		conexao.close();
		
		return aDiaSemana;
	}

}
