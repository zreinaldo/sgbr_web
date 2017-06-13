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

import sgbr.cadastros.IntfDAOConta;
import sgbr.entidades.Cliente;
import sgbr.entidades.Comanda;
import sgbr.entidades.Conta;
import sgbr.entidades.ContaItemCardapio;
import sgbr.entidades.ItemCardapio;
import sgbr.entidades.Mesa;
import sgbr.entidades.Pessoa;
import sgbr.entidades.Promocao;
import sgbr.entidades.TipoConta;
import sgbr.util.Constantes;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDCliente;
import sgbr.util.OTDConta;
import sgbr.util.OTDContaItemCardapio;
import sgbr.util.Util;

/**
 * @author Reinaldo
 *
 */
public class DAOConta extends DAO_MYSQL implements IntfDAOConta {

	private static DAOConta aDAOConta = new DAOConta();

	/**
	 * Cria um novo objeto DAOConta.
	 */
	private DAOConta() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOConta getInstancia() {
		if (DAOConta.aDAOConta == null) {
			DAOConta.aDAOConta = new DAOConta();
		}

		return DAOConta.aDAOConta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOConta#incluir(sgbr.entidades.Conta)
	 */
	@Override
	public void incluir(Conta pConta) throws SQLException {
		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pConta.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "INSERT INTO mydb.conta (COMANDA_CD,MESA_CD,TIPO_CONTA_CD,CLIENTE_CD,FUNCIONARIO_CD,DH_INCLUSAO ) VALUES  (?,?,?,?,?,?)";

		ppSt = conexao.prepareStatement(sql);
		if (pConta.getCdComanda() != null) {

			ppSt.setInt(1, pConta.getCdComanda());
		} else {
			ppSt.setNull(1, java.sql.Types.INTEGER);
		}

		if (pConta.getCdMesa() != null) {

			ppSt.setInt(2, pConta.getCdMesa());
		} else {
			ppSt.setNull(2, java.sql.Types.INTEGER);
		}

		if (pConta.getCdTipoConta() != null) {

			ppSt.setInt(3, pConta.getCdTipoConta());
		} else {
			ppSt.setNull(3, java.sql.Types.INTEGER);
		}

		if (pConta.getCdCliente() != null) {

			ppSt.setInt(4, pConta.getCdCliente());
		} else {
			ppSt.setNull(4, java.sql.Types.INTEGER);
		}
		
		
		if (pConta.getCdFuncionario() != null) {
			
			ppSt.setInt(5, pConta.getCdFuncionario());
		} else {
			ppSt.setNull(5, java.sql.Types.INTEGER);
		}

		ppSt.setTimestamp(6, pConta.getDhIncusaoRegistro());

		ppSt.execute();

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOConta#alterar(sgbr.entidades.Conta)
	 */
	@Override
	public void alterar(Conta pConta) throws SQLException {

		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		String sql = "UPDATE mydb.conta SET CLIENTE_CD = ?, " + "CONTA_DESCONTO_VL=?, " + "CONTA_VL_ORIGINAL=?, "
				+ "CONTA_DESCONTO_PERC=?, " + "CONTA_VL_FINAL=?, " + "DH_ENCERRAMENTO = ? " + "WHERE CONTA_CD = ? ";

		ppSt = conexao.prepareStatement(sql);

		if (pConta.getCdCliente() != null) {

			ppSt.setInt(1, pConta.getCdCliente());
		} else {
			ppSt.setNull(1, java.sql.Types.INTEGER);
		}

		if (pConta.getVlDescontoConta() != null) {
			ppSt.setDouble(2, pConta.getVlDescontoConta());
		} else {
			ppSt.setNull(2, java.sql.Types.DOUBLE);
		}

		if (pConta.getVlContaOriginal() != null) {
			ppSt.setDouble(3, pConta.getVlContaOriginal());
		} else {
			ppSt.setNull(3, java.sql.Types.DOUBLE);
		}

		if (pConta.getPercDescontoConta() != null) {
			ppSt.setDouble(4, pConta.getPercDescontoConta());
		} else {
			ppSt.setNull(4, java.sql.Types.DOUBLE);
		}

		if (pConta.getVlContaFinal() != null) {
			ppSt.setDouble(5, pConta.getVlContaFinal());
		} else {
			ppSt.setNull(5, java.sql.Types.DOUBLE);
		}

		if (pConta.getDhEncerramento() != null) {

			ppSt.setTimestamp(6, pConta.getDhEncerramento());
		} else {
			ppSt.setNull(6, java.sql.Types.TIMESTAMP);
		}

		ppSt.setInt(7, pConta.getCdConta());

		ppSt.execute();

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOConta#excluir(sgbr.entidades.Conta)
	 */
	@Override
	public void excluir(Conta pConta) throws SQLException {
		Connection conexao = null;		

		conexao = this.getConection();

		String sql = "delete from mydb.CONTA WHERE " + Conta.NM_COLUNA_CONTA_CD + " = ?";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		
		ppSt.setInt(1, pConta.getCdConta());
		

		ppSt.execute();

		ppSt.close();
		conexao.close();
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOConta#consultaPorChavePrimaria(sgbr.entidades.
	 * Conta)
	 */
	@Override
	public Conta consultaPorChavePrimaria(Conta pConta) throws SQLException {
		
		Connection conexao = null;
		Conta conta = null;

		conexao = this.getConection();

		String sql = "SELECT " +
				"* " +
				"FROM MYDB.CONTA " +
				"WHERE MYDB.CONTA.CONTA_CD = " + pConta.getCdConta();

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			conta = new Conta();
			conta.setCdConta(rs.getInt(Conta.NM_COLUNA_CONTA_CD));
			
			conta.setCdComanda(
					rs.getInt(Conta.NM_COLUNA_COMANDA_CD) == 0 ? null : rs.getInt(Conta.NM_COLUNA_COMANDA_CD));
			conta.setCdMesa(rs.getInt(Conta.NM_COLUNA_MESA_CD) == 0 ? null : rs.getInt(Conta.NM_COLUNA_MESA_CD));
			conta.setVlContaFinal(rs.getDouble(Conta.NM_COLUNA_CONTA_VL_FINAL) == 0 ? null : rs.getDouble(Conta.NM_COLUNA_CONTA_VL_FINAL));
			conta.setCdCliente(
					rs.getInt(Conta.NM_COLUNA_CLIENTE_CD) == 0 ? null : rs.getInt(Conta.NM_COLUNA_CLIENTE_CD));
			conta.setVlDescontoConta(rs.getDouble(Conta.NM_COLUNA_CONTA_DESCONTO_VL) == 0 ? null : rs.getDouble(Conta.NM_COLUNA_CONTA_DESCONTO_VL));
			conta.setPercDescontoConta(rs.getDouble(Conta.NM_COLUNA_CONTA_DESCONTO_PERC) == 0 ? null : rs.getDouble(Conta.NM_COLUNA_CONTA_DESCONTO_PERC));
			conta.setDhIncusaoRegistro(rs.getTimestamp(Conta.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			conta.setDhEncerramento(rs.getTimestamp(Conta.NM_COLUNA_DH_ENCERRAMENTO));
			conta.setCdTipoConta(rs.getInt(TipoConta.NM_COLUNA_TIPO_CONTA_CD));
			conta.setVlContaOriginal(rs.getDouble(Conta.NM_COLUNA_CONTA_VL_ORIGINAL) == 0 ? null : rs.getDouble(Conta.NM_COLUNA_CONTA_VL_ORIGINAL));

		}

		rs.close();
		stm.close();
		conexao.close();
		return conta;
	}

	public ArrayList<OTDConta> consultaTelaManterConta(String pCdMesa, String pCdComanda, String pSiConta, String pCdCliente)
			throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDConta> arrayResposta = new ArrayList<>();
		OTDConta otdConta = null;

		conexao = this.getConection();

		String sql = "SELECT " + "mydb.conta.*, " + "mydb.tipo_conta.*, " + "mydb.pessoa.PESSOA_NM as CLIENTE_NM, " 
				+ " pf.pessoa_nm AS FUNCIONARIO_NM , "
				
				+ "IF(mydb.conta.DH_ENCERRAMENTO is null,'ABERTA','ENCERRADA') AS SITUACAO " + "FROM mydb.conta "
				+ " inner join mydb.tipo_conta on mydb.tipo_conta.TIPO_CONTA_CD = mydb.conta.tipo_conta_cd "
				+ "left join mydb.cliente on mydb.cliente.CLIENTE_CD = mydb.conta.CLIENTE_CD "
				+ "left join mydb.pessoa on mydb.pessoa.PESSOA_CD = mydb.cliente.PESSOA_CD "
		
				+ "LEFT join mydb.funcionario on mydb.funcionario.FUNCIONARIO_CD = mydb.conta.FUNCIONARIO_CD " 
				+ "LEFT join mydb.pessoa as pf on pf.PESSOA_CD = mydb.funcionario.PESSOA_CD ";

		if (!pCdMesa.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "mydb.conta.MESA_CD = " + pCdMesa;
			sqlConector = " \n AND ";
		}

		if (!pCdComanda.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "mydb.conta.COMANDA_CD = " + pCdComanda;
			sqlConector = " \n AND ";
		}

		if (pSiConta.equals(Constantes.SI_CONTA_SITUACAO_ENCERRADA)) {
			sqlWhere = sqlWhere + sqlConector + "conta.DH_ENCERRAMENTO is not null ";
			sqlConector = " \n AND ";
		} else if (pSiConta.equals(Constantes.SI_CONTA_SITUACAO_ABERTA)) {
			sqlWhere = sqlWhere + sqlConector + "conta.DH_ENCERRAMENTO is null ";
			sqlConector = " \n AND ";
		}
		
		if (!pCdCliente.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "mydb.conta.CLIENTE_CD = " + pCdCliente;
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		sql = sql + " order by mydb.conta.conta_cd desc";

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);
		
		while (rs.next()) {
			otdConta = new OTDConta();
			otdConta.setCdCliente(
					rs.getInt(Conta.NM_COLUNA_CLIENTE_CD) == 0 ? null : rs.getInt(Conta.NM_COLUNA_CLIENTE_CD));
			otdConta.setCdComanda(
					rs.getInt(Conta.NM_COLUNA_COMANDA_CD) == 0 ? null : rs.getInt(Conta.NM_COLUNA_COMANDA_CD));
			otdConta.setCdConta(rs.getInt(Conta.NM_COLUNA_CONTA_CD));
			otdConta.setCdMesa(rs.getInt(Conta.NM_COLUNA_MESA_CD) == 0 ? null : rs.getInt(Conta.NM_COLUNA_MESA_CD));
			otdConta.setNmCliente(rs.getString("CLIENTE_NM"));
			otdConta.setSiConta(rs.getString("SITUACAO"));
			otdConta.setDhAbertura(rs.getTimestamp(Conta.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			otdConta.setCdTipoConta(rs.getInt(TipoConta.NM_COLUNA_TIPO_CONTA_CD));			
			otdConta.setDsTipoConta(rs.getString(TipoConta.NM_COLUNA_TIPO_CONTA_DS));			
			otdConta.setNmFuncionario(rs.getString("FUNCIONARIO_NM"));
			
			arrayResposta.add(otdConta);
		}

		rs.close();
		stm.close();
		conexao.close();
		return arrayResposta;

	}
	
	public OTDConta consultaDetalharConta(String pCdConta) throws SQLException {
		
		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		OTDConta otdConta = null;

		conexao = this.getConection();

		String sql = "SELECT " + "mydb.conta.*, " + "mydb.tipo_conta.*, " + "mydb.pessoa.PESSOA_NM, "
				+ "IF(mydb.conta.DH_ENCERRAMENTO is null,'ABERTO','FECHADO') AS SITUACAO " + "FROM mydb.conta "
				+ " inner join mydb.tipo_conta on mydb.tipo_conta.TIPO_CONTA_CD = mydb.conta.tipo_conta_cd "
				+ "left join mydb.cliente on mydb.cliente.CLIENTE_CD = mydb.conta.CLIENTE_CD "
				+ "left join mydb.pessoa on mydb.pessoa.PESSOA_CD = mydb.cliente.PESSOA_CD ";

		if (!pCdConta.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "mydb.conta.CONTA_CD = " + pCdConta;
			sqlConector = " \n AND ";
		}
		
		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}


		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdConta = new OTDConta();
			otdConta.setCdCliente(
					rs.getInt(Conta.NM_COLUNA_CLIENTE_CD) == 0 ? null : rs.getInt(Conta.NM_COLUNA_CLIENTE_CD));
			otdConta.setCdComanda(
					rs.getInt(Conta.NM_COLUNA_COMANDA_CD) == 0 ? null : rs.getInt(Conta.NM_COLUNA_COMANDA_CD));
			otdConta.setCdConta(rs.getInt(Conta.NM_COLUNA_CONTA_CD));
			otdConta.setCdMesa(rs.getInt(Conta.NM_COLUNA_MESA_CD) == 0 ? null : rs.getInt(Conta.NM_COLUNA_MESA_CD));
			otdConta.setNmCliente(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM));
			otdConta.setSiConta(rs.getString("SITUACAO"));
			otdConta.setDhAbertura(rs.getTimestamp(Conta.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			otdConta.setCdTipoConta(rs.getInt(TipoConta.NM_COLUNA_TIPO_CONTA_CD));
			otdConta.setDsTipoConta(rs.getString(TipoConta.NM_COLUNA_TIPO_CONTA_DS));
			
			otdConta.setVlDescontoConta(this.getDoubleOpcional( rs,Conta.NM_COLUNA_CONTA_DESCONTO_VL));
			otdConta.setVlContaOriginal(this.getDoubleOpcional( rs,Conta.NM_COLUNA_CONTA_VL_ORIGINAL));
			otdConta.setPercDescontoConta(this.getDoubleOpcional( rs,Conta.NM_COLUNA_CONTA_DESCONTO_PERC));
			otdConta.setVlContaFinal(this.getDoubleOpcional( rs,Conta.NM_COLUNA_CONTA_VL_FINAL));
			otdConta.setDhEncerramento(rs.getTimestamp(Conta.NM_COLUNA_DH_ENCERRAMENTO));	
			
			
		}

		rs.close();
		stm.close();
		conexao.close();
		return otdConta;
	}

	/**
	 * retorna a comandas em uso ou as livres para serem usadas
	 * 
	 * @param pInUso
	 * @return
	 * @throws SQLException
	 */
	public Collection<Comanda> consultaComandaConta(String pInUso, String pCdTipoConta) throws SQLException {

		Connection conexao = null;
		Comanda comanda = null;
		Collection<Comanda> colecaoComanda = new ArrayList<Comanda>();

		conexao = this.getConection();

		conexao = this.getConection();
		String sql = "SELECT comanda_CD FROM mydb.comanda";
		// comandas validas
		sql = sql + " where ";

		String operadorNot = "";
		if (pInUso.equals(Constantes.CD_NAO)) {
			operadorNot = "not";
		}
		if (pCdTipoConta != null) {
			sql = sql + operadorNot
					+ " EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.comanda_CD = mydb.comanda.comanda_CD and conta.TIPO_CONTA_CD = "
					+ pCdTipoConta + " and conta.DH_ENCERRAMENTO is null)";
		} else {
			sql = sql + operadorNot
					+ " EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.comanda_CD = mydb.comanda.comanda_CD and conta.DH_ENCERRAMENTO is null )";
		}

		// so retorna comandas validas
		sql = sql
				+ " and (mydb.comanda.COMANDA_DT_FIM_VALIDADE is null or mydb.comanda.COMANDA_DT_FIM_VALIDADE > CURRENT_TIMESTAMP) ";

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			comanda = new Comanda();
			comanda.setCdComanda(rs.getInt(Comanda.NM_COLUNA_COMANDA_CD));
			colecaoComanda.add(comanda);
		}

		rs.close();
		stm.close();
		conexao.close();

		return colecaoComanda;
	}

	public Collection<Mesa> consultaMesaConta(String pInUso, String pCdTipoConta) throws SQLException {

		Connection conexao = null;
		Mesa mesa = null;
		Collection<Mesa> colecaoMesa = new ArrayList<Mesa>();

		conexao = this.getConection();
		String sql = "SELECT MESA_CD FROM mydb.mesa";
		// comandas validas
		sql = sql + " where ";

		String operadorNot = "";
		if (pInUso.equals(Constantes.CD_NAO)) {
			operadorNot = "not";
		}
		if (pCdTipoConta != null) {
			sql = sql + operadorNot
					+ " EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.MESA_CD = mydb.mesa.MESA_CD and conta.TIPO_CONTA_CD = "
					+ pCdTipoConta + " and conta.DH_ENCERRAMENTO is null )";
		} else {
			sql = sql + operadorNot
					+ " EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.MESA_CD = mydb.mesa.MESA_CD and conta.DH_ENCERRAMENTO is null )";
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			mesa = new Mesa();
			mesa.setCdMesa(rs.getInt(Mesa.NM_COLUNA_MESA_CD));
			colecaoMesa.add(mesa);
		}

		rs.close();
		stm.close();
		conexao.close();

		return colecaoMesa;
	}

	public Collection<OTDCliente> consultaClienteConta(boolean pInUso) throws SQLException {

		Connection conexao = null;
		OTDCliente cliente = null;
		Collection<OTDCliente> colecaoCLiente = new ArrayList<OTDCliente>();

		conexao = this.getConection();
		String sql = "SELECT CLIENTE_CD, mydb.pessoa.PESSOA_NM FROM mydb.cliente "
				+ " inner join mydb.pessoa on mydb.pessoa.PESSOA_CD = mydb.cliente.PESSOA_CD ";

		sql = sql + " where ";

		String operadorNot = "";
		if (!pInUso) {
			operadorNot = "not";
		}

		sql = sql + operadorNot
				+ " EXISTS( SELECT   1   FROM mydb.conta   where mydb.conta.CLIENTE_CD = mydb.cliente.CLIENTE_CD and mydb.conta.DH_ENCERRAMENTO is  null)";

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			cliente = new OTDCliente();
			cliente.setCdCliente(rs.getInt(Cliente.NM_COLUNA_CLIENTE_CD));
			cliente.setNmCliente(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM));
			colecaoCLiente.add(cliente);
		}

		rs.close();
		stm.close();
		conexao.close();

		return colecaoCLiente;
	}

	public ArrayList<OTDContaItemCardapio> consultarTodosItensConta(Integer pCdConta) throws SQLException {

		String sqlFinal = "";
		String diaSemana = Util.getDiaSemana();

		Connection conexao = null;
		ArrayList<OTDContaItemCardapio> arrayResposta = new ArrayList<>();
		OTDContaItemCardapio otdContaItemCardapio = null;

		conexao = this.getConection();
		String sqlItemEmPromocao = "SELECT " + "item_cardapio.ITEM_CARDAPIO_CD, " + "item_cardapio.ITEM_CARDAPIO_NM, "
				+ "mydb.promocao.PROMOCAO_VL, " + "MYDB.CONTA_ITEM_CARDAPIO.CONTA_ITEM_CARDAPIO_QTD, "
				+ "(mydb.promocao.PROMOCAO_VL * MYDB.CONTA_ITEM_CARDAPIO.CONTA_ITEM_CARDAPIO_QTD)as VL_TOTAL, "
				+ "'SIM' AS ITEM_IN_PROMOCAO " + "FROM mydb.conta_item_cardapio "
				+ "INNER JOIN mydb.item_cardapio ON mydb.conta_item_cardapio.ITEM_CARDAPIO_CD = mydb.item_cardapio.ITEM_CARDAPIO_CD "
				+ "inner join mydb.promocao ON mydb.conta_item_cardapio.ITEM_CARDAPIO_CD = mydb.promocao.ITEM_CARDAPIO_CD "
				+ "INNER JOIN MYDB.CONTA ON MYDB.CONTA.CONTA_CD = MYDB.CONTA_ITEM_CARDAPIO.CONTA_CD "
				+ "and conta.DH_ENCERRAMENTO is null " + "where MYDB.CONTA.CONTA_CD = " + pCdConta + " And EXISTS "
				+ "( " + "   SELECT " + "   1 " + "   FROM mydb.promocao_dia_semana " + "   where "
				+ "       mydb.promocao_dia_semana.PROMOCAO_CD = mydb.promocao.PROMOCAO_CD "
				+ "   and mydb.promocao_dia_semana.DIA_SEMANA_CD = " + diaSemana
				+ " and (mydb.promocao.PROMOCAO_DT_FIM is null or mydb.promocao.PROMOCAO_DT_FIM > current_date) "
				+ ") ";

		String sqlItem = "SELECT " + "item_cardapio.ITEM_CARDAPIO_CD, " + "item_cardapio.ITEM_CARDAPIO_NM, "
				+ "item_cardapio.ITEM_CARDAPIO_VL, " + "MYDB.CONTA_ITEM_CARDAPIO.CONTA_ITEM_CARDAPIO_QTD, "
				+ "(mydb.item_cardapio.ITEM_CARDAPIO_VL * MYDB.CONTA_ITEM_CARDAPIO.CONTA_ITEM_CARDAPIO_QTD)as VL_TOTAL, "
				+ "'NAO' AS ITEM_IN_PROMOCAO " + "FROM mydb.conta_item_cardapio "
				+ "INNER JOIN mydb.item_cardapio ON mydb.conta_item_cardapio.ITEM_CARDAPIO_CD = mydb.item_cardapio.ITEM_CARDAPIO_CD "
				+ "INNER JOIN MYDB.CONTA ON MYDB.CONTA.CONTA_CD = MYDB.CONTA_ITEM_CARDAPIO.CONTA_CD "
				+ "and conta.DH_ENCERRAMENTO is null " + "where MYDB.CONTA.CONTA_CD = " + pCdConta + " and not EXISTS( "
				+ "   SELECT " + "   1 " + "   FROM mydb.promocao "
				+ "   inner join mydb.promocao_dia_semana on mydb.promocao_dia_semana.PROMOCAO_CD = mydb.promocao.PROMOCAO_CD "
				+ "   where mydb.conta_item_cardapio.ITEM_CARDAPIO_CD = mydb.promocao.ITEM_CARDAPIO_CD "
				+ "   and mydb.promocao_dia_semana.DIA_SEMANA_CD = " + diaSemana
				+ "    and (mydb.promocao.PROMOCAO_DT_FIM is null or mydb.promocao.PROMOCAO_DT_FIM > current_date) "
				+ ") ";

		sqlFinal = sqlItemEmPromocao + " UNION ALL " + sqlItem;

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sqlFinal);

		while (rs.next()) {
			otdContaItemCardapio = new OTDContaItemCardapio();
			otdContaItemCardapio.setCdItemCardapio(rs.getInt(ContaItemCardapio.NM_COLUNA_ITEM_CARDAPIO_CD));
			otdContaItemCardapio.setNmItemCardapio(rs.getString(ItemCardapio.NM_COLUNA_ITEM_CARDAPIO_NM));
			otdContaItemCardapio.setQtdItemCardapio(rs.getInt(ContaItemCardapio.NM_COLUNA_CONTA_ITEM_CARDAPIO_QTD));
			otdContaItemCardapio.setVlItemCardapio(rs.getDouble(Promocao.NM_COLUNA_PROMOCAO_VL));
			otdContaItemCardapio.setVlTotal(rs.getDouble("VL_TOTAL"));
			otdContaItemCardapio.setInPromocao(rs.getString("ITEM_IN_PROMOCAO"));

			arrayResposta.add(otdContaItemCardapio);
		}

		rs.close();
		stm.close();
		conexao.close();
		return arrayResposta;
	}

}
