/**
 * 
 */
package sgbr.entidades;

import java.sql.Timestamp;

import sgbr.util.EntidadeGenerica;

/**
 * 
 * Table: conta Columns: CONTA_CD int(11) AI PK COMANDA_CD int(11) MESA_CD
 * int(11) CONTA_VL_FINAL double CLIENTE_CD int(11) CONTA_DESCONTO_VL double
 * CONTA_DESCONTO_PERC double DH_INCLUSAO timestamp(6) DH_ENCERRAMENTO
 * timestamp(6) TIPO_CONTA_CD int(11) CONTA_VL_ORIGINAL double FUNCIONARIO_CD
 * int(11)
 * 
 * @author Reinaldo
 *
 */
public class Conta extends EntidadeGenerica {

	public static final String NM_COLUNA_CONTA_CD = "CONTA_CD";
	public static final String NM_COLUNA_COMANDA_CD = "COMANDA_CD";
	public static final String NM_COLUNA_MESA_CD = "MESA_CD";
	public static final String NM_COLUNA_CONTA_VL_FINAL = "CONTA_VL_FINAL";
	public static final String NM_COLUNA_CLIENTE_CD = "CLIENTE_CD";
	public static final String NM_COLUNA_CONTA_DESCONTO_VL = "CONTA_DESCONTO_VL";
	public static final String NM_COLUNA_CONTA_DESCONTO_PERC = "CONTA_DESCONTO_PERC";
	public static final String NM_COLUNA_DH_ENCERRAMENTO = "DH_ENCERRAMENTO";
	public static final String NM_COLUNA_TIPO_CONTA_CD = "TIPO_CONTA_CD";
	public static final String NM_COLUNA_CONTA_VL_ORIGINAL = "CONTA_VL_ORIGINAL";
	public static final String NM_COLUNA_FUNCIONARIO_CD = "FUNCIONARIO_CD";
	

	private Integer cdConta;
	private Integer cdComanda;
	private Integer cdMesa;
	private Integer cdCliente;
	private Integer cdFuncionario;
	private Integer cdTipoConta;
	private Double vlContaFinal;
	private Double vlContaOriginal;
	private Double vlDescontoConta;
	private Double percDescontoConta;
	private Timestamp dhEncerramento;

	/**
	 * @return the cdConta
	 */
	public Integer getCdConta() {
		return this.cdConta;
	}

	/**
	 * @param pCdConta
	 *            the cdConta to set
	 */
	public void setCdConta(Integer pCdConta) {
		this.cdConta = pCdConta;
	}

	/**
	 * @return the cdComanda
	 */
	public Integer getCdComanda() {
		return this.cdComanda;
	}

	/**
	 * @param pCdComanda
	 *            the cdComanda to set
	 */
	public void setCdComanda(Integer pCdComanda) {
		this.cdComanda = pCdComanda;
	}

	/**
	 * @return the cdMesa
	 */
	public Integer getCdMesa() {
		return this.cdMesa;
	}

	/**
	 * @param pCdMesa
	 *            the cdMesa to set
	 */
	public void setCdMesa(Integer pCdMesa) {
		this.cdMesa = pCdMesa;
	}

	/**
	 * @return the cdCliente
	 */
	public Integer getCdCliente() {
		return this.cdCliente;
	}

	/**
	 * @param pCdCliente
	 *            the cdCliente to set
	 */
	public void setCdCliente(Integer pCdCliente) {
		this.cdCliente = pCdCliente;
	}

	/**
	 * @return the cdTipoConta
	 */
	public Integer getCdTipoConta() {
		return this.cdTipoConta;
	}

	/**
	 * @param pCdTipoConta
	 *            the cdTipoConta to set
	 */
	public void setCdTipoConta(Integer pCdTipoConta) {
		this.cdTipoConta = pCdTipoConta;
	}

	/**
	 * @return the vlContaFinal
	 */
	public Double getVlContaFinal() {
		return this.vlContaFinal;
	}

	/**
	 * @param pVlContaFinal
	 *            the vlContaFinal to set
	 */
	public void setVlContaFinal(Double pVlContaFinal) {
		this.vlContaFinal = pVlContaFinal;
	}

	/**
	 * @return the vlContaOriginal
	 */
	public Double getVlContaOriginal() {
		return this.vlContaOriginal;
	}

	/**
	 * @param pVlContaOriginal
	 *            the vlContaOriginal to set
	 */
	public void setVlContaOriginal(Double pVlContaOriginal) {
		this.vlContaOriginal = pVlContaOriginal;
	}

	/**
	 * @return the vlDescontoConta
	 */
	public Double getVlDescontoConta() {
		return this.vlDescontoConta;
	}

	/**
	 * @param pVlDescontoConta
	 *            the vlDescontoConta to set
	 */
	public void setVlDescontoConta(Double pVlDescontoConta) {
		this.vlDescontoConta = pVlDescontoConta;
	}

	/**
	 * @return the percDescontoConta
	 */
	public Double getPercDescontoConta() {
		return this.percDescontoConta;
	}

	/**
	 * @param pPercDescontoConta
	 *            the percDescontoConta to set
	 */
	public void setPercDescontoConta(Double pPercDescontoConta) {
		this.percDescontoConta = pPercDescontoConta;
	}

	/**
	 * @return the dhEncerramento
	 */
	public Timestamp getDhEncerramento() {
		return this.dhEncerramento;
	}

	/**
	 * @param pDhEncerramento
	 *            the dhEncerramento to set
	 */
	public void setDhEncerramento(Timestamp pDhEncerramento) {
		this.dhEncerramento = pDhEncerramento;
	}

	/**
	 * @return the cdFuncionario
	 */
	public Integer getCdFuncionario() {
		return this.cdFuncionario;
	}

	/**
	 * @param pCdFuncionario the cdFuncionario to set
	 */
	public void setCdFuncionario(Integer pCdFuncionario) {
		this.cdFuncionario = pCdFuncionario;
	}

}