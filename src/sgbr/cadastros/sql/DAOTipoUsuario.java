/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.IntfDAOTipoUsuario;
import sgbr.entidades.TipoUsuario;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOTipoUsuario extends DAO_MYSQL implements IntfDAOTipoUsuario {

	private static DAOTipoUsuario aDAOUsuario = new DAOTipoUsuario();

	/**
	 * Cria um novo objeto DAOUsuario.
	 */
	private DAOTipoUsuario() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOTipoUsuario getInstancia() {
		if (DAOTipoUsuario.aDAOUsuario == null) {
			DAOTipoUsuario.aDAOUsuario = new DAOTipoUsuario();
		}

		return DAOTipoUsuario.aDAOUsuario;
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOTipoUsuario#consultaTodosRegistros(boolean)
	 */
	public Collection<TipoUsuario> consultaTodosRegistros(boolean pInRetornarApenasVigentes) throws SQLException {

		Connection conexao = null;
		TipoUsuario tipoUsuario = null;
		Collection<TipoUsuario> colecaoTipoUsuario = new ArrayList<TipoUsuario>();

		conexao = this.getConection();

		String sql = "SELECT * FROM mydb.TIPO_USUARIO ";

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			tipoUsuario = new TipoUsuario();
			tipoUsuario.setCdTpUsuario(rs.getInt(TipoUsuario.NM_COLUNA_TIPO_USUARIO_CD));
			tipoUsuario.setNmTpUsuario(rs.getString(TipoUsuario.NM_COLUNA_TIPO_USUARIO_NM));
			colecaoTipoUsuario.add(tipoUsuario);
		}

		rs.close();
		stm.close();
		conexao.close();

		return colecaoTipoUsuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOTipoUsuario#consultaPorChavePrimaria(sgbr.entidades.
	 * TipoUsuario)
	 */
	public TipoUsuario consultaPorChavePrimaria(TipoUsuario pTipoUsuario) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		TipoUsuario tipoUsuario = null;

		conexao = this.getConection();

		String sql = "select * from mydb.TIPO_USUARIO";

		if (pTipoUsuario.getCdTpUsuario() != null) {
			sqlWhere = sqlWhere + sqlConector + "mydb.TIPO_USUARIO.TIPO_USUARIO_CD = " + pTipoUsuario.getCdTpUsuario();
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			tipoUsuario = new TipoUsuario();
			tipoUsuario.setCdTpUsuario(rs.getInt(TipoUsuario.NM_COLUNA_TIPO_USUARIO_CD));
			tipoUsuario.setCdTpUsuario(rs.getInt(TipoUsuario.NM_COLUNA_TIPO_USUARIO_CD));
			
		}

		rs.close();
		stm.close();
		conexao.close();
		return tipoUsuario;
	}

}
