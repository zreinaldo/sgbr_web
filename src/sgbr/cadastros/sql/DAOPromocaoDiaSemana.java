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
				+ PromocaoDiaSemana.NM_COLUNA_PROMOCAO_DIA_CD + " , " + PromocaoDiaSemana.NM_COLUNA_DH_INCLUSAO_REGISTRO
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
	public void excluir(Promocao pPromocao) throws SQLException {

		Connection conexao = null;

		conexao = this.getConection();

		String sql = "delete from mydb.PROMOCAO WHERE " + Promocao.NM_COLUNA_PROMOCAO_CD + " = ?";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		ppSt.setInt(1, pPromocao.getCdPromocao());

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

}
