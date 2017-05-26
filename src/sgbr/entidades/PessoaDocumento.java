/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeGenerica;

/**
 * 
 * Table: pessoa_documento Columns: TIPO_DOCUMENTO_CD Integer(11) PK PESSOA_CD
 * Integer(11) PK PESSOA_DOCUMENTO_NU varchar(45) DH_INCLUSAO timestamp(6)
 * DH_ALTERACAO timestamp(6)
 * 
 * @author Reinaldo
 *
 */
public class PessoaDocumento extends EntidadeGenerica {

	public static final String NM_COLUNA_PESSOA_CD = "PESSOA_CD";
	public static final String NM_COLUNA_TIPO_DOCUMENTO_CD = "TIPO_DOCUMENTO_CD";
	public static final String NM_COLUNA_PESSOA_DOCUMENTO_NU = "PESSOA_DOCUMENTO_NU";

	private Integer cdPessoa;
	private Integer tpDocumento;
	private String nuDocumento;

	public PessoaDocumento (Integer pCdPessoa, Integer pTpDocumento) {
		this.cdPessoa = pCdPessoa;
		this.tpDocumento = pTpDocumento;
	}
	
	/**
	 * 
	 */
	public PessoaDocumento(){
		
	}
	/**
	 * @return the cdPessoa
	 */
	public Integer getCdPessoa() {
		return cdPessoa;
	}

	/**
	 * @param pCdPessoa
	 *            the cdPessoa to set
	 */
	public void setCdPessoa(Integer pCdPessoa) {
		this.cdPessoa = pCdPessoa;
	}

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
