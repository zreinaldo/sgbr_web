/**
 * 
 */
package sgbr.util;

import java.sql.Timestamp;

/**
 * atributos comuns as classes persistentes
 * 
 * @author Reinaldo
 *
 */
public class EntidadeGenerica {

	
	public static final String NM_COLUNA_DH_INCLUSAO_REGISTRO = "DH_INCLUSAO";
	public static final String NM_COLUNA_DH_ALTERACAO_REGISTRO = "DH_ALTERACAO";
	
	private Timestamp dhIncusaoRegistro;
	private Timestamp dhAlteracaoRegistro;

	/**
	 * @return the dhIncusaoRegistro
	 */
	public Timestamp getDhIncusaoRegistro() {
		return dhIncusaoRegistro;
	}

	/**
	 * @param pDhIncusaoRegistro
	 *            the dhIncusaoRegistro to set
	 */
	public void setDhIncusaoRegistro(Timestamp pDhIncusaoRegistro) {
		this.dhIncusaoRegistro = pDhIncusaoRegistro;
	}

	/**
	 * @return the dhAlteracaoRegistro
	 */
	public Timestamp getDhAlteracaoRegistro() {
		return dhAlteracaoRegistro;
	}

	/**
	 * @param pDhAlteracaoRegistro
	 *            the dhAlteracaoRegistro to set
	 */
	public void setDhAlteracaoRegistro(Timestamp pDhAlteracaoRegistro) {
		this.dhAlteracaoRegistro = pDhAlteracaoRegistro;
	}

}
