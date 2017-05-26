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
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pPessoa.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));
		pPessoa.setDhAlteracaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "INSERT INTO mydb.pessoa (" + Pessoa.NM_COLUNA_PESSOA_NM + "," + Pessoa.NM_COLUNA_PESSOA_EE + ","
				+ Pessoa.NM_COLUNA_PESSOA_DT_NASC + "," + Pessoa.NM_COLUNA_PESSOA_ENDERECO_BAIRRO_NM + ","
				+ Pessoa.NM_COLUNA_PESSOA_ENDERECO_LOGRADOURO_NM + "," + Pessoa.NM_COLUNA_PESSOA_ENDERECO_LOGRADOURO_NU
				+ "," + Pessoa.NM_COLUNA_PESSOA_ENDERECO_CIDADE + "," + Pessoa.NM_COLUNA_PESSOA_ENDERECO_UF + ","
				+ Pessoa.NM_COLUNA_DH_INCLUSAO_REGISTRO + "," + Pessoa.NM_COLUNA_DH_ALTERACAO_REGISTRO
				+ ") VALUES(?,?,?,?,?,?,?,?,?,?)";

		ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ppSt.setString(1, pPessoa.getNmPessoa().toUpperCase());
		ppSt.setString(2, pPessoa.getEePessoa());
		ppSt.setDate(3, pPessoa.getDtNascPessoa());
		ppSt.setString(4, pPessoa.getNmBairro());
		ppSt.setString(5, pPessoa.getNmLogradouro());
		ppSt.setString(6, pPessoa.getNuLogradouro());
		ppSt.setString(7, pPessoa.getNmCidade());
		ppSt.setString(8, pPessoa.getNmUF());
		ppSt.setTimestamp(9, pPessoa.getDhIncusaoRegistro());
		ppSt.setTimestamp(10, pPessoa.getDhAlteracaoRegistro());

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
