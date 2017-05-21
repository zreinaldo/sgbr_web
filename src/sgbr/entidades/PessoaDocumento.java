/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeGenerica;

/**
 * 
 * Table: pessoa_documento Columns: TIPO_DOCUMENTO_CD int(11) PK PESSOA_CD
 * int(11) PK PESSOA_DOCUMENTO_NU varchar(45) DH_INCLUSAO timestamp(6)
 * DH_ALTERACAO timestamp(6)
 * 
 * @author Reinaldo
 *
 */
public class PessoaDocumento extends EntidadeGenerica {

	public static final String NM_COLUNA_PESSOA_CD = "PESSOA_CD";
	public static final String NM_COLUNA_TIPO_DOCUMENTO_CD = "TIPO_DOCUMENTO_CD";
	public static final String NM_COLUNA_PESSOA_DOCUMENTO_NU = "PESSOA_DOCUMENTO_NU";

	private int cdPessoa;
	private int tpDocumento;
	private String nuDocumento;

	/**
	 * @return the cdPessoa
	 */
	public int getCdPessoa() {
		return cdPessoa;
	}

	/**
	 * @param pCdPessoa
	 *            the cdPessoa to set
	 */
	public void setCdPessoa(int pCdPessoa) {
		this.cdPessoa = pCdPessoa;
	}

	/**
	 * @return the tpDocumento
	 */
	public int getTpDocumento() {
		return tpDocumento;
	}

	/**
	 * @param pTpDocumento
	 *            the tpDocumento to set
	 */
	public void setTpDocumento(int pTpDocumento) {
		this.tpDocumento = pTpDocumento;
	}

	/**
	 * @return the nuDocumento
	 */
	public String getNuDocumento() {
		return nuDocumento;
	}

	/**
	 * @param pNuDocumento
	 *            the nuDocumento to set
	 */
	public void setNuDocumento(String pNuDocumento) {
		this.nuDocumento = pNuDocumento;
	}
}
