/**
 * 
 */
package sgbr.util;

import java.sql.Date;

/**
 * @author Reinaldo
 *
 */
public class OTDTipoFuncionario {

	private Integer cdTpFuncionario;
	private String dsTpFuncionario;
	private Date dtFimVigencia;

	/**
	 * @return the cdTpFuncionario
	 */
	public Integer getCdTpFuncionario() {
		return cdTpFuncionario;
	}

	/**
	 * @param pCdTpFuncionario
	 *            the cdTpFuncionario to set
	 */
	public void setCdTpFuncionario(Integer pCdTpFuncionario) {
		this.cdTpFuncionario = pCdTpFuncionario;
	}

	/**
	 * @return the dsTpFuncionario
	 */
	public String getDsTpFuncionario() {
		return dsTpFuncionario;
	}

	/**
	 * @param pDsTpFuncionario
	 *            the dsTpFuncionario to set
	 */
	public void setDsTpFuncionario(String pDsTpFuncionario) {
		this.dsTpFuncionario = pDsTpFuncionario;
	}
	
	
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
