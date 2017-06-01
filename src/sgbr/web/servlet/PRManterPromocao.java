/**
 * 
 */
package sgbr.web.servlet;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.entidades.Promocao;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.Constantes;
import sgbr.util.OTDPromocao;
import sgbr.util.Util;
import sgbr.util.web.PRManterCadastro;

/**
 * @author Reinaldo
 *
 */
@WebServlet("/PRManterPromocao")
public class PRManterPromocao extends PRManterCadastro{
	
	public static final String ID_REQ_ATR_cdPromocao = "cdPromocao";
	public static final String ID_REQ_ATR_cdItemCardapio = "cdItemCardapio";
	public static final String ID_REQ_ATR_vlPromocao = "vlPromocao";
	public static final String ID_REQ_ATR_dtInicioPromocao = "dtInicioPromocao";
	public static final String ID_REQ_ATR_dtFimPromocao = "dtFimPromocao";
	public static final String ID_REQ_ATR_diaSemanaPromocao = "diaSemanaPromocao";
	public static final String ID_REQ_ATR_inRetornarApenasVigentes = "inRetornarApenasVigentes";
	
	public static final String ID_REQ_ATR_Promocao = "Promocao";
	public static final String ID_REQ_ATR_otdPromocao = "OTDPromocao";
	public static final String ID_REQ_ATR_radio_consulta_promocao = "radio_consulta_promocao" ;
	
	public static final String NM_SERVLET = "PRManterPromocao";
	public static final String NM_JSP_CONSULTA = "/jsp/manter_promocao/consulta.jsp";
	public static final String NM_JSP_INCLUIR = "/jsp/manter_promocao/incluir.jsp";
	public static final String NM_JSP_ALTERAR = "/jsp/manter_promocao/alterar.jsp";
	public static final String NM_JSP_DETALHAR = "/jsp/manter_promocao/detalhar.jsp";

	
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
		Promocao promocao = new Promocao();
		
		String cdItemCardapio = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_cdItemCardapio, pRequest);
		String vlPromocao = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_vlPromocao, pRequest);
		String dtInicioPromocao = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_dtInicioPromocao, pRequest);
		String dtFimPromocao = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_dtFimPromocao, pRequest);
		
		vlPromocao = vlPromocao.replaceAll(",", ".");
		
		promocao.setCdItemCardapio(!cdItemCardapio.isEmpty() ? Integer.parseInt(cdItemCardapio) : null );
		promocao.setVlPromocao(!vlPromocao.isEmpty() ? Double.valueOf(vlPromocao) : null );
		promocao.setDtInicioPromocao(!dtInicioPromocao.isEmpty() ? Util.formataData(dtInicioPromocao) : null);
		promocao.setDtInicioPromocao(!dtFimPromocao.isEmpty() ? Util.formataData(dtFimPromocao) : null);
		
		this.aFachadaSGBR.incluirPromocao(promocao);
		
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

		String	valueRadio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_promocao, pRequest);

		Promocao promocao =  new Promocao();
		promocao.setCdPromocao(Integer.valueOf(valueRadio));
		promocao = this.aFachadaSGBR.consultaPromocaoPorChavePrimaria(promocao);		
		pRequest.setAttribute(this.ID_REQ_ATR_Promocao, promocao);
		
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
		Promocao promocao = new Promocao();
		String cdPromocao = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdPromocao, pRequest);
		String cdItemCardapio = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_cdItemCardapio, pRequest);
		String vlPromocao = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_vlPromocao, pRequest);
		String dtInicioPromocao = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_dtInicioPromocao, pRequest);
		String dtFimPromocao = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_dtFimPromocao, pRequest);
		
		vlPromocao = vlPromocao.replaceAll(",", ".");
		
		promocao.setCdPromocao(Integer.parseInt(cdPromocao) );
		promocao.setCdItemCardapio(!cdItemCardapio.isEmpty() ? Integer.parseInt(cdItemCardapio) : null );
		promocao.setVlPromocao(!vlPromocao.isEmpty() ? Double.valueOf(vlPromocao) : null );
		promocao.setDtInicioPromocao(!dtInicioPromocao.isEmpty() ? Util.formataData(dtInicioPromocao) : null);
		promocao.setDtInicioPromocao(!dtFimPromocao.isEmpty() ? Util.formataData(dtFimPromocao) : null);
		this.aFachadaSGBR.alterarPromocao(promocao);
		
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


		String cdPromocao = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_promocao, pRequest);
		
         Promocao promocao = new Promocao();
         promocao.setCdPromocao(Integer.valueOf(cdPromocao));
         
         promocao = this.aFachadaSGBR.consultaPromocaoPorChavePrimaria(promocao);
        
        pRequest.setAttribute(this.ID_REQ_ATR_Promocao, promocao);

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

		String cdPromocao = this.getAtributoOuParametroStringOpcional(PRManterPromocao.ID_REQ_ATR_cdPromocao,pRequest);
				
				
		Promocao promocao = new Promocao();
		promocao.setCdPromocao(Integer.valueOf(cdPromocao));

     	this.aFachadaSGBR.excluirPromocao(promocao);
		
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
		
		String cdItemCardapio = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_cdItemCardapio, pRequest);
		String inRetornarApenasVigentes = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_inRetornarApenasVigentes, pRequest);
		String diaSemanaPromocao = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_diaSemanaPromocao, pRequest);
		
		if (cdItemCardapio.equals(Constantes.CD_TODOS)){
			cdItemCardapio = "";
		}
		
		if (inRetornarApenasVigentes.equals(Constantes.CD_TODOS)){
			inRetornarApenasVigentes = "";
		}
		
		
		ArrayList<OTDPromocao> otdResposta = this.aFachadaSGBR.consultaTelaManterPromocao(cdItemCardapio,inRetornarApenasVigentes,diaSemanaPromocao);
		
		pRequest.setAttribute(this.ID_REQ_ATR_otdPromocao, otdResposta);
		
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
		String cdPromocao = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_promocao, pRequest);
		
         Promocao promocao = new Promocao();
         promocao.setCdPromocao(Integer.valueOf(cdPromocao));
         
         promocao = this.aFachadaSGBR.consultaPromocaoPorChavePrimaria(promocao);
        
      pRequest.setAttribute(this.ID_REQ_ATR_Promocao, promocao);
      pRequest.setAttribute(this.ID_REQ_indicadorExclusao, false);
		
		
		this.redirecionar(this.NM_JSP_DETALHAR, pRequest, pResponse);
	}

}
