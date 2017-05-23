<%@page import="sgbr.web.servlet.selects.SelectTipoDocumento"%>
<%@page import="sgbr.web.servlet.selects.SelectTipoFuncionario"%>
<%@page import="sgbr.web.servlet.PRManterFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%

String tpDocumento = PRManterFuncionario.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_tpDocumento, request);
String tpFuncionario = PRManterFuncionario.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_tpCargo, request);








%>


<body>
	<script type="text/javascript">
		function submeterFormulario(pServlet, pEvento) {
			alert(pServlet);
			alert(pEvento);
			document.form_principal.action = pServlet;
			evento = eval("document.form_principal.evento");
			if (evento != null) {
				evento.value = pEvento;
			}

			document.form_principal.submit();

		}
	</script>
	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento"
			name="<%=PRManterFuncionario.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
			
							
				<tr>
					<td><label for="tpDocumento">Tipo Documento:</label></td>
					<td><%= SelectTipoDocumento.getInstancia().getHTML(request, PRManterFuncionario.ID_REQ_ATR_tpDocumento, PRManterFuncionario.ID_REQ_ATR_tpDocumento, tpDocumento)%></td>
				</tr>
				
				<tr>
					<td><label for="nuDocumento">Número Documento:</label></td>
					<td><input type="text" id="<%=PRManterFuncionario.ID_REQ_ATR_nuDocumento%>" name="<%=PRManterFuncionario.ID_REQ_ATR_nuDocumento%>" maxlength="15"></td>
				</tr>
				
				<tr>
					<td><label for="nomeCliente">Cargo:</label></td>
					<td><%=SelectTipoFuncionario.getInstancia().getHTML(request, PRManterFuncionario.ID_REQ_ATR_tpCargo, PRManterFuncionario.ID_REQ_ATR_tpCargo, tpFuncionario) %></td>
				</tr>
			
				<tr>
					<td><label for="nomeCliente">Nome Funcionario:</label></td>
					<td><input type="text" id="<%=PRManterFuncionario.ID_REQ_ATR_nmFuncionario%>" name="<%=PRManterFuncionario.ID_REQ_ATR_nmFuncionario%>"
						maxlength="45"></td>
				</tr>		

				<tr>
					<td colspan="2" id="botoes">
					    <input type="button" value="Incluir"	onclick="submeterFormulario('<%=PRManterFuncionario.NM_SERVLET%>','<%=PRManterFuncionario.EVENTO_EXIBIR_INCLUSAO%>')" id="incluir"> 
					    <input type="button" value="Consultar"	onclick="submeterFormulario('<%=PRManterFuncionario.NM_SERVLET%>','<%=PRManterFuncionario.EVENTO_PROCESSAR_CONSULTA%>')" id="consultar">
					    <input type="button" value="Alterar" OnClick=""> 
					    <input type="button" value="Excluir" onClick="">
					</td>
				</tr>
			</table>


			<div id="divTabela">
				<table border="1" id="tab">
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>Cargo</th>						
					</tr>
		 
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				
				</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>