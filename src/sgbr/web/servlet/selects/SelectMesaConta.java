/**
 * 
 */
package sgbr.web.servlet.selects;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import sgbr.entidades.Mesa;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.Constantes;
import sgbr.util.web.SelectGenerico;

/**
 * @author Reinaldo
 *
 */
public class SelectMesaConta extends SelectGenerico {

	private static SelectMesaConta aSelectConta = new SelectMesaConta();

	private SelectMesaConta() {
		super();
	}

	public static SelectMesaConta getInstancia() {
		if (SelectMesaConta.aSelectConta == null) {
			SelectMesaConta.aSelectConta = new SelectMesaConta();
		}

		return SelectMesaConta.aSelectConta;
	}

	public String getHTML(HttpServletRequest pRequest, String pNmSelect, String pIdSelect, String pCampoSelecionado,
			boolean pObrigatorio, boolean pComTodos, String pInUso,String pCdTipoConta) throws Exception {

		String html = "";
		Collection<Mesa> colecao = null;

		colecao = (Collection<Mesa>) FachadaSGBR.getInstancia().consultaMesaConta(pInUso, pCdTipoConta);

		html = this.getColecaoComoHTMLSelect(colecao, pNmSelect, pIdSelect, pCampoSelecionado, pObrigatorio, pComTodos);

		return html;

	}

	public String getHTML(HttpServletRequest pRequest, String pNmSelect, String pIdSelect, String pCampoSelecionado,
			boolean pObrigatorio, boolean pComTodos, String pInUso) throws Exception{
		return this.getHTML(pRequest, pNmSelect, pIdSelect, pCampoSelecionado, pObrigatorio, pComTodos, pInUso,null);
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

		return this.getHTML(pRequest, pNmSelect, pIdSelect, pCampoSelecionado, pObrigatorio, pComTodos, Constantes.CD_NAO,null);
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
		Mesa mesa = null;

		this.criarSelect(pNmSelect, pIdSelect, bufferHtml, pObrigatorio, pComTodos);

		it = pColecao.iterator();
		while (it.hasNext()) {
			mesa = (Mesa) it.next();
			this.valoresOptions(bufferHtml, pCampoSelecionado, mesa.getCdMesa().toString(),
					mesa.getCdMesa().toString());

		}

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}

}
