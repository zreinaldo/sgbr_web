/**
 * 
 */
package sgbr.cadastros;

import java.sql.SQLException;

import sgbr.entidades.PessoaDocumento;

/**
 * @author Reinaldo
 *
 */
public interface IntfDAOPessoaDocumento {

	public void incluir(PessoaDocumento pPessoaDocumento) throws SQLException;

	public void alterar(PessoaDocumento pPessoaDocumento) throws SQLException;

	public void excluir(PessoaDocumento pPessoaDocumento) throws SQLException;

	public PessoaDocumento consultarPorChavePrimaria(PessoaDocumento pPessoaDocumento) throws SQLException;

}
