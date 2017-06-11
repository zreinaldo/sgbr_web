<%@page import="sgbr.web.servlet.selects.SelectSituacaoItemCardapio"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Item Cardápio</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	
	<%
	

	ItemCardapio itemCardapio =  (ItemCardapio) PRManterItemCardapio.getAtributoOpcional(PRManterItemCardapio.ID_REQ_ATR_ItemCardapio,request); 

		
	%>

<body>
<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterItemCardapio.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
					<tr>
			<th align="left">Alterar Item Cardápio</th>
			</tr>	
				

				<tr>
					<td><label for="cdItemCardapio">Código Item Cardápio:</label></td>
					<td><input type="text" readonly="readonly" 
						id="<%=PRManterItemCardapio.ID_REQ_ATR_cdItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_cdItemCardapio%>" value="<%=itemCardapio.getCdItemCardapio()%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nmItemCardapio">Descrição:</label></td>
					<td><input type="text" required
						id="<%=PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio%>" value="<%=itemCardapio.getNmItemCardapio()%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="vlItemCardapio">Valor:</label></td>
					<td><input type="text" required
						id="<%=PRManterItemCardapio.ID_REQ_ATR_vlItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_vlItemCardapio%>" maxlength="58" value="<%=itemCardapio.getVlItemCardapio()%>"> </td>
				</tr>
			
			
			<tr>
					<td><label for="siItemCardapio">Situação:</label></td>
					
					<td><%= SelectSituacaoItemCardapio.getInstancia().getHTML(request, PRManterItemCardapio.ID_REQ_ATR_siItemCardapio, PRManterItemCardapio.ID_REQ_ATR_siItemCardapio, itemCardapio.getSiItemCardapio(),false,false)%></td>
					
				</tr>

				
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Alterar"
						onclick="submeterFormulario('<%=PRManterItemCardapio.NM_SERVLET%>','<%=PRManterItemCardapio.EVENTO_PROCESSAR_ALTERACAO%>')"
						id="alterar"><input type="button" value="Voltar"
						onclick=" window.history.back();" id="voltar"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>