package sgbr.web.servlet.teste;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.util.web.PRConsultar;

/**
 * Servlet implementation class TesteServlet
 */
@WebServlet("/TesteServlet")
public class TesteServlet extends PRConsultar {

	
	/**
	 * -
	 */
	public static final String NM_JSP_CONSULTA = "/jsp/teste/NewFile.jsp";

	@SuppressWarnings("unused")
	@Override
	public void exibirConsulta(HttpServletRequest request, HttpServletResponse response) throws Exception {

	@SuppressWarnings("static-access")
	
	String vl3 = this.getParametroStringOpcional("teste",true,request);
	String vl2 = this.getParametroStringOpcional(this.ID_REQ_EVENTO,true,request);
	String vl4= this.getAtributoStringOpcional(this.ID_REQ_EVENTO,true,request);
	
	
	
	request.setAttribute("enviado", vl3);
	
	
		this.redirecionar(this.NM_JSP_CONSULTA, request, response);
		
	}

	@Override
	public void processarConsulta(HttpServletRequest request, HttpServletResponse response) throws Exception {

		this.redirecionar(this.NM_JSP_CONSULTA, request, response);
	}

	@Override
	public void exibirDetalhamentoConsulta(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
