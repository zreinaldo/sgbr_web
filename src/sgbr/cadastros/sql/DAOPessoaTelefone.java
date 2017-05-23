/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.SQLException;

import sgbr.cadastros.IntfDAOPessoaTelefone;
import sgbr.entidades.PessoaTelefone;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOPessoaTelefone extends DAO_MYSQL implements IntfDAOPessoaTelefone{

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOPessoaTelefone#incluir(sgbr.entidades.PessoaTelefone)
	 */
	@Override
	public void incluir(PessoaTelefone pPessoaTelefone) throws SQLException {
		// TODO Auto-generated method stub
		
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
