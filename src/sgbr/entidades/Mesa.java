/**
 * 
 */
package sgbr.entidades;

/**
 * entidade que nao possui CRUD Table: mesa Columns: MESA_CD int(11) PK
 * 
 * @author Reinaldo
 *
 */
public class Mesa {

	public static final String NM_COLUNA_MESA_CD = "MESA_CD";
	private Integer cdMesa;

	/**
	 * @return the cdMesa
	 */
	public Integer getCdMesa() {
		return this.cdMesa;
	}

	/**
	 * @param pCdMesa
	 *            the cdMesa to set
	 */
	public void setCdMesa(Integer pCdMesa) {
		this.cdMesa = pCdMesa;
	}

}
