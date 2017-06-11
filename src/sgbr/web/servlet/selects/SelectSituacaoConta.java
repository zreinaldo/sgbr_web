/**
 * 
 */
package sgbr.web.servlet.selects;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import sgbr.util.Constantes;
import sgbr.util.web.SelectGenerico;

/**
 * @author Reinaldo
 *
 */
public class SelectSituacaoConta extends SelectGenerico {

	private static SelectSituacaoConta aSelectSituacaoConta = new SelectSituacaoConta();

	private SelectSituacaoConta() {
		super();
	}

	public static SelectSituacaoConta getInstancia() {
		if (SelectSituacaoConta.aSelectSituacaoConta == null) {
			SelectSituacaoConta.aSelectSituacaoConta = new SelectSituacaoConta();
		}

		return SelectSituacaoConta.aSelectSituacaoConta;
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
		
			this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.SI_CONTA_SITUACAO_ABERTA, Constantes.DS_CONTA_SITUACAO_ABERTA);
			this.valoresOptions(bufferHtml, pCampoSelecionado, Constantes.SI_CONTA_SITUACAO_ENCERRADA, Constantes.DS_CONTA_SITUACAO_ENCERRADA);

		this.finalizarSelect(bufferHtml);

		return bufferHtml.toString();
	}


}
