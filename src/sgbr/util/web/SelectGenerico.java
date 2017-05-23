/**
 * 
 */
package sgbr.util.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import sgbr.util.Constantes;

/**
 * @author Reinaldo
 *
 */
public abstract class SelectGenerico {

	/**
	 * deverar se utilizado nas jsps e ira retornar um html de um campo select
	 * 
	 * @param pRequest
	 * @param pNmSelect
	 * @param pIdSelect
	 * @param pCampoSelecionado
	 * @return
	 * @throws Exception
	 */
	public abstract String getHTML(HttpServletRequest pRequest, String pNmSelect, String pIdSelect,
			String pCampoSelecionado) throws Exception;

	/**
	 * deverar ser utilizado para montar o html
	 * 
	 * @param pColecao
	 * @param pNmSelect
	 * @param pIdSelect
	 * @param pCampoSelecionado
	 * @return
	 * @throws Exception
	 */
	protected abstract String getColecaoComoHTMLSelect(Collection<?> pColecao, String pNmSelect, String pIdSelect,
			String pCampoSelecionado) throws Exception;

	/**
	 * @param pNmSelect
	 * @param pIdSelect
	 * @param bufferHtml
	 */
	protected void criarSelect(String pNmSelect, String pIdSelect, StringBuffer bufferHtml, boolean pObrigatorio, boolean pComTodos) {
		bufferHtml.append("<SELECT id=\"");
		bufferHtml.append(pIdSelect);
		bufferHtml.append("\" name=\"");
		bufferHtml.append(pNmSelect);
		bufferHtml.append("\"");
		bufferHtml.append(">");
		
		if (pObrigatorio) {
			bufferHtml.append("<OPTION value=\"\" ");			
			bufferHtml.append(">-Escolha uma opção</OPTION>");
		}
		
		if (pComTodos) {
			bufferHtml.append("<OPTION value=\"");
			bufferHtml.append(Constantes.CD_TODOS);
			bufferHtml.append("\" ");			
			bufferHtml.append(">-Todos</OPTION>");
		}
		
		
	}

	/**
	 * @param pCampoSelecionado
	 * @param bufferHtml
	 * @param tp
	 */
	protected void valoresOptions(StringBuffer bufferHtml, String pCampoSelecionado, String pValue, String pDescricao) {
		bufferHtml.append("<OPTION value=\"");
		bufferHtml.append(pValue);
		bufferHtml.append("\" ");
		if (pCampoSelecionado.equals( pValue)) {
			bufferHtml.append("selected=\"selected\"");
		}
		bufferHtml.append(">");
		bufferHtml.append(pDescricao);
		bufferHtml.append("</OPTION>");
	}

	/**
	 * @param bufferHtml
	 */
	protected void finalizarSelect(StringBuffer bufferHtml) {
		bufferHtml.append("</SELECT>");
	}

}
