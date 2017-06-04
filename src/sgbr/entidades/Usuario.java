/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeGenerica;

/**
 * 
 * Table: usuario
Columns:
USUARIO_CD int(11) AI PK 
TIPO_USUARIO_CD int(11) 
FUNCIONARIO_CD int(11) 
USUARIO_LOGIN varchar(45) 
USUARIO_SENHA varchar(45) 
DH_INCLUSAO timestamp(6) 
USUARIO_IN_BLOQUEIO char(1) 
DH_ALTERACAO timestamp(6)
 * 
 * @author Reinaldo
 *
 */
public class Usuario extends EntidadeGenerica {

	public static final String NM_COLUNA_USUARIO_CD = "USUARIO_CD";
	public static final String NM_COLUNA_TIPO_USUARIO_CD = "TIPO_USUARIO_CD";
	public static final String NM_COLUNA_FUNCIONARIO_CD = "FUNCIONARIO_CD";
	public static final String NM_COLUNA_USUARIO_LOGIN = "USUARIO_LOGIN";
	public static final String NM_COLUNA_USUARIO_SENHA = "USUARIO_SENHA";
	public static final String NM_COLUNA_USUARIO_IN_BLOQUEIO = "USUARIO_IN_BLOQUEIO";
	
	
	private Integer cdUsuario;
	private Integer cdTpUsuario;
	private Integer cdFuncionario;
	private String loginUsuario;
	private String senhaUsuario;
	private String inBloqueioUsuario;
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


}
