/**
 * 
 */
package sgbr.entidades;

/**
 * 
 * classe interna de controle, não possui crud
 * Table: dia_semana Columns: DIA_SEMANA_CD int(11) PK DIA_SEMANA_DS varchar(20)
 * 
 * @author Reinaldo
 *
 */
public class DiaSemana {

	public static final String NM_COLUNA_DIA_SEMANA_CD = "DIA_SEMANA_CD";
	public static final String NM_COLUNA_DIA_SEMANA_DS = "DIA_SEMANA_DS";

	private Integer cdDiaSemana;
	private String dsDiaSemana;

	/**
	 * @return the cdDiaSemana
	 */
	public Integer getCdDiaSemana() {
		return this.cdDiaSemana;
	}

	/**
	 * @param pCdDiaSemana
	 *            the cdDiaSemana to set
	 */
	public void setCdDiaSemana(Integer pCdDiaSemana) {
		this.cdDiaSemana = pCdDiaSemana;
	}

	/**
	 * @return the dsDiaSemana
	 */
	public String getDsDiaSemana() {
		return this.dsDiaSemana;
	}

	/**
	 * @param pDsDiaSemana
	 *            the dsDiaSemana to set
	 */
	public void setDsDiaSemana(String pDsDiaSemana) {
		this.dsDiaSemana = pDsDiaSemana;
	}

}
