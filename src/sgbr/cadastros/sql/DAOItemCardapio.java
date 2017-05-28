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
import sgbr.entidades.Comanda;
import sgbr.entidades.Funcionario;
import sgbr.entidades.Pessoa;
import sgbr.entidades.ItemCardapio;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDComanda;
import sgbr.util.OTDFuncionario;
import sgbr.util.OTDItemCardapio;

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

		String sql = "INSERT INTO mydb.TIPO_FUNCIONARIO (" + ItemCardapio.NM_COLUNA_TIPO_FUNCIONARIO_DS + "," 
		+ ItemCardapio.NM_COLUNA_DH_INCLUSAO_REGISTRO + "," + ItemCardapio.NM_COLUNA_DH_ALTERACAO_REGISTRO +  ") VALUES(?,?,?)";

		ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ppSt.setString(1, pItemCardapio.getDsTpFuncionario().toUpperCase());		
		ppSt.setTimestamp(2, pItemCardapio.getDhIncusaoRegistro());
		ppSt.setTimestamp(3, pItemCardapio.getDhAlteracaoRegistro());

		ppSt.execute();

		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pItemCardapio.setCdTpFuncionario(rs.getInt(1));
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

		String sql = "UPDATE mydb.TIPO_FUNCIONARIO SET " + " TIPO_FUNCIONARIO_DS = ?, " + " DT_FIM_VIGENCIA = ? ,"  + "DH_ALTERACAO = current_timestamp ";
		
		sql = sql + " WHERE TIPO_FUNCIONARIO_CD = ? ";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		ppSt.setString(1, pItemCardapio.getDsTpFuncionario());
				
		ppSt.setDate(2, pItemCardapio.getDtFimVigencia());
		
		ppSt.setInt(3, pItemCardapio.getCdTpFuncionario());
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

		String sql = "delete from mydb.TIPO_FUNCIONARIO WHERE TIPO_FUNCIONARIO_CD  = ?";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		
		ppSt.setInt(1, pItemCardapio.getCdTpFuncionario());
		

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
		ItemCardapio tpFuncionario = null;
		Collection<ItemCardapio> colecaoItemCardapio = new ArrayList<ItemCardapio>();

		conexao = this.getConection();
		
		String sql = "SELECT * FROM mydb.tipo_funcionario ";
		
		if (pInRetornarApenasVigentes){
			sql = sql + " where mydb.tipo_funcionario.dt_fim_vigencia is null";
		}

		Statement stm = conexao.createStatement();
				
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			tpFuncionario = new ItemCardapio();
			tpFuncionario.setCdTpFuncionario(rs.getInt(ItemCardapio.NM_COLUNA_TIPO_FUNCIONARIO_CD));
			tpFuncionario.setDsTpFuncionario(rs.getString(ItemCardapio.NM_COLUNA_TIPO_FUNCIONARIO_DS));
			tpFuncionario.setDhIncusaoRegistro(rs.getTimestamp(ItemCardapio.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			tpFuncionario.setDhAlteracaoRegistro(rs.getTimestamp(ItemCardapio.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			tpFuncionario.setDtFimVigencia(rs.getDate(ItemCardapio.NM_COLUNA_DT_FIM_VIGENCIA));
			colecaoItemCardapio.add(tpFuncionario);
		}

		rs.close();
		stm.close();
		conexao.close();
		
		return colecaoItemCardapio;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOItemCardapio#consultaTelaManterItemCardapio(java.lang.String, java.lang.String)
	 */
	public ArrayList<OTDItemCardapio> consultaTelaManterItemCardapio(String pCdItemCardapio, String pDsItemCardapio) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDItemCardapio> arrayResposta = new ArrayList<>();
		OTDItemCardapio otdItemCardapio = null;

		conexao = this.getConection();
		String sql = "SELECT " + "MYDB.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_CD, " 
				+ "MYDB.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_DS,  "
				+ "MYDB.TIPO_FUNCIONARIO.DT_FIM_VIGENCIA " 				
				+ "FROM MYDB.TIPO_FUNCIONARIO ";
			

		if (!pCdItemCardapio.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "	MYDB.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_CD = " + pCdItemCardapio;
			sqlConector = " \n AND ";
		}
		
		if (!pDsItemCardapio.isEmpty()) {
			sqlWhere =  sqlWhere + sqlConector + "MYDB.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_DS LIKE '%" + pDsItemCardapio.toUpperCase() + "%'";
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
			otdItemCardapio.setCdTpFuncionario(rs.getInt(ItemCardapio.NM_COLUNA_TIPO_FUNCIONARIO_CD));
			otdItemCardapio.setDsTpFuncionario(rs.getString(ItemCardapio.NM_COLUNA_TIPO_FUNCIONARIO_DS));
			otdItemCardapio.setDtFimVigencia(rs.getDate(ItemCardapio.NM_COLUNA_DT_FIM_VIGENCIA));
			

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

		String sql = "select * from mydb.TIPO_FUNCIONARIO";

		if (pItemCardapio.getCdTpFuncionario() != null) {
			sqlWhere = sqlWhere + sqlConector + "mydb.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_CD = " + pItemCardapio.getCdTpFuncionario();
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
			itemCardapio.setCdTpFuncionario(rs.getInt(ItemCardapio.NM_COLUNA_TIPO_FUNCIONARIO_CD));
			itemCardapio.setDsTpFuncionario(rs.getString(ItemCardapio.NM_COLUNA_TIPO_FUNCIONARIO_DS));
			itemCardapio.setDhIncusaoRegistro(rs.getTimestamp(ItemCardapio.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			itemCardapio.setDhAlteracaoRegistro(rs.getTimestamp( ItemCardapio.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			itemCardapio.setDtFimVigencia(this.getDateOpcional(rs, ItemCardapio.NM_COLUNA_DT_FIM_VIGENCIA));

		}

		rs.close();
		stm.close();
		conexao.close();
		return itemCardapio;
	}


}
