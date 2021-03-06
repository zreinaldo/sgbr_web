/**
 * 
 */
package sgbr.util;

import java.sql.Date;

/**
 * @author Reinaldo
 *
 */
public class OTDFuncionario  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3611041008330955377L;

	private String nmFuncionario;
	private String nuCPF;
	private String nuRG;
	private String nuCarteira;
	private String nmBanco;
	private String nuAgencia;
	private String nuCC;
	private Double vlSalario;
	private Date dtAdmissao;
	private String nmUF;
	private String nmCidade;
	private String nmBairro;
	private String nmLogradouro;
	private String nuLogradouro;
	private String nuCEP;
	private Date dtNascimento;
	private String email;
	private Integer tpFuncionario;
	private String dsFuncionario;
	private Integer cdFuncionario;
	private Integer cdPessoa;
	private Date dtDemissao;
	private String nuTelefoneConvencional;
	private String dddTelefoneConvencional;	
	private String nuTelefoneCelular;
	private String dddTelefoneCelular;
	

	/**
	 * @return the dtNascimento
	 */
	public Date getDtNascimento() {
		return dtNascimento;
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
		return email;
	}

	/**
	 * @param pEmail
	 *            the email to set
	 */
	public void setEmail(String pEmail) {
		this.email = pEmail;
	}

	/**
	 * @return the nmFuncionario
	 */
	public String getNmFuncionario() {
		return nmFuncionario;
	}

	/**
	 * @param pNmFuncionario
	 *            the nmFuncionario to set
	 */
	public void setNmFuncionario(String pNmFuncionario) {
		this.nmFuncionario = pNmFuncionario;
	}

	
	/**
	 * @return the nuCPF
	 */
	public String getNuCPF() {
		return nuCPF;
	}

	/**
	 * @param pNuCPF
	 *            the nuCPF to set
	 */
	public void setNuCPF(String pNuCPF) {
		this.nuCPF = pNuCPF;
	}

	/**
	 * @return the nuRG
	 */
	public String getNuRG() {
		return nuRG;
	}

	/**
	 * @param pNuRG
	 *            the nuRG to set
	 */
	public void setNuRG(String pNuRG) {
		this.nuRG = pNuRG;
	}

	/**
	 * @return the nuCarteira
	 */
	public String getNuCarteira() {
		return nuCarteira;
	}

	/**
	 * @param pNuCarteira
	 *            the nuCarteira to set
	 */
	public void setNuCarteira(String pNuCarteira) {
		this.nuCarteira = pNuCarteira;
	}

	/**
	 * @return the nmBanco
	 */
	public String getNmBanco() {
		return nmBanco;
	}

	/**
	 * @param pNmBanco
	 *            the nmBanco to set
	 */
	public void setNmBanco(String pNmBanco) {
		this.nmBanco = pNmBanco;
	}

	/**
	 * @return the nuAgencia
	 */
	public String getNuAgencia() {
		return nuAgencia;
	}

	/**
	 * @param pNuAgencia
	 *            the nuAgencia to set
	 */
	public void setNuAgencia(String pNuAgencia) {
		this.nuAgencia = pNuAgencia;
	}

	/**
	 * @return the nuCC
	 */
	public String getNuCC() {
		return nuCC;
	}

	/**
	 * @param pNuCC
	 *            the nuCC to set
	 */
	public void setNuCC(String pNuCC) {
		this.nuCC = pNuCC;
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
		this.vlSalario = pVlSalario;
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
		this.dtAdmissao = pDtAdmissao;
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
	 * @return the nuCEP
	 */
	public String getNuCEP() {
		return nuCEP;
	}

	/**
	 * @param pNuCEP
	 *            the nuCEP to set
	 */
	public void setNuCEP(String pNuCEP) {
		this.nuCEP = pNuCEP;
	}

	/**
	 * @return
	 */
	public Integer getTpFuncionario() {
		return tpFuncionario;
	}


	/**
	 * @param pTpFuncionario
	 */
	public void setTpFuncionario(Integer pTpFuncionario) {
		this.tpFuncionario = pTpFuncionario;
	}

	/**
	 * @return the dsFuncionario
	 */
	public String getDsFuncionario() {
		return dsFuncionario;
	}

	/**
	 * @param pDsFuncionario the dsFuncionario to set
	 */
	public void setDsFuncionario(String pDsFuncionario) {
		this.dsFuncionario = pDsFuncionario;
	}

	/**
	 * @return the cdFuncionario
	 */
	public Integer getCdFuncionario() {
		return cdFuncionario;
	}

	/**
	 * @param pCdFuncionario the cdFuncionario to set
	 */
	public void setCdFuncionario(Integer pCdFuncionario) {
		this.cdFuncionario = pCdFuncionario;
	}

	/**
	 * @return the cdPessoa
	 */
	public Integer getCdPessoa() {
		return cdPessoa;
	}

	/**
	 * @param pCdPessoa the cdPessoa to set
	 */
	public void setCdPessoa(Integer pCdPessoa) {
		this.cdPessoa = pCdPessoa;
	}

	/**
	 * @return the dtDemissao
	 */
	public Date getDtDemissao() {
		return dtDemissao;
	}

	/**
	 * @param pDtDemissao the dtDemissao to set
	 */
	public void setDtDemissao(Date pDtDemissao) {
		this.dtDemissao = pDtDemissao;
	}

	/**
	 * @return the nuTelefoneConvencional
	 */
	public String getNuTelefoneConvencional() {
		return this.nuTelefoneConvencional;
	}

	/**
	 * @param pNuTelefoneConvencional the nuTelefoneConvencional to set
	 */
	public void setNuTelefoneConvencional(String pNuTelefoneConvencional) {
		this.nuTelefoneConvencional = pNuTelefoneConvencional;
	}

	/**
	 * @return the dddTelefoneConvencional
	 */
	public String getDddTelefoneConvencional() {
		return this.dddTelefoneConvencional;
	}

	/**
	 * @param pDddTelefoneConvencional the dddTelefoneConvencional to set
	 */
	public void setDddTelefoneConvencional(String pDddTelefoneConvencional) {
		this.dddTelefoneConvencional = pDddTelefoneConvencional;
	}

	/**
	 * @return the nuTelefoneCelular
	 */
	public String getNuTelefoneCelular() {
		return this.nuTelefoneCelular;
	}

	/**
	 * @param pNuTelefoneCelular the nuTelefoneCelular to set
	 */
	public void setNuTelefoneCelular(String pNuTelefoneCelular) {
		this.nuTelefoneCelular = pNuTelefoneCelular;
	}

	/**
	 * @return the dddTelefoneCelular
	 */
	public String getDddTelefoneCelular() {
		return this.dddTelefoneCelular;
	}

	/**
	 * @param pDddTelefoneCelular the dddTelefoneCelular to set
	 */
	public void setDddTelefoneCelular(String pDddTelefoneCelular) {
		this.dddTelefoneCelular = pDddTelefoneCelular;
	}

}
