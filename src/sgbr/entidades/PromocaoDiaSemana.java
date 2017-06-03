/**
 * 
 */
package sgbr.entidades;

import sgbr.util.EntidadeGenerica;

/**
 * 
 * Table: promocao_dia_semana Columns: PROMOCAO_CD int(11) PK PROMOCAO_DIA_CD
 * int(11) PK DH_INCLUSAO timestamp(6)
 * 
 * @author Reinaldo
 *
 */
public class PromocaoDiaSemana extends EntidadeGenerica {

	public static final String NM_COLUNA_PROMOCAO_CD = "PROMOCAO_CD";
	public static final String NM_COLUNA_DIA_SEMANA_CD = "DIA_SEMANA_CD";

	private Integer cdPromocao;
	private Integer cdDiaPromocao;

	public PromocaoDiaSemana() {
	}

	public PromocaoDiaSemana(Integer pCdPromocao, Integer pCdDiaPromocao) {
		this.cdPromocao = pCdPromocao;
		this.cdDiaPromocao = pCdDiaPromocao;

	}

	/**
	 * @return the cdPromocao
	 */
	public Integer getCdPromocao() {
		return this.cdPromocao;
	}

	/**
	 * @param pCdPromocao
	 *            the cdPromocao to set
	 */
	public void setCdPromocao(Integer pCdPromocao) {
		this.cdPromocao = pCdPromocao;
	}

	/**
	 * @return the cdDiaPromocao
	 */
	public Integer getCdDiaPromocao() {
		return this.cdDiaPromocao;
	}

	/**
	 * @param pCdDiaPromocao
	 *            the cdDiaPromocao to set
	 */
	public void setCdDiaPromocao(Integer pCdDiaPromocao) {
		this.cdDiaPromocao = pCdDiaPromocao;
	}

}
