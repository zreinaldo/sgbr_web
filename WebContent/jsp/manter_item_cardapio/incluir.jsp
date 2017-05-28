<%@page import="sgbr.web.servlet.selects.SelectSituacaoItemCardapio"%>
<%@page import="sgbr.web.servlet.PRManterItemCardapio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Item Cardápio</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>
<body>
	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento"
			name="<%=PRManterItemCardapio.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
							

				<tr>
					<td><label for="<%=PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio%>">Descrição Item Cardápio:</label></td>
					<td><input type="text" required 
						id="<%=PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterItemCardapio.ID_REQ_ATR_vlItemCardapio%>">Valor :</label></td>
					<td><input type="text" required 
						id="<%=PRManterItemCardapio.ID_REQ_ATR_vlItemCardapio%>"
						name="<%=PRManterItemCardapio.ID_REQ_ATR_vlItemCardapio%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="siItemCardapio">Situação:</label></td>
					<td><%= SelectSituacaoItemCardapio.getInstancia().getHTML(request, PRManterItemCardapio.ID_REQ_ATR_siItemCardapio, PRManterItemCardapio.ID_REQ_ATR_siItemCardapio, "",false,false)%></td>
				</tr>
			
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Incluir"
						onclick="submeterFormulario('<%=PRManterItemCardapio.NM_SERVLET%>','<%=PRManterItemCardapio.EVENTO_PROCESSAR_INCLUSAO%>')"
						id="consultar"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>