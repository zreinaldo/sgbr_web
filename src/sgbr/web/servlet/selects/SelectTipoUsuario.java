/**
 * 
 */
package sgbr.web.servlet.selects;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import sgbr.entidades.TipoUsuario;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.web.SelectGenerico;

/**
 * @author Reinaldo
 *
 */
public class SelectTipoUsuario extends SelectGenerico {

	private static SelectTipoUsuario aSelectTipoUsuario = new SelectTipoUsuario();

	private SelectTipoUsuario() {
		super();
	}

	public static SelectTipoUsuario getInstancia() {
		if (SelectTipoUsuario.aSelectTipoUsuario == null) {
			SelectTipoUsuario.aSelectTipoUsuario = new SelectTipoUsuario();
		}

		return SelectTipoUsuario.aSelectTipoUsuario;
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
		Collection<TipoUsuario> colecao = null;

		colecao = FachadaSGBR.getInstancia().consultaTodosRegistrosTipoUsuario(true);

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
		TipoUsuario tipoUsuario = null;

		this.criarSelect(pNmSelect, pIdSelect, bufferHtml, pObrigatorio, pComTodos);

		it = pColecao.iterator();
		while (it.hasNext()) {
			tipoUsuario = (TipoUsuario) it.next();
			this.valoresOptions(bufferHtml, pCampoSelecionado, tipoUsuario.getCdTpUsuario().toString(),
					tipoUsuario.getNmTpUsuario());

		}

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}


}
