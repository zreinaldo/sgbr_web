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
<title>Abrir Conta</title>
</head>

<%
  String cdTipoConta = PRManterConta.getAtributoOuParametroStringOpcional(PRManterConta.ID_REQ_ATR_cdTipoConta,request);

%>

<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>
<body>
	<FORM name="form_principal" method="post" action="">


<%@ include file = "../../jsp/util/menu.jsp" %>

		<INPUT type="hidden" id="evento" name="<%=PRManterConta.ID_REQ_EVENTO%>" value="">
	<INPUT type="hidden" id="cdTipoConta" name="<%=PRManterConta.ID_REQ_ATR_cdTipoConta%>" value="<%=cdTipoConta%>">

		<fieldset>
			<table>
									<%
	if (cdTipoConta.equals((Constantes.CD_TIPO_CONTA_COMANDA))) {
	 
%>
<th>Abrir Conta por Comanda</th>

<%} else {%>
<th>Abrir Conta por Mesa</th>
<%} %>
			
			<tr>
					<td><label for="<%=PRManterConta.ID_REQ_ATR_cdMesa%>">Número Mesa:</label></td>
					<%if (cdTipoConta.equals(Constantes.CD_TIPO_CONTA_COMANDA) ) { %>
					<td><%=SelectMesaConta.getInstancia().getHTML(request, PRManterConta.ID_REQ_ATR_cdMesa, PRManterConta.ID_REQ_ATR_cdMesa, "", true, false, Constantes.CD_NAO, Constantes.CD_TIPO_CONTA_MESA)	%></td>
					
					<%} else {  %>
					<td><%=SelectMesaConta.getInstancia().getHTML(request, PRManterConta.ID_REQ_ATR_cdMesa, PRManterConta.ID_REQ_ATR_cdMesa, "", true, false, Constantes.CD_NAO)%></td>
					<%} %>
				</tr>			

			<%if (cdTipoConta.equals(Constantes.CD_TIPO_CONTA_COMANDA)) {  %>
				<tr>
					<td><label for="<%=PRManterConta.ID_REQ_ATR_cdComanda%>">Número Comanda:</label></td>
					<td><%=SelectComandaConta.getInstancia().getHTML(request, PRManterConta.ID_REQ_ATR_cdComanda, PRManterConta.ID_REQ_ATR_cdComanda, "", true, false, Constantes.CD_NAO)	%></td>
				</tr>
				<%} %>	
				
				<tr>
					<td><label for="<%=PRManterConta.ID_REQ_ATR_cdCliente%>">Cliente:</label></td>
					<td><%=SelectClienteConta.getInstancia().getHTML(request, PRManterConta.ID_REQ_ATR_cdCliente, PRManterConta.ID_REQ_ATR_cdCliente, "", true, false, false)	%></td>
				</tr>	
			
			
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Incluir"
						onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_PROCESSAR_ABRIR_CONTA%>')"
						id="consultar">  <input type="button" value="Voltar"
						onclick=" window.history.back();" id="voltar"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>