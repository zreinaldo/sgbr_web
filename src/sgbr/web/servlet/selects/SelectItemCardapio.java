/**
 * 
 */
package sgbr.web.servlet.selects;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import sgbr.entidades.ItemCardapio;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.web.SelectGenerico;

/**
 * @author Reinaldo
 *
 */
public class SelectItemCardapio extends SelectGenerico {

	private static SelectItemCardapio aSelectItemCardapio = new SelectItemCardapio();

	private SelectItemCardapio() {
		super();
	}

	public static SelectItemCardapio getInstancia() {
		if (SelectItemCardapio.aSelectItemCardapio == null) {
			SelectItemCardapio.aSelectItemCardapio = new SelectItemCardapio();
		}

		return SelectItemCardapio.aSelectItemCardapio;
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
		Collection<ItemCardapio> colecao = null;

		colecao = FachadaSGBR.getInstancia().consultaTodosRegistrosItemCardapio(true);

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
		ItemCardapio itemCardapio = null;

		this.criarSelect(pNmSelect, pIdSelect, bufferHtml, pObrigatorio, pComTodos);

		it = pColecao.iterator();
		while (it.hasNext()) {
			itemCardapio = (ItemCardapio) it.next();
			this.valoresOptions(bufferHtml, pCampoSelecionado, itemCardapio.getCdItemCardapio().toString(),
					itemCardapio.getNmItemCardapio());

		}

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}

}
