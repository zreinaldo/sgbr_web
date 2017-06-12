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
/**
 * @author Reinaldo
 *
 */
public class DAO_MYSQL {
	
	/**
	 * retorna um campo date opcionar
	 * @param pRs
	 * @param pCampo
	 * @return
	 */
	protected Date getDateOpcional (ResultSet pRs, String pCampo) {
		Date retorno = null;
		try {
			retorno = pRs.getDate(pCampo) != null ? pRs.getDate(pCampo) : null;
		} catch (SQLException e) {			
		} 
		return retorno;
	}
	
	/**
	 * @param pRs
	 * @param pCampo
	 * @return
	 */
	protected Double getDoubleOpcional (ResultSet pRs, String pCampo) {
		Double retorno = null;
		try {
			retorno = pRs.getDouble(pCampo) == 0 ?  null : pRs.getDouble(pCampo) ;
		} catch (SQLException e) {			
			e.printStackTrace();
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
			System.out.println("Atenção: Drive não encontrado!");
			throw new SQLException(eDrive.getMessage());			
	
		} catch (SQLException erro){
			System.out.println("Erro - banco pode estar desativado... ou ter ocorrido qualquer problema com o comando SQL");
			throw erro;
			
			
		}

		return conn;
	}
}
