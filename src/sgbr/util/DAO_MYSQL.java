/**
 * 
 */
package sgbr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * classe responsavel por conectar ao banco mysql
 * @author Reinaldo
 *
 */
public class DAO_MYSQL {

	//para pegar a conexao
	public static Connection getConection() throws SQLException {

		Connection conn = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb", "root", "003284");
			
			System.out.println("Conexão com o banco estabelecida com sucesso!");

		} catch (ClassNotFoundException eDrive) {
			System.out.println("Atenção: Drive não encontrado!");
			throw new SQLException(eDrive.getMessage());			
	
		} catch (SQLException erro){
			System.out.println("Erro - banco pode estar desativado... ou ter ocorrido qualquer problema com o comando SQL");
			throw erro;
			
			
		}

		return conn;
	}
}
