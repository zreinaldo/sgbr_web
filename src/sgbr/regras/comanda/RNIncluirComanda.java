/**
 * 
 */
package sgbr.regras.comanda;

import java.sql.Date;

import sgbr.cadastros.sql.DAOComanda;
import sgbr.entidades.Comanda;
import sgbr.util.OTDComanda;
import sgbr.util.Util;

/**
 * @author Reinaldo
 *
 */
public class RNIncluirComanda {

	private static RNIncluirComanda aRNIncluirComanda = new RNIncluirComanda();

	/**
	 * Cria um novo objeto RNIncluirComanda.
	 */
	private RNIncluirComanda() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static RNIncluirComanda getInstancia() {
		if (RNIncluirComanda.aRNIncluirComanda == null) {
			RNIncluirComanda.aRNIncluirComanda = new RNIncluirComanda();
		}

		return RNIncluirComanda.aRNIncluirComanda;
	}

	public void processar(Integer pQtdComandas) {

		Comanda comanda = null;
		try {
			
			
			for (int aI = 0; aI < pQtdComandas; aI++) {
				comanda = new Comanda();
				comanda.setDtIniValidade(Util.getDataHoje());
				
				DAOComanda.getInstancia().incluir(comanda);
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
