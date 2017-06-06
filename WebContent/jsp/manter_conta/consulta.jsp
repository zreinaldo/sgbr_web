
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="sgbr.web.servlet.PRManterConta"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manter Conta</title>

<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

</head>
<%



%>


<body>

<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterConta.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>		
							
				<tr>
					<td><label for="cdItemCardapio">Numero Mesa:</label></td>
					<td><input type="search" id="<>" value="<>" name="<>" maxlength="15"></td>
					
					<td></td>
				</tr>
				
				<tr>
					<td><label for="nmItemCardapio">Numero Comanda:</label></td>
					<td><input type="search" id="<>" value="<>" name="<>" maxlength="15"></td>
				</tr>
							
				<tr>
					<td><label for="siItemCardapio">Situação conta:</label></td>
					<td><input type="search" id="<>" value="<>" name="<>" maxlength="15"></td>
				</tr>
								
				
			</table>


			<div id="divTabela">
				<table border="1" id="tab" style="width:100%">
					<tr>
					    <th>Selecione</th>
						<th>Conta</th>
						<th>Mesa</th>	
						<th>Comanda</th>
						<th>Cliente</th>								
						<th>Data Abertura</th>
						<th>Situação</th>
				
					</tr>

				</table>
				
				<table>
				<tr>
					<td colspan="2" id="botoes">
					
					
					    <input type="button" value="Consultar"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_PROCESSAR_CONSULTA%>')" id="consultar">
					    <input type="button" value="Abrir Conta Mesa"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_ABRIR_CONTA%>')" id="abrirContaMesa">
					 					    
					   
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>