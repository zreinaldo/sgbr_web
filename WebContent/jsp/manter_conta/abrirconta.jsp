<%@page import="sgbr.web.servlet.PRManterConta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Abrir Conta</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>
<body>
	<FORM name="form_principal" method="post" action="">


<%@ include file = "../../jsp/util/menu.jsp" %>

		<INPUT type="hidden" id="evento" name="<%=PRManterConta.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
				<tr>
					<td><label for="<%=PRManterConta.ID_REQ_ATR_cdMesa%>">Numero Mesa:</label></td>
					<td>SelectMEsa</td>
				</tr>			

				<tr>
					<td><label for="<%=PRManterConta.ID_REQ_ATR_cdComanda%>">Numero Comanda:</label></td>
					<td>SelectComanda</td>
				</tr>	
				
				<tr>
					<td><label for="<%=PRManterConta.ID_REQ_ATR_cdCliente%>">Cliente:</label></td>
					<td>SelectCliente</td>
				</tr>	
			
			
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Incluir"
						onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_PROCESSAR_ABRIR_CONTA%>')"
						id="consultar"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>