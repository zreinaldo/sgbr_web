/**
 * 
 */
package sgbr.web.servlet.selects;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import sgbr.entidades.TipoFuncionario;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.web.SelectGenerico;

/**
 * @author Reinaldo
 *
 */
public class SelectTipoFuncionario extends SelectGenerico {

	private static SelectTipoFuncionario aSelectTipoFuncionario = new SelectTipoFuncionario();

	private SelectTipoFuncionario() {
		super();
	}

	public static SelectTipoFuncionario getInstancia() {
		if (SelectTipoFuncionario.aSelectTipoFuncionario == null) {
			SelectTipoFuncionario.aSelectTipoFuncionario = new SelectTipoFuncionario();
		}

		return SelectTipoFuncionario.aSelectTipoFuncionario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.SelectGenerico#getHTML(javax.servlet.http.
	 * HttpServletRequest, java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getHTML(HttpServletRequest pRequest, String pNmSelect, String pIdSelect, String pCampoSelecionado)
			throws Exception {

		String html = "";
		Collection<TipoFuncionario> colecao = null;

		colecao = FachadaSGBR.getInstancia().consultaTodosRegistrosTipoFuncionario(true);

		html = this.getColecaoComoHTMLSelect(colecao, pNmSelect, pIdSelect, pCampoSelecionado);

		return html;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.SelectGenerico#getColecaoComoHTMLSelect(java.util.
	 * Collection, java.lang.String, java.lang.String, java.lang.String)
	 */
	protected String getColecaoComoHTMLSelect(Collection<?> pColecao, String pNmSelect, String pIdSelect,
			String pCampoSelecionado) throws Exception {

		Iterator it;
		StringBuffer bufferHtml = new StringBuffer(200);
		TipoFuncionario tipoFuncionario = null;

		this.criarSelect(pNmSelect, pIdSelect, bufferHtml,false,true);

		it = pColecao.iterator();
		while (it.hasNext()) {
			tipoFuncionario = (TipoFuncionario) it.next();
			this.valoresOptions(bufferHtml, pCampoSelecionado, tipoFuncionario.getTpFuncionario().toString(),
					tipoFuncionario.getDsFuncionario());

		}

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}

}
