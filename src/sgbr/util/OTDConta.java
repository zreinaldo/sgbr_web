/**
 * 
 */
package sgbr.util;

import java.sql.Timestamp;



/**
 * @author Reinaldo
 *
 */
public class OTDConta {

	private Integer cdConta;
	private Integer cdComanda;
	private Integer cdMesa;
	private Integer cdCliente;
	private String nmCliente;
	private double vlTotal;
	private double vlDesconto;
	private double percDesconto;
	private Timestamp dhEncerramento;
	private Timestamp dhAbertura;
	private boolean inContaMesa;
	private String siConta;

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
	 * @return the vlTotal
	 */
	public double getVlTotal() {
		return this.vlTotal;
	}

	/**
	 * @param pVlTotal
	 *            the vlTotal to set
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
	 * @param pVlDesconto
	 *            the vlDesconto to set
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
	 * @param pPercDesconto
	 *            the percDesconto to set
	 */
	public void setPercDesconto(double pPercDesconto) {
		this.percDesconto = pPercDesconto;
	}


	/**
	 * @return the inContaMesa
	 */
	public boolean isInContaMesa() {
		return this.inContaMesa;
	}

	/**
	 * @param pInContaMesa
	 *            the inContaMesa to set
	 */
	public void setInContaMesa(boolean pInContaMesa) {
		this.inContaMesa = pInContaMesa;
	}

	/**
	 * @return the nmCliente
	 */
	public String getNmCliente() {
		return this.nmCliente;
	}

	/**
	 * @param pNmCliente the nmCliente to set
	 */
	public void setNmCliente(String pNmCliente) {
		this.nmCliente = pNmCliente;
	}

	/**
	 * @return the siConta
	 */
	public String getSiConta() {
		return this.siConta;
	}

	/**
	 * @param pSiConta the siConta to set
	 */
	public void setSiConta(String pSiConta) {
		this.siConta = pSiConta;
	}

	/**
	 * @return the dhEncerramento
	 */
	public Timestamp getDhEncerramento() {
		return this.dhEncerramento;
	}

	/**
	 * @param pDhEncerramento the dhEncerramento to set
	 */
	public void setDhEncerramento(Timestamp pDhEncerramento) {
		this.dhEncerramento = pDhEncerramento;
	}

	/**
	 * @return the dhAbertura
	 */
	public Timestamp getDhAbertura() {
		return this.dhAbertura;
	}

	/**
	 * @param pDhAbertura the dhAbertura to set
	 */
	public void setDhAbertura(Timestamp pDhAbertura) {
		this.dhAbertura = pDhAbertura;
	}

}
