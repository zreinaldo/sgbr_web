/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sgbr.cadastros.IntfDAOComanda;
import sgbr.entidades.Comanda;
import sgbr.util.Constantes;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDComanda;

/**
 * @author Reinaldo
 *
 */
public class DAOComanda extends DAO_MYSQL implements IntfDAOComanda {

	private static DAOComanda aDAOComanda = new DAOComanda();

	/**
	 * Cria um novo objeto DAOComanda.
	 */
	private DAOComanda() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOComanda getInstancia() {
		if (DAOComanda.aDAOComanda == null) {
			DAOComanda.aDAOComanda = new DAOComanda();
		}

		return DAOComanda.aDAOComanda;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOComanda#incluir(sgbr.entidades.Comanda)
	 */
	@Override
	public void incluir(Comanda pComanda) throws SQLException {

		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		String sql = "INSERT INTO mydb.comanda  ( " + Comanda.NM_COLUNA_COMANDA_DT_INI_VALIDADE + ") VALUES (?)";

		ppSt = conexao.prepareStatement(sql);

		ppSt.setDate(1, pComanda.getDtIniValidade());

		ppSt.execute();

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOComanda#alterar(sgbr.entidades.Comanda)
	 */
	@Override
	public void alterar(Comanda pComanda) throws SQLException {
		Connection conexao = null;

		conexao = this.getConection();

		String sql = "UPDATE mydb.comanda SET mydb.comanda.COMANDA_DT_INI_VALIDADE = ?  , mydb.comanda.COMANDA_DT_FIM_VALIDADE = ? WHERE mydb.comanda.COMANDA_CD = ?";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		ppSt.setDate(1, pComanda.getDtIniValidade());
		ppSt.setDate(2, pComanda.getDtFimValidade());
		ppSt.setInt(3, pComanda.getCdComanda());

		ppSt.execute();

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOComanda#excluir(sgbr.entidades.Comanda)
	 */
	@Override
	public void excluir(Comanda pComanda) throws SQLException {

		Connection conexao = null;

		conexao = this.getConection();

		String sql = "delete from mydb.comanda WHERE COMANDA_CD  = ?";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		ppSt.setInt(1, pComanda.getCdComanda());

		ppSt.execute();

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOComanda#consultaTelaManterComanda(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public ArrayList<OTDComanda> consultaTelaManterComanda(String pCodigo, String pInVigentes) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";

		Connection conexao = null;
		ArrayList<OTDComanda> arrayResposta = new ArrayList<>();
		OTDComanda otdComanda = null;

		conexao = this.getConection();

		String sql = "select * from mydb.comanda";

		if (!pCodigo.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "mydb.comanda.COMANDA_CD = " + pCodigo;
			sqlConector = " \n AND ";
		}

		if (!pInVigentes.isEmpty()) {

			if (pInVigentes.equals(Constantes.CD_SIM)) {
				sqlWhere = sqlWhere + sqlConector + "MYDB.comanda.COMANDA_DT_FIM_VALIDADE is null";
				sqlConector = " \n AND ";
			} else {
				sqlWhere = sqlWhere + sqlConector + "MYDB.comanda.COMANDA_DT_FIM_VALIDADE is not null";
				sqlConector = " \n AND ";
			}
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdComanda = new OTDComanda();
			otdComanda.setCdComanda(rs.getInt(Comanda.NM_COLUNA_COMANDA_CD));
			otdComanda.setDtIniVigencia(this.getDateOpcional(rs, Comanda.NM_COLUNA_COMANDA_DT_INI_VALIDADE));
			otdComanda.setDtFimVigencia(this.getDateOpcional(rs, Comanda.NM_COLUNA_COMANDA_DT_FIM_VALIDADE));

			arrayResposta.add(otdComanda);
		}

		rs.close();
		stm.close();
		conexao.close();
		return arrayResposta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOComanda#consultaPorChavePrimaria(sgbr.entidades.
	 * Comanda)
	 */
	@Override
	public Comanda consultaPorChavePrimaria(Comanda pComanda) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		Comanda comanda = null;

		conexao = this.getConection();

		String sql = "select * from mydb.comanda";

		if (pComanda.getCdComanda() != null) {
			sqlWhere = sqlWhere + sqlConector + "mydb.comanda.COMANDA_CD = " + pComanda.getCdComanda();
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			comanda = new Comanda();
			comanda.setCdComanda(rs.getInt(Comanda.NM_COLUNA_COMANDA_CD));
			comanda.setDtIniValidade(this.getDateOpcional(rs, Comanda.NM_COLUNA_COMANDA_DT_INI_VALIDADE));
			comanda.setDtFimValidade(this.getDateOpcional(rs, Comanda.NM_COLUNA_COMANDA_DT_FIM_VALIDADE));

		}

		rs.close();
		stm.close();
		conexao.close();
		return comanda;
	}

}
