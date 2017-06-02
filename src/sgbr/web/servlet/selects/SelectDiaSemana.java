/**
 * 
 */
package sgbr.web.servlet.selects;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import sgbr.util.Constantes;
import sgbr.util.web.SelectGenerico;

/**
 * @author Reinaldo
 *
 */
public class SelectDiaSemana extends SelectGenerico {

	private static SelectDiaSemana aSelectDiaSemana = new SelectDiaSemana();

	private SelectDiaSemana() {
		super();
	}

	public static SelectDiaSemana getInstancia() {
		if (SelectDiaSemana.aSelectDiaSemana == null) {
			SelectDiaSemana.aSelectDiaSemana = new SelectDiaSemana();
		}

		return SelectDiaSemana.aSelectDiaSemana;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.SelectGenerico#getHTML(javax.servlet.http.
	 * HttpServletRequest, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getHTML(HttpServletRequest pRequest, String pNmSelect, String pIdSelect, String pCampoSelecionado,
			boolean pObrigatorio, boolean pComTodos) throws Exception {

		String html = "";
		Collection<String> colecao = null;

		html = this.getColecaoComoHTMLSelect(colecao, pNmSelect, pIdSelect, pCampoSelecionado, pObrigatorio, pComTodos);

		return html;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.SelectGenerico#getColecaoComoHTMLSelect(java.util.
	 * Collection, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	protected String getColecaoComoHTMLSelect(Collection<?> pColecao, String pNmSelect, String pIdSelect,
			String pCampoSelecionado, boolean pObrigatorio, boolean pComTodos) throws Exception {

		
		StringBuffer bufferHtml = new StringBuffer(200);		

		this.criarSelect(pNmSelect, pIdSelect, bufferHtml, pObrigatorio, pComTodos);

		this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.CD_DIA_SEMANA_DOMINGO + "",
				Constantes.DS_DIA_SEMANA_DOMINGO);
		this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.CD_DIA_SEMANA_SEGUNDA + "",
				Constantes.DS_DIA_SEMANA_SEGUNDA);
		this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.CD_DIA_SEMANA_TERCA + "",
				Constantes.DS_DIA_SEMANA_TERCA);
		this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.CD_DIA_SEMANA_QUARTA + "",
				Constantes.DS_DIA_SEMANA_QUARTA);
		this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.CD_DIA_SEMANA_QUINTA + "",
				Constantes.DS_DIA_SEMANA_QUINTA);
		this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.CD_DIA_SEMANA_SEXTA + "",
				Constantes.DS_DIA_SEMANA_SEXTA);
		this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.CD_DIA_SEMANA_SABADO + "",
				Constantes.DS_DIA_SEMANA_SABADO);

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}

}
