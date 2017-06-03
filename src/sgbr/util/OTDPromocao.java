/**
 * 
 */
package sgbr.util;

import java.sql.Date;
import java.util.ArrayList;

import sgbr.entidades.PromocaoDiaSemana;

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
	private String colecaoDsPromocaoDiasSemana;
	private String[] listaDiasSemanaPromocao;
	private Integer cdDiaSemanaPromocao;
	private ArrayList<PromocaoDiaSemana> arrayPromocaoDiaSemana;
	
	
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
	 * @return the listaDiasSemanaPromocao
	 */
	public String[] getListaDiasSemanaPromocao() {
		return this.listaDiasSemanaPromocao;
	}
	/**
	 * @param pListaDiasSemanaPromocao the listaDiasSemanaPromocao to set
	 */
	public void setListaDiasSemanaPromocao(String[] pListaDiasSemanaPromocao) {
		this.listaDiasSemanaPromocao = pListaDiasSemanaPromocao;
	}
	/**
	 * @return the cdDiaSemanaPromocao
	 */
	public Integer getCdDiaSemanaPromocao() {
		return this.cdDiaSemanaPromocao;
	}
	/**
	 * @param pCdDiaSemanaPromocao the cdDiaSemanaPromocao to set
	 */
	public void setCdDiaSemanaPromocao(Integer pCdDiaSemanaPromocao) {
		this.cdDiaSemanaPromocao = pCdDiaSemanaPromocao;
	}
	/**
	 * @return the colecaoDiasSemana
	 */
	public String getColecaoDsPromocaoDiasSemana() {
		return this.colecaoDsPromocaoDiasSemana;
	}
	/**
	 * @param pColecaoDiasSemana the colecaoDiasSemana to set
	 */
	public void setColecaoDsPromocaoDiasSemana(String pColecaoDiasSemana) {
		this.colecaoDsPromocaoDiasSemana = pColecaoDiasSemana;
	}
	/**
	 * @return the arrayPromocaoDiaSemana
	 */
	public ArrayList<PromocaoDiaSemana> getArrayPromocaoDiaSemana() {
		return this.arrayPromocaoDiaSemana;
	}
	/**
	 * @param pArrayPromocaoDiaSemana the arrayPromocaoDiaSemana to set
	 */
	public void setArrayPromocaoDiaSemana(ArrayList<PromocaoDiaSemana> pArrayPromocaoDiaSemana) {
		this.arrayPromocaoDiaSemana = pArrayPromocaoDiaSemana;
	}

}
