/**
 * 
 */
package sgbr.util;

import java.sql.Date;

/**
 * @author Reinaldo
 *
 */
public class OTDComanda {

	private Integer cdComanda;
	private Date dtIniVigencia;
	private Date dtFimVigencia;

	/**
	 * @return the cdComanda
	 */
	public Integer getCdComanda() {
		return this.cdComanda;
	}

	/**
	 * @param pCdComanda
	 *            the cdComanda to set
	 */
	public void setCdComanda(Integer pCdComanda) {
		this.cdComanda = pCdComanda;
	}

	/**
	 * @return the dtIniVigencia
	 */
	public Date getDtIniVigencia() {
		return this.dtIniVigencia;
	}

	/**
	 * @param pDtIniVigencia
	 *            the dtIniVigencia to set
	 */
	public void setDtIniVigencia(Date pDtIniVigencia) {
		this.dtIniVigencia = pDtIniVigencia;
	}

	/**
	 * @return the dtFimVigencia
	 */
	public Date getDtFimVigencia() {
		return this.dtFimVigencia;
	}

	/**
	 * @param pDtFimVigencia
	 *            the dtFimVigencia to set
	 */
	public void setDtFimVigencia(Date pDtFimVigencia) {
		this.dtFimVigencia = pDtFimVigencia;
	}
}
