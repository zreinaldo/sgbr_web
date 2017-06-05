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

import sgbr.cadastros.IntfDAOTipoFuncionario;
import sgbr.entidades.TipoFuncionario;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDTipoFuncionario;

/**
 * @author Reinaldo
 *
 */
public class DAOTipoFuncionario extends DAO_MYSQL implements IntfDAOTipoFuncionario {
	
	private static DAOTipoFuncionario aDAOTipoFuncionario = new DAOTipoFuncionario();

	/**
	 * Cria um novo objeto DAOTipoFuncionario.
	 */
	private DAOTipoFuncionario() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOTipoFuncionario getInstancia() {
		if (DAOTipoFuncionario.aDAOTipoFuncionario == null) {
			DAOTipoFuncionario.aDAOTipoFuncionario = new DAOTipoFuncionario();
		}

		return DAOTipoFuncionario.aDAOTipoFuncionario;
	}
	

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOTipoFuncionario#incluir(sgbr.entidades.TipoFuncionario)
	 */
	@Override
	public TipoFuncionario incluir(TipoFuncionario pTipoFuncionario) throws SQLException {
		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pTipoFuncionario.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));
		pTipoFuncionario.setDhAlteracaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "INSERT INTO mydb.TIPO_FUNCIONARIO (" + TipoFuncionario.NM_COLUNA_TIPO_FUNCIONARIO_DS + "," 
		+ TipoFuncionario.NM_COLUNA_DH_INCLUSAO_REGISTRO + "," + TipoFuncionario.NM_COLUNA_DH_ALTERACAO_REGISTRO +  ") VALUES(?,?,?)";

		ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ppSt.setString(1, pTipoFuncionario.getDsTpFuncionario().toUpperCase());		
		ppSt.setTimestamp(2, pTipoFuncionario.getDhIncusaoRegistro());
		ppSt.setTimestamp(3, pTipoFuncionario.getDhAlteracaoRegistro());

		ppSt.execute();

		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pTipoFuncionario.setCdTpFuncionario(rs.getInt(1));
		}

		ppSt.close();
		conexao.close();

		return pTipoFuncionario;
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOTipoFuncionario#alterar(sgbr.entidades.TipoFuncionario)
	 */
	@Override
	public void alterar(TipoFuncionario pTipoFuncionario) throws SQLException {
		Connection conexao = null;

		conexao = this.getConection();

		String sql = "UPDATE mydb.TIPO_FUNCIONARIO SET " + " TIPO_FUNCIONARIO_DS = ?, " + " DT_FIM_VIGENCIA = ? ,"  + "DH_ALTERACAO = current_timestamp ";
		
		sql = sql + " WHERE TIPO_FUNCIONARIO_CD = ? ";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		ppSt.setString(1, pTipoFuncionario.getDsTpFuncionario());
				
		ppSt.setDate(2, pTipoFuncionario.getDtFimVigencia());
		
		ppSt.setInt(3, pTipoFuncionario.getCdTpFuncionario());
		ppSt.execute();

		ppSt.close();
		conexao.close();
		
	}


	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOTipoFuncionario#excluir(sgbr.entidades.TipoFuncionario)
	 */
	public void excluir(TipoFuncionario pTipoFuncionario) throws SQLException {
		Connection conexao = null;		

		conexao = this.getConection();

		String sql = "delete from mydb.TIPO_FUNCIONARIO WHERE TIPO_FUNCIONARIO_CD  = ?";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		
		ppSt.setInt(1, pTipoFuncionario.getCdTpFuncionario());
		

		ppSt.execute();

		ppSt.close();
		conexao.close();
		
	}
	
	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOTipoFuncionario#consultaTodosRegistros(boolean)
	 */
	public Collection<TipoFuncionario> consultaTodosRegistros( boolean pInRetornarApenasVigentes) throws SQLException {
		
		Connection conexao = null;
		PreparedStatement ppSt = null;
		TipoFuncionario tpFuncionario = null;
		Collection<TipoFuncionario> colecaoTipoFuncionario = new ArrayList<TipoFuncionario>();

		conexao = this.getConection();
		
		String sql = "SELECT * FROM mydb.tipo_funcionario ";
		
		if (pInRetornarApenasVigentes){
			sql = sql + " where mydb.tipo_funcionario.dt_fim_vigencia is null";
		}

		Statement stm = conexao.createStatement();
				
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			tpFuncionario = new TipoFuncionario();
			tpFuncionario.setCdTpFuncionario(rs.getInt(TipoFuncionario.NM_COLUNA_TIPO_FUNCIONARIO_CD));
			tpFuncionario.setDsTpFuncionario(rs.getString(TipoFuncionario.NM_COLUNA_TIPO_FUNCIONARIO_DS));
			tpFuncionario.setDhIncusaoRegistro(rs.getTimestamp(TipoFuncionario.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			tpFuncionario.setDhAlteracaoRegistro(rs.getTimestamp(TipoFuncionario.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			tpFuncionario.setDtFimVigencia(rs.getDate(TipoFuncionario.NM_COLUNA_DT_FIM_VIGENCIA));
			colecaoTipoFuncionario.add(tpFuncionario);
		}

		rs.close();
		stm.close();
		conexao.close();
		
		return colecaoTipoFuncionario;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOTipoFuncionario#consultaTelaManterTipoFuncionario(java.lang.String, java.lang.String)
	 */
	public ArrayList<OTDTipoFuncionario> consultaTelaManterTipoFuncionario(String pCdTipoFuncionario, String pDsTipoFuncionario) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDTipoFuncionario> arrayResposta = new ArrayList<>();
		OTDTipoFuncionario otdTipoFuncionario = null;

		conexao = this.getConection();
		String sql = "SELECT " + "MYDB.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_CD, " 
				+ "MYDB.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_DS,  "
				+ "MYDB.TIPO_FUNCIONARIO.DT_FIM_VIGENCIA " 				
				+ "FROM MYDB.TIPO_FUNCIONARIO ";
			

		if (!pCdTipoFuncionario.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "	MYDB.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_CD = " + pCdTipoFuncionario;
			sqlConector = " \n AND ";
		}
		
		if (!pDsTipoFuncionario.isEmpty()) {
			sqlWhere =  sqlWhere + sqlConector + "MYDB.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_DS LIKE '%" + pDsTipoFuncionario.toUpperCase() + "%'";
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdTipoFuncionario = new OTDTipoFuncionario();
			otdTipoFuncionario.setCdTpFuncionario(rs.getInt(TipoFuncionario.NM_COLUNA_TIPO_FUNCIONARIO_CD));
			otdTipoFuncionario.setDsTpFuncionario(rs.getString(TipoFuncionario.NM_COLUNA_TIPO_FUNCIONARIO_DS));
			otdTipoFuncionario.setDtFimVigencia(rs.getDate(TipoFuncionario.NM_COLUNA_DT_FIM_VIGENCIA));
			

			arrayResposta.add(otdTipoFuncionario);
		}

		rs.close();
		stm.close();
		conexao.close();
		return arrayResposta;
	}
	

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOTipoFuncionario#consultaPorChavePrimaria(sgbr.entidades.TipoFuncionario)
	 */
	public TipoFuncionario consultaPorChavePrimaria(TipoFuncionario pTipoFuncionario) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		TipoFuncionario tipoFuncionario = null;

		conexao = this.getConection();

		String sql = "select * from mydb.TIPO_FUNCIONARIO";

		if (pTipoFuncionario.getCdTpFuncionario() != null) {
			sqlWhere = sqlWhere + sqlConector + "mydb.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_CD = " + pTipoFuncionario.getCdTpFuncionario();
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			tipoFuncionario = new TipoFuncionario();
			tipoFuncionario.setCdTpFuncionario(rs.getInt(TipoFuncionario.NM_COLUNA_TIPO_FUNCIONARIO_CD));
			tipoFuncionario.setDsTpFuncionario(rs.getString(TipoFuncionario.NM_COLUNA_TIPO_FUNCIONARIO_DS));
			tipoFuncionario.setDhIncusaoRegistro(rs.getTimestamp(TipoFuncionario.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			tipoFuncionario.setDhAlteracaoRegistro(rs.getTimestamp( TipoFuncionario.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			tipoFuncionario.setDtFimVigencia(this.getDateOpcional(rs, TipoFuncionario.NM_COLUNA_DT_FIM_VIGENCIA));

		}

		rs.close();
		stm.close();
		conexao.close();
		return tipoFuncionario;
	}


}
