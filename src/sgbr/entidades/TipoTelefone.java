/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeTipoGenerica;

/**
 * Table: tipo_telefone Columns: TIPO_TELEFONE_CD int(11) PK TIPO_TELEFONE_DS
 * varchar(45) DH_INCLUSAO timestamp(6) DH_ALTERACAO timestamp(6)
 * DT_FIM_VIGENCIAl date
 * 
 * @author Reinaldo
 *
 */
public class TipoTelefone extends EntidadeTipoGenerica {

	public static final String NM_COLUNA_TIPO_FUNCIONARIO_CD = "TIPO_TELEFONE_CD";
	public static final String NM_COLUNA_TIPO_TELEFONE_DS = "TIPO_TELEFONE_DS";

	private int tpTelefone;
	private String dsTelefone;

	/**
	 * @return the tpTelefone
	 */
	public int getTpTelefone() {
		return tpTelefone;
	}

	/**
	 * @param pTpTelefone
	 *            the tpTelefone to set
	 */
	public void setTpTelefone(int pTpTelefone) {
		this.tpTelefone = pTpTelefone;
	}

	/**
	 * @return the dsTelefone
	 */
	public String getDsTelefone() {
		return dsTelefone;
	}

	/**
	 * @param pDsTelefone
	 *            the dsTelefone to set
	 */
	public void setDsTelefone(String pDsTelefone) {
		this.dsTelefone = pDsTelefone;
	}

}
