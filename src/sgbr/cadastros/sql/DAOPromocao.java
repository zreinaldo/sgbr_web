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

import sgbr.cadastros.IntfDAOPromocao;
import sgbr.entidades.ItemCardapio;
import sgbr.entidades.Promocao;
import sgbr.util.Constantes;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDPromocao;

/**
 * @author Reinaldo
 *
 */
public class DAOPromocao extends DAO_MYSQL implements IntfDAOPromocao {
	
	private static DAOPromocao aDAOPromocao = new DAOPromocao();

	/**
	 * Cria um novo objeto DAOPromocao.
	 */
	private DAOPromocao() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOPromocao getInstancia() {
		if (DAOPromocao.aDAOPromocao == null) {
			DAOPromocao.aDAOPromocao = new DAOPromocao();
		}

		return DAOPromocao.aDAOPromocao;
	}
	

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOPromocao#incluir(sgbr.entidades.Promocao)
	 */
	@Override
	public Promocao incluir(Promocao pPromocao) throws SQLException {
		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pPromocao.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));
		pPromocao.setDhAlteracaoRegistro(new Timestamp(System.currentTimeMillis()));

		
		String sql = "INSERT INTO mydb.PROMOCAO (" + Promocao.NM_COLUNA_ITEM_CARDAPIO_CD + "," 
				 + Promocao.NM_COLUNA_PROMOCAO_VL + "," 
				  + Promocao.NM_COLUNA_PROMOCAO_DT_INICIO + "," 
				 + Promocao.NM_COLUNA_PROMOCAO_DT_FIM + "," 
		+ Promocao.NM_COLUNA_DH_INCLUSAO_REGISTRO + "," + Promocao.NM_COLUNA_DH_ALTERACAO_REGISTRO +  ") VALUES(?,?,?,?,?,?)";

		ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ppSt.setInt(1, pPromocao.getCdItemCardapio());
		ppSt.setDouble(2, pPromocao.getVlPromocao());
		ppSt.setDate(3, pPromocao.getDtInicioPromocao());
		ppSt.setDate(4, pPromocao.getDtFimPromocao());
		ppSt.setTimestamp(5, pPromocao.getDhIncusaoRegistro());
		ppSt.setTimestamp(6, pPromocao.getDhAlteracaoRegistro());

		ppSt.execute();

		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pPromocao.setCdPromocao(rs.getInt(1));
		}

		ppSt.close();
		conexao.close();

		return pPromocao;
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOPromocao#alterar(sgbr.entidades.Promocao)
	 */
	@Override
	public void alterar(Promocao pPromocao) throws SQLException {
		Connection conexao = null;

		conexao = this.getConection();

		String sql = "UPDATE mydb.PROMOCAO SET  " 
				+ Promocao.NM_COLUNA_ITEM_CARDAPIO_CD  + " =? ,"
				+ Promocao.NM_COLUNA_PROMOCAO_VL + " = ?, " 
				  + Promocao.NM_COLUNA_PROMOCAO_DT_INICIO + " =? ," 
				 + Promocao.NM_COLUNA_PROMOCAO_DT_FIM + " =? ," 
		+   Promocao.NM_COLUNA_DH_ALTERACAO_REGISTRO +" = CURRENT_TIMESTAMP " ;
		
		sql = sql + " WHERE " + Promocao.NM_COLUNA_PROMOCAO_CD +" = ? ";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		ppSt.setInt(1, pPromocao.getCdItemCardapio());
				
		ppSt.setDouble(2, pPromocao.getVlPromocao());
		
		ppSt.setDate(3, pPromocao.getDtInicioPromocao());
		ppSt.setDate(4, pPromocao.getDtFimPromocao());
		
		ppSt.setInt(5, pPromocao.getCdPromocao());
		ppSt.execute();

		ppSt.close();
		conexao.close();
		
	}


	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOPromocao#excluir(sgbr.entidades.Promocao)
	 */
	public void excluir(Integer pCdPromocao) throws SQLException {
		Connection conexao = null;		

		conexao = this.getConection();

		String sql = "delete from mydb.PROMOCAO WHERE " + Promocao.NM_COLUNA_PROMOCAO_CD + " = ?";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		
		ppSt.setInt(1, pCdPromocao);
		

		ppSt.execute();

		ppSt.close();
		conexao.close();
		
	}
	
	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOPromocao#consultaTodosRegistros(boolean)
	 */
	public Collection<Promocao> consultaTodosRegistros( String pInRetornarApenasVigentes) throws SQLException {
		
		Connection conexao = null;
		PreparedStatement ppSt = null;
		Promocao Promocao = null;
		Collection<Promocao> colecaoPromocao = new ArrayList<Promocao>();

		conexao = this.getConection();
		
		String sql = "SELECT * FROM mydb.PROMOCAO ";
		
		if (!pInRetornarApenasVigentes.isEmpty() && pInRetornarApenasVigentes.equals(Constantes.CD_SIM)) {
			sql = sql + " WHERE " + "	MYDB.PROMOCAO.PROMOCAO_DT_INICIO <= CURRENT_DATE AND (MYDB.PROMOCAO.PROMOCAO_DT_FIM IS NULL OR MYDB.PROMOCAO.PROMOCAO_DT_FIM >= CURRENT_DATE) ";
		} else if (!pInRetornarApenasVigentes.isEmpty() && pInRetornarApenasVigentes.equals(Constantes.CD_NAO)) {
			sql = sql + " WHERE " + " MYDB.PROMOCAO.PROMOCAO_DT_INICIO > CURRENT_DATE OR MYDB.PROMOCAO.PROMOCAO_DT_FIM < CURRENT_DATE";
		}

		Statement stm = conexao.createStatement();
				
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			Promocao = new Promocao();
			Promocao.setCdPromocao(rs.getInt(Promocao.NM_COLUNA_PROMOCAO_CD));
			Promocao.setCdItemCardapio(rs.getInt(Promocao.NM_COLUNA_ITEM_CARDAPIO_CD));
			Promocao.setVlPromocao(rs.getDouble(Promocao.NM_COLUNA_PROMOCAO_VL));
			Promocao.setDtInicioPromocao(rs.getDate(Promocao.NM_COLUNA_PROMOCAO_DT_INICIO));
			Promocao.setDtFimPromocao(rs.getDate(Promocao.NM_COLUNA_PROMOCAO_DT_FIM));
			Promocao.setDhIncusaoRegistro(rs.getTimestamp(Promocao.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			Promocao.setDhAlteracaoRegistro(rs.getTimestamp(Promocao.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			
			colecaoPromocao.add(Promocao);
		}

		rs.close();
		stm.close();
		conexao.close();
		
		return colecaoPromocao;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOPromocao#consultaTelaManterPromocao(java.lang.String, java.lang.String)
	 */
	public ArrayList<OTDPromocao> consultaTelaManterPromocao(String pCdItemCardapio,
			String pInRetornarApenasVigentes,  String pDiaSemanaPromocao) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDPromocao> arrayResposta = new ArrayList<>();
		OTDPromocao otdPromocao = null;

		conexao = this.getConection();
		
		String sql = "SELECT " + " MYDB.PROMOCAO.PROMOCAO_CD, " 
				+ " MYDB.PROMOCAO.ITEM_CARDAPIO_CD,  "
				+ " MYDB.PROMOCAO.PROMOCAO_VL,  "
				+ " MYDB.PROMOCAO.PROMOCAO_DT_INICIO,  "
				+ " MYDB.PROMOCAO.PROMOCAO_DT_FIM, "
				+ " MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_NM, "
				 + "group_concat( MYDB.dia_semana.DIA_SEMANA_DS) as DIA_SEMANA_DS,"
				+ " group_concat( MYDB.dia_semana.DIA_SEMANA_CD) as DIA_SEMANA_CD"
				+ " FROM MYDB.PROMOCAO "
				+ "INNER JOIN MYDB.ITEM_CARDAPIO ON MYDB.PROMOCAO.ITEM_CARDAPIO_CD = MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_CD "
				+ "LEFT JOIN MYDB.promocao_dia_semana ON MYDB.promocao_dia_semana.PROMOCAO_CD = MYDB.PROMOCAO.PROMOCAO_CD " 
				+ "LEFT JOIN MYDB.dia_semana ON MYDB.promocao_dia_semana.DIA_SEMANA_CD = MYDB.dia_semana.DIA_SEMANA_CD ";

		
		String groupBY = " GROUP BY " +
				"MYDB.PROMOCAO.PROMOCAO_CD, " +
				"MYDB.PROMOCAO.ITEM_CARDAPIO_CD, " +
				"MYDB.PROMOCAO.PROMOCAO_VL, " +
				"MYDB.PROMOCAO.PROMOCAO_DT_INICIO, " +
				"MYDB.PROMOCAO.PROMOCAO_DT_FIM, " +
				"MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_NM ";
			

		if (!pCdItemCardapio.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + " MYDB.PROMOCAO.ITEM_CARDAPIO_CD =  " + pCdItemCardapio;
			sqlConector = " \n AND ";
		}
		
		if (!pDiaSemanaPromocao.isEmpty()) {
			sqlWhere =  sqlWhere + sqlConector + " MYDB.promocao_dia_semana.DIA_SEMANA_CD = " + pDiaSemanaPromocao;
			sqlConector = " \n AND ";
		}
		
		if (!pInRetornarApenasVigentes.isEmpty() && pInRetornarApenasVigentes.equals(Constantes.CD_SIM)) {
			sqlWhere = sqlWhere + sqlConector + "	MYDB.PROMOCAO.PROMOCAO_DT_INICIO <= CURRENT_DATE AND (MYDB.PROMOCAO.PROMOCAO_DT_FIM IS NULL OR MYDB.PROMOCAO.PROMOCAO_DT_FIM >= CURRENT_DATE) ";
			sqlConector = " \n AND ";
		} else if (!pInRetornarApenasVigentes.isEmpty() && pInRetornarApenasVigentes.equals(Constantes.CD_NAO)) {
			sqlWhere = sqlWhere + sqlConector + " MYDB.PROMOCAO.PROMOCAO_DT_INICIO > CURRENT_DATE OR MYDB.PROMOCAO.PROMOCAO_DT_FIM < CURRENT_DATE";
					sqlConector = " \n AND ";
		}
		
		
		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere + groupBY;
		}else {
			sql = sql + groupBY;
		}

		
		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
						
			otdPromocao = new OTDPromocao();
			otdPromocao.setCdPromocao(rs.getInt(Promocao.NM_COLUNA_PROMOCAO_CD));
			otdPromocao.setCdItemCardapio(rs.getInt(Promocao.NM_COLUNA_ITEM_CARDAPIO_CD));
			otdPromocao.setVlPromocao(rs.getDouble(Promocao.NM_COLUNA_PROMOCAO_VL));
			otdPromocao.setDtInicioPromocao(rs.getDate(Promocao.NM_COLUNA_PROMOCAO_DT_INICIO));
			otdPromocao.setDtFimPromocao(rs.getDate(Promocao.NM_COLUNA_PROMOCAO_DT_FIM));
			otdPromocao.setNmItemCardapio(rs.getString(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_NM));			
			String diasSemana = rs.getString("DIA_SEMANA_CD");			
			
			if (diasSemana != null) {
			String[] colDiasSemana = diasSemana.split(",");
			otdPromocao.setListaDiasSemanaPromocao(colDiasSemana);
			}
			
			otdPromocao.setColecaoDsPromocaoDiasSemana(rs.getString("DIA_SEMANA_DS") );
			
			

			arrayResposta.add(otdPromocao);
		}

		rs.close();
		stm.close();
		conexao.close();
		return arrayResposta;
	}
	

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOPromocao#consultaPorChavePrimaria(sgbr.entidades.Promocao)
	 */
	public Promocao consultaPorChavePrimaria(Promocao pPromocao) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		Promocao promocao = null;

		conexao = this.getConection();

		String sql = "select * from mydb.PROMOCAO";

		if (pPromocao.getCdPromocao() != null) {
			sqlWhere = sqlWhere + sqlConector + "mydb.PROMOCAO.PROMOCAO_CD = " + pPromocao.getCdPromocao();
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			promocao = new Promocao();
			promocao.setCdPromocao(rs.getInt(Promocao.NM_COLUNA_PROMOCAO_CD));
			promocao.setCdItemCardapio(rs.getInt(Promocao.NM_COLUNA_ITEM_CARDAPIO_CD));
			promocao.setVlPromocao(rs.getDouble(Promocao.NM_COLUNA_PROMOCAO_VL));
			promocao.setDtInicioPromocao(rs.getDate(Promocao.NM_COLUNA_PROMOCAO_DT_INICIO));
			promocao.setDtFimPromocao(rs.getDate(Promocao.NM_COLUNA_PROMOCAO_DT_FIM));
			promocao.setDhIncusaoRegistro(rs.getTimestamp(Promocao.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			promocao.setDhAlteracaoRegistro(rs.getTimestamp( Promocao.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			

		}

		rs.close();
		stm.close();
		conexao.close();
		return promocao;
	}

	
	
	public OTDPromocao consultaDadosPromocao(Integer pCdPromocao) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDPromocao> arrayResposta = new ArrayList<>();
		OTDPromocao otdPromocao = null;

		conexao = this.getConection();
		
		String sql = "SELECT " + " MYDB.PROMOCAO.PROMOCAO_CD, " 
				+ " MYDB.PROMOCAO.ITEM_CARDAPIO_CD,  "
				+ " MYDB.PROMOCAO.PROMOCAO_VL,  "
				+ " MYDB.PROMOCAO.PROMOCAO_DT_INICIO,  "
				+ " MYDB.PROMOCAO.PROMOCAO_DT_FIM, "
				+ " MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_NM, "				 
				+ "group_concat( MYDB.dia_semana.DIA_SEMANA_DS) as DIA_SEMANA_DS,"
				+ " group_concat( MYDB.dia_semana.DIA_SEMANA_CD) as DIA_SEMANA_CD"
				+ " FROM MYDB.PROMOCAO "
				+ "INNER JOIN MYDB.ITEM_CARDAPIO ON MYDB.PROMOCAO.ITEM_CARDAPIO_CD = MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_CD "
				+ "LEFT JOIN MYDB.promocao_dia_semana ON MYDB.promocao_dia_semana.PROMOCAO_CD = MYDB.PROMOCAO.PROMOCAO_CD " 
				+ "LEFT JOIN MYDB.dia_semana ON MYDB.promocao_dia_semana.DIA_SEMANA_CD = MYDB.dia_semana.DIA_SEMANA_CD ";

		
		String groupBY = " GROUP BY " +
				"MYDB.PROMOCAO.PROMOCAO_CD, " +
				"MYDB.PROMOCAO.ITEM_CARDAPIO_CD, " +
				"MYDB.PROMOCAO.PROMOCAO_VL, " +
				"MYDB.PROMOCAO.PROMOCAO_DT_INICIO, " +
				"MYDB.PROMOCAO.PROMOCAO_DT_FIM, " +
				"MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_NM ";
			

		
			sqlWhere = sqlWhere + sqlConector + " MYDB.PROMOCAO.PROMOCAO_CD =  " + pCdPromocao;
		
		
		// Constroi SQL completo

		sql = sql + " \n WHERE " + sqlWhere + groupBY;

		
		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
						
			otdPromocao = new OTDPromocao();
			otdPromocao.setCdPromocao(rs.getInt(Promocao.NM_COLUNA_PROMOCAO_CD));
			otdPromocao.setCdItemCardapio(rs.getInt(Promocao.NM_COLUNA_ITEM_CARDAPIO_CD));
			otdPromocao.setVlPromocao(rs.getDouble(Promocao.NM_COLUNA_PROMOCAO_VL));
			otdPromocao.setDtInicioPromocao(rs.getDate(Promocao.NM_COLUNA_PROMOCAO_DT_INICIO));
			otdPromocao.setDtFimPromocao(rs.getDate(Promocao.NM_COLUNA_PROMOCAO_DT_FIM));
			otdPromocao.setNmItemCardapio(rs.getString(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_NM));			
			String diasSemana = rs.getString("DIA_SEMANA_CD");			
			
			if (diasSemana != null) {
			String[] colDiasSemana = diasSemana.split(",");
			otdPromocao.setListaDiasSemanaPromocao(colDiasSemana);
			}
			
			otdPromocao.setColecaoDsPromocaoDiasSemana(rs.getString("DIA_SEMANA_DS") );
			
			
		}

		rs.close();
		stm.close();
		conexao.close();
		return otdPromocao;
	}

}
