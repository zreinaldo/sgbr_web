
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="sgbr.web.servlet.selects.SelectSituacaoConta"%>
<%@page import="sgbr.web.servlet.selects.SelectSimNao"%>
<%@page import="sgbr.web.servlet.PRManterPedido"%>
<%@page import="sgbr.util.Constantes"%>
<%@page import="sgbr.web.servlet.selects.SelectClienteConta"%>
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
String cdCliente = PRManterComanda.getParametroStringOpcional(PRManterConta.ID_REQ_ATR_cdCliente, true, request);




ArrayList<OTDConta> otd =  (ArrayList)PRManterConta.getAtributoOpcional(PRManterConta.ID_REQ_ATR_otdConta,request); 

if (otd == null) {
	otd = new ArrayList<OTDConta>();
}



%>


<body>

	<FORM name="form_principal" method="post" action="">

<%@ include file = "../../jsp/util/menu.jsp" %>

		<INPUT type="hidden" id="evento" name="<%=PRManterConta.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>		
<th>Manter Conta</th>	
				<tr>
					<td><label for="cdMesa">Conta por Mesa /N� Mesa em uso:</label></td>
					<td><%= SelectMesaConta.getInstancia().getHTML(request, PRManterConta.ID_REQ_ATR_cdMesa, PRManterConta.ID_REQ_ATR_cdMesa, cdMesa, false, true, Constantes.CD_SIM,Constantes.CD_TIPO_CONTA_MESA)	%></td>
					
					<td></td>
				</tr>
				
				<tr>
					<td><label for="cdComanda">Conta por Comanda /N� Comanda em uso:</label></td>					
					<td><%= SelectComandaConta.getInstancia().getHTML(request, PRManterConta.ID_REQ_ATR_cdComanda, PRManterConta.ID_REQ_ATR_cdComanda, cdComanda, false, true, Constantes.CD_SIM,Constantes.CD_TIPO_CONTA_COMANDA)	%></td>
				</tr>
				
				
								
				<tr>
					<td><label for="cdCliente">Nome Cliente em Uso:</label></td>
					<td><%= SelectClienteConta.getInstancia().getHTML(request, PRManterConta.ID_REQ_ATR_cdCliente, PRManterConta.ID_REQ_ATR_cdCliente, cdCliente, false, true, true)	%></td>
				</tr>
							
							
				<tr>
					<td><label for="siItemCardapio">Situa��o da Conta:</label></td>
					
					<td><%=SelectSituacaoConta.getInstancia().getHTML(request, PRManterConta.ID_REQ_ATR_siConta, PRManterConta.ID_REQ_ATR_siConta, "", false, true) %></td>
				</tr>
								
				
			</table>


			<div id="divTabela">
				<table border="1" id="tab" style="width:100%">
					<tr>
					    <th>Selecione</th>
						<th>Tipo Conta</th>
						<th>Conta</th>
						<th>Mesa</th>	
						<th>Comanda</th>
						<th>Cliente</th>								
						<th>Data/Hora Abertura</th>
						<th>Situa��o</th>
				
					</tr>
		 <% for (OTDConta campos : otd) {
			  
			 Integer cdConta = campos.getCdConta();			 		
		
			 %>
		 
		 
					<tr>
						
					<td>
					<% if(otd.size() == 1 )  {%>
					<INPUT checked="checked" type="radio" id="radio_consulta_funcionario" name="<%=PRManterConta.ID_REQ_ATR_radio_consulta_conta%>" value="<%=cdConta%>"></td>
					<%}else {%>
                    <INPUT type="radio" id="radio_consulta_funcionario" name="<%=PRManterConta.ID_REQ_ATR_radio_consulta_conta%>" value="<%=cdConta%>"></td>
                    <%}%>
						<td><%=campos.getDsTipoConta()%></td>
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
					    <input type="button" value="Abrir Conta Mesa"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_ABRIR_CONTA_MESA%>')" id="abrirContaMesa">
					     <input type="button" value="Abrir Conta Comanda"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_ABRIR_CONTA_COMANDA%>')" id="abrirContaComanda">
					     <input type="button" value="Incluir Pedido"	onclick="submeterFormulario('<%=PRManterPedido.NM_SERVLET%>','<%=PRManterPedido.EVENTO_EXIBIR_INCLUSAO%>')" id="exibirInclusaoPedido">
					     <input type="button" value="Encerrar Conta"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_ENCERRAR_CONTA%>')" id="exibirEncerrarConta">
					    <input type="button" value="Conta Parcial"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_CONTA_PARCIAL%>')" id="exibirContaParcial">
					     <input type="button" value="Detalhar"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_DETALHAMENTO_CONSULTA%>')" id="exibirDetalhamentoConsulta">
					     <input type="button" value="Alterar"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_ALTERACAO%>')" id="alterar">
					     <input type="button" value="Excluir"	onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_EXIBIR_EXCLUSAO%>')" id="excluir">
					 					    
					   
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>