/**
 * 
 */
package sgbr.web.servlet.selects;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import sgbr.util.web.SelectGenerico;

/**
 * @author Reinaldo
 *
 */
public class SelectEstado extends SelectGenerico {

	private static SelectEstado aSelectEstado = new SelectEstado();

	private SelectEstado() {
		super();
	}

	public static SelectEstado getInstancia() {
		if (SelectEstado.aSelectEstado == null) {
			SelectEstado.aSelectEstado = new SelectEstado();
		}

		return SelectEstado.aSelectEstado;
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

		
		StringBuffer bufferHtml = new StringBuffer(200);

		this.criarSelect(pNmSelect, pIdSelect, bufferHtml, pObrigatorio, pComTodos);
		
			this.valoresOptions(bufferHtml, pCampoSelecionado, "PE", "Pernambuco");
			this.valoresOptions(bufferHtml, pCampoSelecionado, "PB", "Paraiba");
			this.valoresOptions(bufferHtml, pCampoSelecionado, "RJ", "Rio de Janeiro");
			this.valoresOptions(bufferHtml, pCampoSelecionado, "AL", "Alagoas");

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}


}
