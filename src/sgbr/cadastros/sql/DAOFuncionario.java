package sgbr.cadastros.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import sgbr.cadastros.IntfDAOFuncionario;
import sgbr.entidades.Funcionario;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOFuncionario extends DAO_MYSQL implements IntfDAOFuncionario {

	private static DAOFuncionario aDAOFuncionario = new DAOFuncionario();

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOFuncionario getInstancia() {
		if (DAOFuncionario.aDAOFuncionario == null) {
			DAOFuncionario.aDAOFuncionario = new DAOFuncionario();
		}

		return DAOFuncionario.aDAOFuncionario;
	}

	/**
	 * Cria um novo objeto DAOFuncionario.
	 */
	private DAOFuncionario() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOFuncionario#incluir(sgbr.entidades.Funcionario)
	 */
	@Override
	public Funcionario incluir(Funcionario pFuncionario) throws SQLException {

		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pFuncionario.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));
		pFuncionario.setDhAlteracaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "INSERT INTO mydb.funcionario  ( " + Funcionario.NM_COLUNA_PESSOA_CD + ","
				+ Funcionario.NM_COLUNA_FUNCIONARIO_TP + "," + Funcionario.NM_COLUNA_FUNCIONARIO_BANCO_AGENCIA + ","
				+ Funcionario.NM_COLUNA_FUNCIONARIO_BANCO_CONTA + "," + Funcionario.NM_COLUNA_FUNCIONARIO_SALARIO + ","
				+ Funcionario.NM_COLUNA_FUNCIONARIO_DT_ADMISSAO + "," + Funcionario.NM_COLUNA_FUNCIONARIO_BANCO_NM + ","
				+ Funcionario.NM_COLUNA_DH_INCLUSAO_REGISTRO + "," + Funcionario.NM_COLUNA_DH_ALTERACAO_REGISTRO
				+ ") VALUES(?,?,?,?,?,?,?,?,?)";

		ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ppSt.setInt(1, pFuncionario.getCdPessoa());
		ppSt.setInt(2, pFuncionario.getTpFuncionario());
		ppSt.setString(3, pFuncionario.getNuBancoAgencia());
		ppSt.setString(4, pFuncionario.getNuBancoConta());
		ppSt.setDouble(5, pFuncionario.getVlSalario());
		ppSt.setDate(6, pFuncionario.getDtAdmissao());
		ppSt.setString(7, pFuncionario.getNmBanco());
		ppSt.setTimestamp(8, pFuncionario.getDhIncusaoRegistro());
		ppSt.setTimestamp(9, pFuncionario.getDhAlteracaoRegistro());

		ppSt.execute();

		// pega o ultimo sequencial gerado pelo banco na tabela
		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pFuncionario.setCdFuncionario(rs.getInt(1));
		}

		ppSt.close();
		conexao.close();

		return pFuncionario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOFuncionario#alterar(sgbr.entidades.Funcionario)
	 */
	@Override
	public void alterar(Funcionario pFuncionario) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOFuncionario#excluir(sgbr.entidades.Funcionario)
	 */
	@Override
	public void excluir(Funcionario pFuncionario) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOFuncionario#consultarPorChavePrimaria(sgbr.
	 * entidades.Funcionario)
	 */
	@Override
	public Funcionario consultarPorChavePrimaria(Funcionario pFuncionario) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
