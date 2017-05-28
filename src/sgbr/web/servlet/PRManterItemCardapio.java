/**
 * 
 */
package sgbr.web.servlet;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.entidades.ItemCardapio;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.Constantes;
import sgbr.util.OTDItemCardapio;
import sgbr.util.web.PRManterCadastro;

/**
 * @author Reinaldo
 *
 */
@WebServlet("/PRManterItemCardapio")
public class PRManterItemCardapio extends PRManterCadastro{
	
	public static final String ID_REQ_ATR_cdItemCardapio = "cdItemCardapio";
	public static final String ID_REQ_ATR_nmItemCardapio = "nmItemCardapio";
	public static final String ID_REQ_ATR_vlItemCardapio = "vlItemCardapio";
	public static final String ID_REQ_ATR_siItemCardapio = "siItemCardapio";
	public static final String ID_REQ_ATR_dtIniVigencia = "dtIniVigencia";
	public static final String ID_REQ_ATR_dtFimVigencia = "dtFimVigencia";
	
	public static final String ID_REQ_ATR_ItemCardapio = "ItemCardapio";
	public static final String ID_REQ_ATR_otdItemCardapio = "OTDItemCardapio";
	public static final String ID_REQ_ATR_radio_consulta_item_cardapio = "radio_consulta_item_cardapio" ;
	
	public static final String NM_SERVLET = "PRManterItemCardapio";
	public static final String NM_JSP_CONSULTA = "/jsp/manter_item_cardapio/consulta.jsp";
	public static final String NM_JSP_INCLUIR = "/jsp/manter_item_cardapio/incluir.jsp";
	public static final String NM_JSP_ALTERAR = "/jsp/manter_item_cardapio/alterar.jsp";
	public static final String NM_JSP_DETALHAR = "/jsp/manter_item_cardapio/detalhar.jsp";

	
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
		ItemCardapio itemCardapio = new ItemCardapio();
		
		String nmItemCardapio = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_nmItemCardapio, pRequest);
		String vlItemCardapio = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_vlItemCardapio, pRequest);
		String siItemCardapio = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_siItemCardapio, pRequest);
		
		vlItemCardapio = vlItemCardapio.replaceAll(",", ".");
		
		itemCardapio.setNmItemCardapio(nmItemCardapio);
		itemCardapio.setSiItemCardapio(siItemCardapio);
		itemCardapio.setVlItemCardapio(Double.valueOf(vlItemCardapio));
		
		this.aFachadaSGBR.incluirItemCardapio(itemCardapio);
		
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

		String	valueRadio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_item_cardapio, pRequest);

		ItemCardapio itemCardapio =  new ItemCardapio();
		itemCardapio.setCdItemCardapio(Integer.valueOf(valueRadio));
		itemCardapio = this.aFachadaSGBR.consultaItemCardapioPorChavePrimaria(itemCardapio);		
		pRequest.setAttribute(this.ID_REQ_ATR_ItemCardapio, itemCardapio);
		
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
		ItemCardapio itemCardapio = new ItemCardapio();
		String cdItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdItemCardapio, pRequest);
		String nmItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_nmItemCardapio, pRequest);
		String vlItemCardapio = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_vlItemCardapio, pRequest);
		String siItemCardapio = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_siItemCardapio, pRequest);
		
		vlItemCardapio = vlItemCardapio.replaceAll(",", ".");
		
		itemCardapio.setNmItemCardapio(nmItemCardapio);
		itemCardapio.setSiItemCardapio(siItemCardapio);
		itemCardapio.setVlItemCardapio(Double.valueOf(vlItemCardapio));
         itemCardapio.setCdItemCardapio(Integer.valueOf(cdItemCardapio));    
		this.aFachadaSGBR.alterarItemCardapio(itemCardapio);
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


		String cdItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_item_cardapio, pRequest);
		
         ItemCardapio itemCardapio = new ItemCardapio();
         itemCardapio.setCdItemCardapio(Integer.valueOf(cdItemCardapio));
         
         itemCardapio = this.aFachadaSGBR.consultaItemCardapioPorChavePrimaria(itemCardapio);
        
        pRequest.setAttribute(this.ID_REQ_ATR_ItemCardapio, itemCardapio);

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

		String cdItemCardapio = this.getAtributoOuParametroStringOpcional(PRManterItemCardapio.ID_REQ_ATR_cdItemCardapio,pRequest);
				
				
		ItemCardapio itemCardapio = new ItemCardapio();
		itemCardapio.setCdItemCardapio(Integer.valueOf(cdItemCardapio));

     	this.aFachadaSGBR.excluirItemCardapio(itemCardapio);
		
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
		
		String cdItemCardapio = this.getParametroStringOpcional(this.ID_REQ_ATR_cdItemCardapio, true, pRequest);
		String nmItemCardapio = this.getParametroStringOpcional(this.ID_REQ_ATR_nmItemCardapio, true, pRequest);
		String siItemCardapio = this.getParametroStringOpcional(this.ID_REQ_ATR_siItemCardapio, true, pRequest);
		
		if (siItemCardapio.equals(Constantes.CD_TODOS)){
			siItemCardapio = "";
		}
		ArrayList<OTDItemCardapio> otdResposta = this.aFachadaSGBR.consultaTelaManterItemCardapio(cdItemCardapio, nmItemCardapio, siItemCardapio);
		
		pRequest.setAttribute(this.ID_REQ_ATR_otdItemCardapio, otdResposta);
		
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
		String cdItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_item_cardapio, pRequest);
		
         ItemCardapio itemCardapio = new ItemCardapio();
         itemCardapio.setCdItemCardapio(Integer.valueOf(cdItemCardapio));
         
         itemCardapio = this.aFachadaSGBR.consultaItemCardapioPorChavePrimaria(itemCardapio);
        
      pRequest.setAttribute(this.ID_REQ_ATR_ItemCardapio, itemCardapio);
      pRequest.setAttribute(this.ID_REQ_indicadorExclusao, false);
		
		
		this.redirecionar(this.NM_JSP_DETALHAR, pRequest, pResponse);
	}

}
