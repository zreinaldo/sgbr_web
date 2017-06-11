/**
 * 
 */
package sgbr.web.servlet;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.entidades.Comanda;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.Constantes;
import sgbr.util.OTDComanda;
import sgbr.util.Util;
import sgbr.util.web.PRManterCadastro;

/**
 * @author Reinaldo
 *
 */
@WebServlet("/PRManterComanda")
public class PRManterComanda extends PRManterCadastro{
	
	public static final String ID_REQ_ATR_cdComanda = "cdComanda";
	public static final String ID_REQ_ATR_dtIniVigencia = "dtIniVigencia";
	public static final String ID_REQ_ATR_dtFimVigencia = "dtFimVigencia";
	public static final String ID_REQ_ATR_inVigentes = "inVigentes";
	public static final String ID_REQ_ATR_qtdComandas = "qtdComandas";
	
	public static final String ID_REQ_ATR_comanda = "Comanda";
	
	public static final String ID_REQ_ATR_otdComanda = "OTDComanda";
	public static final String ID_REQ_ATR_radio_consulta_comanda = "radio_consulta_comanda" ;
	
	public static final String NM_SERVLET = "PRManterComanda";
	public static final String NM_JSP_CONSULTA = "/jsp/manter_comanda/consulta.jsp";
	public static final String NM_JSP_INCLUIR = "/jsp/manter_comanda/incluir.jsp";
	public static final String NM_JSP_ALTERAR = "/jsp/manter_comanda/alterar.jsp";
	public static final String NM_JSP_DETALHAR = "/jsp/manter_comanda/detalhar.jsp";

	
	private FachadaSGBR aFachadaSGBR;

	public void init() throws ServletException {
		this.aFachadaSGBR = FachadaSGBR.getInstancia();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.PRManterCadastro#exibirInclusao(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirInclusao(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		this.redirecionar(this.NM_JSP_INCLUIR, pRequest, pResponse);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.PRManterCadastro#processarInclusao(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("static-access")
	@Override
	public void processarInclusao(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {

		String qtdComandas = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_qtdComandas, pRequest);
		

		
		this.aFachadaSGBR.incluirComanda(Integer.valueOf(qtdComandas));
		
		this.redirecionar(this.NM_JSP_CONSULTA, pRequest, pResponse);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.PRManterCadastro#exibirAlteracao(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirAlteracao(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {

		String	valueRadio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_comanda, pRequest);

		Comanda comanda =  new Comanda();
		comanda.setCdComanda(Integer.valueOf(valueRadio));
		comanda = this.aFachadaSGBR.consultaComandaPorChavePrimaria(comanda);		
		pRequest.setAttribute(this.ID_REQ_ATR_comanda, comanda);
		
		this.redirecionar(this.NM_JSP_ALTERAR, pRequest, pResponse);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.util.web.PRManterCadastro#processarAlteracao(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void processarAlteracao(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
   
		String cdComanda = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdComanda, pRequest);
		String dtIniVigencia = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_dtIniVigencia, pRequest);
		String dtFimVigencia = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_dtFimVigencia, pRequest);

         Comanda comanda = new Comanda();
         comanda.setCdComanda(Integer.valueOf(cdComanda));         
         comanda.setDtIniValidade(!dtIniVigencia.isEmpty() ? Util.formataData(dtIniVigencia) : null);
         comanda.setDtFimValidade(!dtFimVigencia.isEmpty() ? Util.formataData(dtFimVigencia) : null);
		this.aFachadaSGBR.alterarComanda(comanda);
//		
		
		
		this.redirecionar(this.NM_JSP_CONSULTA, pRequest, pResponse);
		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.PRManterCadastro#exibirExclusao(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirExclusao(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {


		String cdComanda = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_comanda, pRequest);
		
         Comanda comanda = new Comanda();
         comanda.setCdComanda(Integer.valueOf(cdComanda));
         
         comanda = this.aFachadaSGBR.consultaComandaPorChavePrimaria(comanda);
        
        pRequest.setAttribute(this.ID_REQ_ATR_comanda, comanda);

		pRequest.setAttribute(this.ID_REQ_indicadorExclusao, true);
		
		this.redirecionar(this.NM_JSP_DETALHAR, pRequest, pResponse);
	

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.PRManterCadastro#processarExclusao(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void processarExclusao(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {

		String cdComanda = this.getAtributoOuParametroStringOpcional(PRManterComanda.ID_REQ_ATR_cdComanda,pRequest);
				
				
		Comanda comanda = new Comanda();
		comanda.setCdComanda(Integer.valueOf(cdComanda));

     	this.aFachadaSGBR.excluirComanda(comanda);
		
		this.redirecionar(this.NM_JSP_CONSULTA, pRequest, pResponse);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.PRConsultar#exibirConsulta(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirConsulta(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		this.redirecionar(this.NM_JSP_CONSULTA, pRequest, pResponse);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.PRConsultar#processarConsulta(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void processarConsulta(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		
		String cdComanda = this.getParametroStringOpcional(this.ID_REQ_ATR_cdComanda, true, pRequest);
		String inVigentes = this.getParametroStringOpcional(this.ID_REQ_ATR_inVigentes, true, pRequest);
		
		
		if(inVigentes.equals(Constantes.CD_TODOS)) {
			inVigentes = "";
		}
		
		ArrayList<OTDComanda> otdResposta = this.aFachadaSGBR.consultaTelaManterComanda(cdComanda, inVigentes);
		
		pRequest.setAttribute(this.ID_REQ_ATR_otdComanda, otdResposta);
		
		pRequest.setAttribute(this.ID_REQ_indicadorExclusao, false);
		this.redirecionar(this.NM_JSP_CONSULTA, pRequest, pResponse);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.util.web.PRConsultar#exibirDetalhamentoConsulta(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirDetalhamentoConsulta(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		String cdComanda = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_comanda, pRequest);
		
         Comanda comanda = new Comanda();
         comanda.setCdComanda(Integer.valueOf(cdComanda));
         
         comanda = this.aFachadaSGBR.consultaComandaPorChavePrimaria(comanda);
        
      pRequest.setAttribute(this.ID_REQ_ATR_comanda, comanda);
		pRequest.setAttribute(this.ID_REQ_indicadorExclusao, false);
		
		
		this.redirecionar(this.NM_JSP_DETALHAR, pRequest, pResponse);
	}

}
