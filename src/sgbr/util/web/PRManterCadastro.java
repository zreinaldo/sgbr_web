/**
 * 
 */
package sgbr.util.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Reinaldo
 *
 */
public abstract class PRManterCadastro extends PRConsultar {
	
	public static final String ID_REQ_indicadorExclusao = "indicador_exclusao";
	

	/**
	 * -
	 *
	 * @param request
	 * @param response
	 *
	 * @throws Exception
	 */
	public abstract void exibirInclusao(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * -
	 *
	 * @param request
	 * @param response
	 *
	 * @throws Exception
	 */
	public abstract void processarInclusao(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * -
	 *
	 * @param request
	 * @param response
	 *
	 * @throws Exception
	 */
	public abstract void exibirAlteracao(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * -
	 *
	 * @param request
	 * @param response
	 *
	 * @throws Exception
	 */
	public abstract void processarAlteracao(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * -
	 *
	 * @param request
	 * @param response
	 *
	 * @throws Exception
	 */
	public abstract void exibirExclusao(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * -
	 *
	 * @param request
	 * @param response
	 *
	 * @throws Exception
	 */
	public abstract void processarExclusao(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
