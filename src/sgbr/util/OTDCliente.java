/**
 * 
 */
package sgbr.util;

import java.sql.Date;

/**
 * @author Reinaldo
 *
 */
public class OTDCliente {

	private Integer cdCliente;
	private Integer cdPessoa;
	private String nmCliente;
	private Date dtNascimento;
	private String email;
	private String nuCPF;

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

	/**
	 * @return the nmCliente
	 */
	public String getNmCliente() {
		return this.nmCliente;
	}

	/**
	 * @param pNmCliente
	 *            the nmCliente to set
	 */
	public void setNmCliente(String pNmCliente) {
		this.nmCliente = pNmCliente;
	}

	/**
	 * @return the dtNascimento
	 */
	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	/**
	 * @param pDtNascimento
	 *            the dtNascimento to set
	 */
	public void setDtNascimento(Date pDtNascimento) {
		this.dtNascimento = pDtNascimento;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param pEmail
	 *            the email to set
	 */
	public void setEmail(String pEmail) {
		this.email = pEmail;
	}

	/**
	 * @return the nuCPF
	 */
	public String getNuCPF() {
		return this.nuCPF;
	}

	/**
	 * @param pNuCPF
	 *            the nuCPF to set
	 */
	public void setNuCPF(String pNuCPF) {
		this.nuCPF = pNuCPF;
	}

}
