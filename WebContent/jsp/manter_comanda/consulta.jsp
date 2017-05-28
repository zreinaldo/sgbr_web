<%@page import="sgbr.util.OTDComanda"%>
<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.OTDFuncionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.selects.SelectTipoDocumento"%>
<%@page import="sgbr.web.servlet.selects.SelectTipoFuncionario"%>
<%@page import="sgbr.web.servlet.PRManterComanda"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manter Funcionario</title>

<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

</head>
<%

String cdComanda = PRManterComanda.getAtributoOuParametroStringOpcional(PRManterComanda.ID_REQ_ATR_cdComanda, request);



ArrayList<OTDComanda> otd =  (ArrayList)PRManterComanda.getAtributoOpcional(PRManterComanda.ID_REQ_ATR_otdComanda,request); 

if (otd == null) {
	otd = new ArrayList<OTDComanda>();
}




%>


<body>

<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterComanda.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>		
							
				<tr>
					<td><label for="tpDocumento">Situacao Comanda:</label></td>
					<td></td>
				</tr>
				
				<tr>
					<td><label for="nuDocumento">Número Comanda:</label></td>
					<td><input type="search" id="<%=PRManterComanda.ID_REQ_ATR_cdComanda%>" value="<%=cdComanda%>" name="<%=PRManterComanda.ID_REQ_ATR_cdComanda%>" maxlength="15"></td>
				</tr>
								
				
			</table>


			<div id="divTabela">
				<table border="1" id="tab" style="width:100%">
					<tr>
					    <th>Selecione</th>
						<th>Codigo</th>
						<th>Data Inicio Vigenca</th>
						<th>Data Inicio Vigenca</th>								
				
					</tr>
		 <% for (OTDComanda campos : otd) {		 
		
			 %>		 
					<tr>
					<td><INPUT type="radio" id="radio_consulta_funcionario" name="<%=PRManterComanda.ID_REQ_ATR_radio_consulta_comanda%>" value="<%=campos.getCdComanda()%>"></td>
					
						<td><%=campos.getCdComanda()%></td>
						<td><%= Util.formataDataParaString(campos.getDtIniVigencia())%></td>
						<td><%= Util.formataDataParaString(campos.getDtFimVigencia())%></td>
					
						
					</tr>
			<%} %>	
				</table>
				
				<table>
				<tr>
					<td colspan="2" id="botoes">
					    <input type="button" value="Consultar"	onclick="submeterFormulario('<%=PRManterComanda.NM_SERVLET%>','<%=PRManterComanda.EVENTO_PROCESSAR_CONSULTA%>')" id="consultar">
					    <input type="button" value="Incluir"	onclick="submeterFormulario('<%=PRManterComanda.NM_SERVLET%>','<%=PRManterComanda.EVENTO_EXIBIR_INCLUSAO%>')" id="incluir"> 
					    <input type="button" value="Alterar" onclick="submeterFormulario('<%=PRManterComanda.NM_SERVLET%>','<%=PRManterComanda.EVENTO_EXIBIR_ALTERACAO%>')" id="alterar"> 
					    <input type="button" value="Detalhar" onclick="submeterFormulario('<%=PRManterComanda.NM_SERVLET%>','<%=PRManterComanda.EVENTO_EXIBIR_DETALHAMENTO_CONSULTA%>')" id="excluir">
					    <input type="button" value="Excluir" onclick="submeterFormulario('<%=PRManterComanda.NM_SERVLET%>','<%=PRManterComanda.EVENTO_EXIBIR_EXCLUSAO%>')" id="excluir">
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>