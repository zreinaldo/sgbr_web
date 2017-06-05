/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeGenerica;

/**
 * 
 * Table: tipo_usuario Columns: TIPO_USUARIO_CD int(11) AI PK TIPO_USUARIO_NM
 * varchar(45)
 * 
 * @author Reinaldo
 *
 */
public class TipoUsuario extends EntidadeGenerica {

	public static final String NM_COLUNA_TIPO_USUARIO_CD = "TIPO_USUARIO_CD";
	public static final String NM_COLUNA_TIPO_USUARIO_NM = "TIPO_USUARIO_NM";

	private Integer cdTpUsuario;
	private String nmTpUsuario;



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
	 * 
	 * /**
	 * 
	 * @return the nmTpUsuario
	 */
	public String getNmTpUsuario() {
		return this.nmTpUsuario;
	}

	/**
	 * @param pNmTpUsuario
	 *            the nmTpUsuario to set
	 */
	public void setNmTpUsuario(String pNmTpUsuario) {
		this.nmTpUsuario = pNmTpUsuario;
	}

}