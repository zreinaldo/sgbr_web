/**
 * 
 */
package sgbr.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sgbr.entidades.Usuario;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.OTDUsuario;
import sgbr.util.web.PRGenerica;

/**
 * @author Reinaldo
 *
 */
@WebServlet("/PRLoginUsuario")
public class PRLoginUsuario extends PRGenerica {

	public static final String EVENTO_EXIBIR_LOGIN_USUARIO = "exibirLoginUsuario";
	public static final String EVENTO_PROCESSAR_LOGIN_USUARIO = "processarLoginUsuario";
	
	public static final String EVENTO_PROCESSAR_DESLOGAR_USUARIO = "processarDeslogarUsuario";

	public static final String ID_REQ_ATR_loginUsuario = "loginUsuario";
	public static final String ID_REQ_ATR_senhaUsuario = "senhaUsuario";
	public static final String ID_REQ_ATR_isLoginSenhaInvalida = "isLoginSenhaInvalida";

	public static final String ID_REQ_ATR_Usuario = "Usuario";
	public static final String ID_REQ_ATR_otdUsuario = "OTDUsuario";
	

	public static final String NM_SERVLET = "PRLoginUsuario";
	public static final String NM_JSP_LOGIN = "/jsp/login_usuario/login.jsp";

	private FachadaSGBR aFachadaSGBR;

	public void init() throws ServletException {
		this.aFachadaSGBR = FachadaSGBR.getInstancia();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public final String getEventoPadrao() {
		return this.EVENTO_EXIBIR_LOGIN_USUARIO;
	}

	public void exibirLoginUsuario(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		pRequest.setAttribute(this.ID_REQ_ATR_isLoginSenhaInvalida, false);
		this.redirecionar(this.NM_JSP_LOGIN, pRequest, pResponse);
	}

	public void processarLoginUsuario(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		OTDUsuario otdUsuario = new OTDUsuario();

		String loginUsuario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_loginUsuario, pRequest);
		String senhaUsuario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_senhaUsuario, pRequest);
		

		 HttpSession session = ((HttpServletRequest)pRequest).getSession();
		 
		 session.removeAttribute("usuario");
		

		otdUsuario = this.aFachadaSGBR.consultaUsuarioSenha(loginUsuario, senhaUsuario);
		if (otdUsuario == null) {

			pRequest.setAttribute(this.ID_REQ_ATR_isLoginSenhaInvalida, true);
			this.redirecionar(this.NM_JSP_LOGIN, pRequest, pResponse);
		} else {			
	     	 session.setAttribute("usuario", otdUsuario);
			this.redirecionar(PRManterConta.NM_SERVLET, PRManterConta.NM_JSP_CONSULTA, pRequest, pResponse);
		}

	}
	
	public void processarDeslogarUsuario(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		

		 HttpSession session = ((HttpServletRequest)pRequest).getSession();
		 
		 session.removeAttribute("usuario");
		

	 this.exibirLoginUsuario(pRequest, pResponse);

	}

}
