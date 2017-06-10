package sgbr.web.servlet;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.cadastros.sql.DAOConta;
import sgbr.entidades.Conta;
import sgbr.fachada.FachadaSGBR;
import sgbr.regras.conta.RNEncerrarConta;
import sgbr.util.Constantes;
import sgbr.util.OTDConta;
import sgbr.util.OTDContaItemCardapio;
import sgbr.util.Util;
import sgbr.util.web.PRConsultar;

/**
 * Servlet implementation class PRManterConta
 */
@WebServlet("/PRManterConta")
public class PRManterConta extends PRConsultar {
	private static final long serialVersionUID = 1L;

	public static final String ID_REQ_ATR_cdConta = "cdConta";
	public static final String ID_REQ_ATR_cdTipoConta = "cdTipoConta";
	public static final String ID_REQ_ATR_cdComanda= "cdComanda";
	public static final String ID_REQ_ATR_cdMesa= "cdMesa";
	public static final String ID_REQ_ATR_siConta= "siConta";
	public static final String ID_REQ_ATR_cdCliente= "cdCliente";
	public static final String ID_REQ_ATR_vlContaFinal= "vlContaFinal";
	public static final String ID_REQ_ATR_vlContaOriginal= "vlContaOriginal";
	public static final String ID_REQ_ATR_vlDinheiroDesconto= "vlDinheiroDesconto";
	public static final String ID_REQ_ATR_vlPercDesconto= "vlPercDesconto";
	public static final String ID_REQ_ATR_percDesconto= "percDesconto";
	public static final String ID_REQ_ATR_dhEncerramento= "dhEncerramento";
    public static final String ID_REQ_ATR_inFecharConta = "inFecharConta";
    public static final String ID_REQ_ATR_inContaDesconto = "inContaDesconto";
    

    public static final String ID_REQ_ATR_otdContaItemCardapio = "OTDContaItemCardapio";
	public static final String ID_REQ_ATR_otdConta = "OTDConta";
	public static final String ID_REQ_ATR_radio_consulta_conta = "radio_consulta_conta";

	public static final String NM_SERVLET = "PRManterConta";
	
	
	
	public static final String EVENTO_EXIBIR_ABRIR_CONTA_MESA = "exibirAbrirContaMesa";
	public static final String EVENTO_EXIBIR_ABRIR_CONTA_COMANDA = "exibirAbrirContaComanda";
	public static final String EVENTO_PROCESSAR_ABRIR_CONTA = "processarAbrirConta";
	
	public static final String EVENTO_EXIBIR_INCLUSAO_PEDIDO = "exibirInclusaoPedido";
	public static final String EVENTO_EXIBIR_CONTA_PARCIAL = "exibirContaParcial";	
	
	
	public static final String EVENTO_EXIBIR_ENCERRAR_CONTA = "exibirEncerrarConta";
	public static final String EVENTO_PROCESSAR_ENCERRAR_CONTA = "processarEncerrarConta";
	
	public static final String EVENTO_ATUALIZAR_DESCONTO_CONTA = "atualizarDescontoConta";
	
	public static final String NM_JSP_CONSULTA = "/jsp/manter_conta/consulta.jsp";
	public static final String NM_JSP_ABRIR_CONTA = "/jsp/manter_conta/abrirConta.jsp";
	public static final String NM_JSP_CONTA = "/jsp/manter_conta/conta.jsp";
	
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
		
		String cdMesa = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdMesa, pRequest);
		String cdComanda = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdComanda, pRequest);
		String siConta = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_siConta, pRequest);
				
		
		if (cdMesa.equals(Constantes.CD_TODOS)) {
			cdMesa = "";
		}
		if (cdComanda.equals(Constantes.CD_TODOS)) {
			cdComanda = "";
		}
		
		
	ArrayList<OTDConta> otdConta =  this.aFachadaSGBR.consultaTelaManterConta(cdMesa, cdComanda, siConta);
	
	pRequest.setAttribute(this.ID_REQ_ATR_otdConta, otdConta);
	
	this.redirecionar(this.NM_JSP_CONSULTA, pRequest, pResponse);
	
		
	}

	/* (non-Javadoc)
	 * @see sgbr.util.web.PRConsultar#exibirDetalhamentoConsulta(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirDetalhamentoConsulta(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void exibirAbrirContaComanda(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		
		pRequest.setAttribute(this.ID_REQ_ATR_cdTipoConta, Constantes.CD_TIPO_CONTA_COMANDA);
		
		this.redirecionar(this.NM_JSP_ABRIR_CONTA, pRequest, pResponse);
	}
	
	public void exibirAbrirContaMesa(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		
		pRequest.setAttribute(this.ID_REQ_ATR_cdTipoConta, Constantes.CD_TIPO_CONTA_MESA);
		
		this.redirecionar(this.NM_JSP_ABRIR_CONTA, pRequest, pResponse);
	}
	
	
	public void processarAbrirConta(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		String cdMesa = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdMesa, pRequest);
		String cdComanda = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdComanda, pRequest);
		String cdCliente = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdCliente, pRequest);
		String cdTipoConta = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdTipoConta, pRequest);
	
		Conta conta = new Conta();
		
		
		
		conta.setCdMesa(Util.getInteger(cdMesa));
		conta.setCdComanda(Util.getInteger(cdComanda));
		conta.setCdCliente(Util.getInteger(cdCliente));
		conta.setCdTipoConta(Util.getInteger(cdTipoConta));
		this.aFachadaSGBR.incluir(conta);
		
		this.redirecionar(this.NM_JSP_CONSULTA, pRequest, pResponse);
		
	
	}
	
	
	public void exibirEncerrarConta(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		
		String cdConta = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_conta, pRequest);
		
		
		ArrayList<OTDContaItemCardapio> otd = DAOConta.getInstancia().consultarTodosItensConta(Integer.valueOf(cdConta));
		
		
		pRequest.setAttribute(this.ID_REQ_ATR_cdConta, cdConta);
		pRequest.setAttribute(this.ID_REQ_ATR_otdContaItemCardapio, otd);
		pRequest.setAttribute(this.ID_REQ_ATR_inFecharConta, Constantes.CD_SIM);
		this.redirecionar(this.NM_JSP_CONTA, pRequest, pResponse);
		
	}
	
	public void exibirContaParcial(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		
		String cdConta = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_conta, pRequest);
		
		//TODO usar fachada
		ArrayList<OTDContaItemCardapio> otd = DAOConta.getInstancia().consultarTodosItensConta(Integer.valueOf(cdConta));
		
		
		pRequest.setAttribute(this.ID_REQ_ATR_cdConta, cdConta);
		pRequest.setAttribute(this.ID_REQ_ATR_otdContaItemCardapio, otd);
		pRequest.setAttribute(this.ID_REQ_ATR_inFecharConta, Constantes.CD_NAO);
		this.redirecionar(this.NM_JSP_CONTA, pRequest, pResponse);
		
	}
	
	
	public void processarEncerrarConta(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		
		String cdConta = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdConta, pRequest);
		String vlDinheiroDesconto = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_vlDinheiroDesconto, pRequest);
		String vlPercDesconto = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_vlPercDesconto, pRequest);
		String vlContaFinal = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_vlContaFinal, pRequest);
		String vlContaOriginal = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_vlContaOriginal, pRequest);
		
		Conta conta = new Conta();
		conta.setCdConta(Integer.valueOf(cdConta));
		
		conta.setVlDescontoConta(vlDinheiroDesconto.isEmpty() ? null: Double.valueOf(vlDinheiroDesconto));		
		conta.setPercDescontoConta( vlPercDesconto.isEmpty() ? null: Double.valueOf(vlPercDesconto));
		//TODO colocar cliente
		//conta.setCdCliente(pCdCliente);
		conta.setVlContaFinal(Double.valueOf(vlContaFinal));
		conta.setVlContaOriginal(Double.valueOf(vlContaOriginal));
		conta.setDhEncerramento(new Timestamp(System.currentTimeMillis()));
		
		RNEncerrarConta.getInstancia().processar(conta);
		
		this.redirecionar(this.NM_JSP_CONSULTA, pRequest, pResponse);
	}
	
	
	public void atualizarDescontoConta(HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		
		String cdConta = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdConta, pRequest);
		String vlDinheiroDesconto = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_vlDinheiroDesconto, pRequest);
		String vlPercDesconto = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_vlPercDesconto, pRequest);
		
		
		
		//TODO mudar para fachada
		ArrayList<OTDContaItemCardapio> otd = DAOConta.getInstancia().consultarTodosItensConta(Integer.valueOf(cdConta));
		
		
		String inContaDesconto = Constantes.CD_SIM;
		if (vlDinheiroDesconto.isEmpty() && vlPercDesconto.isEmpty()) {
			inContaDesconto = Constantes.CD_NAO;
		}
		
		pRequest.setAttribute(this.ID_REQ_ATR_cdConta, cdConta);
		pRequest.setAttribute(this.ID_REQ_ATR_otdContaItemCardapio, otd);
		pRequest.setAttribute(this.ID_REQ_ATR_vlDinheiroDesconto, vlDinheiroDesconto.replace(",", "."));
		pRequest.setAttribute(this.ID_REQ_ATR_vlPercDesconto, vlPercDesconto.replace(",", "."));
		pRequest.setAttribute(this.ID_REQ_ATR_inFecharConta, Constantes.CD_SIM);
		pRequest.setAttribute(this.ID_REQ_ATR_inContaDesconto, inContaDesconto);
		
		this.redirecionar(this.NM_JSP_CONTA, pRequest, pResponse);
	}
		


}
