<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.OTDFuncionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.selects.SelectTipoDocumento"%>
<%@page import="sgbr.web.servlet.selects.SelectTipoFuncionario"%>
<%@page import="sgbr.web.servlet.PRManterFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manter Funcionario</title>
</head>
<%

String tpDocumento = PRManterFuncionario.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_tpDocumento, request);
String tpFuncionario = PRManterFuncionario.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_tpCargo, request);

String nmFuncionario = PRManterFuncionario.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nmFuncionario, request);
String nuDocumento = PRManterFuncionario.getAtributoOuParametroStringOpcional(PRManterFuncionario.ID_REQ_ATR_nuDocumento, request);



ArrayList<OTDFuncionario> otd =  (ArrayList)PRManterFuncionario.getAtributoOpcional(PRManterFuncionario.ID_REQ_ATR_otdFuncionario,request); 

if (otd == null) {
	otd = new ArrayList<OTDFuncionario>();
}




%>


<body>
	<script type="text/javascript">
	
	function alterar (pServlet, pEvento,pIdChave) {
		
		
	}
	
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

		<INPUT type="hidden" id="evento" name="<%=PRManterFuncionario.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
			
							
				<tr>
					<td><label for="tpDocumento">Tipo Documento:</label></td>
					<td><%= SelectTipoDocumento.getInstancia().getHTML(request, PRManterFuncionario.ID_REQ_ATR_tpDocumento, PRManterFuncionario.ID_REQ_ATR_tpDocumento, tpDocumento)%></td>
				</tr>
				
				<tr>
					<td><label for="nuDocumento">Número Documento:</label></td>
					<td><input type="text" id="<%=PRManterFuncionario.ID_REQ_ATR_nuDocumento%>" value="<%=nuDocumento%>" name="<%=PRManterFuncionario.ID_REQ_ATR_nuDocumento%>" maxlength="15"></td>
				</tr>
				
				<tr>
					<td><label for="tpCargo">Cargo:</label></td>
					<td><%=SelectTipoFuncionario.getInstancia().getHTML(request, PRManterFuncionario.ID_REQ_ATR_tpCargo, PRManterFuncionario.ID_REQ_ATR_tpCargo, tpFuncionario) %></td>
				</tr>
			
				<tr>
					<td><label for="nomeFuncionario">Nome Funcionario:</label></td>
					<td><input type="text" id="<%=PRManterFuncionario.ID_REQ_ATR_nmFuncionario%>" value="<%=nmFuncionario%>" name="<%=PRManterFuncionario.ID_REQ_ATR_nmFuncionario%>"
						maxlength="45"></td>
				</tr>		
				
			</table>


			<div id="divTabela">
				<table border="1" id="tab">
					<tr>
					    <th>Selecione</th>
						<th>Nome</th>
						<th>Cargo</th>
						<th>Data Admissão</th>
						<th>Salário</th>						
						<th>Data Demissão</th>				
				
					</tr>
		 <% for (OTDFuncionario campos : otd) {
			  
			 Integer cdFuncionario = campos.getCdFuncionario();
			 Integer cdPessoa= campos.getCdPessoa();
		
			 %>
		 
		 
					<tr>
					<td><INPUT type="radio" id="radio_consulta_funcionario" name="<%=PRManterFuncionario.ID_REQ_ATR_radio_consulta_funcionario%>" value="<%=cdFuncionario+","+cdPessoa%>"></td>
					
						<td><%=campos.getNmFuncionario()%></td>
						<td><%=campos.getDsFuncionario()%></td>
						<td><%= Util.formataDataParaString(campos.getDtAdmissao())%></td>
						<td><%=campos.getVlSalario()%></td>
						<td><%= Util.formataDataParaString(campos.getDtDemissao())%></td>
						
					</tr>
			<%} %>	
				</table>
				
				<table>
				<tr>
					<td colspan="2" id="botoes">
					    <input type="button" value="Incluir"	onclick="submeterFormulario('<%=PRManterFuncionario.NM_SERVLET%>','<%=PRManterFuncionario.EVENTO_EXIBIR_INCLUSAO%>')" id="incluir"> 
					    <input type="button" value="Consultar"	onclick="submeterFormulario('<%=PRManterFuncionario.NM_SERVLET%>','<%=PRManterFuncionario.EVENTO_PROCESSAR_CONSULTA%>')" id="consultar">
					    <input type="button" value="Alterar" onclick="submeterFormulario('<%=PRManterFuncionario.NM_SERVLET%>','<%=PRManterFuncionario.EVENTO_EXIBIR_ALTERACAO%>')" id="alterar"> 
					    <input type="button" value="Excluir" onclick="submeterFormulario('<%=PRManterFuncionario.NM_SERVLET%>','<%=PRManterFuncionario.EVENTO_EXIBIR_DETALHAMENTO_CONSULTA%>')" id="excluir">
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>