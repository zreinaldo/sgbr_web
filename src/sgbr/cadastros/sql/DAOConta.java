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
import sgbr.entidades.Mesa;
import sgbr.entidades.Pessoa;
import sgbr.entidades.TipoConta;
import sgbr.util.Constantes;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDCliente;
import sgbr.util.OTDConta;

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

	
	
	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOConta#incluir(sgbr.entidades.Conta)
	 */
	@Override
	public void incluir(Conta pConta) throws SQLException {
		// TODO Auto-generated method stub
		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pConta.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "INSERT INTO mydb.conta (COMANDA_CD,MESA_CD,TIPO_CONTA_CD,CLIENTE_CD,DH_INCLUSAO ) VALUES  (?,?,?,?,?)";

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

		ppSt.setTimestamp(5, pConta.getDhIncusaoRegistro());

		ppSt.execute();


		ppSt.close();
		conexao.close();

	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOConta#alterar(sgbr.entidades.Conta)
	 */
	@Override
	public void alterar(Conta pConta) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOConta#excluir(sgbr.entidades.Conta)
	 */
	@Override
	public void excluir(Conta pConta) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOConta#consultaTodosRegistros(boolean)
	 */
	@Override
	public Collection<Conta> consultaTodosRegistros(boolean pInRetornarApenasVigentes) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOConta#consultaPorChavePrimaria(sgbr.entidades.Conta)
	 */
	@Override
	public Conta consultaPorChavePrimaria(Conta pConta) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ArrayList<OTDConta> consultaTelaManterConta(String pCdMesa, String pCdComanda, String pSiConta)throws SQLException {


		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDConta> arrayResposta = new ArrayList<>();
		OTDConta otdConta = null;

		conexao = this.getConection();

		String sql = 
				"SELECT " +
						"mydb.conta.*, " +
						"mydb.tipo_conta.*, " +
						"mydb.pessoa.PESSOA_NM, " +
						"IF(mydb.conta.DH_ENCERRAMENTO is null,'ABERTO','FECHADO') AS SITUACAO " +
						"FROM mydb.conta " +
						" inner join mydb.tipo_conta on mydb.tipo_conta.TIPO_CONTA_CD = mydb.conta.tipo_conta_cd " +
						"left join mydb.cliente on mydb.cliente.CLIENTE_CD = mydb.conta.CLIENTE_CD " +
						"left join mydb.pessoa on mydb.pessoa.PESSOA_CD = mydb.cliente.PESSOA_CD ";

		if (!pCdMesa.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "mydb.conta.MESA_CD = "   + pCdMesa;
			sqlConector = " \n AND ";
		}

		if (!pCdComanda.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "mydb.conta.COMANDA_CD = "   + pCdMesa;
			sqlConector = " \n AND ";
		}

		if (pSiConta.equals(Constantes.SI_CONTA_SITUACAO_ENCERRADA)) {
			sqlWhere = sqlWhere + sqlConector + "conta.DH_ENCERRAMENTO is not null ";
			sqlConector = " \n AND ";
		}else if (pSiConta.equals(Constantes.SI_CONTA_SITUACAO_ABERTA)) {
			sqlWhere = sqlWhere + sqlConector + "conta.DH_ENCERRAMENTO is null ";
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
			otdConta.setCdCliente(rs.getInt(Conta.NM_COLUNA_CLIENTE_CD) == 0 ? null : rs.getInt(Conta.NM_COLUNA_CLIENTE_CD) );
			otdConta.setCdComanda(rs.getInt(Conta.NM_COLUNA_COMANDA_CD)  == 0 ? null : rs.getInt(Conta.NM_COLUNA_COMANDA_CD) );
			otdConta.setCdConta(rs.getInt(Conta.NM_COLUNA_CONTA_CD));
			otdConta.setCdMesa(rs.getInt(Conta.NM_COLUNA_MESA_CD) == 0 ? null : rs.getInt(Conta.NM_COLUNA_MESA_CD) );			
			otdConta.setNmCliente(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM));
			otdConta.setSiConta(rs.getString("SITUACAO"));
			otdConta.setDhAbertura(rs.getTimestamp(Conta.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			otdConta.setCdTipoConta(rs.getInt(TipoConta.NM_COLUNA_TIPO_CONTA_CD));
			otdConta.setDsTipoConta(rs.getString(TipoConta.NM_COLUNA_TIPO_CONTA_DS));
			arrayResposta.add(otdConta);
		}

		rs.close();
		stm.close();
		conexao.close();
		return arrayResposta;
	
		
	}
	
	/**
	 * retorna a comandas em uso ou as livres para serem usadas
	 * 
	 * @param pInUso
	 * @return
	 * @throws SQLException
	 */
	public Collection<Comanda> consultaComandaConta(String pInUso,String pCdTipoConta) throws SQLException {

		Connection conexao = null;
		Comanda comanda = null;
		Collection<Comanda> colecaoComanda = new ArrayList<Comanda>();

		conexao = this.getConection();
		String sql = "SELECT COMANDA_CD FROM mydb.comanda";
		//comandas validas
		sql = sql + " where  mydb.comanda.COMANDA_DT_FIM_VALIDADE is null ";

//		String operadorNot = "";
//		if (!pInUso) {
//			operadorNot = "not";
//		}
//
//		sql = sql + "and " + operadorNot
//				+ " EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.COMANDA_CD = mydb.comanda.COMANDA_CD and mydb.conta.DH_ENCERRAMENTO is null)";

		um select par acada tela
		if (pInUso.equals(Constantes.CD_NAO) && (pCdTipoConta == null || pCdTipoConta.isEmpty() )) {
			sql = sql + " and NOT EXISTS  ( SELECT 1 FROM mydb.conta where mydb.conta.COMANDA_CD = mydb.comanda.COMANDA_CD and mydb.conta.DH_ENCERRAMENTO is null)";
		} else if (pInUso.equals(Constantes.CD_SIM)  && (pCdTipoConta == null || pCdTipoConta.isEmpty() )) {
			
			sql = sql + " and EXISTS  ( SELECT 1 FROM mydb.conta where mydb.conta.COMANDA_CD =  mydb.comanda.COMANDA_CD and mydb.conta.DH_ENCERRAMENTO is null)";
		} else {
			if (pCdTipoConta == Constantes.CD_TIPO_CONTA_MESA){
				sql = sql + " and not EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.COMANDA_CD =  mydb.comanda.COMANDA_CD and conta.DH_ENCERRAMENTO is null )";
			} else	if (pInUso.equals(Constantes.CD_SIM) && pCdTipoConta == Constantes.CD_TIPO_CONTA_COMANDA){
				sql = sql + " and EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.COMANDA_CD =  mydb.comanda.COMANDA_CD and TIPO_CONTA_CD = " + Constantes.CD_TIPO_CONTA_MESA +" and conta.DH_ENCERRAMENTO is null )";
			}else	if (pCdTipoConta == Constantes.CD_TIPO_CONTA_COMANDA){
				sql = sql + " and not EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.COMANDA_CD =  mydb.comanda.COMANDA_CD and TIPO_CONTA_CD = " + Constantes.CD_TIPO_CONTA_MESA +" and conta.DH_ENCERRAMENTO is null )";
			}  
			
		}
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
	
	
	public Collection<Mesa> consultaMesaConta(String pInUso,String pCdTipoConta) throws SQLException {

		Connection conexao = null;
		Mesa mesa = null;
		Collection<Mesa> colecaoMesa = new ArrayList<Mesa>();

		conexao = this.getConection();
		String sql = "SELECT MESA_CD FROM mydb.mesa";
		//comandas validas
		sql = sql + " where ";

		String operadorNot = "";
		if (pInUso.equals(Constantes.CD_NAO)) {
			sql = sql + " NOT EXISTS  ( SELECT 1 FROM mydb.conta where mydb.conta.mesa_CD = mydb.mesa.mesa_CD and mydb.conta.DH_ENCERRAMENTO is null)";
		} else if (pInUso.equals(Constantes.CD_SIM)) {
			
			sql = sql + "EXISTS  ( SELECT 1 FROM mydb.conta where mydb.conta.mesa_CD = mydb.mesa.mesa_CD and mydb.conta.DH_ENCERRAMENTO is null)";
		} else {
			if (pCdTipoConta == Constantes.CD_TIPO_CONTA_MESA){
				sql = sql + "not EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.MESA_CD = mydb.mesa.MESA_CD and conta.DH_ENCERRAMENTO is null )";
			} else	if (pCdTipoConta == Constantes.CD_TIPO_CONTA_COMANDA){
				sql = sql + "not EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.MESA_CD = mydb.mesa.MESA_CD and TIPO_CONTA_CD = " + Constantes.CD_TIPO_CONTA_MESA +" and conta.DH_ENCERRAMENTO is null )";
			}
		}
		
		
		
//		if (pCdTipoConta == null) {
//			sql = sql + operadorNot
//			+ " ( SELECT 1 FROM mydb.conta where mydb.conta.mesa_CD = mydb.mesa.mesa_CD and mydb.conta.DH_ENCERRAMENTO is null)";
//	     }else {
//	    	 sql = sql + operadorNot
//	    				+ " EXISTS( SELECT 1 FROM mydb.conta where "
//	    				+ " mydb.conta.mesa_CD = mydb.mesa.mesa_CD "
//	    				+ "and mydb.conta.DH_ENCERRAMENTO is null "
//	    				+ "and mydb.conta.TIPO_CONTA_CD = " + pCdTipoConta + ")";
//	     }
		
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
		String sql = "SELECT CLIENTE_CD, mydb.pessoa.PESSOA_NM FROM mydb.cliente " +
				" inner join mydb.pessoa on mydb.pessoa.PESSOA_CD = mydb.cliente.PESSOA_CD "; 

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
}
