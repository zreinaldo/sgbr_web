/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sgbr.cadastros.IntfDAOPessoa;
import sgbr.entidades.Pessoa;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOPessoa extends DAO_MYSQL implements IntfDAOPessoa {

	private static DAOPessoa aDAOPessoa = new DAOPessoa();

	/**
	 * Cria um novo objeto DAOPessoa.
	 */
	private DAOPessoa() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOPessoa getInstancia() {
		if (DAOPessoa.aDAOPessoa == null) {
			DAOPessoa.aDAOPessoa = new DAOPessoa();
		}

		return DAOPessoa.aDAOPessoa;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOPessoa#incluir(sgbr.entidades.Pessoa)
	 */
	@Override
	public Pessoa incluir(Pessoa pPessoa) throws SQLException {
		Connection conexao = null;
		PreparedStatement preStmt = null;

		conexao = this.getConection();

		String sql = "INSERT INTO mydb.pessoa (" + Pessoa.NM_COLUNA_PESSOA_NM + "," + Pessoa.NM_COLUNA_PESSOA_EE + ","
				+ Pessoa.NM_COLUNA_PESSOA_DT_NASC + ") VALUES(?,?,?)";

		PreparedStatement ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ppSt.setString(1, pPessoa.getNmPessoa());
		ppSt.setString(2, pPessoa.getEePessoa());
		ppSt.setDate(3, pPessoa.getDtNascPessoa());

		ppSt.execute();

		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pPessoa.setCdPessoa(rs.getInt(1));
		}

		ppSt.close();
		conexao.close();

		return pPessoa;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOPessoa#alterar(sgbr.entidades.Pessoa)
	 */
	@Override
	public void alterar(Pessoa pPessoa) throws SQLException {

		Connection conexao = null;
		PreparedStatement preStmt = null;

		conexao = this.getConection();

		String sql = "INSERT INTO mydb.pessoa (PESSOA_nm,pessoa_ee,pessoa_dt_nasc) VALUES(?,?, ?)";

		PreparedStatement ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ppSt.setString(1, pPessoa.getNmPessoa());
		ppSt.setString(2, pPessoa.getEePessoa());
		ppSt.setDate(3, pPessoa.getDtNascPessoa());

		ppSt.execute();

		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pPessoa.setCdPessoa(rs.getInt(1));
		}

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOPessoa#excluir(sgbr.entidades.Pessoa)
	 */
	@Override
	public void excluir(Pessoa pPessoa) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOPessoa#consultarPorChavePrimaria(sgbr.entidades.
	 * Pessoa)
	 */
	@Override
	public Pessoa consultarPorChavePrimaria(Pessoa pPessoa) {
		// TODO Auto-generated method stub
		return null;
	}

}
