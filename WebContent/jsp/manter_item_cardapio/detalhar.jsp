<%@page import="sgbr.web.servlet.PRManterItemCardapio"%>
<%@page import="sgbr.entidades.ItemCardapio"%>
<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.OTDItemCardapio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.PRManterItemCardapio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<%
	boolean indicadorExclusao = false;
	indicadorExclusao = (Boolean) PRManterItemCardapio.getAtributoOpcional(PRManterItemCardapio.ID_REQ_indicadorExclusao, request);
	if (indicadorExclusao) {
%>
<title>Excluir Item Cardápio</title>
<%
	} else {
%>
<title>Detalhar Item Cardápio</title>
<%
	}
%>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	
	<%
	

	ItemCardapio itemCardapio =  (ItemCardapio) PRManterItemCardapio.getAtributoOpcional(PRManterItemCardapio.ID_REQ_ATR_ItemCardapio,request); 

		
	%>

<body>
<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterItemCardapio.ID_REQ_EVENTO%>" value="">
			<INPUT type="hidden" id="cdItemCardapio" name="<%=PRManterItemCardapio.ID_REQ_ATR_cdItemCardapio%>" value="<%=itemCardapio.getCdItemCardapio()%> ">


		<fieldset>
			<table>
	<%	if (indicadorExclusao) { %>
<th align="left">Excluir Item Cardápio</th>

<%} else {%>
<th align="left">Detalhar Item Cardápio</th>
<%} %>	
					

				<tr>
					<td><label for="cdItemCardapio">Código Item Cardápio:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterItemCardapio.ID_REQ_ATR_cdItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_cdItemCardapio%>" value="<%=itemCardapio.getCdItemCardapio() %>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="cdItemCardapio">Descrição :</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio%>" value="<%=itemCardapio.getNmItemCardapio() %>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="cdItemCardapio">Situação:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterItemCardapio.ID_REQ_ATR_siItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_siItemCardapio%>" value="<%=Util.getDsSiItemCardapio(itemCardapio.getSiItemCardapio()) %>"
						maxlength="58"></td>
				</tr>

					<tr>
					<td><label for="dtFimValidade">Valor:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterItemCardapio.ID_REQ_ATR_vlItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_vlItemCardapio%>" maxlength="58" value="<%=itemCardapio.getVlItemCardapio()%>"> </td>
				</tr>
			

				
				<tr>
					<td colspan="2" id="botoes">
							<%
							if (indicadorExclusao) {
						%>
						<input type="button"
						value="Excluir"
						onclick="submeterFormulario('<%=PRManterItemCardapio.NM_SERVLET%>','<%=PRManterItemCardapio.EVENTO_PROCESSAR_EXCLUSAO%>')"
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