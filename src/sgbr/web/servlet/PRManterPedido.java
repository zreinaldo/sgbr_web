/**
 * 
 */
package sgbr.web.servlet;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.entidades.ContaItemCardapio;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.Constantes;
import sgbr.util.OTDConta;
import sgbr.util.OTDContaItemCardapio;
import sgbr.util.Util;
import sgbr.util.web.PRManterCadastro;

/**
 * @author Reinaldo
 *
 */
@WebServlet("/PRManterPedido")
public class PRManterPedido extends PRManterCadastro{
	
	public static final String ID_REQ_ATR_cdPedido = "cdPedido";
	public static final String ID_REQ_ATR_cdItemCardapio = "cdItemCardapio";
	public static final String ID_REQ_ATR_nmItemCardapio = "nmItemCardapio";
	public static final String ID_REQ_ATR_qtdItemCardapio = "qtdItemCardapio";
	public static final String ID_REQ_ATR_obsItemCardapio = "obsItemCardapio";
	public static final String ID_REQ_ATR_cdComanda= "cdComanda";
	public static final String ID_REQ_ATR_cdMesa= "cdMesa";
	public static final String ID_REQ_ATR_ContaItemCardapio = "ContaItemCardapio";
	public static final String ID_REQ_ATR_otdContaItemPedido = "OTDContaItemPedido";
	public static final String ID_REQ_ATR_radio_consulta_pedido = "radio_consulta_pedido" ;
	
	public static final String NM_SERVLET = "PRManterPedido";
	public static final String NM_JSP_CONSULTA = "/jsp/manter_pedido/consulta.jsp";
	public static final String NM_JSP_INCLUIR = "/jsp/manter_pedido/incluir.jsp";
	public static final String NM_JSP_ALTERAR = "/jsp/manter_pedido/alterar.jsp";
	public static final String NM_JSP_DETALHAR = "/jsp/manter_pedido/detalhar.jsp";

	
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
		ContaItemCardapio contaItemCardapio = new ContaItemCardapio();
		
		String cdItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdItemCardapio, pRequest);
		String qtdItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_qtdItemCardapio, pRequest);
		String obsItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_obsItemCardapio, pRequest);
		
		
		contaItemCardapio.setCdItemCardapio(Util.getInteger(cdItemCardapio));
		contaItemCardapio.setQtdContaItemCardapio(Util.getInteger(qtdItemCardapio));
		contaItemCardapio.setObsContaItemCardapio(obsItemCardapio);
		
		this.aFachadaSGBR.incluirContaItemCardapio(contaItemCardapio);
		
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

		String	valueRadio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_pedido, pRequest);

		ContaItemCardapio itemCardapio =  new ContaItemCardapio();
		itemCardapio.setCdContaItemCardapio(Integer.valueOf(valueRadio));
		itemCardapio = this.aFachadaSGBR.consultaContaItemCardapioPorChavePrimaria(itemCardapio);		
		pRequest.setAttribute(this.ID_REQ_ATR_ContaItemCardapio, itemCardapio);
		
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
		ContaItemCardapio itemCardapio = new ContaItemCardapio();
		String cdContaItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdItemCardapio, pRequest);
		String nmContaItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_nmItemCardapio, pRequest);
		String vlContaItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_vlContaItemCardapio, pRequest);
		String siContaItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_obsItemCardapio, pRequest);
		
		vlContaItemCardapio = vlContaItemCardapio.replaceAll(",", ".");
		
		itemCardapio.setNmContaItemCardapio(nmContaItemCardapio);
		itemCardapio.setSiContaItemCardapio(siContaItemCardapio);
		itemCardapio.setVlContaItemCardapio(Double.valueOf(vlContaItemCardapio));
         itemCardapio.setCdContaItemCardapio(Integer.valueOf(cdContaItemCardapio));    
		this.aFachadaSGBR.alterarContaItemCardapio(itemCardapio);
		
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


		String cdContaItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_pedido, pRequest);
		
         ContaItemCardapio itemCardapio = new ContaItemCardapio();
         itemCardapio.setCdContaItemCardapio(Integer.valueOf(cdContaItemCardapio));
         
         itemCardapio = this.aFachadaSGBR.consultaContaItemCardapioPorChavePrimaria(itemCardapio);
        
        pRequest.setAttribute(this.ID_REQ_ATR_ContaItemCardapio, itemCardapio);

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

		String cdContaItemCardapio = this.getAtributoOuParametroStringOpcional(PRManterPedido.ID_REQ_ATR_cdItemCardapio,pRequest);
				
				
		ContaItemCardapio itemCardapio = new ContaItemCardapio();
		itemCardapio.setCdContaItemCardapio(Integer.valueOf(cdContaItemCardapio));

     	this.aFachadaSGBR.excluirContaItemCardapio(itemCardapio);
		
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
		
		String cdMesa = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdMesa, pRequest);
		String cdComanda = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdComanda, pRequest);
				
		
		if (cdMesa.equals(Constantes.CD_TODOS)) {
			cdMesa = "";
		}
		if (cdComanda.equals(Constantes.CD_TODOS)) {
			cdComanda = "";
		}
		
		
	ArrayList<OTDContaItemCardapio> otdContaItemPedido =  this.aFachadaSGBR.consultaTelaManterPedido(cdMesa, cdComanda );
	
	pRequest.setAttribute(this.ID_REQ_ATR_otdContaItemPedido, otdContaItemPedido);
	
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
		String cdContaItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_pedido, pRequest);
		
         ContaItemCardapio itemCardapio = new ContaItemCardapio();
         itemCardapio.setCdContaItemCardapio(Integer.valueOf(cdContaItemCardapio));
         
         itemCardapio = this.aFachadaSGBR.consultaContaItemCardapioPorChavePrimaria(itemCardapio);
        
      pRequest.setAttribute(this.ID_REQ_ATR_ContaItemCardapio, itemCardapio);
      pRequest.setAttribute(this.ID_REQ_indicadorExclusao, false);
		
		
		this.redirecionar(this.NM_JSP_DETALHAR, pRequest, pResponse);
	}

}
