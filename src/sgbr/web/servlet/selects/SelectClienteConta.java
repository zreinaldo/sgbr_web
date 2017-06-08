/**
 * 
 */
package sgbr.web.servlet.selects;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import sgbr.entidades.Mesa;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.OTDCliente;
import sgbr.util.web.SelectGenerico;

/**
 * @author Reinaldo
 *
 */
public class SelectClienteConta extends SelectGenerico {

	private static SelectClienteConta aSelectConta = new SelectClienteConta();

	private SelectClienteConta() {
		super();
	}

	public static SelectClienteConta getInstancia() {
		if (SelectClienteConta.aSelectConta == null) {
			SelectClienteConta.aSelectConta = new SelectClienteConta();
		}

		return SelectClienteConta.aSelectConta;
	}

	public String getHTML(HttpServletRequest pRequest, String pNmSelect, String pIdSelect, String pCampoSelecionado,
			boolean pObrigatorio, boolean pComTodos, boolean pInUso) throws Exception {

		String html = "";
		Collection<OTDCliente> colecao = null;

		colecao = (Collection<OTDCliente>) FachadaSGBR.getInstancia().consultaClienteConta(pInUso);

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
		OTDCliente otdCliente = null;

		this.criarSelect(pNmSelect, pIdSelect, bufferHtml, pObrigatorio, pComTodos);

		it = pColecao.iterator();
		while (it.hasNext()) {
			otdCliente = (OTDCliente) it.next();
			this.valoresOptions(bufferHtml, pCampoSelecionado, otdCliente.getCdCliente().toString(),
					otdCliente.getNmCliente().toString());

		}

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}

}
