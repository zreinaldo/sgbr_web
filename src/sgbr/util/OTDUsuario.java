/**
 * 
 */
package sgbr.util;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Reinaldo
 *
 */
public class OTDUsuario implements Serializable {


	private Integer cdUsuario;
	private Integer cdTpUsuario;
	private Integer cdFuncionario;
	private String loginUsuario;
	private String senhaUsuario;
	private String inBloqueioUsuario;
	private String nmFuncionario;
	private String nmTpUsuario ;
	private Timestamp dhInclusao;
	private Timestamp dhAlteracao;
	/**
	 * @return the cdUsuario
	 */
	public Integer getCdUsuario() {
		return this.cdUsuario;
	}
	/**
	 * @param pCdUsuario the cdUsuario to set
	 */
	public void setCdUsuario(Integer pCdUsuario) {
		this.cdUsuario = pCdUsuario;
	}
	/**
	 * @return the cdTpUsuario
	 */
	public Integer getCdTpUsuario() {
		return this.cdTpUsuario;
	}
	/**
	 * @param pCdTpUsuario the cdTpUsuario to set
	 */
	public void setCdTpUsuario(Integer pCdTpUsuario) {
		this.cdTpUsuario = pCdTpUsuario;
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
	 * @return the loginUsuario
	 */
	public String getLoginUsuario() {
		return this.loginUsuario;
	}
	/**
	 * @param pLoginUsuario the loginUsuario to set
	 */
	public void setLoginUsuario(String pLoginUsuario) {
		this.loginUsuario = pLoginUsuario;
	}
	/**
	 * @return the senhaUsuario
	 */
	public String getSenhaUsuario() {
		return this.senhaUsuario;
	}
	/**
	 * @param pSenhaUsuario the senhaUsuario to set
	 */
	public void setSenhaUsuario(String pSenhaUsuario) {
		this.senhaUsuario = pSenhaUsuario;
	}
	/**
	 * @return the inBloqueioUsuario
	 */
	public String getInBloqueioUsuario() {
		return this.inBloqueioUsuario;
	}
	/**
	 * @param pInBloqueioUsuario the inBloqueioUsuario to set
	 */
	public void setInBloqueioUsuario(String pInBloqueioUsuario) {
		this.inBloqueioUsuario = pInBloqueioUsuario;
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
	 * @return the nmTpUsuario
	 */
	public String getNmTpUsuario() {
		return this.nmTpUsuario;
	}
	/**
	 * @param pNmTpUsuario the nmTpUsuario to set
	 */
	public void setNmTpUsuario(String pNmTpUsuario) {
		this.nmTpUsuario = pNmTpUsuario;
	}
	/**
	 * @return the dhInclusao
	 */
	public Timestamp getDhInclusao() {
		return this.dhInclusao;
	}
	/**
	 * @param pDhInclusao the dhInclusao to set
	 */
	public void setDhInclusao(Timestamp pDhInclusao) {
		this.dhInclusao = pDhInclusao;
	}
	/**
	 * @return the dhAlteracao
	 */
	public Timestamp getDhAlteracao() {
		return this.dhAlteracao;
	}
	/**
	 * @param pDhAlteracao the dhAlteracao to set
	 */
	public void setDhAlteracao(Timestamp pDhAlteracao) {
		this.dhAlteracao = pDhAlteracao;
	}


}
