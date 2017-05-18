/**
 * 
 */
package sgbr.entidades;

import java.sql.Date;
import java.sql.SQLException;

import sgbr.cadastros.sql.DAOFuncionario;
import sgbr.util.EntidadeGenerica;
import sgbr.util.OTDFuncionario;

/**
 * Table: funcionario Columns: FUNCIONARIO_CD int(11) AI PK PESSOA_CD int(11) PK
 * TIPO_FUNCIONARIO_CD int(11) FUNCIONARIO_BANCO_AGENCIA varchar(10)
 * FUNCIONARIO_BANCO_CONTA varchar(20) FUNCIONARIO_SALARIO double
 * FUNCIONARIO_DT_ADMISSAO date
 * 
 * @author Reinaldo
 *
 */
public class Funcionario extends Pessoa {

	/*
	 * constantes referentes aos atributos do banco
	 */
	public static final String NM_COLUNA_FUNCIONARIO_CD = "FUNCIONARIO_CD";
	public static final String NM_COLUNA_PESSOA_CD = "PESSOA_CD";
	public static final String NM_COLUNA_FUNCIONARIO_TP = "FUNCIONARIO_TP";
	public static final String NM_COLUNA_FUNCIONARIO_BANCO_AGENCIA = "FUNCIONARIO_BANCO_AGENCIA";
	public static final String NM_COLUNA_FUNCIONARIO_BANCO_CONTA = "FUNCIONARIO_BANCO_CONTA";
	public static final String NM_COLUNA_FUNCIONARIO_SALARIO = "FUNCIONARIO_SALARIO";
	public static final String NM_COLUNA_FUNCIONARIO_DT_ADMISSAO = "FUNCIONARIO_DT_ADMISSAO";

	private int cdFuncionario;
	private int cdPessoa;
	private int tpFuncionario;
	private String nuBancoAgencia;
	private String nuBancoConta;
	private Double vlSalario;
	private Date dtAdmissao;

	
	/**
	 * contrutor
	 */
	public Funcionario() {
		super();
	}

	
	/**
	 * @param pCdFuncionario
	 * @param pCdPessoa
	 */
	public Funcionario(int pCdFuncionario, int pCdPessoa) {
		super();
		cdFuncionario = pCdFuncionario;
		cdPessoa = pCdPessoa;
	}

	/**
	 * @return the cdFuncionario
	 */
	public int getCdFuncionario() {
		return cdFuncionario;
	}

	/**
	 * @param pCdFuncionario
	 *            the cdFuncionario to set
	 */
	public void setCdFuncionario(int pCdFuncionario) {
		cdFuncionario = pCdFuncionario;
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
	 * @return the tpFuncionario
	 */
	public int getTpFuncionario() {
		return tpFuncionario;
	}

	/**
	 * @param pTpFuncionario
	 *            the tpFuncionario to set
	 */
	public void setTpFuncionario(int pTpFuncionario) {
		tpFuncionario = pTpFuncionario;
	}

	/**
	 * @return the nuBancoAgencia
	 */
	public String getNuBancoAgencia() {
		return nuBancoAgencia;
	}

	/**
	 * @param pNuBancoAgencia
	 *            the nuBancoAgencia to set
	 */
	public void setNuBancoAgencia(String pNuBancoAgencia) {
		nuBancoAgencia = pNuBancoAgencia;
	}

	/**
	 * @return the nuBancoConta
	 */
	public String getNuBancoConta() {
		return nuBancoConta;
	}

	/**
	 * @param pNuBancoConta
	 *            the nuBancoConta to set
	 */
	public void setNuBancoConta(String pNuBancoConta) {
		nuBancoConta = pNuBancoConta;
	}

	/**
	 * @return the vlSalario
	 */
	public Double getVlSalario() {
		return vlSalario;
	}

	/**
	 * @param pVlSalario
	 *            the vlSalario to set
	 */
	public void setVlSalario(Double pVlSalario) {
		vlSalario = pVlSalario;
	}

	/**
	 * @return the dtAdmissao
	 */
	public Date getDtAdmissao() {
		return dtAdmissao;
	}

	/**
	 * @param pDtAdmissao
	 *            the dtAdmissao to set
	 */
	public void setDtAdmissao(Date pDtAdmissao) {
		dtAdmissao = pDtAdmissao;
	}
		
}
