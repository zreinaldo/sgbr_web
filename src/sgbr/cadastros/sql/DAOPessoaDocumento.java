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

import sgbr.cadastros.IntfDAOPessoaDocumento;
import sgbr.entidades.PessoaDocumento;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOPessoaDocumento extends DAO_MYSQL implements IntfDAOPessoaDocumento {

	private static DAOPessoaDocumento aDAOPessoaDocumento = new DAOPessoaDocumento();

	/**
	 * Cria um novo objeto DAOPessoaDocumento.
	 */
	private DAOPessoaDocumento() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOPessoaDocumento getInstancia() {
		if (DAOPessoaDocumento.aDAOPessoaDocumento == null) {
			DAOPessoaDocumento.aDAOPessoaDocumento = new DAOPessoaDocumento();
		}

		return DAOPessoaDocumento.aDAOPessoaDocumento;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOPessoaDocumento#incluir(sgbr.entidades.
	 * PessoaDocumento)
	 */
	@Override
	public void incluir(PessoaDocumento pPessoaDocumento) throws SQLException {

		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pPessoaDocumento.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));
		pPessoaDocumento.setDhAlteracaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "INSERT INTO mydb.pessoa_documento  ( " + PessoaDocumento.NM_COLUNA_TIPO_DOCUMENTO_CD + ","
				+ PessoaDocumento.NM_COLUNA_PESSOA_CD + "," + PessoaDocumento.NM_COLUNA_PESSOA_DOCUMENTO_NU + ","
				+ PessoaDocumento.NM_COLUNA_DH_INCLUSAO_REGISTRO + "," + PessoaDocumento.NM_COLUNA_DH_ALTERACAO_REGISTRO
				+ ") VALUES (?,?,?,?,?)";

		ppSt = conexao.prepareStatement(sql);

		ppSt.setInt(1, pPessoaDocumento.getTpDocumento());
		ppSt.setInt(2, pPessoaDocumento.getCdPessoa());
		ppSt.setString(3, pPessoaDocumento.getNuDocumento());
		ppSt.setTimestamp(4, pPessoaDocumento.getDhIncusaoRegistro());
		ppSt.setTimestamp(5, pPessoaDocumento.getDhAlteracaoRegistro());

		ppSt.execute();

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOPessoaDocumento#alterar(sgbr.entidades.
	 * PessoaDocumento)
	 */
	@Override
	public void alterar(PessoaDocumento pPessoaDocumento) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOPessoaDocumento#excluir(sgbr.entidades.
	 * PessoaDocumento)
	 */
	@Override
	public void excluir(PessoaDocumento pPessoaDocumento) throws SQLException {

		String sqlConector = "";
		Connection conexao = null;

		conexao = this.getConection();

		String sql = "DELETE FROM mydb.pessoa_documento where PESSOA_CD = " + pPessoaDocumento.getCdPessoa()
				+ " and TIPO_DOCUMENTO_CD = " + pPessoaDocumento.getTpDocumento();

		Statement stm = conexao.createStatement();

		stm.execute(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOPessoaDocumento#consultarPorChavePrimaria(sgbr.
	 * entidades.PessoaDocumento)
	 */
	@Override
	public PessoaDocumento consultarPorChavePrimaria(PessoaDocumento pPessoaDocumento) throws SQLException {

		Connection conexao = null;

		PessoaDocumento pessoaDocumento = null;

		conexao = this.getConection();

		String sql = "SELECT * FROM mydb.pessoa_documento WHERE PESSOA_CD =  " + pPessoaDocumento.getCdPessoa()
				+ " AND TIPO_DOCUMENTO_CD = " + pPessoaDocumento.getTpDocumento();

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			pessoaDocumento = new PessoaDocumento();

			pessoaDocumento.setCdPessoa(rs.getInt(PessoaDocumento.NM_COLUNA_PESSOA_CD));
			pessoaDocumento.setNuDocumento(rs.getString(PessoaDocumento.NM_COLUNA_PESSOA_DOCUMENTO_NU));
			pessoaDocumento.setTpDocumento(rs.getInt(PessoaDocumento.NM_COLUNA_TIPO_DOCUMENTO_CD));
			pessoaDocumento.setDhAlteracaoRegistro(rs.getTimestamp(PessoaDocumento.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			pessoaDocumento.setDhIncusaoRegistro(rs.getTimestamp(PessoaDocumento.NM_COLUNA_DH_INCLUSAO_REGISTRO));

		}

		rs.close();
		stm.close();
		conexao.close();
		return pessoaDocumento;

	}

	public PessoaDocumento consultarPesssoaDocumento(PessoaDocumento pPessoaDocumento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
