
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.OTDConta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.selects.SelectMesaConta"%>
<%@page import="sgbr.web.servlet.selects.SelectComandaConta"%>
<%@page import="sgbr.web.servlet.PRManterComanda"%>
<%@page import="sgbr.web.servlet.PRManterConta"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manter Conta</title>

<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

</head>
<%

String cdComanda = PRManterComanda.getParametroStringOpcional(PRManterConta.ID_REQ_ATR_cdComanda, true, request);
String cdMesa = PRManterComanda.getParametroStringOpcional(PRManterConta.ID_REQ_ATR_cdMesa, true, request);



ArrayList<OTDConta> otd =  (ArrayList)PRManterConta.getAtributoOpcional(PRManterConta.ID_REQ_ATR_otdConta,request); 

if (otd == null) {
	otd = new ArrayList<OTDConta>();
}



%>


<body>

<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterConta.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>		
							
				<tr>
					<td><label for="cdItemCardapio">Numero Mesa em uso:</label></td>
					<td><%= SelectMesaConta.getInstancia().getHTML(request, PRManterConta.ID_REQ_ATR_cdMesa, PRManterConta.ID_REQ_ATR_cdMesa, cdComanda, false, true, true)	%></td>
					
					<td></td>
				</tr>
				
				<tr>
					<td><label for="nmItemCardapio">Numero Comanda em uso:</label></td>
					<td><%= SelectComandaConta.getInstancia().getHTML(request, PRManterConta.ID_REQ_ATR_cdComanda, PRManterConta.ID_REQ_ATR_cdComanda, cdMesa, false, true, true)	%></td>
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
		 <% for (OTDConta campos : otd) {
			  
			 Integer cdConta = campos.getCdConta();			 
		
			 %>
		 
		 
					<tr>
					<td><INPUT type="radio" id="radio_consulta_funcionario" name="<%=PRManterConta.ID_REQ_ATR_radio_consulta_conta%>" value="<%=cdConta%>"></td>
					
						<td><%=campos.getCdConta()%></td>
						<td><%=Util.getValorHTML(campos.getCdMesa())%></td>
						<td><%=Util.getValorHTML(campos.getCdComanda())%></td>
						<td><%=Util.getValorHTML(campos.getNmCliente())%></td>						
						<td><%=campos.getDhAbertura()%></td>
						<td><%=campos.getSiConta()%></td>
						
					</tr>
			<%} %>	
				</table>
				
				<table>
				<tr>
					<td colspan="2" id="botoes">
					
					
					    <input type="button" value="Consultar"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_PROCESSAR_CONSULTA%>')" id="consultar">
					    <input type="button" value="Abrir Conta Mesa"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_ABRIR_CONTA%>')" id="abrirContaMesa">
					     <input type="button" value="Abrir Conta Comanda"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_ABRIR_CONTA%>')" id="abrirContaMesa">
					     <input type="button" value="Incluir Pedido"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_ABRIR_CONTA%>')" id="abrirContaMesa">
					     <input type="button" value="Encerrar Conta"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_ABRIR_CONTA%>')" id="abrirContaMesa">
					     <input type="button" value="Conta Parcial"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_ABRIR_CONTA%>')" id="abrirContaMesa">
					 					    
					   
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>