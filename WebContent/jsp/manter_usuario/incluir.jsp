<%@page import="sgbr.util.Constantes"%>
<%@page import="sgbr.web.servlet.selects.SelectTipoUsuario"%>
<%@page import="sgbr.web.servlet.PRManterUsuario"%>
<%@page import="sgbr.web.servlet.selects.SelectFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Usuário</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

<SCRIPT language="JavaScript" type="text/javascript">

function validarSenhaConfirmacao() {
	
	if ((document.form_principal.senhaConfirmacao.value == "" || document.form_principal.senhaUsuario.value == "") || (document.form_principal.senhaConfirmacao.value != document.form_principal.senhaUsuario.value)){
		
		alert("Senha Inválida!");
		
		return false;
	} else {
		
		submeterFormulario('<%=PRManterUsuario.NM_SERVLET%>','<%=PRManterUsuario.EVENTO_PROCESSAR_INCLUSAO%>');
	}
	
}
</SCRIPT>
<body>
	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento"
			name="<%=PRManterUsuario.ID_REQ_EVENTO%>" value="">
	<INPUT type="hidden" id="<%=PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario%>"
			name="<%=PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario%>" value="<%=Constantes.CD_NAO%>">

		<fieldset>
			<table>
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_cdFuncionario%>">Funcionário:</label></td>
					<td><%= SelectFuncionario.getInstancia().getHTML(request, PRManterUsuario.ID_REQ_ATR_cdFuncionario, PRManterUsuario.ID_REQ_ATR_cdFuncionario, "",false,false,true)%></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_cdTpUsuario%>">Tipo de Usuário:</label></td>
					<td><%= SelectTipoUsuario.getInstancia().getHTML(request, PRManterUsuario.ID_REQ_ATR_cdTpUsuario, PRManterUsuario.ID_REQ_ATR_cdTpUsuario, "",false,false)%></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>">Login Usuário:</label></td>
					<td><input type="text" required 
						id="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_senhaUsuario%>">Senha:</label></td>
					<td><input type="password" required 
						id="<%=PRManterUsuario.ID_REQ_ATR_senhaUsuario%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_senhaUsuario%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_senhaConfirmacao%>">Senha Confirmação:</label></td>
					<td><input type="password" required 
						id="<%=PRManterUsuario.ID_REQ_ATR_senhaConfirmacao%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_senhaConfirmacao%>" 
						maxlength="58"></td>
				</tr>
				
				
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Incluir"
						onclick="return validarSenhaConfirmacao();"
						id="consultar"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>