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
public class SelectSituacaoItemCardapio extends SelectGenerico {

	private static SelectSituacaoItemCardapio aSelectSituacaoItemCardapio = new SelectSituacaoItemCardapio();

	private SelectSituacaoItemCardapio() {
		super();
	}

	public static SelectSituacaoItemCardapio getInstancia() {
		if (SelectSituacaoItemCardapio.aSelectSituacaoItemCardapio == null) {
			SelectSituacaoItemCardapio.aSelectSituacaoItemCardapio = new SelectSituacaoItemCardapio();
		}

		return SelectSituacaoItemCardapio.aSelectSituacaoItemCardapio;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.SelectGenerico#getHTML(javax.servlet.http.
	 * HttpServletRequest, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getHTML(HttpServletRequest pRequest, String pNmSelect, String pIdSelect, String pCampoSelecionado,boolean pObrigatorio, boolean pComTodos)
			throws Exception {

		String html = "";
		Collection<String> colecao = null;
	

		html = this.getColecaoComoHTMLSelect(colecao, pNmSelect, pIdSelect, pCampoSelecionado,pObrigatorio,pComTodos);

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
			String pCampoSelecionado,boolean pObrigatorio, boolean pComTodos) throws Exception {

		Iterator it;
		StringBuffer bufferHtml = new StringBuffer(200);
		HashMap<String,String> hash = null;

		this.criarSelect(pNmSelect, pIdSelect, bufferHtml, pObrigatorio, pComTodos);
		
			this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.SI_ITEM_CARDAPIO_DISPONIVEL, "DISPONÍVEL");
			this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.SI_ITEM_CARDAPIO_INDISPONIVEL, "INDISPONÍVEL");
			this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.SI_ITEM_CARDAPIO_TEMPORARIAMENTE_INDISPONIVEL, "TEMPORARIAMENTE INDISPONÍVEL");

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}

}
