/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import sgbr.cadastros.IntfDAOPessoaTelefone;
import sgbr.entidades.PessoaTelefone;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOPessoaTelefone extends DAO_MYSQL implements IntfDAOPessoaTelefone{
	
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

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOPessoaTelefone#incluir(sgbr.entidades.PessoaTelefone)
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

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOPessoaTelefone#alterar(sgbr.entidades.PessoaTelefone)
	 */
	@Override
	public void alterar(PessoaTelefone pPessoaTelefone) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOPessoaTelefone#excluir(sgbr.entidades.PessoaTelefone)
	 */
	@Override
	public void excluir(PessoaTelefone pPessoaTelefone) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOPessoaTelefone#consultarPorChavePrimaria(sgbr.entidades.PessoaTelefone)
	 */
	@Override
	public PessoaTelefone consultarPorChavePrimaria(PessoaTelefone pPessoaTelefone) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
