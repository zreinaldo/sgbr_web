/**
 * 
 */
package sgbr.web.servlet.selects;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import sgbr.entidades.Comanda;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.web.SelectGenerico;

/**
 * @author Reinaldo
 *
 */
public class SelectComandaConta extends SelectGenerico {

	private static SelectComandaConta aSelectComanda = new SelectComandaConta();

	private SelectComandaConta() {
		super();
	}

	public static SelectComandaConta getInstancia() {
		if (SelectComandaConta.aSelectComanda == null) {
			SelectComandaConta.aSelectComanda = new SelectComandaConta();
		}

		return SelectComandaConta.aSelectComanda;
	}

	public String getHTML(HttpServletRequest pRequest, String pNmSelect, String pIdSelect, String pCampoSelecionado,
			boolean pObrigatorio, boolean pComTodos, boolean pInUso) throws Exception {

		String html = "";
		Collection<Comanda> colecao = null;

		colecao = (Collection<Comanda>) FachadaSGBR.getInstancia().consultaComandaConta(pInUso);

		html = this.getColecaoComoHTMLSelect(colecao, pNmSelect, pIdSelect, pCampoSelecionado, pObrigatorio, pComTodos);

		return html;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.SelectGenerico#getHTML(javax.servlet.http.
	 * HttpServletRequest, java.lang.String, java.lang.String, java.lang.String,
	 * boolean, boolean)
	 */
	@Override
	public String getHTML(HttpServletRequest pRequest, String pNmSelect, String pIdSelect, String pCampoSelecionado,
			boolean pObrigatorio, boolean pComTodos) throws Exception {

		return this.getHTML(pRequest, pNmSelect, pIdSelect, pCampoSelecionado, pObrigatorio, pComTodos, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.SelectGenerico#getColecaoComoHTMLSelect(java.util.
	 * Collection, java.lang.String, java.lang.String, java.lang.String,
	 * boolean, boolean)
	 */
	@Override
	protected String getColecaoComoHTMLSelect(Collection<?> pColecao, String pNmSelect, String pIdSelect,
			String pCampoSelecionado, boolean pObrigatorio, boolean pComTodos) throws Exception {

		Iterator it;
		StringBuffer bufferHtml = new StringBuffer(200);
		Comanda Comanda = null;

		this.criarSelect(pNmSelect, pIdSelect, bufferHtml, pObrigatorio, pComTodos);

		it = pColecao.iterator();
		while (it.hasNext()) {
			Comanda = (Comanda) it.next();
			this.valoresOptions(bufferHtml, pCampoSelecionado, Comanda.getCdComanda().toString(),
					Comanda.getCdComanda().toString());

		}

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}

}
