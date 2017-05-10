package sgbr.util.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class PRConsultar extends PRGenerica {

	/**
	 * -
	 *
	 * @param request
	 * @param response
	 *
	 * @throws Exception
	 */
	public abstract void exibirConsulta(HttpServletRequest request, HttpServletResponse response)
		throws Exception;

	/**
	 * -
	 *
	 * @param request
	 * @param response
	 *
	 * @throws Exception
	 */
	public abstract void processarConsulta(HttpServletRequest request, HttpServletResponse response)
		throws Exception;

	/**
	 * -
	 *
	 * @param request
	 * @param response
	 *
	 * @throws Exception
	 */
	public abstract void exibirDetalhamentoConsulta(HttpServletRequest request, HttpServletResponse response)
		throws Exception;


	/**
	 * -
	 *
	 * @return
	 */
	public final String getEventoPadrao() {
		return this.EVENTO_EXIBIR_CONSULTA;
	}
}
