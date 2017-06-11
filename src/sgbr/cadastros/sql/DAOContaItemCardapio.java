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

import sgbr.cadastros.IntfDAOContaItemCardapio;
import sgbr.entidades.Comanda;
import sgbr.entidades.Conta;
import sgbr.entidades.ContaItemCardapio;
import sgbr.entidades.Funcionario;
import sgbr.entidades.ItemCardapio;
import sgbr.entidades.Mesa;
import sgbr.entidades.Pessoa;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDContaItemCardapio;

/**
 * @author Reinaldo
 *
 */
public class DAOContaItemCardapio extends DAO_MYSQL implements IntfDAOContaItemCardapio {
	
	private static DAOContaItemCardapio aDAOContaItemCardapio = new DAOContaItemCardapio();

	/**
	 * Cria um novo objeto DAOContaItemCardapio.
	 */
	private DAOContaItemCardapio() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOContaItemCardapio getInstancia() {
		if (DAOContaItemCardapio.aDAOContaItemCardapio == null) {
			DAOContaItemCardapio.aDAOContaItemCardapio = new DAOContaItemCardapio();
		}

		return DAOContaItemCardapio.aDAOContaItemCardapio;
	}
	

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOContaItemCardapio#incluir(sgbr.entidades.ContaItemCardapio)
	 */
	@Override
	public ContaItemCardapio incluir(ContaItemCardapio pContaItemCardapio) throws SQLException {
		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pContaItemCardapio.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));
		pContaItemCardapio.setDhAlteracaoRegistro(new Timestamp(System.currentTimeMillis()));

		
		String sql = "INSERT INTO mydb.conta_item_cardapio (ITEM_CARDAPIO_CD,CONTA_CD,CONTA_ITEM_CARDAPIO_QTD,CONTA_ITEM_CARDAPIO_OBS,FUNCIONARIO_CD) VALUES (?,?,?,?,?);";

		ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		if (pContaItemCardapio.getCdItemCardapio() != null) {

			ppSt.setInt(1, pContaItemCardapio.getCdItemCardapio());
		} else {
			ppSt.setNull(1, java.sql.Types.INTEGER);
		}
		
		if (pContaItemCardapio.getCdConta() != null) {

			ppSt.setInt(2, pContaItemCardapio.getCdConta());
		} else {
			ppSt.setNull(2, java.sql.Types.INTEGER);
		}
		
		if (pContaItemCardapio.getQtdContaItemCardapio() != null) {

			ppSt.setInt(3, pContaItemCardapio.getQtdContaItemCardapio());
		} else {
			ppSt.setNull(3, java.sql.Types.INTEGER);
		}
		ppSt.setString(4, pContaItemCardapio.getObsContaItemCardapio());
		
		if (pContaItemCardapio.getCdFuncionario() != null) {

			ppSt.setInt(5, pContaItemCardapio.getCdFuncionario());
		} else {
			ppSt.setNull(5, java.sql.Types.INTEGER);
		}		

		ppSt.execute();

		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pContaItemCardapio.setCdContaItemCardapio(rs.getInt(1));
		}

		ppSt.close();
		conexao.close();

		return pContaItemCardapio;
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOContaItemCardapio#alterar(sgbr.entidades.ContaItemCardapio)
	 */
	
	public void alterar(ContaItemCardapio pContaItemCardapio) throws SQLException {
		Connection conexao = null;
		conexao = this.getConection();

		
		String sql = "UPDATE mydb.CONTA_ITEM_CARDAPIO SET  " 
		+ ContaItemCardapio.NM_COLUNA_CONTA_ITEM_CARDAPIO_QTD +" = ?, "  
		+ ContaItemCardapio.NM_COLUNA_CONTA_ITEM_CARDAPIO_OBS +" = ? "  ;
		
		sql = sql + " WHERE " + ContaItemCardapio.NM_COLUNA_CONTA_ITEM_CARDAPIO_CD +" = ? ";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		ppSt.setInt(1, pContaItemCardapio.getQtdContaItemCardapio());
		ppSt.setString(2, pContaItemCardapio.getObsContaItemCardapio());
		ppSt.setInt(3, pContaItemCardapio.getCdContaItemCardapio());
		
		ppSt.execute();

		ppSt.close();
		conexao.close();
				
	}


	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOContaItemCardapio#excluir(sgbr.entidades.ContaItemCardapio)
	 */
	public void excluir(String pCdContaItemCardapio) throws SQLException {
		Connection conexao = null;		

		conexao = this.getConection();

		String sql = "delete from mydb.CONTA_ITEM_CARDAPIO WHERE " + ContaItemCardapio.NM_COLUNA_CONTA_ITEM_CARDAPIO_CD + " = ?";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		
		ppSt.setInt(1, Integer.parseInt(pCdContaItemCardapio));
		

		ppSt.execute();

		ppSt.close();
		conexao.close();
		
	}
	
	
	
	
	
	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOContaItemCardapio#consultaTelaManterContaItemCardapio(java.lang.String, java.lang.String)
	 */
	public ArrayList<OTDContaItemCardapio> consultaTelaManterPedido(String pCdMesa, String pCdComanda) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDContaItemCardapio> arrayResposta = new ArrayList<>();
		OTDContaItemCardapio otdContaItemCardapio = null;

		conexao = this.getConection();
		String sql = "SELECT  MYDB.CONTA_ITEM_CARDAPIO.CONTA_ITEM_CARDAPIO_CD, "
				+ "MYDB.CONTA.CONTA_CD, MYDB.CONTA.MESA_CD, "
				+ "MYDB.CONTA.COMANDA_CD , "
				+ "MYDB.CONTA_ITEM_CARDAPIO.ITEM_CARDAPIO_CD, "
				+ "MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_NM, "
				+ "MYDB.CONTA_ITEM_CARDAPIO.CONTA_ITEM_CARDAPIO_QTD,"
				+ " MYDB.CONTA_ITEM_CARDAPIO.CONTA_ITEM_CARDAPIO_OBS, "
				+ " MYDB.CONTA_ITEM_CARDAPIO.FUNCIONARIO_CD, " 
				+" MYDB.pessoa.PESSOA_NM "
				+ "FROM mydb.conta_item_cardapio INNER JOIN  mydb.item_cardapio ON mydb.conta_item_cardapio.ITEM_CARDAPIO_CD = mydb.item_cardapio.ITEM_CARDAPIO_CD"
				+ "  INNER JOIN MYDB.CONTA  ON MYDB.CONTA.CONTA_CD = MYDB.CONTA_ITEM_CARDAPIO.CONTA_CD"
				+ " and conta.DH_ENCERRAMENTO is null "
				+" INNER JOIN MYDB.funcionario ON MYDB.conta_item_cardapio.FUNCIONARIO_CD = MYDB.funcionario.FUNCIONARIO_CD " 
				+" INNER JOIN MYDB.pessoa ON MYDB.pessoa.PESSOA_CD = MYDB.funcionario.PESSOA_CD ";
			

		if (!pCdMesa.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "	MYDB.CONTA.MESA_CD = " + pCdMesa;
			sqlConector = " \n AND ";
		}
		
		if (!pCdComanda.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "	MYDB.CONTA.COMANDA_CD = " + pCdComanda;
			sqlConector = " \n AND ";
		}
		
		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdContaItemCardapio = new OTDContaItemCardapio();
			otdContaItemCardapio.setCdPedido(rs.getInt(ContaItemCardapio.NM_COLUNA_CONTA_ITEM_CARDAPIO_CD));
			otdContaItemCardapio.setCdItemCardapio(rs.getInt(ContaItemCardapio.NM_COLUNA_ITEM_CARDAPIO_CD));
			otdContaItemCardapio.setNmItemCardapio(rs.getString(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_NM));
			otdContaItemCardapio.setQtdItemCardapio(rs.getInt(ContaItemCardapio.NM_COLUNA_CONTA_ITEM_CARDAPIO_QTD));
			otdContaItemCardapio.setObsItemCardapio(rs.getString(ContaItemCardapio.NM_COLUNA_CONTA_ITEM_CARDAPIO_OBS));
			otdContaItemCardapio.setCdMesa(rs.getInt(Mesa.NM_COLUNA_MESA_CD) == 0 ? null : rs.getInt(Mesa.NM_COLUNA_MESA_CD));
			otdContaItemCardapio.setCdComanda(rs.getInt(Comanda.NM_COLUNA_COMANDA_CD) == 0 ? null : rs.getInt(Comanda.NM_COLUNA_COMANDA_CD));
			otdContaItemCardapio.setCdConta(rs.getInt(Conta.NM_COLUNA_CONTA_CD));
			otdContaItemCardapio.setCdFuncionario(rs.getInt(Funcionario.NM_COLUNA_FUNCIONARIO_CD));
			otdContaItemCardapio.setNmFuncionario(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM));

			arrayResposta.add(otdContaItemCardapio);
		}

		rs.close();
		stm.close();
		conexao.close();
		return arrayResposta;
	}
	
	
	public OTDContaItemCardapio consultaDetalharPedido(String pCdPedido) throws SQLException{
		
		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		OTDContaItemCardapio otdContaItemCardapio = null;

		conexao = this.getConection();
		String sql = "SELECT  MYDB.CONTA_ITEM_CARDAPIO.CONTA_ITEM_CARDAPIO_CD, MYDB.CONTA.CONTA_CD, MYDB.CONTA.MESA_CD, MYDB.CONTA.COMANDA_CD , MYDB.CONTA_ITEM_CARDAPIO.ITEM_CARDAPIO_CD, MYDB.ITEM_CARDAPIO.ITEM_CARDAPIO_NM, MYDB.CONTA_ITEM_CARDAPIO.CONTA_ITEM_CARDAPIO_QTD,"
				+ " MYDB.CONTA_ITEM_CARDAPIO.CONTA_ITEM_CARDAPIO_OBS FROM mydb.conta_item_cardapio INNER JOIN  mydb.item_cardapio ON mydb.conta_item_cardapio.ITEM_CARDAPIO_CD = mydb.item_cardapio.ITEM_CARDAPIO_CD"
				+ "  INNER JOIN MYDB.CONTA  ON MYDB.CONTA.CONTA_CD = MYDB.CONTA_ITEM_CARDAPIO.CONTA_CD"
				+ " and conta.DH_ENCERRAMENTO is null ";
			
	
		if (!pCdPedido.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "	 MYDB.CONTA_ITEM_CARDAPIO.CONTA_ITEM_CARDAPIO_CD = " + pCdPedido;
			sqlConector = " \n AND ";
		}
		
		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdContaItemCardapio = new OTDContaItemCardapio();
			otdContaItemCardapio.setCdPedido(rs.getInt(ContaItemCardapio.NM_COLUNA_CONTA_ITEM_CARDAPIO_CD));
			otdContaItemCardapio.setCdItemCardapio(rs.getInt(ContaItemCardapio.NM_COLUNA_ITEM_CARDAPIO_CD));
			otdContaItemCardapio.setNmItemCardapio(rs.getString(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_NM));
			otdContaItemCardapio.setQtdItemCardapio(rs.getInt(ContaItemCardapio.NM_COLUNA_CONTA_ITEM_CARDAPIO_QTD));
			otdContaItemCardapio.setObsItemCardapio(rs.getString(ContaItemCardapio.NM_COLUNA_CONTA_ITEM_CARDAPIO_OBS));
			otdContaItemCardapio.setCdMesa(rs.getInt(Mesa.NM_COLUNA_MESA_CD) == 0 ? null : rs.getInt(Mesa.NM_COLUNA_MESA_CD));
			otdContaItemCardapio.setCdComanda(rs.getInt(Comanda.NM_COLUNA_COMANDA_CD) == 0 ? null : rs.getInt(Comanda.NM_COLUNA_COMANDA_CD));
			otdContaItemCardapio.setCdConta(rs.getInt(Conta.NM_COLUNA_CONTA_CD));

		}

		rs.close();
		stm.close();
		conexao.close();
		return otdContaItemCardapio;
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOContaItemCardapio#consultaPorChavePrimaria(sgbr.entidades.ContaItemCardapio)
	 */
	public ContaItemCardapio consultaPorChavePrimaria(ContaItemCardapio pContaItemCardapio) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDContaItemCardapio> arrayResposta = new ArrayList<>();
		ContaItemCardapio itemCardapio = null;

		conexao = this.getConection();

		String sql = "select * from mydb.ITEM_CARDAPIO";

		if (pContaItemCardapio.getCdContaItemCardapio() != null) {
			sqlWhere = sqlWhere + sqlConector + "mydb.ITEM_CARDAPIO.ITEM_CARDAPIO_CD = " + pContaItemCardapio.getCdContaItemCardapio();
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			itemCardapio = new ContaItemCardapio();
			itemCardapio.setCdContaItemCardapio(rs.getInt(ContaItemCardapio.NM_COLUNA_ITEM_CARDAPIO_CD));
			itemCardapio.setDhIncusaoRegistro(rs.getTimestamp(ContaItemCardapio.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			itemCardapio.setDhAlteracaoRegistro(rs.getTimestamp( ContaItemCardapio.NM_COLUNA_DH_ALTERACAO_REGISTRO));	

		}

		rs.close();
		stm.close();
		conexao.close();
		return itemCardapio;
	}


}
