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
public class SelectComanda extends SelectGenerico {

	/* (non-Javadoc)
	 * @see sgbr.util.web.SelectGenerico#getHTML(javax.servlet.http.HttpServletRequest, java.lang.String, java.lang.String, java.lang.String, boolean, boolean)
	 */
	@Override
	public String getHTML(HttpServletRequest pRequest, String pNmSelect, String pIdSelect, String pCampoSelecionado,
			boolean pObrigatorio, boolean pComTodos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see sgbr.util.web.SelectGenerico#getColecaoComoHTMLSelect(java.util.Collection, java.lang.String, java.lang.String, java.lang.String, boolean, boolean)
	 */
	@Override
	protected String getColecaoComoHTMLSelect(Collection<?> pColecao, String pNmSelect, String pIdSelect,
			String pCampoSelecionado, boolean pObrigatorio, boolean pComTodos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
