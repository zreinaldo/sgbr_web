/**
 * 
 */
package sgbr.web.servlet;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.entidades.Usuario;
import sgbr.fachada.FachadaSGBR;
import sgbr.util.Constantes;
import sgbr.util.OTDUsuario;
import sgbr.util.web.PRManterCadastro;

/**
 * @author Reinaldo
 *
 */
@WebServlet("/PRManterUsuario")
public class PRManterUsuario extends PRManterCadastro {

	public static final String ID_REQ_ATR_cdUsuario = "cdUsuario";
	public static final String ID_REQ_ATR_cdFuncionario = "cdFuncionario";
	public static final String ID_REQ_ATR_nmFuncionario = "nmFuncionario";
	public static final String ID_REQ_ATR_loginUsuario = "loginUsuario";
	public static final String ID_REQ_ATR_cdTpUsuario = "cdTpUsuario";
	public static final String ID_REQ_ATR_nmTpUsuario = "nmTpUsuario";
	public static final String ID_REQ_ATR_senhaUsuario = "senhaUsuario";
	public static final String ID_REQ_ATR_senhaConfirmacao = "senhaConfirmacao";
	public static final String ID_REQ_ATR_senhaAnterior = "senhaAnterior";
	public static final String ID_REQ_ATR_senhaAnteriorConfirmacao = "senhaAnteriorConfirmacao";
	public static final String ID_REQ_ATR_dtIniVigencia = "dtIniVigencia";
	public static final String ID_REQ_ATR_dtFimVigencia = "dtFimVigencia";
	public static final String ID_REQ_ATR_inBloqueioUsuario = "inBloqueioUsuario";

	public static final String ID_REQ_ATR_Usuario = "Usuario";
	public static final String ID_REQ_ATR_otdUsuario = "OTDUsuario";
	public static final String ID_REQ_ATR_radio_consulta_usuario = "radio_consulta_usuario";

	public static final String NM_SERVLET = "PRManterUsuario";
	public static final String NM_JSP_CONSULTA = "/jsp/manter_usuario/consulta.jsp";
	public static final String NM_JSP_INCLUIR = "/jsp/manter_usuario/incluir.jsp";
	public static final String NM_JSP_ALTERAR = "/jsp/manter_usuario/alterar.jsp";
	public static final String NM_JSP_DETALHAR = "/jsp/manter_usuario/detalhar.jsp";

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
		Usuario usuario = new Usuario();

		String loginUsuario = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_loginUsuario, pRequest);
		String cdTpUsuario = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_cdTpUsuario, pRequest);
		String senhaUsuario = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_senhaUsuario, pRequest);
		String cdFuncionario = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_cdFuncionario, pRequest);
		String inBloqueioUsuario = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_inBloqueioUsuario, pRequest);

		usuario.setLoginUsuario(loginUsuario);
		usuario.setSenhaUsuario(senhaUsuario);
		usuario.setCdTpUsuario(!cdTpUsuario.isEmpty() ? Integer.valueOf(cdTpUsuario) : null);
		usuario.setCdFuncionario(!cdFuncionario.isEmpty() ? Integer.valueOf(cdFuncionario) : null);
		usuario.setInBloqueioUsuario(inBloqueioUsuario);

		this.aFachadaSGBR.incluirUsuario(usuario);

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

		String valueRadio = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_usuario, pRequest);
		OTDUsuario otdUsuario = new OTDUsuario();
		otdUsuario = this.aFachadaSGBR.consultaDadosUsuario(Integer.valueOf(valueRadio));
		pRequest.setAttribute(this.ID_REQ_ATR_Usuario, otdUsuario);

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
		Usuario usuario = new Usuario();
		String cdUsuario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdUsuario, pRequest);
		String loginUsuario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_loginUsuario, pRequest);
		String cdTpUsuario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_cdTpUsuario, pRequest);
		String senhaUsuario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_senhaUsuario, pRequest);
		String inBloqueioUsuario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_inBloqueioUsuario,
				pRequest);

		usuario.setLoginUsuario(loginUsuario);
		usuario.setSenhaUsuario(senhaUsuario);
		usuario.setInBloqueioUsuario(inBloqueioUsuario);
		usuario.setCdTpUsuario(!cdTpUsuario.isEmpty() ? Integer.valueOf(cdTpUsuario) : null);
		usuario.setCdUsuario(!cdUsuario.isEmpty() ? Integer.valueOf(cdUsuario) : null);

		if (!cdUsuario.isEmpty()) {
			this.aFachadaSGBR.alterarUsuario(usuario);
		}

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

		String cdUsuario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_usuario, pRequest);

		OTDUsuario otdUsuario = new OTDUsuario();
		otdUsuario = this.aFachadaSGBR.consultaDadosUsuario(Integer.valueOf(cdUsuario));
		pRequest.setAttribute(this.ID_REQ_ATR_Usuario, otdUsuario);

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

		String cdUsuario = this.getAtributoOuParametroStringOpcional(PRManterUsuario.ID_REQ_ATR_cdUsuario, pRequest);

		Usuario usuario = new Usuario();
		usuario.setCdUsuario(Integer.valueOf(cdUsuario));

		this.aFachadaSGBR.excluirUsuario(usuario);

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

		String cdTpUsuario = this.getParametroStringOpcional(this.ID_REQ_ATR_cdTpUsuario, true, pRequest);
		String loginUsuario = this.getParametroStringOpcional(this.ID_REQ_ATR_loginUsuario, true, pRequest);
		String cdFuncionario = this.getParametroStringOpcional(this.ID_REQ_ATR_cdFuncionario, true, pRequest);
		String inBloqueioUsuario = this.getParametroStringOpcional(this.ID_REQ_ATR_inBloqueioUsuario, true, pRequest);

		if (cdTpUsuario.equals(Constantes.CD_TODOS)) {
			cdTpUsuario = "";
		}

		if (cdFuncionario.equals(Constantes.CD_TODOS)) {
			cdFuncionario = "";
		}

		if (inBloqueioUsuario.equals(Constantes.CD_TODOS)) {
			inBloqueioUsuario = "";
		}

		ArrayList<OTDUsuario> otdResposta = this.aFachadaSGBR.consultaTelaManterUsuario(loginUsuario, cdTpUsuario,
				cdFuncionario, inBloqueioUsuario);

		pRequest.setAttribute(this.ID_REQ_ATR_otdUsuario, otdResposta);

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
		String cdUsuario = this.getAtributoOuParametroStringOpcional(this.ID_REQ_ATR_radio_consulta_usuario, pRequest);

		OTDUsuario otdUsuario = new OTDUsuario();
		otdUsuario = this.aFachadaSGBR.consultaDadosUsuario(Integer.valueOf(cdUsuario));
		pRequest.setAttribute(this.ID_REQ_ATR_Usuario, otdUsuario);
		pRequest.setAttribute(this.ID_REQ_indicadorExclusao, false);

		this.redirecionar(this.NM_JSP_DETALHAR, pRequest, pResponse);
	}

}
