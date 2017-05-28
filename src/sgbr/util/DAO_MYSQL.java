/**
 * 
 */
package sgbr.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe responsavel por conectar ao banco mysql
 * @author Reinaldo
 *
 */
public class DAO_MYSQL {
	
	protected Date getDateOpcional (ResultSet pRs, String pCampo) {
		Date retorno = null;
		try {
			retorno = pRs.getDate(pCampo) != null ? pRs.getDate(pCampo) : null;
		} catch (SQLException e) {			
		} 
		return retorno;
	}


	//para pegar a conexao
	protected Connection getConection() throws SQLException {

		Connection conn = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb", "root", "003284");

		} catch (ClassNotFoundException eDrive) {
			System.out.println("Aten��o: Drive n�o encontrado!");
			throw new SQLException(eDrive.getMessage());			
	
		} catch (SQLException erro){
			System.out.println("Erro - banco pode estar desativado... ou ter ocorrido qualquer problema com o comando SQL");
			throw erro;
			
			
		}

		return conn;
	}
}
