<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.OTDConta"%>
<%@page import="sgbr.web.servlet.PRManterConta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	boolean indicadorExclusao = false;
	indicadorExclusao = (Boolean) PRManterConta.getAtributoOpcional(PRManterConta.ID_REQ_indicadorExclusao, request);
	if (indicadorExclusao) {
%>
<title>Excluir Conta</title>
<%
	} else {
%>
<title>Detalhar Conta</title>
<%
	}
%>
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
							<%
	if (indicadorExclusao) {
	 
%>
<th>Excluir Conta</th>

<%} else {%>
<th>Detalhar Conta</th>
<%} %>
			
			
			<tr>
				<tr>
					<td><label for="cdConta2">Conta:</label></td>
					<td><input type="text" readonly="readonly" disabled="disabled"
						id="<%=PRManterConta.ID_REQ_ATR_cdConta%>2"
						name="<%=PRManterConta.ID_REQ_ATR_cdConta%>2" maxlength="58" value="<%=otdConta.getCdConta()%>"> </td>
				</tr>
				<tr>
					<td><label for="cdMesa">Mesa:</label></td>
					<td><input type="text" readonly="readonly" disabled="disabled"
						id="<%=PRManterConta.ID_REQ_ATR_cdMesa%>"
						name="<%=PRManterConta.ID_REQ_ATR_cdMesa%>" maxlength="58" value="<%=otdConta.getCdMesa()%>"> </td>
				</tr>
				<% if (otdConta.getCdComanda() != null){ %>
				<tr>
					<td><label for="cdComanda">Comanda:</label></td>
					<td><input type="text" readonly="readonly" disabled="disabled"
						id="<%=PRManterConta.ID_REQ_ATR_cdComanda%>"
						name="<%=PRManterConta.ID_REQ_ATR_cdComanda%>" maxlength="58" value="<%=otdConta.getCdComanda()%>"> </td>
				</tr>
				<% } %>
				
				
				<tr>
					<td><label for="cdMesa">Desconto na Conta em R$:</label></td>
					<td><input type="text" value="<%=Util.getValorHTML(otdConta.getVlDescontoConta())%>"  disabled="disabled"						
						maxlength="58"></td>				
				</tr>
				
						
				<tr>
					<td><label for="cdMesa">Desconto na Conta em %:</label></td>
					<td><input type="text"  value="<%=Util.getValorHTML(otdConta.getPercDescontoConta())%>"  disabled="disabled"					
						maxlength="58"></td>			
				</tr>	
				
				
				<tr>
					<td><label for="cdMesa">Valor da Conta Original R$:</label></td>
					<td><input type="text"  value="<%=Util.getValorHTML(otdConta.getVlContaOriginal())%>" disabled="disabled"
						maxlength="58"></td>			
				</tr>	
				
				<tr>
					<td><label for="cdMesa">Valor Final da Conta R$:</label></td>
					<td><input type="text" value="<%=Util.getValorHTML(otdConta.getVlContaFinal())%>"	 disabled="disabled"				
						maxlength="58"></td>				
				</tr>		
				
				
				
				<tr>
					<td><label for="<%=PRManterConta.ID_REQ_ATR_nmCliente%>">Cliente:</label></td>
					<td><input type="text" readonly="readonly" disabled="disabled"
						id="<%=PRManterConta.ID_REQ_ATR_nmCliente%>"
						name="<%=PRManterConta.ID_REQ_ATR_nmCliente%>" maxlength="58" value="<%=otdConta.getNmCliente() != null ? otdConta.getNmCliente() :  ""%>"> </td>
				</tr>	
				
<%
	if (indicadorExclusao) {
	 
%>
<tr>
<td colspan="2">*Contas com pedidos não serão excluídas*</td>
</tr>

<%} %>
			
			
				<tr>
					<td colspan="2" id="botoes">
							<%
							if (indicadorExclusao) {
						%>
						<input type="button"
						value="Excluir"
						onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_PROCESSAR_EXCLUSAO%>')"
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