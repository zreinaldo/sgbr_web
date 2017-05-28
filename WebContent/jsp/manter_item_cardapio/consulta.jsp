<%@page import="sgbr.web.servlet.selects.SelectSituacaoItemCardapio"%>
<%@page import="sgbr.util.OTDItemCardapio"%>
<%@page import="sgbr.util.Util"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.PRManterItemCardapio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manter Tipo Funcionario</title>

<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

</head>
<%

String cdItemCardapio = PRManterItemCardapio.getAtributoOuParametroStringOpcional(PRManterItemCardapio.ID_REQ_ATR_cdItemCardapio, request);
String nmItemCardapio = PRManterItemCardapio.getAtributoOuParametroStringOpcional(PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio, request);
String vlItemCardapio = PRManterItemCardapio.getAtributoOuParametroStringOpcional(PRManterItemCardapio.ID_REQ_ATR_vlItemCardapio, request);
String siItemCardapio = PRManterItemCardapio.getAtributoOuParametroStringOpcional(PRManterItemCardapio.ID_REQ_ATR_siItemCardapio, request);


ArrayList<OTDItemCardapio> otd =  (ArrayList)PRManterItemCardapio.getAtributoOpcional(PRManterItemCardapio.ID_REQ_ATR_otdItemCardapio,request); 

if (otd == null) {
	otd = new ArrayList<OTDItemCardapio>();
}




%>


<body>

<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterItemCardapio.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>		
							
				<tr>
					<td><label for="cdItemCardapio">Código Item Cardápio:</label></td>
					<td><input type="search" id="<%=PRManterItemCardapio.ID_REQ_ATR_cdItemCardapio%>" value="<%=cdItemCardapio%>" name="<%=PRManterItemCardapio.ID_REQ_ATR_cdItemCardapio%>" maxlength="15"></td>
					
					<td></td>
				</tr>
				
				<tr>
					<td><label for="nmItemCardapio">Descrição:</label></td>
					<td><input type="search" id="<%=PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio%>" value="<%=nmItemCardapio%>" name="<%=PRManterItemCardapio.ID_REQ_ATR_nmItemCardapio%>" maxlength="15"></td>
				</tr>
							
				<tr>
					<td><label for="siItemCardapio">Situação:</label></td>
					<td><%= SelectSituacaoItemCardapio.getInstancia().getHTML(request, PRManterItemCardapio.ID_REQ_ATR_siItemCardapio, PRManterItemCardapio.ID_REQ_ATR_siItemCardapio, siItemCardapio,false,false)%></td>
				</tr>
								
				
			</table>


			<div id="divTabela">
				<table border="1" id="tab" style="width:100%">
					<tr>
					    <th>Selecione</th>
						<th>Código</th>
						<th>Descrição</th>	
						<th>Valor</th>
						<th>Situação</th>								
				
					</tr>
		 <% for (OTDItemCardapio campos : otd) {		 
		
			 %>		 
					<tr>
					<td><INPUT type="radio" id="radio_consulta_item_cardapio" name="<%=PRManterItemCardapio.ID_REQ_ATR_radio_consulta_item_cardapio%>" value="<%=campos.getCdItemCardapio()%>"></td>
					
						<td><%=campos.getCdItemCardapio()%></td>
						<td><%=campos.getNmItemCardapio()%></td>
						<td><%=campos.getVlItemCardapio()%></td>
						<td><%=campos.getSiItemCardapio()%></td>
						
					</tr>
			<%} %>	
				</table>
				
				<table>
				<tr>
					<td colspan="2" id="botoes">
					    <input type="button" value="Consultar"	onclick="submeterFormulario('<%=PRManterItemCardapio.NM_SERVLET%>','<%=PRManterItemCardapio.EVENTO_PROCESSAR_CONSULTA%>')" id="consultar">
					    <input type="button" value="Incluir"	onclick="submeterFormulario('<%=PRManterItemCardapio.NM_SERVLET%>','<%=PRManterItemCardapio.EVENTO_EXIBIR_INCLUSAO%>')" id="incluir"> 
					    <input type="button" value="Alterar" onclick="submeterFormulario('<%=PRManterItemCardapio.NM_SERVLET%>','<%=PRManterItemCardapio.EVENTO_EXIBIR_ALTERACAO%>')" id="alterar"> 
					    <input type="button" value="Detalhar" onclick="submeterFormulario('<%=PRManterItemCardapio.NM_SERVLET%>','<%=PRManterItemCardapio.EVENTO_EXIBIR_DETALHAMENTO_CONSULTA%>')" id="excluir">
					    <input type="button" value="Excluir" onclick="submeterFormulario('<%=PRManterItemCardapio.NM_SERVLET%>','<%=PRManterItemCardapio.EVENTO_EXIBIR_EXCLUSAO%>')" id="excluir">
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>