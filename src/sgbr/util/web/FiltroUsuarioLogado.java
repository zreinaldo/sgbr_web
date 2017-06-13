package sgbr.util.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sgbr.util.OTDUsuario;

/**
 * 
 * filtro utilizado para verificar se tem usuario logado Servlet Filter
 * implementation class FiltroUsuarioLogado
 */

@WebFilter("/*")
public class FiltroUsuarioLogado implements Filter {

	/**
	 * Default constructor.
	 */
	public FiltroUsuarioLogado() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy filter");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) request).getSession();

		OTDUsuario usuario = (OTDUsuario) session.getAttribute("usuario");

		if (usuario == null) {
			session.setAttribute("usuario", new OTDUsuario());

			((HttpServletResponse) response).sendRedirect("/sgbr_web/PRLoginUsuario");

		} else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init filter");
	}

}
