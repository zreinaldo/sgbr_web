package sgbr.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.fachada.FachadaSGBR;
import sgbr.util.web.PRConsultar;

/**
 * Servlet implementation class PRManterConta
 */
@WebServlet("/PRManterConta")
public class PRManterConta extends PRConsultar {
	private static final long serialVersionUID = 1L;


	public static final String EVENTO_ABRIR_CONTA = "abrirConta";
	
	public static final String ID_REQ_ATR_otdConta = "OTDConta";
	public static final String ID_REQ_ATR_radio_consulta_conta = "radio_consulta_conta";

	public static final String NM_SERVLET = "PRManterConta";
	
	public static final String NM_JSP_CONSULTA = "/jsp/manter_conta/consulta.jsp";
	public static final String NM_JSP_ABRIR_CONTA = "/jsp/manter_conta/abrirconta.jsp";
	public static final String NM_JSP_CONTA_PARCIAL = "/jsp/manter_conta/contaparcial.jsp";
	public static final String NM_JSP_ENCERRAR_CONTA = "/jsp/manter_conta/encerrarconta.jsp";

	
	private boolean inContaMesa;

	
	protected FachadaSGBR aFachadaSGBR;

	public void init() throws ServletException {
		this.aFachadaSGBR = FachadaSGBR.getInstancia();
	}

	/* (non-Javadoc)
	 * @see sgbr.util.web.PRConsultar#exibirConsulta(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirConsulta(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		
		boolean bo = this.isInContaMesa();
		
		if(bo) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		this.redirecionar(this.NM_JSP_CONSULTA, pRequest, pResponse);
 
		
	}

	/* (non-Javadoc)
	 * @see sgbr.util.web.PRConsultar#processarConsulta(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void processarConsulta(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see sgbr.util.web.PRConsultar#exibirDetalhamentoConsulta(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirDetalhamentoConsulta(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void incluirComandaIndividual(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		
		System.out.println("individual");
	}
	

	/**
	 * @return the inContaMesa
	 */
	public boolean isInContaMesa() {
		return this.inContaMesa;
	}


}
