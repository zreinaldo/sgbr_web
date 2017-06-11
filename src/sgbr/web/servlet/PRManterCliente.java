/**
 * 
 */
package sgbr.web.servlet;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.fachada.FachadaSGBR;
import sgbr.util.Constantes;
import sgbr.util.OTDCliente;
import sgbr.util.Util;
import sgbr.util.web.PRManterCadastro;

/**
 * @author Reinaldo
 *
 */
@WebServlet("/PRManterCliente")
public class PRManterCliente extends PRManterCadastro {

	private static final long serialVersionUID = -3732079316294020607L;

	public static final String ID_REQ_ATR_cdPessoa = "cdPessoa";
	public static final String ID_REQ_ATR_cdCliente = "cdCliente";

	public static final String ID_REQ_ATR_tpDocumento = "tpDocumento";
	public static final String ID_REQ_ATR_nuDocumento = "nuDocumento";
	public static final String ID_REQ_ATR_nmCliente = "nmCliente";
	public static final String ID_REQ_ATR_email = "email";
	public static final String ID_REQ_ATR_dtNascimento = "dtNascimento";
	
	public static final String ID_REQ_ATR_nuTelefoneCelular = "nuTelefoneCelular";
	public static final String ID_REQ_ATR_dddTelefoneCelular = "dddTelefoneCelular";

	public static final String ID_REQ_ATR_otdCliente = "OTDCliente";

	public static final String ID_REQ_ATR_radio_consulta_cliente = "radio_consulta_cliente";
	/**
	 * 
	 */

	public static final String NM_SERVLET = "PRManterCliente";
	public static final String NM_JSP_CONSULTA = "/jsp/manter_cliente/consulta.jsp";
	public static final String NM_JSP_INCLUIR = "/jsp/manter_cliente/incluir.jsp";
	public static final String NM_JSP_ALTERAR = "/jsp/manter_cliente/alterar.jsp";
	public static final String NM_JSP_DETALHAR = "/jsp/manter_cliente/detalhar.jsp";



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
	@Override
	public void processarInclusao(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		String nmCliente = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_nmCliente, pRequest);
		String dtNascimento = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_dtNascimento, pRequest);
		String email = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_email, pRequest);
		String nuDocumento = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_nuDocumento, pRequest);
		
		String nuTelefone = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_nuTelefoneCelular, pRequest);
		String dddTelefone = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_dddTelefoneCelular, pRequest);
		

		
		

		OTDCliente otdCliente = new OTDCliente();

		otdCliente.setNmCliente(nmCliente);
		otdCliente.setDtNascimento(!dtNascimento.isEmpty() ? Util.formataData(dtNascimento) : null);
		otdCliente.setEmail(email);
		otdCliente.setNuCPF(nuDocumento);
		otdCliente.setNuTelefone(nuTelefone);
		otdCliente.setDddTelefone(dddTelefone);
		

		this.aFachadaSGBR.incluirCliente(otdCliente);

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

		String valueRadio = (String) this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_cliente, pRequest);

		String[] valores = valueRadio.split(",", 2);

		OTDCliente otdCliente = this.aFachadaSGBR.consultarDadosCliente(Integer.valueOf(valores[0]),
				Integer.valueOf(valores[1]));

		pRequest.setAttribute(this.ID_REQ_ATR_otdCliente, otdCliente);

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
		String nmCliente = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_nmCliente, pRequest);
		String dtNascimento = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_dtNascimento, pRequest);
		String email = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_email, pRequest);
		String nuDocumento = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_nuDocumento, pRequest);

		String cdPessoa = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdPessoa,
				pRequest);
		String cdCliente = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdCliente, pRequest);
		
		OTDCliente otdCliente = new OTDCliente();
		otdCliente.setCdCliente(Integer.valueOf(cdCliente));
		otdCliente.setCdPessoa(Integer.valueOf(cdPessoa));
		otdCliente.setNmCliente(nmCliente);
		otdCliente.setDtNascimento(!dtNascimento.isEmpty() ? Util.formataData(dtNascimento) : null);
		otdCliente.setEmail(email);
		otdCliente.setNuCPF(nuDocumento);

		
		this.aFachadaSGBR.alterarCliente(otdCliente);
		
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
		String valueRadio = (String) this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_cliente, pRequest);

		String[] valores = valueRadio.split(",", 2);

		OTDCliente otdCliente = this.aFachadaSGBR.consultarDadosCliente(Integer.valueOf(valores[0]),
				Integer.valueOf(valores[1]));

		pRequest.setAttribute(this.ID_REQ_ATR_otdCliente, otdCliente);

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
		String cdPessoa = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdPessoa,
				pRequest);
		String cdCliente = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdCliente, pRequest);
		
		
		OTDCliente otdCliente = new OTDCliente();
		
		otdCliente.setCdCliente(Integer.valueOf(cdCliente));
		otdCliente.setCdPessoa(Integer.valueOf(cdPessoa));
				
		this.aFachadaSGBR.excluirCliente(otdCliente);
		
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
		String tpDocumento = this.getParametroStringOpcional(this.ID_REQ_ATR_tpDocumento, true, pRequest);
		String nuDocumento = this.getParametroStringOpcional(this.ID_REQ_ATR_nuDocumento, true, pRequest);
		String nmCliente = this.getParametroStringOpcional(this.ID_REQ_ATR_nmCliente, true, pRequest);

		if (tpDocumento.equals(Constantes.CD_TODOS)) {
			tpDocumento = "";
		}

		ArrayList<OTDCliente> otdResposta = this.aFachadaSGBR.consultaTelaManterCliente(nmCliente, tpDocumento,
				nuDocumento);

		pRequest.setAttribute(this.ID_REQ_ATR_otdCliente, otdResposta);

		pRequest.setAttribute(this.ID_REQ_ATR_tpDocumento, tpDocumento);
		pRequest.setAttribute(this.ID_REQ_ATR_nuDocumento, nuDocumento);
		pRequest.setAttribute(this.ID_REQ_ATR_nmCliente, nmCliente);

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

		String valueRadio = (String) this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_cliente, pRequest);

		String[] valores = valueRadio.split(",", 2);

		OTDCliente otdCliente = this.aFachadaSGBR.consultarDadosCliente(Integer.valueOf(valores[0]),
				Integer.valueOf(valores[1]));

		pRequest.setAttribute(this.ID_REQ_ATR_otdCliente, otdCliente);

		pRequest.setAttribute(this.ID_REQ_indicadorExclusao, false);
		this.redirecionar(this.NM_JSP_DETALHAR, pRequest, pResponse);

	}

}
