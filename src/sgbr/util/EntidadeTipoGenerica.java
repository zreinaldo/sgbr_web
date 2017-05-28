/**
 * 
 */
package sgbr.util;

import java.sql.Date;

/**
 * @author Reinaldo
 *
 */
public class EntidadeTipoGenerica extends EntidadeGenerica {

	public static final String NM_COLUNA_DT_FIM_VIGENCIA = "DT_FIM_VIGENCIA";

	private Date dtFimVigencia;

	/**
	 * @return the dtFimVigencia
	 */
	public Date getDtFimVigencia() {
		return dtFimVigencia;
	}

	/**
	 * @param pDtFimVigencia
	 *            the dtFImVigencia to set
	 */
	public void setDtFimVigencia(Date pDtFimVigencia) {
		this.dtFimVigencia = pDtFimVigencia;
	}

}
