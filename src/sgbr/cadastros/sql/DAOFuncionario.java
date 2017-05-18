/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.SQLException;

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
		// TODO Auto-generated method stub
		return null;
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
