/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeGenerica;

/**
 * Table: pessoa_telefone Columns: PESSOA_CD int(11) PK TIPO_TELEFONE_CD int(11)
 * PK PESSOA_TELEFONE_DDD varchar(3) PESSOA_TELEFONE_NU_TEL varchar(10)
 * DT_INCLUSAO timestamp(6) DT_ALTERACAO timestamp(6)
 * 
 * @author Reinaldo
 *
 */
public class PessoaTelefone extends EntidadeGenerica {

	public static final String NM_COLUNA_PESSOA_CD = "PESSOA_CD";
	public static final String NM_COLUNA_TIPO_TELEFONE_CD = "TIPO_TELEFONE_CD";
	public static final String NM_COLUNA_PESSOA_TELEFONE_DDD = "PESSOA_TELEFONE_DDD";
	public static final String NM_COLUNA_PESSOA_TELEFONE_NU_TEL = "PESSOA_TELEFONE_NU_TEL";

	private Integer cdPessoa;
	private Integer tpTelefone;
	private String nuDDDTelefone;
	private String nuTelefone;

	
	public PessoaTelefone (){
		
	}
	
	public PessoaTelefone (Integer pCdPessoa, Integer pTpTelefone){
		this.cdPessoa = pCdPessoa;
		this.tpTelefone = pTpTelefone;
	}
	
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
	 * @return the nuDDDTelefone
	 */
	public String getNuDDDTelefone() {
		return nuDDDTelefone;
	}

	/**
	 * @param pNuDDDTelefone
	 *            the nuDDDTelefone to set
	 */
	public void setNuDDDTelefone(String pNuDDDTelefone) {
		this.nuDDDTelefone = pNuDDDTelefone;
	}

	/**
	 * @return the nuTelefone
	 */
	public String getNuTelefone() {
		return nuTelefone;
	}

	/**
	 * @param pNuTelefone
	 *            the nuTelefone to set
	 */
	public void setNuTelefone(String pNuTelefone) {
		this.nuTelefone = pNuTelefone;
	}
}
