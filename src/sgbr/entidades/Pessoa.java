package sgbr.entidades;

import java.sql.Date;

import sgbr.util.EntidadeGenerica;

/**
 * Table: pessoa Columns: PESSOA_CD int(11) AI PK PESSOA_NM varchar(45)
 * PESSOA_EE varchar(45) PESSOA_DT_NASC varchar(45)
 * 
 * @author Reinaldo
 *
 */
public class Pessoa extends EntidadeGenerica {

	/*
	 * constantes referentes aos atributos do banco
	 */
	public static final String NM_COLUNA_PESSOA_CD = "PESSOA_CD";
	public static final String NM_COLUNA_PESSOA_NM = "PESSOA_NM";
	public static final String NM_COLUNA_PESSOA_EE = "PESSOA_EE";
	public static final String NM_COLUNA_PESSOA_DT_NASC = "PESSOA_DT_NASC";

	private int cdPessoa;
	private String nmPessoa;
	private String eePessoa;
	private Date dtNascPessoa;

	/**
	 * @param pCdPessoa
	 */
	public Pessoa(int pCdPessoa) {
		super();
		cdPessoa = pCdPessoa;
	}

	/**
	 * @param pCdPessoa
	 */
	public Pessoa() {
		super();

	}

	/**
	 * @return the nmPessoa
	 */
	public String getNmPessoa() {
		return nmPessoa;
	}

	/**
	 * @param pNmPessoa
	 *            the nmPessoa to set
	 */
	public void setNmPessoa(String pNmPessoa) {
		nmPessoa = pNmPessoa;
	}

	/**
	 * @return the eePessoa
	 */
	public String getEePessoa() {
		return eePessoa;
	}

	/**
	 * @param pEePessoa
	 *            the eePessoa to set
	 */
	public void setEePessoa(String pEePessoa) {
		eePessoa = pEePessoa;
	}

	/**
	 * @return the dtNascPessoa
	 */
	public Date getDtNascPessoa() {
		return dtNascPessoa;
	}

	/**
	 * @param pDtNascPessoa
	 *            the dtNascPessoa to set
	 */
	public void setDtNascPessoa(Date pDtNascPessoa) {
		dtNascPessoa = pDtNascPessoa;
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
		cdPessoa = pCdPessoa;
	}

}
