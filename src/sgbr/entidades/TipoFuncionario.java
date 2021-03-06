/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeTipoGenerica;

/**
 * Table: tipo_funcionario Columns: TIPO_FUNCIONARIO_CD Integer(11) PK
 * TIPO_FUNCIONARIO_DS varchar(45)
 * 
 * @author Reinaldo
 *
 */
public class TipoFuncionario extends EntidadeTipoGenerica {

	public static final String NM_COLUNA_TIPO_FUNCIONARIO_CD = "TIPO_FUNCIONARIO_CD";
	public static final String NM_COLUNA_TIPO_FUNCIONARIO_DS = "TIPO_FUNCIONARIO_DS";

	private Integer cdTpFuncionario;
	private String dsTpFuncionario;

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

}
