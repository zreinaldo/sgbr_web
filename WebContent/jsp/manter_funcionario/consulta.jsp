<%@page import="sgbr.web.servlet.PRManterFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
					<td><label for="nomeCliente">Nome:</label></td>
					<td><input type="text" id="nmFuncionario" name="nmFuncionario"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nomeCliente">CPF:</label></td>
					<td><input type="text" id="nuCPF" name="nuCPF" maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nomeCliente">Nome:</label></td>
					<td><input type="text" id="nmFuncionario" name="nmFuncionario"
						maxlength="58"></td>
				</tr>

				<tr>
					<td colspan="2" id="botoes"><input type="button"
						value="Consultar"
						onclick="submeterFormulario('<%=PRManterFuncionario.NM_SERVLET%>','<%=PRManterFuncionario.EVENTO_EXIBIR_INCLUSAO%>')"
						id="consultar"> <input type="button" value="Pesquisar"
						onclick="submeterFormulario(PRManterFuncionario,processarFiltroConsulta)">
						<input type="button" value="Novo" OnClick=""> <input
						type="button" value="Home" onClick=""></td>
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