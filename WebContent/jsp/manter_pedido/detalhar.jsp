<%@page import="sgbr.util.OTDContaItemCardapio"%>
<%@page import="sgbr.web.servlet.PRManterPedido"%>
<%@page import="sgbr.util.Util"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<%
	boolean indicadorExclusao = false;
	indicadorExclusao = (Boolean) PRManterPedido.getAtributoOpcional(PRManterPedido.ID_REQ_indicadorExclusao, request);
	if (indicadorExclusao) {
%>
<title>Excluir Pedido</title>
<%
	} else {
%>
<title>Detalhar Pedido</title>
<%
	}
%>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	
	<%
	

	OTDContaItemCardapio otdContaItemCardapio =  (OTDContaItemCardapio) PRManterPedido.getAtributoOpcional(PRManterPedido.ID_REQ_ATR_otdContaItemPedido,request); 

		
	%>

<body>
<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterPedido.ID_REQ_EVENTO%>" value="">
		<INPUT type="hidden" id="cdPedido" name="<%=PRManterPedido.ID_REQ_ATR_cdPedido%>" value="<%=otdContaItemCardapio.getCdPedido()%>">


		<fieldset>
			<table>
										<%
	if (indicadorExclusao) {
	 
%>
<th align="left">Excluir Pedido</th>

<%} else {%>
<th align="left">Detalhar Pedido</th>
<%} %>
<tr>
					<td><label for="cdConta">Conta:</label></td>
					<td><input type="text" readonly="readonly" disabled="disabled"
						id="<%=PRManterPedido.ID_REQ_ATR_cdConta%>"
						name="<%=PRManterPedido.ID_REQ_ATR_cdConta%>" maxlength="58" value="<%=otdContaItemCardapio.getCdConta()%>"> </td>
				</tr>
				<tr>
					<td><label for="cdMesa">Mesa:</label></td>
					<td><input type="text" readonly="readonly" disabled="disabled"
						id="<%=PRManterPedido.ID_REQ_ATR_cdMesa%>"
						name="<%=PRManterPedido.ID_REQ_ATR_cdMesa%>" maxlength="58" value="<%=otdContaItemCardapio.getCdMesa()%>"> </td>
				</tr>
				<% if (otdContaItemCardapio.getCdComanda() != null){ %>
				<tr>
					<td><label for="cdComanda">Comanda:</label></td>
					<td><input type="text" readonly="readonly" disabled="disabled"
						id="<%=PRManterPedido.ID_REQ_ATR_cdComanda%>"
						name="<%=PRManterPedido.ID_REQ_ATR_cdComanda%>" maxlength="58" value="<%=otdContaItemCardapio.getCdComanda()%>"> </td>
				</tr>
				<% } %>
				
				<tr>
					<td><label for="nmItemCardapio">Item Cardápio:</label></td>
					<td><input type="text" readonly="readonly" disabled="disabled"
						id="<%=PRManterPedido.ID_REQ_ATR_nmItemCardapio%>"
						name="<%=PRManterPedido.ID_REQ_ATR_nmItemCardapio%>" value="<%=otdContaItemCardapio.getNmItemCardapio()%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="qtdItemCardapio">Quantidade:</label></td>
					<td><input type="text" readonly="readonly" disabled="disabled"
						id="<%=PRManterPedido.ID_REQ_ATR_qtdItemCardapio%>"
						name="<%=PRManterPedido.ID_REQ_ATR_qtdItemCardapio%>" value="<%=otdContaItemCardapio.getQtdItemCardapio()%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="obsItemCardapio">Observação:</label></td>
					<td><input type="text" readonly="readonly" disabled="disabled"
						id="<%=PRManterPedido.ID_REQ_ATR_obsItemCardapio%>"
						name="<%=PRManterPedido.ID_REQ_ATR_obsItemCardapio%>" maxlength="58" value="<%=otdContaItemCardapio.getObsItemCardapio()%>"> </td>
				</tr>
			

				
				<tr>
					<td colspan="2" id="botoes">
							<%
							if (indicadorExclusao) {
						%>
						<input type="button"
						value="Excluir"
						onclick="submeterFormulario('<%=PRManterPedido.NM_SERVLET%>','<%=PRManterPedido.EVENTO_PROCESSAR_EXCLUSAO%>')"
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