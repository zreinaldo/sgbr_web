/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeGenerica;

/**
 * Table: conta_item_cardapio
Columns:
CONTA_ITEM_CARDAPIO_CD int(11) PK 
ITEM_CARDAPIO_CD int(11) PK 
CONTA_CD int(11) PK 
CONTA_ITEM_CARDAPIO_QTD int(11) 
CONTA_ITEM_CARDAPIO_OBS varchar(45) 
FUNCIONARIO_CD int(11)
 * 
 * @author Reinaldo
 *
 */
public class ContaItemCardapio extends EntidadeGenerica {
	public static final String NM_COLUNA_CONTA_ITEM_CARDAPIO_CD = "CONTA_ITEM_CARDAPIO_CD";
	public static final String NM_COLUNA_ITEM_CARDAPIO_CD = "ITEM_CARDAPIO_CD";
	public static final String NM_COLUNA_CONTA_CD = "CONTA_CD";
	public static final String NM_COLUNA_CONTA_ITEM_CARDAPIO_QTD = "CONTA_ITEM_CARDAPIO_QTD";
	public static final String NM_COLUNA_CONTA_ITEM_CARDAPIO_OBS= "CONTA_ITEM_CARDAPIO_OBS";
	public static final String NM_COLUNA_FUNCIONARIO_CD= "FUNCIONARIO_CD";

	private Integer cdContaItemCardapio;
	private Integer cdItemCardapio;
	private Integer cdConta;
	private Integer qtdContaItemCardapio;
	private String obsContaItemCardapio;
	private Integer cdFuncionario;
	/**
	 * @return the cdContaItemCardapio
	 */
	public Integer getCdContaItemCardapio() {
		return this.cdContaItemCardapio;
	}
	/**
	 * @param pCdContaItemCardapio the cdContaItemCardapio to set
	 */
	public void setCdContaItemCardapio(Integer pCdContaItemCardapio) {
		this.cdContaItemCardapio = pCdContaItemCardapio;
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
	 * @return the cdConta
	 */
	public Integer getCdConta() {
		return this.cdConta;
	}
	/**
	 * @param pCdConta the cdConta to set
	 */
	public void setCdConta(Integer pCdConta) {
		this.cdConta = pCdConta;
	}
	/**
	 * @return the qtdContaItemCardapio
	 */
	public Integer getQtdContaItemCardapio() {
		return this.qtdContaItemCardapio;
	}
	/**
	 * @param pQtdContaItemCardapio the qtdContaItemCardapio to set
	 */
	public void setQtdContaItemCardapio(Integer pQtdContaItemCardapio) {
		this.qtdContaItemCardapio = pQtdContaItemCardapio;
	}
	/**
	 * @return the obsContaItemCardapio
	 */
	public String getObsContaItemCardapio() {
		return this.obsContaItemCardapio;
	}
	/**
	 * @param pObsContaItemCardapio the obsContaItemCardapio to set
	 */
	public void setObsContaItemCardapio(String pObsContaItemCardapio) {
		this.obsContaItemCardapio = pObsContaItemCardapio;
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

	
	
	
}
