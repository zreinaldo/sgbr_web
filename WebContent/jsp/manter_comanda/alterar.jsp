<%@page import="sgbr.web.servlet.PRManterComanda"%>
<%@page import="sgbr.entidades.Comanda"%>
<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.OTDFuncionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.selects.SelectTipoFuncionario"%>
<%@page import="sgbr.web.servlet.PRManterComanda"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Funcionario</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	
	<%
	

	Comanda comanda =  (Comanda) PRManterComanda.getAtributoOpcional(PRManterComanda.ID_REQ_ATR_comanda,request); 

		
	%>

<body>
<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterComanda.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
				

				<tr>
					<td><label for="cdComanda">Codigo Comanda:</label></td>
					<td><input type="text" readonly="readonly"
						id="<%=PRManterComanda.ID_REQ_ATR_cdComanda%>"
						name="<%=PRManterComanda.ID_REQ_ATR_cdComanda%>" value="<%=comanda.getCdComanda() %>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="dtIniValidade">Data Inicio Validade:</label></td>
					<td><input type="text"
						id="<%=PRManterComanda.ID_REQ_ATR_dtIniVigencia%>"
						name="<%=PRManterComanda.ID_REQ_ATR_dtIniVigencia%>" maxlength="58" value="<%=Util.formataDataParaString(comanda.getDtIniValidade())%>"> </td>
				</tr>

					<tr>
					<td><label for="dtFimValidade">Data Fim Validade:</label></td>
					<td><input type="text"
						id="<%=PRManterComanda.ID_REQ_ATR_dtFimVigencia%>"
						name="<%=PRManterComanda.ID_REQ_ATR_dtFimVigencia%>" maxlength="58" value="<%=Util.formataDataParaString(comanda.getDtFimValidade())%>"> </td>
				</tr>
			

				
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Alterar"
						onclick="submeterFormulario('<%=PRManterComanda.NM_SERVLET%>','<%=PRManterComanda.EVENTO_PROCESSAR_ALTERACAO%>')"
						id="alterar"><input type="button" value="Home"
						onClick=""></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>