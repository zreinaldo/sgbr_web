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

import sgbr.cadastros.IntfDAOPromocaoDiaSemana;
import sgbr.entidades.Promocao;
import sgbr.entidades.PromocaoDiaSemana;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOPromocaoDiaSemana extends DAO_MYSQL implements IntfDAOPromocaoDiaSemana {

	private static DAOPromocaoDiaSemana aDAOPromocaoDiaSemana = new DAOPromocaoDiaSemana();

	/**
	 * Cria um novo objeto DAOPromocaoDiaSemana.
	 */
	private DAOPromocaoDiaSemana() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOPromocaoDiaSemana getInstancia() {
		if (DAOPromocaoDiaSemana.aDAOPromocaoDiaSemana == null) {
			DAOPromocaoDiaSemana.aDAOPromocaoDiaSemana = new DAOPromocaoDiaSemana();
		}

		return DAOPromocaoDiaSemana.aDAOPromocaoDiaSemana;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOPromocaoDiaSemana#incluir()
	 */
	@Override
	public void incluir(PromocaoDiaSemana pPromocaoDiaSemana) throws SQLException {

		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pPromocaoDiaSemana.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "INSERT INTO mydb.promocao_dia_semana " + "(" + PromocaoDiaSemana.NM_COLUNA_PROMOCAO_CD + " , "
				+ PromocaoDiaSemana.NM_COLUNA_DIA_SEMANA_CD + " , " + PromocaoDiaSemana.NM_COLUNA_DH_INCLUSAO_REGISTRO
				+ ") VALUES " + "(?,?,?) " ;

		ppSt = conexao.prepareStatement(sql);

		ppSt.setInt(1, pPromocaoDiaSemana.getCdPromocao());
		ppSt.setInt(2, pPromocaoDiaSemana.getCdDiaPromocao());
		ppSt.setTimestamp(3, pPromocaoDiaSemana.getDhIncusaoRegistro());

		ppSt.execute();

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOPromocaoDiaSemana#excluir(sgbr.entidades.Promocao)
	 */
	@Override
	public void excluir(Integer pCdPromocao) throws SQLException {

		Connection conexao = null;

		conexao = this.getConection();

		String sql = "delete from mydb.promocao_dia_semana WHERE " + PromocaoDiaSemana.NM_COLUNA_PROMOCAO_CD + " = ?";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		ppSt.setInt(1, pCdPromocao);

		ppSt.execute();

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOPromocaoDiaSemana#consultaPorChavePrimaria(sgbr.
	 * entidades.PromocaoDiaSemana)
	 */
	@Override
	public PromocaoDiaSemana consultaPorChavePrimaria(PromocaoDiaSemana pPromocaoDiaSemana) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ArrayList<Integer> consultaPromocaoDiasSemana(Integer pCdPromocao) throws SQLException {	

	Connection conexao = null;
	PromocaoDiaSemana promocaoDiaSemana = null;
	ArrayList<Integer> aPromocaoDiaSemana = new ArrayList<>();

	conexao = this.getConection();

	String sql = "select * from mydb.promocao_dia_semana where mydb.promocao_dia_semana.PROMOCAO_CD = " + pCdPromocao;


	Statement stm = conexao.createStatement();

	ResultSet rs = stm.executeQuery(sql);

	while (rs.next()) {
//		promocaoDiaSemana = new PromocaoDiaSemana();
//		promocaoDiaSemana.setCdPromocao(rs.getInt(PromocaoDiaSemana.NM_COLUNA_PROMOCAO_CD));
//		promocaoDiaSemana.setCdDiaPromocao(rs.getInt(PromocaoDiaSemana.NM_COLUNA_PROMOCAO_CD));
		aPromocaoDiaSemana.add(rs.getInt(PromocaoDiaSemana.NM_COLUNA_DIA_SEMANA_CD));

	}

	rs.close();
	stm.close();
	conexao.close();
	return aPromocaoDiaSemana;
	}

}
