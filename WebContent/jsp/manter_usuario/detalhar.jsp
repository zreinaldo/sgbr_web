<%@page import="sgbr.web.servlet.PRManterUsuario"%>
<%@page import="sgbr.entidades.Usuario"%>
<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.OTDUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<%
	boolean indicadorExclusao = false;
	indicadorExclusao = (Boolean) PRManterUsuario.getAtributoOpcional(PRManterUsuario.ID_REQ_indicadorExclusao, request);
	if (indicadorExclusao) {
%>
<title>Excluir Usuário</title>
<%
	} else {
%>
<title>Detalhar Usuário</title>
<%
	}
%>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	
	<%
	

	OTDUsuario otdUsuario =  (OTDUsuario) PRManterUsuario.getAtributoOpcional(PRManterUsuario.ID_REQ_ATR_Usuario,request); 

		
	%>

<body>
<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterUsuario.ID_REQ_EVENTO%>" value="">
			<INPUT type="hidden" id="cdUsuario" name="<%=PRManterUsuario.ID_REQ_ATR_cdUsuario%>" value="<%=otdUsuario.getCdUsuario()%> ">


		<fieldset>
			<table>
				
<%	if (indicadorExclusao) { %>
<th align="left">Excluir Usuário</th>

<%} else {%>
<th align="left">Detalhar Usuário</th>
<%} %>	
		
				<tr>
					<td><label for="nmFuncionario">Funcionário:</label></td>
					<td><input type="text" readonly="readonly"
						id="<%=PRManterUsuario.ID_REQ_ATR_nmFuncionario%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_nmFuncionario%>" value="<%=otdUsuario.getNmFuncionario()%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario%>">Usuário Bloqueado:</label></td>
					<td><input type="text" readonly="readonly"
						id="<%=PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario%>" value="<%=Util.getDsSimNao(otdUsuario.getInBloqueioUsuario())%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_nmTpUsuario%>">Tipo de Usuário:</label></td>
					<td><input type="text" readonly="readonly"
						id="<%=PRManterUsuario.ID_REQ_ATR_nmTpUsuario%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_nmTpUsuario%>" value="<%=otdUsuario.getNmTpUsuario()%>"
						maxlength="58"></td>
				</tr>
				
				
				
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>">Login Usuário:</label></td>
					<td><input type="text" readonly="readonly"
						id="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>" value="<%=otdUsuario.getLoginUsuario()%>"
						maxlength="58"></td>
				</tr>
			

				
				<tr>
					<td colspan="2" id="botoes">
							<%
							if (indicadorExclusao) {
						%>
						<input type="button"
						value="Excluir"
						onclick="submeterFormulario('<%=PRManterUsuario.NM_SERVLET%>','<%=PRManterUsuario.EVENTO_PROCESSAR_EXCLUSAO%>')"
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