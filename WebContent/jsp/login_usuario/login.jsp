<%@page import="sgbr.util.Constantes"%>
<%@page import="sgbr.web.servlet.PRLoginUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Usuário</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

<SCRIPT language="JavaScript" type="text/javascript">

function validarSenhaConfirmacao() {
	
	if ((document.form_principal.loginUsuario.value == "" || document.form_principal.senhaUsuario.value == "")){
		
		alert("Login/Senha Inválida!");
		
		return false;
	} else {
		
		submeterFormulario('<%=PRLoginUsuario.NM_SERVLET%>','<%=PRLoginUsuario.EVENTO_PROCESSAR_LOGIN_USUARIO%>');
	}
	
}
</SCRIPT>

<%
	
boolean isLoginSenhaInvalida = false;
isLoginSenhaInvalida = (Boolean) PRLoginUsuario.getAtributoOpcional(PRLoginUsuario.ID_REQ_ATR_isLoginSenhaInvalida, request);

		
	%>
<body>
	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento"
			name="<%=PRLoginUsuario.ID_REQ_EVENTO%>" value="">

		<fieldset>
		
			<table>
			<tr>
			<th align="left" colspan="2">Sistema de Gerenciamento de Bares e Restaurante - SGBR</th>
			</tr>
				<% if (isLoginSenhaInvalida){ %>
					
				<tr>
					<td><label for="<%=PRLoginUsuario.ID_REQ_ATR_isLoginSenhaInvalida%>">Login/Senha Inválida!</label></td></tr>
				<% } %>		
				<tr>
					<td><label for="<%=PRLoginUsuario.ID_REQ_ATR_loginUsuario%>">Login Usuário:</label></td>
					<td><input type="text" required 
						id="<%=PRLoginUsuario.ID_REQ_ATR_loginUsuario%>"
						name="<%=PRLoginUsuario.ID_REQ_ATR_loginUsuario%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRLoginUsuario.ID_REQ_ATR_senhaUsuario%>">Senha:</label></td>
					<td><input type="password" required 
						id="<%=PRLoginUsuario.ID_REQ_ATR_senhaUsuario%>"
						name="<%=PRLoginUsuario.ID_REQ_ATR_senhaUsuario%>"
						maxlength="58"></td>
				</tr>
			
					
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Entrar"
						onclick="return validarSenhaConfirmacao();"
						id="entrar"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>