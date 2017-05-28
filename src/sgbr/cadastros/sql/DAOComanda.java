/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.IntfDAOComanda;
import sgbr.entidades.Comanda;
import sgbr.entidades.Funcionario;
import sgbr.entidades.Pessoa;
import sgbr.entidades.PessoaDocumento;
import sgbr.entidades.TipoFuncionario;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDComanda;
import sgbr.util.OTDFuncionario;

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

	// TODO consulta para verifcar se ja esta em uso
	public Collection<Comanda> consultaTodosRegistros(boolean pInRetornarApenasVigentes) throws SQLException {

		Connection conexao = null;
		Comanda comanda = null;
		Collection<Comanda> colecaoComanda = new ArrayList<Comanda>();

		conexao = this.getConection();

		String sql = "select * from mydb.comanda ";

		if (pInRetornarApenasVigentes) {
			sql = sql + " where mydb.comanda.COMANDA_DT_FIM_VALIDADE is null";
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			comanda = new Comanda();
			comanda.setCdComanda(rs.getInt(Comanda.NM_COLUNA_COMANDA_CD));
			comanda.setDtIniValidade(rs.getDate(Comanda.NM_COLUNA_COMANDA_DT_INI_VALIDADE));
			comanda.setDtFimValidade(rs.getDate(Comanda.NM_COLUNA_COMANDA_DT_FIM_VALIDADE));
			colecaoComanda.add(comanda);
		}

		rs.close();
		stm.close();
		conexao.close();

		return colecaoComanda;
	}

	public ArrayList<OTDComanda> consultaTelaManterComanda(String pCodigo, String pSituacao) throws SQLException {

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

		if (!pSituacao.isEmpty()) {
			// sqlWhere = sqlWhere + sqlConector + "
			// MYDB.FUNCIONARIO.FUNCIONARIO_DT_DEMISSAO IS NULL";
			sqlConector = " \n AND ";
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
		ArrayList<OTDComanda> arrayResposta = new ArrayList<>();
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
