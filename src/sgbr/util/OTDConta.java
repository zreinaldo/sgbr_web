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
	private Timestamp dhEncerramento;
	private Timestamp dhAbertura;
	private boolean inContaMesa;
	private String siConta;
	private String dsTipoConta;
	private Integer cdTipoConta;
	private Integer cdFuncionario;
	private String nmFuncionario;

	private Double vlContaFinal;
	private Double vlContaOriginal;
	private Double vlDescontoConta;
	private Double percDescontoConta;
	/**
	 * @return the cdConta
	 */
	public Integer getCdConta() {
		return this.cdConta;
	}
	/**
	 * @param pCdConta the cdConta to set
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
	 * @param pCdComanda the cdComanda to set
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
	 * @param pCdMesa the cdMesa to set
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
	 * @param pCdCliente the cdCliente to set
	 */
	public void setCdCliente(Integer pCdCliente) {
		this.cdCliente = pCdCliente;
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
	/**
	 * @return the inContaMesa
	 */
	public boolean isInContaMesa() {
		return this.inContaMesa;
	}
	/**
	 * @param pInContaMesa the inContaMesa to set
	 */
	public void setInContaMesa(boolean pInContaMesa) {
		this.inContaMesa = pInContaMesa;
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
	 * @return the dsTipoConta
	 */
	public String getDsTipoConta() {
		return this.dsTipoConta;
	}
	/**
	 * @param pDsTipoConta the dsTipoConta to set
	 */
	public void setDsTipoConta(String pDsTipoConta) {
		this.dsTipoConta = pDsTipoConta;
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
	/**
	 * @return the nmFuncionario
	 */
	public String getNmFuncionario() {
		return this.nmFuncionario;
	}
	/**
	 * @param pNmFuncionario the nmFuncionario to set
	 */
	public void setNmFuncionario(String pNmFuncionario) {
		this.nmFuncionario = pNmFuncionario;
	}
	/**
	 * @return the vlContaFinal
	 */
	public Double getVlContaFinal() {
		return this.vlContaFinal;
	}
	/**
	 * @param pVlContaFinal the vlContaFinal to set
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
	 * @param pVlContaOriginal the vlContaOriginal to set
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
	 * @param pVlDescontoConta the vlDescontoConta to set
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
	 * @param pPercDescontoConta the percDescontoConta to set
	 */
	public void setPercDescontoConta(Double pPercDescontoConta) {
		this.percDescontoConta = pPercDescontoConta;
	}
	
}
