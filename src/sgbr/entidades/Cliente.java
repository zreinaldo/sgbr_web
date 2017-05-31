/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeGenerica;

/**
 * 
 * Table: cliente Columns: CLIENTE_CD int(11) AI PK PESSOA_CD int(11)
 * DH_INCLUSAO timestamp(6)
 * 
 * @author Reinaldo
 *
 */
public class Cliente extends EntidadeGenerica {

	public static final String NM_COLUNA_CLIENTE_CD = "CLIENTE_CD";
	public static final String NM_COLUNA_PESSOA_CD = "PESSOA_CD";
	
	private Integer cdCliente;
	private Integer cdPessoa;

	public Cliente(Integer pCdCliente, Integer pCdPessoa) {
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
	 * @param pCdCliente
	 *            the cdCliente to set
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
	 * @param pCdPessoa
	 *            the cdPessoa to set
	 */
	public void setCdPessoa(Integer pCdPessoa) {
		this.cdPessoa = pCdPessoa;
	}

}
