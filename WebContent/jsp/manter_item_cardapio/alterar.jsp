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
<title>Alterar Item Card�pio</title>
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
					<td><label for="cdItemCardapio">C�digo Item Card�pio:</label></td>
					<td><input type="text" readonly="readonly"
						id="<%=PRManterItemCardapio.ID_REQ_ATR_cdItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_cdItemCardapio%>" value="<%=itemCardapio.getCdItemCardapio()%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="cdItemCardapio">Descri��o:</label></td>
					<td><input type="text"
						id="<%=PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio%>" value="<%=itemCardapio.getNmItemCardapio()%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="dtFimValidade">Valor:</label></td>
					<td><input type="text"
						id="<%=PRManterItemCardapio.ID_REQ_ATR_vlItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_vlItemCardapio%>" maxlength="58" value="<%=itemCardapio.getVlItemCardapio()%>"> </td>
				</tr>
			
			
			<tr>
					<td><label for="dtFimValidade">Situa��o:</label></td>
					<td><input type="text"
						id="<%=PRManterItemCardapio.ID_REQ_ATR_siItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_siItemCardapio%>" maxlength="58" value="<%itemCardapio.getSiItemCardapio()%>"> </td>
				</tr>

				
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Alterar"
						onclick="submeterFormulario('<%=PRManterItemCardapio.NM_SERVLET%>','<%=PRManterItemCardapio.EVENTO_PROCESSAR_ALTERACAO%>')"
						id="alterar"><input type="button" value="Home"
						onClick=""></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>