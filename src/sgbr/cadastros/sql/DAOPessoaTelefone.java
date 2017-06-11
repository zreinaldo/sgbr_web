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

import sgbr.cadastros.IntfDAOPessoaTelefone;
import sgbr.entidades.PessoaDocumento;
import sgbr.entidades.PessoaTelefone;
import sgbr.entidades.Promocao;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOPessoaTelefone extends DAO_MYSQL implements IntfDAOPessoaTelefone {

	private static DAOPessoaTelefone aDAOPessoaTelefone = new DAOPessoaTelefone();

	/**
	 * Cria um novo objeto DAOPessoa.
	 */
	private DAOPessoaTelefone() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOPessoaTelefone getInstancia() {
		if (DAOPessoaTelefone.aDAOPessoaTelefone == null) {
			DAOPessoaTelefone.aDAOPessoaTelefone = new DAOPessoaTelefone();
		}

		return DAOPessoaTelefone.aDAOPessoaTelefone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOPessoaTelefone#incluir(sgbr.entidades.
	 * PessoaTelefone)
	 */
	@Override
	public void incluir(PessoaTelefone pPessoaTelefone) throws SQLException {
		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pPessoaTelefone.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "insert into  mydb.pessoa_telefone (PESSOA_CD,TIPO_TELEFONE_CD,PESSOA_TELEFONE_DDD,PESSOA_TELEFONE_NU_TEL,DH_INCLUSAO) values (?,?,?,?,?) ";

		ppSt = conexao.prepareStatement(sql);

		ppSt.setInt(1, pPessoaTelefone.getCdPessoa());
		ppSt.setInt(2, pPessoaTelefone.getTpTelefone());
		ppSt.setString(3, pPessoaTelefone.getNuDDDTelefone());
		ppSt.setString(4, pPessoaTelefone.getNuTelefone());
		ppSt.setTimestamp(5, pPessoaTelefone.getDhIncusaoRegistro());

		ppSt.execute();

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOPessoaTelefone#alterar(sgbr.entidades.
	 * PessoaTelefone)
	 */
	@Override
	public void alterar(PessoaTelefone pPessoaTelefone) throws SQLException {
		Connection conexao = null;

		conexao = this.getConection();
		pPessoaTelefone.setDhAlteracaoRegistro(new Timestamp(System.currentTimeMillis()));
		String sql = "UPDATE mydb.pessoa_telefone SET PESSOA_TELEFONE_DDD = ?, " + "PESSOA_TELEFONE_NU_TEL = ?, "
				+ "DH_ALTERACAO = ? ";

		sql = sql + " WHERE PESSOA_CD = ? " + " and TIPO_TELEFONE_CD=? ";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		ppSt.setString(1, pPessoaTelefone.getNuDDDTelefone());
		ppSt.setString(2, pPessoaTelefone.getNuTelefone());
		ppSt.setTimestamp(3, pPessoaTelefone.getDhAlteracaoRegistro());
		
		ppSt.setInt(4, pPessoaTelefone.getCdPessoa());
		ppSt.setInt(5, pPessoaTelefone.getTpTelefone());

		ppSt.execute();

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOPessoaTelefone#excluir(sgbr.entidades.
	 * PessoaTelefone)
	 */
	@Override
	public void excluir(PessoaTelefone pPessoaTelefone) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOPessoaTelefone#consultarPorChavePrimaria(sgbr.
	 * entidades.PessoaTelefone)
	 */
	@Override
	public PessoaTelefone consultarPorChavePrimaria(PessoaTelefone pPessoaTelefone) throws SQLException {
		Connection conexao = null;

		PessoaTelefone pessoaTelefone = null;

		conexao = this.getConection();

		String sql = "SELECT * FROM mydb.pessoa_telefone WHERE PESSOA_CD =  " + pPessoaTelefone.getCdPessoa()
				+ " AND TIPO_TELEFONE_CD = " + pPessoaTelefone.getTpTelefone();

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			pessoaTelefone = new PessoaTelefone();

			pessoaTelefone.setCdPessoa(rs.getInt(PessoaTelefone.NM_COLUNA_PESSOA_CD));
			pessoaTelefone.setNuTelefone(rs.getString(PessoaTelefone.NM_COLUNA_PESSOA_TELEFONE_NU_TEL));
			pessoaTelefone.setNuDDDTelefone(rs.getString(PessoaTelefone.NM_COLUNA_PESSOA_TELEFONE_DDD));			
			pessoaTelefone.setDhAlteracaoRegistro(rs.getTimestamp(PessoaTelefone.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			pessoaTelefone.setDhIncusaoRegistro(rs.getTimestamp(PessoaTelefone.NM_COLUNA_DH_INCLUSAO_REGISTRO));

		}

		rs.close();
		stm.close();
		conexao.close();
		return pessoaTelefone;
	}

}
