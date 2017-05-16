package sgbr.util.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * processador de requisicao 
 * metodos comuns a todos os servlets
 * 
 * @author Reinaldo
 *
 */
public abstract class ProcessadorRequisicao extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4175700659909543233L;

	/**
	 * parametro/atributo do request que representa o metodo da servlet que sera
	 * executado
	 */
	public static final String ID_REQ_EVENTO = "evento";

	/**
	 * Evento que exibe a consulta do servlert
	 */
	public static final String EVENTO_EXIBIR_CONSULTA = "exibirConsulta";

	/**
	 * Evento que processa a consulta do servlet
	 */
	public static final String EVENTO_PROCESSAR_CONSULTA = "processarConsulta";

	/**
	 * Evento que exibea inclusao do servlet
	 */
	public static final String EVENTO_EXIBIR_INCLUSAO = "exibirInclusao";

	/**
	 * Evento que processa a inclusao ...
	 */
	public static final String EVENTO_PROCESSAR_INCLUSAO = "processarInclusao";

	/**
	 * Evento que exibe a alteracao ...
	 */
	public static final String EVENTO_EXIBIR_ALTERACAO = "exibirAlteracao";

	/**
	 * Evento que processa a alteracao.
	 */
	public static final String EVENTO_PROCESSAR_ALTERACAO = "processarAlteracao";

	/**
	 * Evento que exibe a exclusao ...
	 */
	public static final String EVENTO_EXIBIR_EXCLUSAO = "exibirExclusao";

	/**
	 * Evento que processa a exclusao
	 */
	public static final String EVENTO_PROCESSAR_EXCLUSAO = "processarExclusao";

	/**
	 * Evento que exibe detalhe da consulta
	 */
	public static final String EVENTO_EXIBIR_DETALHAMENTO_CONSULTA = "exibirDetalhamentoConsulta";
	
	/**
	 * implementao doget
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processar(request, response);
	}

	/**
	 * implementa o doPost
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processar(request, response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public abstract void processar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * redireciona para uma jsp
	 * 
	 * @param pNmRecurso
	 * @param pRequest
	 * @param pResponse
	 * @throws Exception
	 */
	public void redirecionar(String pNmRecurso, HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {

		this.getServletContext().getRequestDispatcher(pNmRecurso).forward(pRequest, pResponse);

	}

	/**
	 * pega o caminho do contexto
	 * 
	 * @param pRequest
	 * @return
	 */
	public static String getNmContextoWeb(HttpServletRequest pRequest) {
		String nmContextoWeb = pRequest.getContextPath();

		nmContextoWeb = nmContextoWeb.substring(1);

		return nmContextoWeb;
	}

	/**
	 * - retorna o evento
	 *
	 * @param pRequest
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroRequestInvalido
	 */
	@SuppressWarnings("static-access")
	public String getEvento(HttpServletRequest pRequest) throws Exception {
		String evento = this.getAtributoOuParametroStringOpcional(this.ID_REQ_EVENTO, pRequest);

		if (evento.equals("")) {
			evento = this.getEventoPadrao();
		}
		return evento;
	}

	/**
	 * -
	 *
	 * @param pRequest
	 *
	 * @return
	 */
	public static String getNmPR(HttpServletRequest pRequest) {
		String nmPR = pRequest.getServletPath();

		nmPR = nmPR.substring(1);

		return nmPR;
	}

	/**
	 * retorna um atributo do request
	 * 
	 * @param pNmAtributo
	 * @param pRetornarVazioSeAtributoNaoEncontrado
	 * @param pRequest
	 * @return
	 * @throws Exception
	 */
	public static String getAtributoStringOpcional(String pNmAtributo, boolean pRetornarVazioSeAtributoNaoEncontrado,
			HttpServletRequest pRequest) throws Exception {

		String strAux = ((String) pRequest.getAttribute(pNmAtributo));

		if (strAux != null) {
			strAux = strAux.trim();
		} else if (pRetornarVazioSeAtributoNaoEncontrado) {
			strAux = "";
		}

		return strAux;
	}

	/**
	 *  retorna um parametro do request
	 *  
	 * @param pNmAtributo
	 * @param pRetornarVazioSeParametroNaoEncontrado
	 * @param pRequest
	 * @return
	 * @throws Exception
	 */
	public static String getParametroStringOpcional(String pNmAtributo, boolean pRetornarVazioSeParametroNaoEncontrado,
			HttpServletRequest pRequest) throws Exception {

		String strAux =  pRequest.getParameter(pNmAtributo);

		if (strAux != null) {
			strAux = strAux.trim();
		} else if (pRetornarVazioSeParametroNaoEncontrado) {
			strAux = "";
		}

		return strAux;
	}

	/**
	 * pega o atributo ou o parametro do request
	 * 
	 * @param pNmAtributo
	 * @param pRequest
	 * @return
	 * @throws Exception
	 */
	public static String getAtributoOuParametroStringOpcional(String pNmAtributo, HttpServletRequest pRequest)
			throws Exception {
		String strAux = "";

		strAux = ProcessadorRequisicao.getAtributoStringOpcional(pNmAtributo, false, pRequest);

		if (strAux == null) {
			strAux = ProcessadorRequisicao.getParametroStringOpcional(pNmAtributo, true, pRequest);
		}

		return strAux;
	}

	/**
	 * Método utilizado para se obter o evento padrao da servlet
	 *
	 * @return
	 */
	public abstract String getEventoPadrao();

}
