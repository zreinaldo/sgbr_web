<%@page import="sgbr.util.Constantes"%>
<%@page import="sgbr.web.servlet.selects.SelectComandaConta"%>
<%@page import="sgbr.web.servlet.selects.SelectMesaConta"%>
<%@page import="sgbr.web.servlet.selects.SelectItemCardapio"%>
<%@page import="sgbr.web.servlet.PRManterPedido"%>
<%@page import="sgbr.web.servlet.selects.SelectSituacaoItemCardapio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Item no Pedido</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>
<body>
	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento"
			name="<%=PRManterPedido.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
							<Th> Conta por:</Th>
				<tr> 
					<td><label for="cdMesa">Mesa:</label></td>
					<td><%= SelectMesaConta.getInstancia().getHTML(request, PRManterPedido.ID_REQ_ATR_cdMesa, PRManterPedido.ID_REQ_ATR_cdMesa, "", false, true, "", Constantes.CD_TIPO_CONTA_MESA)	%></td>
					
					<td></td>
				
				</tr>			

			<tr>
				
					<td><label for="cdComanda">Comanda:</label></td>
					<td><%= SelectComandaConta.getInstancia().getHTML(request, PRManterPedido.ID_REQ_ATR_cdComanda, PRManterPedido.ID_REQ_ATR_cdComanda, "", false, true, Constantes.CD_SIM, Constantes.CD_TIPO_CONTA_COMANDA)	%></td>
				</tr>			

			<tr>
					<td><label for="cdItemCardapio">Item do Cadápio:</label></td>
					<td><%= SelectItemCardapio.getInstancia().getHTML(request, PRManterPedido.ID_REQ_ATR_cdItemCardapio, PRManterPedido.ID_REQ_ATR_cdItemCardapio, "",true,false)%></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterPedido.ID_REQ_ATR_qtdItemCardapio%>">Quantidade:</label></td>
					<td><input type="text" required 
						id="<%=PRManterPedido.ID_REQ_ATR_qtdItemCardapio%>"
						name="<%=PRManterPedido.ID_REQ_ATR_qtdItemCardapio%>"
						maxlength="58"></td>
				</tr>
				
				
			
			
				<tr>
					<td><label for="<%=PRManterPedido.ID_REQ_ATR_obsItemCardapio%>">Observação:</label></td>
					<td><input type="text"  
						id="<%=PRManterPedido.ID_REQ_ATR_obsItemCardapio%>"
						name="<%=PRManterPedido.ID_REQ_ATR_obsItemCardapio%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Incluir"
						onclick="submeterFormulario('<%=PRManterPedido.NM_SERVLET%>','<%=PRManterPedido.EVENTO_PROCESSAR_INCLUSAO%>')"
						id="consultar"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>