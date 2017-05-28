/**
 * 
 */
package sgbr.web.servlet;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.entidades.TipoFuncionario;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.OTDTipoFuncionario;
import sgbr.util.Util;
import sgbr.util.web.PRManterCadastro;

/**
 * @author Reinaldo
 *
 */
@WebServlet("/PRManterTipoFuncionario")
public class PRManterTipoFuncionario extends PRManterCadastro{
	
	public static final String ID_REQ_ATR_cdTipoFuncionario = "cdTipoFuncionario";
	public static final String ID_REQ_ATR_dsTipoFuncionario = "dsTipoFuncionario";
	
	public static final String ID_REQ_ATR_dtIniVigencia = "dtIniVigencia";
	public static final String ID_REQ_ATR_dtFimVigencia = "dtFimVigencia";
	
	public static final String ID_REQ_ATR_TipoFuncionario = "TipoFuncionario";
	public static final String ID_REQ_ATR_otdTipoFuncionario = "OTDTipoFuncionario";
	public static final String ID_REQ_ATR_radio_consulta_tipo_funcionario = "radio_consulta_tipo_funcionario" ;
	
	public static final String NM_SERVLET = "PRManterTipoFuncionario";
	public static final String NM_JSP_CONSULTA = "/jsp/manter_tipo_funcionario/consulta.jsp";
	public static final String NM_JSP_INCLUIR = "/jsp/manter_tipo_funcionario/incluir.jsp";
	public static final String NM_JSP_ALTERAR = "/jsp/manter_tipo_funcionario/alterar.jsp";
	public static final String NM_JSP_DETALHAR = "/jsp/manter_tipo_funcionario/detalhar.jsp";

	
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
		TipoFuncionario tipoFuncionario = new TipoFuncionario();
		
		String dsTipoFuncionario = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_dsTipoFuncionario, pRequest);
		tipoFuncionario.setDsTpFuncionario(dsTipoFuncionario);
		
		this.aFachadaSGBR.incluirTipoFuncionario(tipoFuncionario);
		
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

		String	valueRadio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_tipo_funcionario, pRequest);

		TipoFuncionario tipoFuncionario =  new TipoFuncionario();
		tipoFuncionario.setCdTpFuncionario(Integer.valueOf(valueRadio));
		tipoFuncionario = this.aFachadaSGBR.consultaTipoFuncionarioPorChavePrimaria(tipoFuncionario);		
		pRequest.setAttribute(this.ID_REQ_ATR_TipoFuncionario, tipoFuncionario);
		
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
   
		String cdTipoFuncionario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdTipoFuncionario, pRequest);
		String dsTipoFuncionario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_dsTipoFuncionario, pRequest);
		String dtFimVigencia = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_dtFimVigencia, pRequest);

         TipoFuncionario tipoFuncionario = new TipoFuncionario();
         tipoFuncionario.setCdTpFuncionario(Integer.valueOf(cdTipoFuncionario));    
         tipoFuncionario.setDsTpFuncionario(dsTipoFuncionario);    
         tipoFuncionario.setDtFimVigencia(!dtFimVigencia.isEmpty() ? Util.formataData(dtFimVigencia) : null);
		this.aFachadaSGBR.alterarTipoFuncionario(tipoFuncionario);
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


		String cdTipoFuncionario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_tipo_funcionario, pRequest);
		
         TipoFuncionario tipoFuncionario = new TipoFuncionario();
         tipoFuncionario.setCdTpFuncionario(Integer.valueOf(cdTipoFuncionario));
         
         tipoFuncionario = this.aFachadaSGBR.consultaTipoFuncionarioPorChavePrimaria(tipoFuncionario);
        
        pRequest.setAttribute(this.ID_REQ_ATR_TipoFuncionario, tipoFuncionario);

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

		String cdTipoFuncionario = this.getAtributoOuParametroStringOpcional(PRManterTipoFuncionario.ID_REQ_ATR_cdTipoFuncionario,pRequest);
				
				
		TipoFuncionario tipoFuncionario = new TipoFuncionario();
		tipoFuncionario.setCdTpFuncionario(Integer.valueOf(cdTipoFuncionario));

     	this.aFachadaSGBR.excluirTipoFuncionario(tipoFuncionario);
		
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
		
		String cdTipoFuncionario = this.getParametroStringOpcional(this.ID_REQ_ATR_cdTipoFuncionario, true, pRequest);
		 String dsTipoFuncionario = this.getParametroStringOpcional(this.ID_REQ_ATR_dsTipoFuncionario, true, pRequest);
		ArrayList<OTDTipoFuncionario> otdResposta = this.aFachadaSGBR.consultaTelaManterTipoFuncionario(cdTipoFuncionario, dsTipoFuncionario);
		
		pRequest.setAttribute(this.ID_REQ_ATR_otdTipoFuncionario, otdResposta);
		
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
		String cdTipoFuncionario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_tipo_funcionario, pRequest);
		
         TipoFuncionario tipoFuncionario = new TipoFuncionario();
         tipoFuncionario.setCdTpFuncionario(Integer.valueOf(cdTipoFuncionario));
         
         tipoFuncionario = this.aFachadaSGBR.consultaTipoFuncionarioPorChavePrimaria(tipoFuncionario);
        
      pRequest.setAttribute(this.ID_REQ_ATR_TipoFuncionario, tipoFuncionario);
      pRequest.setAttribute(this.ID_REQ_indicadorExclusao, false);
		
		
		this.redirecionar(this.NM_JSP_DETALHAR, pRequest, pResponse);
	}

}
