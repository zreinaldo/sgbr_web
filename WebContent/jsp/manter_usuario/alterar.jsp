<%@page import="sgbr.web.servlet.selects.SelectSimNao"%>
<%@page import="sgbr.web.servlet.selects.SelectTipoUsuario"%>
<%@page import="sgbr.web.servlet.PRManterUsuario"%>
<%@page import="sgbr.util.OTDUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Usuário</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

<SCRIPT language="JavaScript" type="text/javascript">

function validarSenhaConfirmacao() {
	if ( document.form_principal.senhaUsuario.value != "" && (document.form_principal.senhaConfirmacao.value != document.form_principal.senhaUsuario.value
	|| 	document.form_principal.senhaAnteriorConfirmacao.value != document.form_principal.senhaAnterior.value)	
	){
		alert("Senha Inválida!");
		
		return false;
	} else {
		 submeterFormulario('<%=PRManterUsuario.NM_SERVLET%>','<%=PRManterUsuario.EVENTO_PROCESSAR_ALTERACAO%>');
	}
}
</SCRIPT>

	
	<%
	

	OTDUsuario otdUsuario =  (OTDUsuario) PRManterUsuario.getAtributoOpcional(PRManterUsuario.ID_REQ_ATR_Usuario,request); 

		
	%>


<body>
<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterUsuario.ID_REQ_EVENTO%>" value="">
		<INPUT type="hidden" id="<%=PRManterUsuario.ID_REQ_ATR_senhaAnterior%>" name="<%=PRManterUsuario.ID_REQ_ATR_senhaAnterior%>" value="<%=otdUsuario.getSenhaUsuario()%>">
		<INPUT type="hidden" id="<%=PRManterUsuario.ID_REQ_ATR_cdUsuario%>" name="<%=PRManterUsuario.ID_REQ_ATR_cdUsuario%>" value="<%=otdUsuario.getCdUsuario()%>">
		<INPUT type="hidden" id="<%=PRManterUsuario.ID_REQ_ATR_cdFuncionario%>" name="<%=PRManterUsuario.ID_REQ_ATR_cdFuncionario%>" value="<%=otdUsuario.getCdFuncionario()%>">


		<fieldset>
			<table>
				
				<tr>
					<td><label for="nmFuncionario">Funcionário:</label></td>
					<td><input type="text" readonly="readonly"
						id="<%=PRManterUsuario.ID_REQ_ATR_nmFuncionario%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_nmFuncionario%>" value="<%=otdUsuario.getNmFuncionario()%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario%>">Bloquear Usuário:</label></td>
					<td><%= SelectSimNao.getInstancia().getHTML(request, PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario, PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario, otdUsuario.getInBloqueioUsuario(),true,false)%></td>
				</tr>
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_cdTpUsuario%>">Tipo de Usuário:</label></td>
					<td><%= SelectTipoUsuario.getInstancia().getHTML(request, PRManterUsuario.ID_REQ_ATR_cdTpUsuario, PRManterUsuario.ID_REQ_ATR_cdTpUsuario, otdUsuario.getCdTpUsuario().toString(),true,false)%></td>
				</tr>
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>">Login Usuário:</label></td>
					<td><input type="text" required
						id="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>" value="<%=otdUsuario.getLoginUsuario()%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="senhaAnteriorConfirmacao">Senha Anterior:</label></td>
					<td><input type="password"  
						id="<%=PRManterUsuario.ID_REQ_ATR_senhaAnteriorConfirmacao%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_senhaAnteriorConfirmacao%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_senhaUsuario%>">Nova Senha:</label></td>
					<td><input type="password"  
						id="<%=PRManterUsuario.ID_REQ_ATR_senhaUsuario%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_senhaUsuario%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_senhaConfirmacao%>">Nova Senha Confirmação:</label></td>
					<td><input type="password"  
						id="<%=PRManterUsuario.ID_REQ_ATR_senhaConfirmacao%>"
						name="<%=PRManterUsuario.ID_REQ_ATR_senhaConfirmacao%>" 
						maxlength="58"></td>
				</tr>

				
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Alterar"
						onclick="return validarSenhaConfirmacao();"
						id="alterar"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>