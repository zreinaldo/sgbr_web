/**
 * 
 */
package sgbr.web.servlet.selects;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import sgbr.fachada.FachadaSGBR;
import sgbr.util.OTDFuncionario;
import sgbr.util.web.SelectGenerico;

/**
 * @author Reinaldo
 *
 */
public class SelectFuncionario extends SelectGenerico {

	private static SelectFuncionario aSelectFuncionario = new SelectFuncionario();

	private SelectFuncionario() {
		super();
	}

	public static SelectFuncionario getInstancia() {
		if (SelectFuncionario.aSelectFuncionario == null) {
			SelectFuncionario.aSelectFuncionario = new SelectFuncionario();
		}

		return SelectFuncionario.aSelectFuncionario;
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

		return this.getHTML(pRequest, pNmSelect, pIdSelect, pCampoSelecionado, pObrigatorio, pComTodos, false);

	}

	public String getHTML(HttpServletRequest pRequest, String pNmSelect, String pIdSelect, String pCampoSelecionado,
			boolean pObrigatorio, boolean pComTodos, boolean pIsFuncionarioSemUsuario) throws Exception {

		String html = "";
		Collection<OTDFuncionario> colecao = null;

		colecao = (Collection<OTDFuncionario>) FachadaSGBR.getInstancia()
				.consultaTodosRegistrosFuncionario(pIsFuncionarioSemUsuario);

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

		Iterator it;
		StringBuffer bufferHtml = new StringBuffer(200);
		OTDFuncionario otdFuncionario = null;

		this.criarSelect(pNmSelect, pIdSelect, bufferHtml, pObrigatorio, pComTodos);

		it = pColecao.iterator();
		while (it.hasNext()) {
			otdFuncionario = (OTDFuncionario) it.next();
			this.valoresOptions(bufferHtml, pCampoSelecionado, otdFuncionario.getCdFuncionario().toString(),
					otdFuncionario.getNmFuncionario());

		}

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}

}
