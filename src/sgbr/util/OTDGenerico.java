/**
 * 
 */
package sgbr.util;

import java.sql.Timestamp;

/**
 * @author Reinaldo
 *
 */
public abstract class OTDGenerico {
	

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
