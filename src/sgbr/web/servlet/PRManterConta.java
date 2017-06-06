package sgbr.web.servlet;

import java.sql.Date;

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

	public static final String ID_REQ_ATR_cdConta = "cdConta";
	public static final String ID_REQ_ATR_cdComanda= "cdComanda";
	public static final String ID_REQ_ATR_cdMesa= "cdMesa";
	public static final String ID_REQ_ATR_cdCliente= "cdCliente";
	public static final String ID_REQ_ATR_vlTotal= "vlTotal";
	public static final String ID_REQ_ATR_vlDesconto= "vlDesconto";
	public static final String ID_REQ_ATR_percDesconto= "percDesconto";
	public static final String ID_REQ_ATR_dhEncerramento= "dhEncerramento";
    public static final String ID_REQ_ATR_inContaMesa= "inContaMesa";

	
	public static final String ID_REQ_ATR_otdConta = "OTDConta";
	public static final String ID_REQ_ATR_radio_consulta_conta = "radio_consulta_conta";

	public static final String NM_SERVLET = "PRManterConta";
	
	public static final String NM_JSP_CONSULTA = "/jsp/manter_conta/consulta.jsp";
	public static final String NM_JSP_ABRIR_CONTA = "/jsp/manter_conta/abrirconta.jsp";
	public static final String NM_JSP_CONTA_PARCIAL = "/jsp/manter_conta/contaparcial.jsp";
	public static final String NM_JSP_ENCERRAR_CONTA = "/jsp/manter_conta/encerrarconta.jsp";

	public static final String EVENTO_EXIBIR_ABRIR_CONTA = "exibirAbrirConta";
	public static final String EVENTO_PROCESSAR_ABRIR_CONTA = "processarAbrirConta";
	
	
	protected FachadaSGBR aFachadaSGBR;

	public void init() throws ServletException {
		this.aFachadaSGBR = FachadaSGBR.getInstancia();
	}

	/* (non-Javadoc)
	 * @see sgbr.util.web.PRConsultar#exibirConsulta(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirConsulta(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		
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
	
	public void exibirAbrirConta(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		
		this.redirecionar(this.NM_JSP_ABRIR_CONTA, pRequest, pResponse);
	}
	
	public void processarAbrirConta(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		
		System.out.println("individual");
	}

}
