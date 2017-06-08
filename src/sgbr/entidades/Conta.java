/**
 * 
 */
package sgbr.entidades;

import java.sql.Date;

import sgbr.util.EntidadeGenerica;

/**
 * 
 * Table: conta Columns: CONTA_CD int(11) AI PK COMANDA_CD int(11) MESA_CD
 * int(11) CONTA_VL_TOTAL double CLIENTE_CD int(11) CONTA_DESCONTO_VL double
 * CONTA_DESCONTO_PERC double DH_INCLUSAO timestamp(6) DH_ENCERRAMENTO 
 * timestamp(6) TIPO_CONTA_CD int(11)
 * 
 * @author Reinaldo
 *
 */
public class Conta extends EntidadeGenerica {

	public static final String NM_COLUNA_CONTA_CD = "CONTA_CD";
	public static final String NM_COLUNA_COMANDA_CD = "COMANDA_CD";
	public static final String NM_COLUNA_MESA_CD = "MESA_CD";
	public static final String NM_COLUNA_CONTA_VL_TOTAL = "CONTA_VL_TOTAL";
	public static final String NM_COLUNA_CLIENTE_CD = "CLIENTE_CD";
	public static final String NM_COLUNA_CONTA_DESCONTO_VL = "CONTA_DESCONTO_VL";
	public static final String NM_COLUNA_CONTA_DESCONTO_PERC = "CONTA_DESCONTO_PERC";
	public static final String NM_COLUNA_DH_ENCERRAMENTO = "DH_ENCERRAMENTO";
	public static final String NM_COLUNA_TIPO_CONTA_CD = "TIPO_CONTA_CD";

	private Integer cdConta;
	private Integer cdComanda;
	private Integer cdMesa;
	private Integer cdCliente;
	private Integer cdTipoConta;
	private double vlTotal;
	private double vlDesconto;
	private double percDesconto;
	private Date dhEncerramento;
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
	 * @return the dhEncerramento
	 */
	public Date getDhEncerramento() {
		return this.dhEncerramento;
	}

	/**
	 * @param pDhEncerramento
	 *            the dhEncerramento to set
	 */
	public void setDhEncerramento(Date pDhEncerramento) {
		this.dhEncerramento = pDhEncerramento;
	}

	/**
	 * @return the vlTotal
	 */
	public double getVlTotal() {
		return this.vlTotal;
	}

	/**
	 * @param pVlTotal the vlTotal to set
	 */
	public void setVlTotal(double pVlTotal) {
		this.vlTotal = pVlTotal;
	}

	/**
	 * @return the vlDesconto
	 */
	public double getVlDesconto() {
		return this.vlDesconto;
	}

	/**
	 * @param pVlDesconto the vlDesconto to set
	 */
	public void setVlDesconto(double pVlDesconto) {
		this.vlDesconto = pVlDesconto;
	}

	/**
	 * @return the percDesconto
	 */
	public double getPercDesconto() {
		return this.percDesconto;
	}

	/**
	 * @param pPercDesconto the percDesconto to set
	 */
	public void setPercDesconto(double pPercDesconto) {
		this.percDesconto = pPercDesconto;
	}

	/**
	 * @return the cdTipoConta
	 */
	public Integer getCdTipoConta() {
		return this.cdTipoConta;
	}

	/**
	 * @param pCdTipoConta the cdTipoConta to set
	 */
	public void setCdTipoConta(Integer pCdTipoConta) {
		this.cdTipoConta = pCdTipoConta;
	}



}
