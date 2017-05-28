/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeGenerica;

/**
 * Table: item_cardapio
Columns:
ITEM_CARDAPIO_CD int(11) AI PK 
ITEM_CARDAPIO_NM varchar(45) 
ITEM_CARDAPIO_VL double 
ITEM_CARDAPIO_SI char(1) = D - DISPONÍVEL, T - TEMPORARIAMENTE INDISPONÍVEL, I - INDISPONÍVEL
DH_INCLUSAO timestamp(6) 
DH_ALTERACAO timestamp(6)
 * 
 * @author Reinaldo
 *
 */
public class ItemCardapio extends EntidadeGenerica {

	public static final String NM_COLUNA_ITEM_CARDAPIO_CD = "ITEM_CARDAPIO_CD";
	public static final String NM_COLUNA_ITEM_CARDAPIO_NM = "ITEM_CARDAPIO_NM";
	public static final String NM_COLUNA_ITEM_CARDAPIO_VL = "ITEM_CARDAPIO_VL";
	public static final String NM_COLUNA_ITEM_CARDAPIO_SI= "ITEM_CARDAPIO_SI";


	private Integer cdItemCardapio;
	private String nmItemCardapio;
	private Double vlItemCardapio;
	private String siItemCardapio;
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
	 * @return the vlItemCardapio
	 */
	public Double getVlItemCardapio() {
		return this.vlItemCardapio;
	}
	/**
	 * @param pVlItemCardapio the vlItemCardapio to set
	 */
	public void setVlItemCardapio(Double pVlItemCardapio) {
		this.vlItemCardapio = pVlItemCardapio;
	}
	/**
	 * @return the siItemCardapio
	 */
	public String getSiItemCardapio() {
		return this.siItemCardapio;
	}
	/**
	 * @param pSiItemCardapio the siItemCardapio to set
	 */
	public void setSiItemCardapio(String pSiItemCardapio) {
		this.siItemCardapio = pSiItemCardapio;
	}
	
}
