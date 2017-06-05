/**
 * 
 */
package sgbr.controlador;

/**
 * @author Reinaldo
 *
 */
public class ControladorPessoaDocumento {

	private static ControladorPessoaDocumento aControladorPessoaDocumento = new ControladorPessoaDocumento();

	/**
	 * Cria um novo objeto ControladorPessoaDocumento.
	 */
	private ControladorPessoaDocumento() {
		super();
	}

	/**
	 * - pega instancia do controlador, padrao singleton
	 *
	 * @return
	 */
	public static ControladorPessoaDocumento getInstancia() {
		if (ControladorPessoaDocumento.aControladorPessoaDocumento == null) {
			ControladorPessoaDocumento.aControladorPessoaDocumento = new ControladorPessoaDocumento();
		}

		return ControladorPessoaDocumento.aControladorPessoaDocumento;
	}
//	
//	public PessoaDocumento consultarPorChavePrimaria(PessoaDocumento pPessoaDocumento) throws SQLException {
//		return DAOPessoaDocumento.getInstancia().consultarPorChavePrimaria(pPessoaDocumento);
//	}
}
