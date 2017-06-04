/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeGenerica;

/**
 * 
 * Table: tipo_usuario
Columns:
TIPO_USUARIO_CD int(11) AI PK 
TIPO_USUARIO_NM varchar(45)
 * 
 * @author Reinaldo
 *
 */
public class TipoUsuario extends EntidadeGenerica {

	public static final String NM_COLUNA_USUARIO_CD = "USUARIO_CD";
	public static final String NM_COLUNA_TIPO_USUARIO_NM = "TIPO_USUARIO_NM";
	
	private String cdUsuario;
	private String nmTpUsuario;
	/**
	 * @return the cdUsuario
	 */
	public String getCdUsuario() {
		return this.cdUsuario;
	}
	/**
	 * @param pCdUsuario the cdUsuario to set
	 */
	public void setCdUsuario(String pCdUsuario) {
		this.cdUsuario = pCdUsuario;
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
}