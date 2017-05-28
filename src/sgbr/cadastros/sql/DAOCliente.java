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

import sgbr.cadastros.IntfDAOCliente;
import sgbr.entidades.Cliente;
import sgbr.entidades.PessoaDocumento;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOCliente extends DAO_MYSQL implements IntfDAOCliente {

	private static DAOCliente aDAOCliente = new DAOCliente();

	/**
	 * Cria um novo objeto DAOCliente.
	 */
	private DAOCliente() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOCliente getInstancia() {
		if (DAOCliente.aDAOCliente == null) {
			DAOCliente.aDAOCliente = new DAOCliente();
		}

		return DAOCliente.aDAOCliente;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOCliente#incluir(sgbr.entidades.Cliente)
	 */
	@Override
	public Cliente incluir(Cliente pCliente) throws SQLException {

		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pCliente.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "INSERT into mydb.cliente (PESSOA_CD,DH_INCLUSAO) values (?,?);";

		ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		;

		ppSt.setInt(2, pCliente.getCdPessoa());
		ppSt.setTimestamp(4, pCliente.getDhIncusaoRegistro());

		ppSt.execute();

		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pCliente.setCdCliente(rs.getInt(1));
		}

		ppSt.close();
		conexao.close();

		return pCliente;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOCliente#alterar(sgbr.entidades.Cliente)
	 */
	@Override
	public void alterar(Cliente pCliente) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOCliente#excluir(sgbr.entidades.Cliente)
	 */
	@Override
	public void excluir(Cliente pCliente) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOCliente#consultarPorChavePrimaria(sgbr.entidades.
	 * Cliente)
	 */
	@Override
	public Cliente consultarPorChavePrimaria(Cliente pCliente) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
