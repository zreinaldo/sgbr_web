<%@page import="sgbr.web.servlet.PRManterCliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Cliente</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>
<body>
	<FORM name="form_principal" method="post" action="">
<%@ include file = "../../jsp/util/menu.jsp" %>

	
		<INPUT type="hidden" id="evento"
			name="<%=PRManterCliente.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
					<tr>
			<th align="left">Incluir Cliente</th>
			</tr>	
				<tr>
					<td><label for="nmCliente">Nome:</label></td>
					<td><input type="text" required 
						id="<%=PRManterCliente.ID_REQ_ATR_nmCliente%>"
						name="<%=PRManterCliente.ID_REQ_ATR_nmCliente%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nuCPF">CPF:</label></td>
					<td><input type="text" required 
						id="<%=PRManterCliente.ID_REQ_ATR_nuDocumento%>"
						name="<%=PRManterCliente.ID_REQ_ATR_nuDocumento%>" maxlength="58"></td>
				</tr>

				<tr>
					<td><label for="dtNascimento">Data Nascimento:</label></td>
					<td><input type="text" required 
						id="<%=PRManterCliente.ID_REQ_ATR_dtNascimento%>"
						name="<%=PRManterCliente.ID_REQ_ATR_dtNascimento%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
				<tr>
				<td><label for="dddCelular">Telefone Celular:</label></td>
					<td><input type="text" size="4" 			
						id="<%=PRManterCliente.ID_REQ_ATR_dddTelefoneCelular%>"
						name="<%=PRManterCliente.ID_REQ_ATR_dddTelefoneCelular%>"
						maxlength="3"> - <input type="text"  
						id="<%=PRManterCliente.ID_REQ_ATR_nuTelefoneCelular%>"
						name="<%=PRManterCliente.ID_REQ_ATR_nuTelefoneCelular%>"
						maxlength="10"> </td>
				</tr>
			
				<tr>
					<td><label for="email">E-mail:</label></td>
					<td><input type="email" id="<%=PRManterCliente.ID_REQ_ATR_email%>"
						name="<%=PRManterCliente.ID_REQ_ATR_email%>" maxlength="58"></td>
				</tr>

				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Incluir"
						onclick="submeterFormulario('<%=PRManterCliente.NM_SERVLET%>','<%=PRManterCliente.EVENTO_PROCESSAR_INCLUSAO%>')"
						id="consultar"><input type="button" value="Voltar"
						onclick=" window.history.back();" id="voltar"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>