/**
 * 
 */
package sgbr.entidades;

import java.sql.Date;

import sgbr.util.EntidadeGenerica;

/**
 * Table: comanda Columns: COMANDA_CD int(11) AI PK COMANDA_DT_INI_VALIDADE date
 * COMANDA_DT_FIM_VALIDADE date
 * 
 * @author Reinaldo
 *
 */
public class Comanda extends EntidadeGenerica {

	public static final String NM_COLUNA_COMANDA_CD = "COMANDA_CD";
	public static final String NM_COLUNA_COMANDA_DT_INI_VALIDADE = "COMANDA_DT_INI_VALIDADE";
	public static final String NM_COLUNA_COMANDA_DT_FIM_VALIDADE = "COMANDA_DT_FIM_VALIDADE";

	private Integer cdComanda;
	private Date dtIniValidade;
	private Date dtFimValidade;

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
	 * @return the dtIniValidade
	 */
	public Date getDtIniValidade() {
		return this.dtIniValidade;
	}

	/**
	 * @param pDtIniValidade
	 *            the dtIniValidade to set
	 */
	public void setDtIniValidade(Date pDtIniValidade) {
		this.dtIniValidade = pDtIniValidade;
	}

	/**
	 * @return the dtFimValidade
	 */
	public Date getDtFimValidade() {
		return this.dtFimValidade;
	}

	/**
	 * @param pDtFimValidade
	 *            the dtFimValidade to set
	 */
	public void setDtFimValidade(Date pDtFimValidade) {
		this.dtFimValidade = pDtFimValidade;
	}

}
