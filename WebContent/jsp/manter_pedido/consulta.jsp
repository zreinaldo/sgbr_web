<%@page import="sgbr.util.Constantes"%>
<%@page import="sgbr.web.servlet.selects.SelectMesaConta"%>
<%@page import="sgbr.web.servlet.selects.SelectComandaConta"%>
<%@page import="sgbr.util.OTDContaItemCardapio"%>
<%@page import="sgbr.util.Util"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.PRManterPedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manter Pedido</title>

<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

</head>
<%

String cdItemCardapio = PRManterPedido.getAtributoOuParametroStringOpcional(PRManterPedido.ID_REQ_ATR_cdItemCardapio, request);
String nmItemCardapio = PRManterPedido.getAtributoOuParametroStringOpcional(PRManterPedido.ID_REQ_ATR_nmItemCardapio, request);
String qtdItemCardapio = PRManterPedido.getAtributoOuParametroStringOpcional(PRManterPedido.ID_REQ_ATR_qtdItemCardapio, request);



String cdComanda = PRManterPedido.getParametroStringOpcional(PRManterPedido.ID_REQ_ATR_cdComanda, true, request);
String cdMesa = PRManterPedido.getParametroStringOpcional(PRManterPedido.ID_REQ_ATR_cdMesa, true, request);

ArrayList<OTDContaItemCardapio> otd =  (ArrayList)PRManterPedido.getAtributoOpcional(PRManterPedido.ID_REQ_ATR_otdContaItemPedido,request); 

if (otd == null) {
	otd = new ArrayList<OTDContaItemCardapio>();
}




%>


<body>

<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterPedido.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>		
			<tr>
			<th align="left">Manter Pedido</th>
			</tr>	
				<tr>
					<td><label for="cdMesa">Número Mesa em uso:</label></td>
					<td><%= SelectMesaConta.getInstancia().getHTML(request, PRManterPedido.ID_REQ_ATR_cdMesa, PRManterPedido.ID_REQ_ATR_cdMesa, cdMesa, false, true, Constantes.CD_SIM)	%></td>
					
					<td></td>
				</tr>
				
				<tr>
					<td><label for="cdComanda">Número Comanda em uso:</label></td>
					<td><%= SelectComandaConta.getInstancia().getHTML(request, PRManterPedido.ID_REQ_ATR_cdComanda, PRManterPedido.ID_REQ_ATR_cdComanda, cdComanda, false, true, Constantes.CD_SIM)	%></td>
				</tr>	
				
			</table>


			<div id="divTabela">
				<table border="1" id="tab" style="width:100%">
					<tr>
					    <th>Selecione</th>
					    <th>Conta</th>
					    <th>Mesa</th>
					    <th>Comanda</th>
						<th>Item Cardápio</th>	
						<th>Quantidade</th>
						<th>Observação</th>								
				
					</tr>
		 <% for (OTDContaItemCardapio campos : otd) {		 
		
			 %>		 
					<tr>
					<td><INPUT type="radio" id="radio_consulta_pedido" name="<%=PRManterPedido.ID_REQ_ATR_radio_consulta_pedido%>" value="<%=campos.getCdPedido()%>"></td>
					<td><%=campos.getCdConta()%></td>
						<td><%=Util.getValorHTML(campos.getCdMesa())%></td>
						<td><%=Util.getValorHTML(campos.getCdComanda())%></td>
						<td><%=campos.getNmItemCardapio()%></td>
						<td><%=campos.getQtdItemCardapio()%></td>
						<td><%=campos.getObsItemCardapio()%></td>
						
					</tr>
			<%} %>	
				</table>
				
				<table>
				<tr>
					<td colspan="2" id="botoes">
					    <input type="button" value="Consultar"	onclick="submeterFormulario('<%=PRManterPedido.NM_SERVLET%>','<%=PRManterPedido.EVENTO_PROCESSAR_CONSULTA%>')" id="consultar">
					    <input type="button" value="Incluir"	onclick="submeterFormulario('<%=PRManterPedido.NM_SERVLET%>','<%=PRManterPedido.EVENTO_EXIBIR_INCLUSAO%>')" id="incluir"> 
					    <input type="button" value="Alterar" onclick="submeterFormulario('<%=PRManterPedido.NM_SERVLET%>','<%=PRManterPedido.EVENTO_EXIBIR_ALTERACAO%>')" id="alterar"> 
					    <input type="button" value="Detalhar" onclick="submeterFormulario('<%=PRManterPedido.NM_SERVLET%>','<%=PRManterPedido.EVENTO_EXIBIR_DETALHAMENTO_CONSULTA%>')" id="excluir">
					    <input type="button" value="Excluir" onclick="submeterFormulario('<%=PRManterPedido.NM_SERVLET%>','<%=PRManterPedido.EVENTO_EXIBIR_EXCLUSAO%>')" id="excluir">
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>