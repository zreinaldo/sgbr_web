/**
 * 
 */
package sgbr.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Reinaldo
 *
 */
public class Util {

	public static Date formataData(String data) throws Exception {

		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}

	public static String formataDataParaString(Date pData) {

		if (pData == null) {
			return "";
		}

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(pData);
	}

	public static Date getDataHoje() {
		java.util.Date dt = new java.util.Date();

		return new Date(dt.getTime());
	}
	
	
	public static String getDsSiItemCardapio(String pSiItemCardapio) {
		String dsSiItemCardapio;

		switch (pSiItemCardapio) {
		case Constantes.SI_ITEM_CARDAPIO_DISPONIVEL:
			dsSiItemCardapio = "DISPONÍVEL";
			break;
		case Constantes.SI_ITEM_CARDAPIO_INDISPONIVEL:
			dsSiItemCardapio = "INDISPONÍVEL";
			break;
		case Constantes.SI_ITEM_CARDAPIO_TEMPORARIAMENTE_INDISPONIVEL:
			dsSiItemCardapio = "TEMPORARIAMENTE INDISPONÍVEL";
			break;

		default: dsSiItemCardapio = "";
			break;
		}
		return dsSiItemCardapio;
	}
}
