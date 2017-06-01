/**
 * 
 */
package sgbr.util;

import java.sql.Date;

/**
 * @author Reinaldo
 *
 */
public class OTDPromocao {

	private Integer cdPromocao;
	private Integer cdItemCardapio;
	private Double vlPromocao;
	private Date dtInicioPromocao;
	private Date dtFimPromocao;
	private String nmItemCardapio;
	private String cdDiaSemanaPromocao;
	private String dsDiaSemanaPromocao;
	/**
	 * @return the cdPromocao
	 */
	public Integer getCdPromocao() {
		return this.cdPromocao;
	}
	/**
	 * @param pCdPromocao the cdPromocao to set
	 */
	public void setCdPromocao(Integer pCdPromocao) {
		this.cdPromocao = pCdPromocao;
	}
	/**
	 * @return the cdItemCardapio
	 */
	public Integer getCdItemCardapio() {
		return this.cdItemCardapio;
	}
	/**
	 * @param pCdItemCardapio the cdItemCardapio to set
	 */
	public void setCdItemCardapio(Integer pCdItemCardapio) {
		this.cdItemCardapio = pCdItemCardapio;
	}
	/**
	 * @return the vlPromocao
	 */
	public Double getVlPromocao() {
		return this.vlPromocao;
	}
	/**
	 * @param pVlPromocao the vlPromocao to set
	 */
	public void setVlPromocao(Double pVlPromocao) {
		this.vlPromocao = pVlPromocao;
	}
	/**
	 * @return the dtInicioPromocao
	 */
	public Date getDtInicioPromocao() {
		return this.dtInicioPromocao;
	}
	/**
	 * @param pDtInicioPromocao the dtInicioPromocao to set
	 */
	public void setDtInicioPromocao(Date pDtInicioPromocao) {
		this.dtInicioPromocao = pDtInicioPromocao;
	}
	/**
	 * @return the dtFimPromocao
	 */
	public Date getDtFimPromocao() {
		return this.dtFimPromocao;
	}
	/**
	 * @param pDtFimPromocao the dtFimPromocao to set
	 */
	public void setDtFimPromocao(Date pDtFimPromocao) {
		this.dtFimPromocao = pDtFimPromocao;
	}
	/**
	 * @return the nmItemCardapio
	 */
	public String getNmItemCardapio() {
		return this.nmItemCardapio;
	}
	/**
	 * @param pNmItemCardapio the nmItemCardapio to set
	 */
	public void setNmItemCardapio(String pNmItemCardapio) {
		this.nmItemCardapio = pNmItemCardapio;
	}
	/**
	 * @return the diaSemanaPromocao
	 */
	public String getCdDiaSemanaPromocao() {
		return this.cdDiaSemanaPromocao;
	}
	/**
	 * @param pCdDiaSemanaPromocao the cdDiaSemanaPromocao to set
	 */
	public void setCdDiaSemanaPromocao(String pCdDiaSemanaPromocao) {
		this.cdDiaSemanaPromocao = pCdDiaSemanaPromocao;
	}
	/**
	 * @return the dsDiaSemanaPromocao
	 */
	public String getDsDiaSemanaPromocao() {
		return this.dsDiaSemanaPromocao;
	}
	/**
	 * @param pDsDiaSemanaPromocao the dsDiaSemanaPromocao to set
	 */
	public void setDsDiaSemanaPromocao(String pDsDiaSemanaPromocao) {
		this.dsDiaSemanaPromocao = pDsDiaSemanaPromocao;
	}
	

}
