<%@page import="sgbr.util.OTDConta"%>
<%@page import="sgbr.util.Constantes"%>
<%@page import="sgbr.web.servlet.selects.SelectClienteConta"%>
<%@page import="sgbr.web.servlet.selects.SelectComandaConta"%>
<%@page import="sgbr.web.servlet.selects.SelectMesaConta"%>
<%@page import="sgbr.web.servlet.PRManterConta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Conta</title>
</head>

<%
  OTDConta otdConta = (OTDConta) PRManterConta.getAtributoOpcional(PRManterConta.ID_REQ_ATR_otdConta,request);

%>

<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>
<body>
	<FORM name="form_principal" method="post" action="">


<%@ include file = "../../jsp/util/menu.jsp" %>

		<INPUT type="hidden" id="evento" name="<%=PRManterConta.ID_REQ_EVENTO%>" value="">
		<INPUT type="hidden" id="cdConta" name="<%=PRManterConta.ID_REQ_ATR_cdConta%>" value="<%=otdConta.getCdConta()%>">

		<fieldset>
			<table>
			
			<th>Alterar Conta</th>
			<tr>
				<tr>
					<td><label for="cdConta">Conta:</label></td>
					<td><input type="text" readonly="readonly" 
						id="<%=PRManterConta.ID_REQ_ATR_cdConta%>"
						name="<%=PRManterConta.ID_REQ_ATR_cdConta%>" maxlength="58" value="<%=otdConta.getCdConta()%>"> </td>
				</tr>
				<tr>
					<td><label for="cdMesa">Mesa:</label></td>
					<td><input type="text" readonly="readonly"
						id="<%=PRManterConta.ID_REQ_ATR_cdMesa%>"
						name="<%=PRManterConta.ID_REQ_ATR_cdMesa%>" maxlength="58" value="<%=otdConta.getCdMesa()%>"> </td>
				</tr>
				<% if (otdConta.getCdComanda() != null){ %>
				<tr>
					<td><label for="cdComanda">Comanda:</label></td>
					<td><input type="text" readonly="readonly" 
						id="<%=PRManterConta.ID_REQ_ATR_cdComanda%>"
						name="<%=PRManterConta.ID_REQ_ATR_cdComanda%>" maxlength="58" value="<%=otdConta.getCdComanda()%>"> </td>
				</tr>
				<% } %>
				
				<tr>
					<td><label for="<%=PRManterConta.ID_REQ_ATR_cdCliente%>">Cliente:</label></td>
					<td><%=SelectClienteConta.getInstancia().getHTML(request, PRManterConta.ID_REQ_ATR_cdCliente, PRManterConta.ID_REQ_ATR_cdCliente, otdConta.getCdCliente() != null ? otdConta.getCdCliente().toString() : "", true, false, false)	%></td>
				</tr>	
			
			
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Alterar"
						onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_PROCESSAR_ALTERACAO%>')"
						id="alterar"> <input type="button" value="Voltar"
						onclick=" window.history.back();" id="voltar"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>