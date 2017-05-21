package sgbr.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgbr.fachada.FachadaSGBR;
import sgbr.util.OTDFuncionario;
import sgbr.util.web.PRManterCadastro;

/**
 * Servlet implementation class PRManterFuncionario
 */
@WebServlet("/PRManterFuncionario")
public class PRManterFuncionario extends PRManterCadastro {
	private static final long serialVersionUID = 1L;

	public static final String ID_REQ_ATR_nmFuncionario = "nmFuncionario";
	public static final String ID_REQ_ATR_tpCargo = "nmCargo";
	public static final String ID_REQ_ATR_nuCPF = "nuCPF";
	public static final String ID_REQ_ATR_nuRG = "nuRG";
	public static final String ID_REQ_ATR_nuCarteira = "nuCarteira";
	public static final String ID_REQ_ATR_nmBanco = "nmBanco";
	public static final String ID_REQ_ATR_nuAgencia = "nuAgencia";
	public static final String ID_REQ_ATR_nuCC = "nuCC";
	public static final String ID_REQ_ATR_vlSalario = "vlSalario";
	public static final String ID_REQ_ATR_dtAdmissao = "dtAdmissao";
	public static final String ID_REQ_ATR_dtNascimento = "dtNascimentoAdmissao";
	public static final String ID_REQ_ATR_email = "email";
	public static final String ID_REQ_ATR_nmUF = "nmUF";
	public static final String ID_REQ_ATR_nmCidade = "nmCidade";
	public static final String ID_REQ_ATR_nmBairro = "nmBairro";
	public static final String ID_REQ_ATR_nmLogradouro = "nmLogradouro";
	public static final String ID_REQ_ATR_nuLogradouro = "nuLogradouro";
	public static final String ID_REQ_ATR_nuCEP = "nuCEP";

	public static final String NM_SERVLET = "PRManterFuncionario";
	public static final String NM_JSP_CONSULTA = "/jsp/manter_funcionario/consulta.jsp";
	public static final String NM_JSP_INCLUIR = "/jsp/manter_funcionario/incluir.jsp";
	public static final String NM_JSP_ALTERAR = "/jsp/manter_funcionario/alterar.jsp";
	public static final String NM_JSP_DETALHAR = "/jsp/manter_funcionario/detalhar.jsp";

	private FachadaSGBR aFachadaSGBR;

	public void init() throws ServletException {
		System.out.println("M�todo init()");
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
		// TODO Auto-generated method stub
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

		String nmFuncionario = this.getAtributoOuParametroStringOpcional(ID_REQ_ATR_nmFuncionario, pRequest);
		String tpCargo = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_tpCargo, pRequest);
		String nuCPF = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nuCPF,
				pRequest);
		String nuRG = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nuRG, pRequest);
		String nuCarteira = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nuCarteira, pRequest);
		String nmBanco = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nmBanco, pRequest);
		String nuAgencia = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nuAgencia,
				pRequest);
		String nuCC = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nuCC, pRequest);
		String vlSalario = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_vlSalario,
				pRequest);
		String dtAdmissao = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_dtAdmissao,
				pRequest);
		
		String nmUF = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nmUF, pRequest);
		String nmCidade = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nmCidade, pRequest);
		String nmBairro = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nmBairro, pRequest);
		String nmLogradouro = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nmLogradouro,
				pRequest);
		String nuLogradouro = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nuLogradouro,
				pRequest);
		String nuCEP = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nuCEP, pRequest);
		
		String dtNascimemnto = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_dtNascimento,
				pRequest);
		String email = this.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_email, pRequest);


		OTDFuncionario otdFuncionario = new OTDFuncionario();
		otdFuncionario.setNmFuncionario(nmFuncionario);

		otdFuncionario.setNuCPF(nuCPF);
		otdFuncionario.setNuRG(nuRG);
		otdFuncionario.setNuCarteira(nuCarteira);
		otdFuncionario.setNmBanco(nmBanco);
		otdFuncionario.setNuAgencia(nuAgencia);
		otdFuncionario.setNuCC(nuCC);
		otdFuncionario.setVlSalario(Double.valueOf(vlSalario));
		otdFuncionario.setTpFuncionario(Integer.valueOf(tpCargo));
		otdFuncionario.setDtAdmissao(dtAdmissao);
		otdFuncionario.setNmUF(nmUF);
		otdFuncionario.setNmCidade(nmCidade);
		otdFuncionario.setNmBairro(nmBairro);
		otdFuncionario.setNmLogradouro(nmLogradouro);
		otdFuncionario.setNuLogradouro(nuLogradouro);
		otdFuncionario.setNuCEP(nuCEP);
		otdFuncionario.setDtNascimento(dtNascimemnto);
		otdFuncionario.setEmail(email);

		this.aFachadaSGBR.incluirFuncionario(otdFuncionario);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.PRManterCadastro#exibirAlteracao(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirAlteracao(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.PRManterCadastro#exibirExclusao(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirExclusao(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.PRManterCadastro#processarExclusao(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void processarExclusao(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.util.web.PRConsultar#exibirConsulta(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void exibirConsulta(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		// TODO Auto-generated method stub
		// FachadaSGBR aFachadaSGBR = FachadaSGBR.getInstancia();
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
		// TODO Auto-generated method stub

		this.aFachadaSGBR.toString();
		System.out.println("oiiioioioioi");
		this.redirecionar(this.NM_JSP_DETALHAR, pRequest, pResponse);
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
		// TODO Auto-generated method stub

	}

}
