/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.SQLException;
import java.util.Collection;

import sgbr.cadastros.IntfDAOConta;
import sgbr.entidades.Conta;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOConta extends DAO_MYSQL implements IntfDAOConta {


	private static DAOConta aDAOConta = new DAOConta();

	/**
	 * Cria um novo objeto DAOConta.
	 */
	private DAOConta() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOConta getInstancia() {
		if (DAOConta.aDAOConta == null) {
			DAOConta.aDAOConta = new DAOConta();
		}

		return DAOConta.aDAOConta;
	}

	
	
	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOConta#incluir(sgbr.entidades.Conta)
	 */
	@Override
	public void incluir(Conta pConta) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOConta#alterar(sgbr.entidades.Conta)
	 */
	@Override
	public void alterar(Conta pConta) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOConta#excluir(sgbr.entidades.Conta)
	 */
	@Override
	public void excluir(Conta pConta) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOConta#consultaTodosRegistros(boolean)
	 */
	@Override
	public Collection<Conta> consultaTodosRegistros(boolean pInRetornarApenasVigentes) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOConta#consultaPorChavePrimaria(sgbr.entidades.Conta)
	 */
	@Override
	public Conta consultaPorChavePrimaria(Conta pConta) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
