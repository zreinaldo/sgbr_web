/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.SQLException;

import sgbr.cadastros.IntfDAOCliente;
import sgbr.entidades.Cliente;

/**
 * @author Reinaldo
 *
 */
public class DAOCliente implements IntfDAOCliente {

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOCliente#incluir(sgbr.entidades.Cliente)
	 */
	@Override
	public Cliente incluir(Cliente pCliente) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOCliente#alterar(sgbr.entidades.Cliente)
	 */
	@Override
	public void alterar(Cliente pCliente) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOCliente#excluir(sgbr.entidades.Cliente)
	 */
	@Override
	public void excluir(Cliente pCliente) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOCliente#consultarPorChavePrimaria(sgbr.entidades.Cliente)
	 */
	@Override
	public Cliente consultarPorChavePrimaria(Cliente pCliente) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
