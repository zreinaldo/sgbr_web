<%@page import="sgbr.web.servlet.selects.SelectEstado"%>
<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.OTDFuncionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.selects.SelectTipoFuncionario"%>
<%@page import="sgbr.web.servlet.PRManterFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%
	boolean indicadorExclusao = false;
	indicadorExclusao = (Boolean) PRManterFuncionario.getAtributoOpcional(PRManterFuncionario.ID_REQ_indicadorExclusao, request);
	if (indicadorExclusao) {
%>
<title>Excluir Funcionario</title>
<%
	} else {
%>
<title>Detalhar Funcionario</title>
<%
	}
%>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	
	<%
	

	OTDFuncionario otdFuncionario =  (OTDFuncionario) PRManterFuncionario.getAtributoOpcional(PRManterFuncionario.ID_REQ_ATR_otdFuncionario,request); 

		
	%>

<body>

	<FORM name="form_principal" method="post" action="">
<%@ include file = "../../jsp/util/menu.jsp" %>
		<INPUT type="hidden" id="evento" name="<%=PRManterFuncionario.ID_REQ_EVENTO%>" value="">
		<INPUT type="hidden" id="cdPessoa" name="<%=PRManterFuncionario.ID_REQ_ATR_cdPessoa%>" value="<%=otdFuncionario.getCdPessoa()%> ">
		<INPUT type="hidden" id="cdFuncionario" name="<%=PRManterFuncionario.ID_REQ_ATR_cdFuncionario%>" value="<%=otdFuncionario.getCdFuncionario()%>">


		<fieldset>
			<table>
			<%	if (indicadorExclusao) { %>
<th align="left">Excluir Funcion�rio</th>

<%} else {%>
<th align="left">Detalhar Funcion�rio</th>
<%} %>	
		<tr>
					<td><label for="nmCargo">Cargo:</label></td>

					<td><%= SelectTipoFuncionario.getInstancia().getHTML(request, PRManterFuncionario.ID_REQ_ATR_tpCargo, PRManterFuncionario.ID_REQ_ATR_tpCargo, otdFuncionario.getTpFuncionario().toString(),false,false)%></td>
				</tr>
								

				<tr>
					<td><label for="nmFuncionario" >Nome:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmFuncionario%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmFuncionario%>" value="<%=otdFuncionario.getNmFuncionario() %>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nuCPF">CPF:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuCPF%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCPF%>" maxlength="58" value="<%=otdFuncionario.getNuCPF()%>"> </td>
				</tr>

				<tr>
					<td><label for="nuRG">RG:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuRG%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuRG%>" maxlength="58" value="<%=otdFuncionario.getNuRG() %>" ></td>
				</tr>
				<tr>
					<td><label for="nuCarteira">Carteira de Trabalho:</label></td>
					<td><input id="<%=PRManterFuncionario.ID_REQ_ATR_nuCarteira%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCarteira%>"
						maxlength="58" value="<%=otdFuncionario.getNuCarteira() %>" ></td>
				</tr>

				<tr>
					<td><label for="dtNascimento">Data Nascimento:</label></td>
					<td><input
						id="<%=PRManterFuncionario.ID_REQ_ATR_dtNascimento%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_dtNascimento%>"
						maxlength="58" value="<%=Util.formataDataParaString(otdFuncionario.getDtNascimento()) %>"></td>
				</tr>
				
	<tr>
					<td><label for="convencional">Telefone Convencional:</label></td>
					<td><input type="text" size="4" 			disabled="disabled"
						id="<%=PRManterFuncionario.ID_REQ_ATR_dddTelefoneConvencional%>" value="<%=otdFuncionario.getDddTelefoneConvencional()%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_dddTelefoneConvencional%>"
						maxlength="3"> - <input type="text"  value="<%=otdFuncionario.getNuTelefoneConvencional()  %>" disabled="disabled"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuTelefoneConvencional%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuTelefoneConvencional%>"
						maxlength="10"> </td>
				</tr>
				
						
				<tr>
				<td><label for="celular">Telefone Celular:</label></td>
					<td><input type="text" size="4" 			
						id="<%=PRManterFuncionario.ID_REQ_ATR_dddTelefoneCelular%>" value="<%=otdFuncionario.getDddTelefoneCelular()%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_dddTelefoneCelular%>" disabled="disabled"
						maxlength="3"> - <input type="text"  
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuTelefoneCelular%>" value="<%=otdFuncionario.getNuTelefoneCelular()%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuTelefoneCelular%>" disabled="disabled"
						maxlength="10"> </td>
				</tr>

				<tr>
					<td><label for="email">E-mail:</label></td>
					<td><input id="<%=PRManterFuncionario.ID_REQ_ATR_email%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_email%>" maxlength="58" value="<%=otdFuncionario.getEmail() %>"></td>
				</tr>

				<td><label for="DadosBancarios">Dados Bancarios</label></td>
				<td>-</td>
				<tr>
					<td><label for="nmBanco">Banco:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmBanco%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmBanco%>" maxlength="58" value="<%=otdFuncionario.getNmBanco() %>"></td>
				</tr>
				<tr>
					<td><label for="nuAgencia">Ag�ncia:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuAgencia%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuAgencia%>"
						maxlength="58" value="<%=otdFuncionario.getNuAgencia() %>"></td>
				</tr>
				<tr>
					<td><label for="nuCC">N�mero Conta Corrente:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuCC%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCC%>" maxlength="58" value="<%=otdFuncionario.getNuCC() %>" ></td>
				</tr>

				<tr>
					<td><label for="vlSalario">Sal�rio:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_vlSalario%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_vlSalario%>"
						maxlength="58" value="<%=otdFuncionario.getVlSalario() %>"></td>
				</tr>
				<tr>
					<td><label for="dtAdmissao">Data Admiss�o:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_dtAdmissao%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_dtAdmissao%>"
						maxlength="58" value="<%=Util.formataDataParaString(otdFuncionario.getDtAdmissao()) %>"></td>
				</tr>
				
				
				<tr>
					<td><label for="dtDemissao">Data Demiss�o:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_dtDemissao%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_dtDemissao%>"
						maxlength="58" value="<%=Util.formataDataParaString(otdFuncionario.getDtDemissao()) %>"></td>
				</tr>
				
				<td><label for="Dados Endere�o">Dados do Endere�o</label></td>
				<td>-</td>			
				<tr>
					<td><label for="nmUF">Estado:</label></td>
					<td><%=SelectEstado.getInstancia().getHTML(request, PRManterFuncionario.ID_REQ_ATR_nmUF, PRManterFuncionario.ID_REQ_ATR_nmUF, otdFuncionario.getNmUF(), false, false) %></td>
				</tr>
				<tr>
					<td><label for="nmCidade">Cidade:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmCidade%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmCidade%>" maxlength="58" value="<%=otdFuncionario.getNmCidade()%>"></td>
				</tr>
				<tr>
					<td><label for="nmBairro">Bairro:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmBairro%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmBairro%>" maxlength="58"value="<%=otdFuncionario.getNmBairro()%>" ></td>
				</tr>
				
				<tr>
					<td><label for="nmLogradouro">Logradouro:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmLogradouro%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmLogradouro%>"
						maxlength="58" size="50" value="<%=otdFuncionario.getNmLogradouro()%>"> 
						
						<label for="nuLogradouro">N�mero:</label><input
						type="text" id="<%=PRManterFuncionario.ID_REQ_ATR_nuLogradouro%>"  disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuLogradouro%>"
						maxlength="8" size="10" value="<%=otdFuncionario.getNuLogradouro()%>"></td>
				</tr>				
				<tr>
					<td><label for="nuCEP">CEP:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuCEP%>" disabled="disabled"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCEP%>" maxlength="58" value="<%=otdFuncionario.getNuCEP()%>"></td>
				</tr>
				<tr>
					<td colspan="2" id="botoes">
						<%
							if (indicadorExclusao) {
						%>
						<input type="button"
						value="Excluir"
						onclick="submeterFormulario('<%=PRManterFuncionario.NM_SERVLET%>','<%=PRManterFuncionario.EVENTO_PROCESSAR_EXCLUSAO%>')"
						id="excluir">
						<%}%>                      
						<input type="button" value="Voltar"
						onclick=" window.history.back();" id="voltar">

					</td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>

