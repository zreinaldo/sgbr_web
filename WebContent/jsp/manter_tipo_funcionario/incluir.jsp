<%@page import="sgbr.web.servlet.PRManterTipoFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Tipo Funcionario</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>
<body>
	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento"
			name="<%=PRManterTipoFuncionario.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
							

				<tr>
					<td><label for="qtdDemandas">Descrição Tipo Funcionário:</label></td>
					<td><input type="text" required 
						id="<%=PRManterTipoFuncionario.ID_REQ_ATR_dsTipoFuncionario%>"
						name="<%=PRManterTipoFuncionario.ID_REQ_ATR_dsTipoFuncionario%>"
						maxlength="58"></td>
				</tr>
			
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Incluir"
						onclick="submeterFormulario('<%=PRManterTipoFuncionario.NM_SERVLET%>','<%=PRManterTipoFuncionario.EVENTO_PROCESSAR_INCLUSAO%>')"
						id="consultar"> <input type="submit"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>