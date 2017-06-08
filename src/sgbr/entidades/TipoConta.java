/**
 * 
 */
package sgbr.entidades;

/**
 * Table: tipo_conta Columns: TIPO_CONTA_CD int(11) PK TIPO_CONTA_DS varchar(45)
 * 
 * @author Reinaldo
 *
 */
public class TipoConta {

	public static final String NM_COLUNA_TIPO_CONTA_CD = "TIPO_CONTA_CD";
	public static final String NM_COLUNA_TIPO_CONTA_DS = "TIPO_CONTA_DS";

	private Integer cdTipoConta;
	private String dsTipoConta;

	/**
	 * @return the dsTipoConta
	 */
	public String getDsTipoConta() {
		return this.dsTipoConta;
	}

	/**
	 * @param pDsTipoConta
	 *            the dsTipoConta to set
	 */
	public void setDsTipoConta(String pDsTipoConta) {
		this.dsTipoConta = pDsTipoConta;
	}

}
