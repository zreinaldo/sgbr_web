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

	private Integer tpFuncionario;
	private String dsFuncionario;

	/**
	 * @return the tpFuncionario
	 */
	public Integer getTpFuncionario() {
		return tpFuncionario;
	}

	/**
	 * @param pTpFuncionario
	 *            the tpFuncionario to set
	 */
	public void setTpFuncionario(Integer pTpFuncionario) {
		this.tpFuncionario = pTpFuncionario;
	}

	/**
	 * @return the dsFuncionario
	 */
	public String getDsFuncionario() {
		return dsFuncionario;
	}

	/**
	 * @param pDsFuncionario
	 *            the dsFuncionario to set
	 */
	public void setDsFuncionario(String pDsFuncionario) {
		this.dsFuncionario = pDsFuncionario;
	}

}
