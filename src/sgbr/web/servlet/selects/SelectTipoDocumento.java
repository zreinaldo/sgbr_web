/**
 * 
 */
package sgbr.web.servlet.selects;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import sgbr.entidades.TipoDocumento;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.web.SelectGenerico;

/**
 * @author Reinaldo
 *
 */
public class SelectTipoDocumento extends SelectGenerico {

	private static SelectTipoDocumento aSelectTipoDocumento = new SelectTipoDocumento();

	private SelectTipoDocumento() {
		super();
	}

	public static SelectTipoDocumento getInstancia() {
		if (SelectTipoDocumento.aSelectTipoDocumento == null) {
			SelectTipoDocumento.aSelectTipoDocumento = new SelectTipoDocumento();
		}

		return SelectTipoDocumento.aSelectTipoDocumento;
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
		Collection<TipoDocumento> colecao = null;

		colecao = FachadaSGBR.getInstancia().consultaTodosRegistrosTipoDocumento(true);

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
		TipoDocumento tipoFuncionario = null;

		this.criarSelect(pNmSelect, pIdSelect, bufferHtml, pObrigatorio, pComTodos);

		it = pColecao.iterator();
		while (it.hasNext()) {
			tipoFuncionario = (TipoDocumento) it.next();
			this.valoresOptions(bufferHtml, pCampoSelecionado, tipoFuncionario.getTpDocumento().toString(),
					tipoFuncionario.getDsDocumento());

		}

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}

}
