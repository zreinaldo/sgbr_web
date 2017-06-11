/**
 * 
 */
package sgbr.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
			dsSiItemCardapio = Constantes.DS_ITEM_CARDAPIO_DISPONIVEL;
			break;
		case Constantes.SI_ITEM_CARDAPIO_INDISPONIVEL:
			dsSiItemCardapio = Constantes.DS_ITEM_CARDAPIO_INDISPONIVEL;
			break;
		case Constantes.SI_ITEM_CARDAPIO_TEMPORARIAMENTE_INDISPONIVEL:
			dsSiItemCardapio = Constantes.DS_ITEM_CARDAPIO_TEMPORARIAMENTE_INDISPONIVEL;
			break;

		default:
			dsSiItemCardapio = "";
			break;
		}
		return dsSiItemCardapio;
	}

	/**
	 * retorna o dia da semana do calendar 
	 * @return
	 */
	public static String getDiaSemana() {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(Util.getDataHoje());
		return String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
	}

	/**
	 * pelo ID do dia retorna a descricao do dia da semana
	 * @param pDiaSemana
	 * @return
	 */
	public static String getDsDiaSemana(int pDiaSemana) {
		String diaSemana;

		switch (pDiaSemana) {

		case Constantes.CD_DIA_SEMANA_DOMINGO:
			diaSemana = Constantes.DS_DIA_SEMANA_DOMINGO;
			break;
		case Constantes.CD_DIA_SEMANA_SEGUNDA:
			diaSemana = Constantes.DS_DIA_SEMANA_SEGUNDA;
			break;
		case Constantes.CD_DIA_SEMANA_TERCA:
			diaSemana = Constantes.DS_DIA_SEMANA_TERCA;
			break;
		case Constantes.CD_DIA_SEMANA_QUARTA:
			diaSemana = Constantes.DS_DIA_SEMANA_QUARTA;
			break;
		case Constantes.CD_DIA_SEMANA_QUINTA:
			diaSemana = Constantes.DS_DIA_SEMANA_QUINTA;
			break;
		case Constantes.CD_DIA_SEMANA_SEXTA:
			diaSemana = Constantes.DS_DIA_SEMANA_SEXTA;
			break;
		case Constantes.CD_DIA_SEMANA_SABADO:
			diaSemana = Constantes.DS_DIA_SEMANA_SABADO;
			break;
		default:
			diaSemana = "";
			break;
		}
		return diaSemana;
	}
			
	public static String getDsSimNao(String pCdSimNao) {
		String dsTpUsuario;

		switch (pCdSimNao) {
		case Constantes.CD_SIM:
			dsTpUsuario = Constantes.DS_SIM;
			break;
		case Constantes.CD_NAO:
			dsTpUsuario = Constantes.DS_NAO;
			break;
		default:
			dsTpUsuario = "";
			break;
		}
		return dsTpUsuario;
	}
	
	/**
	 * @param pValor
	 * @return
	 */
	public static String getValorHTML (Object pValor) {
		return pValor == null ? "" : String.valueOf(pValor);
	}
	
	/**
	 * @param pValor
	 * @return
	 */
	public static Integer getInteger (String pValor) {
		return pValor.equals("") ? null : Integer.parseInt(pValor);
	}
}
