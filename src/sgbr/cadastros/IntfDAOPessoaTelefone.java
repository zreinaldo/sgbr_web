/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;

import sgbr.entidades.PessoaTelefone;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOPessoaTelefone {
	/**
	 * @param pPessoaTelefone
	 * 
	 */
	public void incluir(PessoaTelefone pPessoaTelefone) throws SQLException;

	/**
	 * @param pPessoaTelefone
	 */
	public void alterar(PessoaTelefone pPessoaTelefone) throws SQLException;

	/**
	 * @param pPessoaTelefone
	 */
	public void excluir(PessoaTelefone pPessoaTelefone) throws SQLException;

	/**
	 * @param pPessoaTelefone
	 * @return
	 */
	public PessoaTelefone consultarPorChavePrimaria(PessoaTelefone pPessoaTelefone) throws SQLException;
}
