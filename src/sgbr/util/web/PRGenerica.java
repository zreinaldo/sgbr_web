package sgbr.util.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.fachada.FachadaSGBR;

/**
 * 
 * @author Reinaldo
 *
 */
public abstract class PRGenerica extends ProcessadorRequisicao {

	public static final String NM_JSP_ERRO = "/jsp/util/erro.jsp";

	protected FachadaSGBR aFachadaSGBR;

	public void init() throws ServletException {
		this.aFachadaSGBR = FachadaSGBR.getInstancia();
	}

	// metodo comum que vai chamar os metodos dos servlets
	public void processar(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws ServletException, IOException {
		try {

			// pega o evento definido no botao
			String nmEvento = this.getEvento(pRequest);

			// Obtem método correspondente ao evento solicitado
			Method metodo = this.getClass().getMethod(nmEvento,
					new Class[] { HttpServletRequest.class, HttpServletResponse.class });

			// Executa evento solicitado na requisição
			metodo.invoke(this, new Object[] { pRequest, pResponse });

		} catch (Exception e) {

			//TODO tratamentos de erros
			// vai redirecionar para uma tela simples, informando q tem erro
			// this.getServletContext().getRequestDispatcher(this.NM_JSP_ERRO).forward(pRequest,
			// pResponse);
			e.printStackTrace();

		}
	}

}
