package sgbr.util.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PRGenerica
 */
@SuppressWarnings("serial")
public abstract class PRGenerica extends ProcessadorRequisicao {

	public void processar(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws ServletException, IOException {
		try {

			//pega o evento definido no botao
			String nmEvento = this.getEvento(pRequest);

			// Obtem método correspondente ao evento solicitado
			Method metodo = this.getClass().getMethod(nmEvento,
					new Class[] { HttpServletRequest.class, HttpServletResponse.class });

			// Executa evento solicitado na requisição
			metodo.invoke(this, new Object[] { pRequest, pResponse });

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
