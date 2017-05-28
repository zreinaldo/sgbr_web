/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeGenerica;

/**
 * @author Reinaldo
 *
 */
public class Cliente extends EntidadeGenerica {

	private Integer cdCliente;
	private Integer cdPessoa;
	
	
	public Cliente (Integer pCdCliente, Integer pCdPessoa) {
		this.cdCliente = pCdCliente;
		this.cdPessoa = pCdPessoa;
	}
	
	/**
	 * 
	 */
	public Cliente() {		
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
	 * @return the cdPessoa
	 */
	public Integer getCdPessoa() {
		return this.cdPessoa;
	}
	/**
	 * @param pCdPessoa the cdPessoa to set
	 */
	public void setCdPessoa(Integer pCdPessoa) {
		this.cdPessoa = pCdPessoa;
	}
	
}
