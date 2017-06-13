/**
 * 
 */
package sgbr.web.servlet;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sgbr.entidades.ContaItemCardapio;
import sgbr.fachada.FachadaSGBR;
import sgbr.regras.pedido.RNIncluirPedido;
import sgbr.util.Constantes;
import sgbr.util.OTDContaItemCardapio;
import sgbr.util.OTDUsuario;
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
	public static final String ID_REQ_ATR_cdConta= "cdConta";
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
		
	 String cdConta = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdConta, pRequest);
	 
	 if (cdConta.isEmpty()) {
		 //pode chegar pelo servlet PRMAnterCOnta
		 cdConta = this.getAtributoOuParametroStringOpcional(PRManterConta.ID_REQ_ATR_radio_consulta_conta, pRequest);
	 }
	 
	 
	 pRequest.setAttribute(this.ID_REQ_ATR_cdConta, cdConta);
		
		
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
		String qtdItemCardapio =  this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_qtdItemCardapio, pRequest);
		String obsItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_obsItemCardapio, pRequest);
		String cdConta = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdConta, pRequest);
		
		String cdMesa = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdMesa, pRequest);
		String cdComanda = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdComanda, pRequest);
		
		OTDContaItemCardapio otdContaItemCardapio = new OTDContaItemCardapio();
	    
		otdContaItemCardapio.setCdComanda(Util.getInteger( cdComanda));
		otdContaItemCardapio.setCdItemCardapio(Util.getInteger( cdItemCardapio));
		otdContaItemCardapio.setQtdItemCardapio(Util.getInteger( qtdItemCardapio));
		otdContaItemCardapio.setObsItemCardapio(obsItemCardapio);
		otdContaItemCardapio.setCdConta(Util.getInteger( cdConta));
		otdContaItemCardapio.setCdMesa(Util.getInteger( cdMesa));
		

		HttpSession session = ((HttpServletRequest) pRequest).getSession();
		OTDUsuario usuario = (OTDUsuario) session.getAttribute("usuario");	

		otdContaItemCardapio.setCdFuncionario(usuario.getCdFuncionario());

		this.aFachadaSGBR.incluirPedido(otdContaItemCardapio);
		
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
		
		
		OTDContaItemCardapio otdContaItemCardapio = this.aFachadaSGBR.consultaDetalharPedido(valueRadio);		
		pRequest.setAttribute(this.ID_REQ_ATR_otdContaItemPedido, otdContaItemCardapio);
		
		
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
		ContaItemCardapio contaItemCardapio = new ContaItemCardapio();
		String cdContaItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdPedido, pRequest);
		String qtdItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_qtdItemCardapio, pRequest);
		String obsItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_obsItemCardapio, pRequest);
		
		contaItemCardapio.setCdContaItemCardapio(Util.getInteger(cdContaItemCardapio));
		contaItemCardapio.setQtdContaItemCardapio(Util.getInteger(qtdItemCardapio));
		contaItemCardapio.setObsContaItemCardapio(obsItemCardapio);
		
		this.aFachadaSGBR.alterarContaItemCardapio(contaItemCardapio);
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


	String	valueRadio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_pedido, pRequest);
		
		
		OTDContaItemCardapio otdContaItemCardapio = this.aFachadaSGBR.consultaDetalharPedido(valueRadio);		
		pRequest.setAttribute(this.ID_REQ_ATR_otdContaItemPedido, otdContaItemCardapio);
	
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

		String cdContaItemCardapio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdPedido,pRequest);
				
     	this.aFachadaSGBR.excluirContaItemCardapio(cdContaItemCardapio);
		
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
		
		
	ArrayList<OTDContaItemCardapio> otdContaItemPedido =  this.aFachadaSGBR.consultaTelaManterPedido(cdMesa, cdComanda);
	
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
	String	valueRadio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_pedido, pRequest);
		
		
		OTDContaItemCardapio otdContaItemCardapio = this.aFachadaSGBR.consultaDetalharPedido(valueRadio);		
		pRequest.setAttribute(this.ID_REQ_ATR_otdContaItemPedido, otdContaItemCardapio);
	
      pRequest.setAttribute(this.ID_REQ_indicadorExclusao, false);
		
		
		this.redirecionar(this.NM_JSP_DETALHAR, pRequest, pResponse);
	}

}
