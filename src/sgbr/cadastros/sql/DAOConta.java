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

import sgbr.cadastros.IntfDAOConta;
import sgbr.entidades.Comanda;
import sgbr.entidades.Conta;
import sgbr.entidades.Mesa;
import sgbr.entidades.Pessoa;
import sgbr.util.Constantes;
import sgbr.util.DAO_MYSQL;
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
						"mydb.pessoa.PESSOA_NM, " +
						"IF(mydb.conta.DH_ENCERRAMENTO is null,'ABERTO','FECHADO') AS SITUACAO " +
						"FROM mydb.conta " +
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
	public Collection<Comanda> consultaComandaConta(boolean pInUso) throws SQLException {

		Connection conexao = null;
		Comanda comanda = null;
		Collection<Comanda> colecaoComanda = new ArrayList<Comanda>();

		conexao = this.getConection();
		String sql = "SELECT COMANDA_CD FROM mydb.comanda";
		//comandas validas
		sql = sql + " where  mydb.comanda.COMANDA_DT_FIM_VALIDADE is null ";

		String operadorNot = "";
		if (!pInUso) {
			operadorNot = "not";
		}

		sql = sql + "and " + operadorNot
				+ " EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.COMANDA_CD = mydb.comanda.COMANDA_CD and mydb.conta.DH_ENCERRAMENTO is null)";

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
	
	
	public Collection<Mesa> consultaMesaConta(boolean pInUso) throws SQLException {

		Connection conexao = null;
		Mesa comanda = null;
		Collection<Mesa> colecaoComanda = new ArrayList<Mesa>();

		conexao = this.getConection();
		String sql = "SELECT MESA_CD FROM mydb.mesa";
		//comandas validas
		sql = sql + " where ";

		String operadorNot = "";
		if (!pInUso) {
			operadorNot = "not";
		}

		sql = sql + operadorNot
				+ " EXISTS( SELECT 1 FROM mydb.conta where mydb.conta.mesa_CD = mydb.mesa.mesa_CD and mydb.conta.DH_ENCERRAMENTO is null)";

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			comanda = new Mesa();
			comanda.setCdMesa(rs.getInt(Mesa.NM_COLUNA_MESA_CD));			
			colecaoComanda.add(comanda);
		}

		rs.close();
		stm.close();
		conexao.close();

		return colecaoComanda;
	}
}
