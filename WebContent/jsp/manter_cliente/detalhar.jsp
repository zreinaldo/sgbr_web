<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.OTDCliente"%>
<%@page import="sgbr.web.servlet.PRManterCliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%
	boolean indicadorExclusao = false;
	indicadorExclusao = (Boolean) PRManterCliente.getAtributoOpcional(PRManterCliente.ID_REQ_indicadorExclusao, request);
	if (indicadorExclusao) {
%>
<title>Excluir Cliente</title>
<%
	} else {
%>
<title>Detalhar Cliente</title>
<%
	}
%>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	
	<%
	

	OTDCliente otdCliente =  (OTDCliente) PRManterCliente.getAtributoOpcional(PRManterCliente.ID_REQ_ATR_otdCliente,request); 

		
	%>

<body>

	<FORM name="form_principal" method="post" action="">
<%@ include file = "../../jsp/util/menu.jsp" %>
		<INPUT type="hidden" id="evento" name="<%=PRManterCliente.ID_REQ_EVENTO%>" value="">
		<INPUT type="hidden" id="cdPessoa" name="<%=PRManterCliente.ID_REQ_ATR_cdPessoa%>" value="<%=otdCliente.getCdPessoa()%> ">
		<INPUT type="hidden" id="cdCliente" name="<%=PRManterCliente.ID_REQ_ATR_cdCliente%>" value="<%=otdCliente.getCdCliente()%>">

<fieldset>
			<table>
														<%
	if (indicadorExclusao) {
	 
%>
<th align="left">Excluir Cliente</th>

<%} else {%>
<th align="left">Detalhar Cliente</th>
<%} %>	
				<tr>
					<td><label for="nuCPF">CPF:</label></td>
					<td><input type="text"  value="<%=otdCliente.getNuCPF()%>" disabled="disabled"
						id="<%=PRManterCliente.ID_REQ_ATR_nuDocumento%>"
						name="<%=PRManterCliente.ID_REQ_ATR_nuDocumento%>" maxlength="58"></td>
				</tr>
					
					
				<tr>
					<td><label for="nmCliente">Nome:</label></td>
					<td><input type="text"  value="<%=otdCliente.getNmCliente()%>" disabled="disabled"
						id="<%=PRManterCliente.ID_REQ_ATR_nmCliente%>"
						name="<%=PRManterCliente.ID_REQ_ATR_nmCliente%>"
						maxlength="58"></td>
				</tr>		

				<tr>
					<td><label for="dtNascimento">Data Nascimento:</label></td>
					<td><input type="text"  value="<%=Util.formataDataParaString(otdCliente.getDtNascimento())%>" disabled="disabled"
						id="<%=PRManterCliente.ID_REQ_ATR_dtNascimento%>"
						name="<%=PRManterCliente.ID_REQ_ATR_dtNascimento%>"
						maxlength="58"></td>
				</tr>

				<tr>
					<td><label for="email">E-mail:</label></td>
					<td><input type="email" value="<%=otdCliente.getEmail()%>"  disabled="disabled"
					id="<%=PRManterCliente.ID_REQ_ATR_email%>"
						name="<%=PRManterCliente.ID_REQ_ATR_email%>" maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="telefone">Telefone Celular:</label></td>
					<td><input type="email" value="<%=otdCliente.getDddTelefone()%>"  size="4" disabled="disabled" maxlength="58">-
					<input type="email" value="<%=otdCliente.getNuTelefone()%>"  size="10" disabled="disabled" maxlength="58">
					</td>
				</tr>
				
				<tr>
					<td><label for="dhInclusao">Data-Hora Inclusão:</label></td>
					<td><input type="text" value="<%=otdCliente.getDhIncusaoRegistro()%>"  disabled="disabled"
					id="<%=PRManterCliente.ID_REQ_ATR_dhInclusao%>"
						name="<%=PRManterCliente.ID_REQ_ATR_dhInclusao%>" maxlength="58"></td>
				</tr>

				<tr>
				<td colspan="2" id="botoes">
							<%
							if (indicadorExclusao) {
						%>
						<input type="button"
						value="Excluir"
						onclick="submeterFormulario('<%=PRManterCliente.NM_SERVLET%>','<%=PRManterCliente.EVENTO_PROCESSAR_EXCLUSAO%>')"
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

