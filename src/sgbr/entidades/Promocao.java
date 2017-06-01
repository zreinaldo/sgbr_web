/**
 * 
 */
package sgbr.entidades;

import java.sql.Date;

import sgbr.util.EntidadeGenerica;

/**
 *Table: promocao
Columns:
PROMOCAO_CD int(11) AI PK 
ITEM_CARDAPIO_CD int(11) 
PROMOCAO_VL double 
PROMOCAO_DT_INICIO date 
PROMOCAO_DT_FIM date 
DH_INCLUSAO timestamp(6) 
DH_ALTERACAO timestamp(6)
 * 
 * @author Reinaldo
 *
 */
public class Promocao extends EntidadeGenerica {
	public static final String NM_COLUNA_PROMOCAO_CD = "PROMOCAO_CD";
	public static final String NM_COLUNA_ITEM_CARDAPIO_CD = "ITEM_CARDAPIO_CD";
	public static final String NM_COLUNA_PROMOCAO_VL = "PROMOCAO_VL";
	public static final String NM_COLUNA_PROMOCAO_DT_INICIO = "PROMOCAO_DT_INICIO";
	public static final String NM_COLUNA_PROMOCAO_DT_FIM = "PROMOCAO_DT_FIM";


	private Integer cdPromocao;
	private Integer cdItemCardapio;
	private Double vlPromocao;
	private Date dtInicioPromocao;
	private Date dtFimPromocao;
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

}
