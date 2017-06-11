<%@page import="sgbr.util.OTDCliente"%>
<%@page import="sgbr.util.Util"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.selects.SelectTipoDocumento"%>
<%@page import="sgbr.web.servlet.PRManterCliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manter Cliente</title>

<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

</head>
<%

String tpDocumento = PRManterCliente.getAtributoOuParametroStringOpcional(PRManterCliente.ID_REQ_ATR_tpDocumento, request);
String nmCliente = PRManterCliente.getAtributoOuParametroStringOpcional(PRManterCliente.ID_REQ_ATR_nmCliente, request);
String nuDocumento = PRManterCliente.getAtributoOuParametroStringOpcional(PRManterCliente.ID_REQ_ATR_nuDocumento, request);



ArrayList<OTDCliente> otd =  (ArrayList)PRManterCliente.getAtributoOpcional(PRManterCliente.ID_REQ_ATR_otdCliente,request); 

if (otd == null) {
	otd = new ArrayList<OTDCliente>();
}




%>


<body>

	<FORM name="form_principal" method="post" action="">
<%@ include file = "../../jsp/util/menu.jsp" %>

	
		<INPUT type="hidden" id="evento" name="<%=PRManterCliente.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>		
					<tr>
			<th align="left">Manter Cliente</th>
			</tr>		
				<tr>
					<td><label for="tpDocumento">Tipo Documento:</label></td>
					<td><%= SelectTipoDocumento.getInstancia().getHTML(request, PRManterCliente.ID_REQ_ATR_tpDocumento, PRManterCliente.ID_REQ_ATR_tpDocumento, tpDocumento,false,true)%></td>
				</tr>
				
				<tr>
					<td><label for="nuDocumento">Número Documento:</label></td>
					<td><input type="search" id="<%=PRManterCliente.ID_REQ_ATR_nuDocumento%>" value="<%=nuDocumento%>" name="<%=PRManterCliente.ID_REQ_ATR_nuDocumento%>" maxlength="15"></td>
				</tr>
			
				<tr>
					<td><label for="nomeCliente">Nome Cliente:</label></td>
					<td><input type="search"  size="50%" id="<%=PRManterCliente.ID_REQ_ATR_nmCliente%>" value="<%=nmCliente%>" name="<%=PRManterCliente.ID_REQ_ATR_nmCliente%>"
						maxlength="45"></td>
				</tr>		
				
			</table>


			<div id="divTabela">
				<table border="1" id="tab" style="width:100%">
					<tr>
					    <th>Selecione</th>
						<th>Nome</th>
						<th>Data nascimento</th>
						<th>E-Mail</th>						
						<th>Telefone</th>				
				
					</tr>
		 <% for (OTDCliente campos : otd) {
			  
			 Integer cdCliente = campos.getCdCliente();
			 Integer cdPessoa= campos.getCdPessoa();
		
			 %>
					<tr>
					<td>
					<% 
					String check = "";
					if(otd.size() == 1 )  {%>
					<INPUT checked="checked" type="radio" id="<%=PRManterCliente.ID_REQ_ATR_radio_consulta_cliente%>" name="<%=PRManterCliente.ID_REQ_ATR_radio_consulta_cliente%>" value="<%=cdCliente+","+cdPessoa%>"></td>
					     
					<% }else {%>
					<INPUT checked="checked" type="radio" id="<%=PRManterCliente.ID_REQ_ATR_radio_consulta_cliente%>" name="<%=PRManterCliente.ID_REQ_ATR_radio_consulta_cliente%>" value="<%=cdCliente+","+cdPessoa%>"></td>
					<% }%>
					
						<td><%=campos.getNmCliente()%></td>						
						<td><%= Util.formataDataParaString(campos.getDtNascimento())%></td>
						<td><%=campos.getEmail()%></td>
						<td><%=campos.getDddTelefone() + "-" + campos.getNuTelefone()%></td>
						
					</tr>
			<%} %>	
				</table>
				
				<table>
				<tr>
					<td colspan="2" id="botoes">
					    <input type="button" value="Consultar"	onclick="submeterFormulario('<%=PRManterCliente.NM_SERVLET%>','<%=PRManterCliente.EVENTO_PROCESSAR_CONSULTA%>')" id="consultar">
					    <input type="button" value="Incluir"	onclick="submeterFormulario('<%=PRManterCliente.NM_SERVLET%>','<%=PRManterCliente.EVENTO_EXIBIR_INCLUSAO%>')" id="incluir"> 
					    <input type="button" value="Alterar" onclick="submeterFormulario('<%=PRManterCliente.NM_SERVLET%>','<%=PRManterCliente.EVENTO_EXIBIR_ALTERACAO%>')" id="alterar"> 
					    <input type="button" value="Detalhar" onclick="submeterFormulario('<%=PRManterCliente.NM_SERVLET%>','<%=PRManterCliente.EVENTO_EXIBIR_DETALHAMENTO_CONSULTA%>')" id="detalhar">
					    <input type="button" value="Excluir" onclick="submeterFormulario('<%=PRManterCliente.NM_SERVLET%>','<%=PRManterCliente.EVENTO_EXIBIR_EXCLUSAO%>')" id="excluir">
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>