<%@page import="sgbr.web.servlet.PRManterCliente"%>
<%@page import="sgbr.util.OTDCliente"%>
<%@page import="sgbr.util.Util"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar CLiente</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	
	<%
	

	OTDCliente otdCliente =  (OTDCliente) PRManterCliente.getAtributoOpcional(PRManterCliente.ID_REQ_ATR_otdCliente,request); 

		
	%>

<body>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterCliente.ID_REQ_EVENTO%>" value="">
		<INPUT type="hidden" id="cdPessoa" name="<%=PRManterCliente.ID_REQ_ATR_cdPessoa%>" value="<%=otdCliente.getCdPessoa()%> ">
		<INPUT type="hidden" id="cdCliente" name="<%=PRManterCliente.ID_REQ_ATR_cdCliente%>" value="<%=otdCliente.getCdCliente()%>">

<fieldset>
			<table>
			<tr>
			<th align="left">Alterar Cliente</th>
			</tr>
					
				<tr>
					<td><label for="nuCPF">CPF:</label></td>
					<td><input type="text" value="<%=otdCliente.getNuCPF()%>" readonly="readonly"
						id="<%=PRManterCliente.ID_REQ_ATR_nuDocumento%>"
						name="<%=PRManterCliente.ID_REQ_ATR_nuDocumento%>" maxlength="58"></td>
				</tr>
					
					
				<tr>
					<td><label for="nmCliente">Nome:</label></td>
					<td><input type="text" required value="<%=otdCliente.getNmCliente()%>" 
						id="<%=PRManterCliente.ID_REQ_ATR_nmCliente%>"
						name="<%=PRManterCliente.ID_REQ_ATR_nmCliente%>"
						maxlength="58"></td>
				</tr>		

				<tr>
					<td><label for="dtNascimento">Data Nascimento:</label></td>
					<td><input type="text"  required value="<%=Util.formataDataParaString(otdCliente.getDtNascimento())%>"
						id="<%=PRManterCliente.ID_REQ_ATR_dtNascimento%>"
						name="<%=PRManterCliente.ID_REQ_ATR_dtNascimento%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
				<td><label for="dddCelular">Telefone Celular:</label></td>
					<td><input type="text" size="4" 	value="<%=otdCliente.getDddTelefone()%>"		
						id="<%=PRManterCliente.ID_REQ_ATR_dddTelefoneCelular%>"
						name="<%=PRManterCliente.ID_REQ_ATR_dddTelefoneCelular%>"
						maxlength="3"> - <input type="text"  value="<%=otdCliente.getNuTelefone()%>"
						id="<%=PRManterCliente.ID_REQ_ATR_nuTelefoneCelular%>"
						name="<%=PRManterCliente.ID_REQ_ATR_nuTelefoneCelular%>"
						maxlength="10"> </td>
				</tr>
			

				<tr>
					<td><label for="email">E-mail:</label></td>
					<td><input type="email" value="<%=otdCliente.getEmail()%>" 
					id="<%=PRManterCliente.ID_REQ_ATR_email%>"
						name="<%=PRManterCliente.ID_REQ_ATR_email%>" maxlength="58"></td>
				</tr>

				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Alterar"
						onclick="submeterFormulario('<%=PRManterCliente.NM_SERVLET%>','<%=PRManterCliente.EVENTO_PROCESSAR_ALTERACAO%>')"
						id="Alterar"><input type="button" value="Voltar"
						onclick=" window.history.back();" id="voltar"></td>
				</tr>
			</table>

		</fieldset>

	</FORM>
</body>
</html>