package sgbr.entidades;

import java.sql.Date;

import sgbr.util.EntidadeGenerica;

/**
 * Table: pessoa Columns: PESSOA_CD int(11) AI PK PESSOA_NM varchar(45)
 * PESSOA_EE varchar(45) PESSOA_DT_NASC date PESSOA_ENDERECO_BAIRRO_NM
 * varchar(45) PESSOA_ENDERECO_LOGRADOURO_NM varchar(45)
 * PESSOA_ENDERECO_LOGRADOURO_NU varchar(45) PESSOA_ENDERECO_CIDADE varchar(20)
 * PESSOA_ENDERECO_UF varchar(2) DT_INCLUSAO date DT_ALTERACAO date
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
	public static final String NM_COLUNA_PESSOA_ENDERECO_BAIRRO_NM = "PESSOA_ENDERECO_BAIRRO_NM";
	public static final String NM_COLUNA_PESSOA_ENDERECO_LOGRADOURO_NM = "PESSOA_ENDERECO_LOGRADOURO_NM";
	public static final String NM_COLUNA_PESSOA_ENDERECO_LOGRADOURO_NU = "PESSOA_ENDERECO_LOGRADOURO_NU";
	public static final String NM_COLUNA_PESSOA_ENDERECO_CIDADE = "PESSOA_ENDERECO_CIDADE";
	public static final String NM_COLUNA_PESSOA_ENDERECO_UF = "PESSOA_ENDERECO_UF";

	private int cdPessoa;
	private String nmPessoa;
	private String eePessoa;
	private Date dtNascPessoa;
	private String nmLogradouro;
	private String nuLogradouro;
	private String nmBairro;
	private String nmCidade;
	private String nmUF;

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

	/**
	 * @return the nmLogradouro
	 */
	public String getNmLogradouro() {
		return nmLogradouro;
	}

	/**
	 * @param pNmLogradouro
	 *            the nmLogradouro to set
	 */
	public void setNmLogradouro(String pNmLogradouro) {
		this.nmLogradouro = pNmLogradouro;
	}

	/**
	 * @return the nuLogradouro
	 */
	public String getNuLogradouro() {
		return nuLogradouro;
	}

	/**
	 * @param pNuLogradouro
	 *            the nuLogradouro to set
	 */
	public void setNuLogradouro(String pNuLogradouro) {
		this.nuLogradouro = pNuLogradouro;
	}

	/**
	 * @return the nmBairro
	 */
	public String getNmBairro() {
		return nmBairro;
	}

	/**
	 * @param pNmBairro
	 *            the nmBairro to set
	 */
	public void setNmBairro(String pNmBairro) {
		this.nmBairro = pNmBairro;
	}

	/**
	 * @return the nmCidade
	 */
	public String getNmCidade() {
		return nmCidade;
	}

	/**
	 * @param pNmCidade
	 *            the nmCidade to set
	 */
	public void setNmCidade(String pNmCidade) {
		this.nmCidade = pNmCidade;
	}

	/**
	 * @return the nmUF
	 */
	public String getNmUF() {
		return nmUF;
	}

	/**
	 * @param pNmUF
	 *            the nmUF to set
	 */
	public void setNmUF(String pNmUF) {
		this.nmUF = pNmUF;
	}

}
