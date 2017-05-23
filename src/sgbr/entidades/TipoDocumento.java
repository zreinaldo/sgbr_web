/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeTipoGenerica;

/**
 * Table: tipo_documento Columns: TIPO_DOCUMENTO_CD Integer(11) AI PK
 * TIPO_DOCUMENTO_DS varchar(45) DH_INCLUSAO timestamp(6) DH_ALTERACAO
 * timestamp(6) DT_FIM_VIGENCIA date
 * 
 * @author Reinaldo
 *
 */
public class TipoDocumento extends EntidadeTipoGenerica {

	public static final String NM_COLUNA_TIPO_DOCUMENTO_CD = "TIPO_DOCUMENTO_CD";
	public static final String NM_COLUNA_TIPO_DOCUMENTO_DS = "TIPO_DOCUMENTO_DS";

	private Integer tpDocumento;
	private String dsDocumento;

	/**
	 * @return the tpDocumento
	 */
	public Integer getTpDocumento() {
		return tpDocumento;
	}

	/**
	 * @param pTpDocumento
	 *            the tpDocumento to set
	 */
	public void setTpDocumento(Integer pTpDocumento) {
		this.tpDocumento = pTpDocumento;
	}

	/**
	 * @return the dsDocumento
	 */
	public String getDsDocumento() {
		return dsDocumento;
	}

	/**
	 * @param pDsDocumento
	 *            the dsDocumento to set
	 */
	public void setDsDocumento(String pDsDocumento) {
		this.dsDocumento = pDsDocumento;
	}

}
