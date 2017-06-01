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

import sgbr.cadastros.IntfDAOItemCardapio;
import sgbr.entidades.ItemCardapio;
import sgbr.util.Constantes;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDItemCardapio;
import sgbr.util.Util;

/**
 * @author Reinaldo
 *
 */
public class DAOItemCardapio extends DAO_MYSQL implements IntfDAOItemCardapio {
	
	private static DAOItemCardapio aDAOItemCardapio = new DAOItemCardapio();

	/**
	 * Cria um novo objeto DAOItemCardapio.
	 */
	private DAOItemCardapio() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOItemCardapio getInstancia() {
		if (DAOItemCardapio.aDAOItemCardapio == null) {
			DAOItemCardapio.aDAOItemCardapio = new DAOItemCardapio();
		}

		return DAOItemCardapio.aDAOItemCardapio;
	}
	

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOItemCardapio#incluir(sgbr.entidades.ItemCardapio)
	 */
	@Override
	public ItemCardapio incluir(ItemCardapio pItemCardapio) throws SQLException {
		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pItemCardapio.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));
		pItemCardapio.setDhAlteracaoRegistro(new Timestamp(System.currentTimeMillis()));

		
		String sql = "INSERT INTO mydb.ITEM_CARDAPIO (" + ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_NM + "," 
				 + ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_VL + "," 
				  + ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_SI + "," 
		+ ItemCardapio.NM_COLUNA_DH_INCLUSAO_REGISTRO + "," + ItemCardapio.NM_COLUNA_DH_ALTERACAO_REGISTRO +  ") VALUES(?,?,?,?,?)";

		ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ppSt.setString(1, pItemCardapio.getNmItemCardapio().toUpperCase());
		ppSt.setDouble(2, pItemCardapio.getVlItemCardapio());
		ppSt.setString(3, pItemCardapio.getSiItemCardapio().toUpperCase());
		ppSt.setTimestamp(4, pItemCardapio.getDhIncusaoRegistro());
		ppSt.setTimestamp(5, pItemCardapio.getDhAlteracaoRegistro());

		ppSt.execute();

		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pItemCardapio.setCdItemCardapio(rs.getInt(1));
		}

		ppSt.close();
		conexao.close();

		return pItemCardapio;
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOItemCardapio#alterar(sgbr.entidades.ItemCardapio)
	 */
	@Override
	public void alterar(ItemCardapio pItemCardapio) throws SQLException {
		Connection conexao = null;

		conexao = this.getConection();

		String sql = "UPDATE mydb.ITEM_CARDAPIO SET  " 
		+ ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_NM +" = ?, "  
		+ ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_VL +" = ?, " 
		+   ItemCardapio.NM_COLUNA_DH_ALTERACAO_REGISTRO +" = CURRENT_TIMESTAMP " ;
		
		sql = sql + " WHERE " + ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_CD +" = ? ";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		ppSt.setString(1, pItemCardapio.getNmItemCardapio());
				
		ppSt.setDouble(2, pItemCardapio.getVlItemCardapio());
		
		ppSt.setInt(3, pItemCardapio.getCdItemCardapio());
		ppSt.execute();

		ppSt.close();
		conexao.close();
		
	}


	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOItemCardapio#excluir(sgbr.entidades.ItemCardapio)
	 */
	public void excluir(ItemCardapio pItemCardapio) throws SQLException {
		Connection conexao = null;		

		conexao = this.getConection();

		String sql = "delete from mydb.ITEM_CARDAPIO WHERE " + ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_CD + " = ?";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		
		ppSt.setInt(1, pItemCardapio.getCdItemCardapio());
		

		ppSt.execute();

		ppSt.close();
		conexao.close();
		
	}
	
	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOItemCardapio#consultaTodosRegistros(boolean)
	 */
	public Collection<ItemCardapio> consultaTodosRegistros( boolean pInRetornarApenasVigentes) throws SQLException {
		
		Connection conexao = null;
		PreparedStatement ppSt = null;
		ItemCardapio itemCardapio = null;
		Collection<ItemCardapio> colecaoItemCardapio = new ArrayList<ItemCardapio>();

		conexao = this.getConection();
		
		String sql = "SELECT * FROM mydb.ITEM_CARDAPIO ";
		
		if (pInRetornarApenasVigentes){
			sql = sql + " where mydb.ITEM_CARDAPIO.ITEM_CARDAPIO_SI = '" + Constantes.SI_ITEM_CARDAPIO_DISPONIVEL + "'";
		}

		Statement stm = conexao.createStatement();
				
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			itemCardapio = new ItemCardapio();
			itemCardapio.setCdItemCardapio(rs.getInt(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_CD));
			itemCardapio.setNmItemCardapio(rs.getString(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_NM));
			itemCardapio.setDhIncusaoRegistro(rs.getTimestamp(ItemCardapio.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			itemCardapio.setDhAlteracaoRegistro(rs.getTimestamp(ItemCardapio.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			itemCardapio.setVlItemCardapio(rs.getDouble(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_VL));
			colecaoItemCardapio.add(itemCardapio);
		}

		rs.close();
		stm.close();
		conexao.close();
		
		return colecaoItemCardapio;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOItemCardapio#consultaTelaManterItemCardapio(java.lang.String, java.lang.String)
	 */
	public ArrayList<OTDItemCardapio> consultaTelaManterItemCardapio(String pCdItemCardapio, String pDsItemCardapio, String pSiItemCaradapio) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDItemCardapio> arrayResposta = new ArrayList<>();
		OTDItemCardapio otdItemCardapio = null;

		conexao = this.getConection();
		String sql = "SELECT " + "MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_CD, " 
				+ "MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_NM,  "
				+ "MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_SI,  "
				+ "MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_VL  "
				+ "FROM MYDB.ITEM_CARDAPIO ";
			

		if (!pCdItemCardapio.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "	MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_CD = " + pCdItemCardapio;
			sqlConector = " \n AND ";
		}
		
		if (!pDsItemCardapio.isEmpty()) {
			sqlWhere =  sqlWhere + sqlConector + "MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_NM LIKE '%" + pDsItemCardapio.toUpperCase() + "%'";
			sqlConector = " \n AND ";
		}
		
		if (!pSiItemCaradapio.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "	MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_SI = '" + pSiItemCaradapio + "'";
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdItemCardapio = new OTDItemCardapio();
			otdItemCardapio.setCdItemCardapio(rs.getInt(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_CD));
			otdItemCardapio.setNmItemCardapio(rs.getString(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_NM));
			otdItemCardapio.setSiItemCardapio(rs.getString(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_SI));
			otdItemCardapio.setDsSiItemCardapio(Util.getDsSiItemCardapio(rs.getString(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_SI)));
			otdItemCardapio.setVlItemCardapio(rs.getDouble(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_VL));
			

			arrayResposta.add(otdItemCardapio);
		}

		rs.close();
		stm.close();
		conexao.close();
		return arrayResposta;
	}
	

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOItemCardapio#consultaPorChavePrimaria(sgbr.entidades.ItemCardapio)
	 */
	public ItemCardapio consultaPorChavePrimaria(ItemCardapio pItemCardapio) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDItemCardapio> arrayResposta = new ArrayList<>();
		ItemCardapio itemCardapio = null;

		conexao = this.getConection();

		String sql = "select * from mydb.ITEM_CARDAPIO";

		if (pItemCardapio.getCdItemCardapio() != null) {
			sqlWhere = sqlWhere + sqlConector + "mydb.ITEM_CARDAPIO.ITEM_CARDAPIO_CD = " + pItemCardapio.getCdItemCardapio();
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			itemCardapio = new ItemCardapio();
			itemCardapio.setCdItemCardapio(rs.getInt(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_CD));
			itemCardapio.setNmItemCardapio(rs.getString(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_NM));
			itemCardapio.setSiItemCardapio(rs.getString(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_SI));
			itemCardapio.setVlItemCardapio(rs.getDouble(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_VL));
			itemCardapio.setDhIncusaoRegistro(rs.getTimestamp(ItemCardapio.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			itemCardapio.setDhAlteracaoRegistro(rs.getTimestamp( ItemCardapio.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			

		}

		rs.close();
		stm.close();
		conexao.close();
		return itemCardapio;
	}


}
