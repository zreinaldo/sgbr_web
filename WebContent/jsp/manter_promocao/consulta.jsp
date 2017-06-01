<%@page import="sgbr.web.servlet.selects.SelectSimNao"%>
<%@page import="sgbr.web.servlet.selects.SelectItemCardapio"%>
<%@page import="sgbr.util.OTDPromocao"%>
<%@page import="sgbr.util.Util"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.PRManterPromocao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manter Promoção</title>

<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

</head>
<%

String cdPromocao = PRManterPromocao.getAtributoOuParametroStringOpcional(PRManterPromocao.ID_REQ_ATR_cdPromocao, request);
String cdItemCardapio = PRManterPromocao.getAtributoOuParametroStringOpcional(PRManterPromocao.ID_REQ_ATR_cdItemCardapio, request);
String dtInicioPromocao = PRManterPromocao.getAtributoOuParametroStringOpcional(PRManterPromocao.ID_REQ_ATR_dtInicioPromocao, request);
String dtFimPromocao = PRManterPromocao.getAtributoOuParametroStringOpcional(PRManterPromocao.ID_REQ_ATR_dtFimPromocao, request);



ArrayList<OTDPromocao> otd =  (ArrayList)PRManterPromocao.getAtributoOpcional(PRManterPromocao.ID_REQ_ATR_otdPromocao,request); 

if (otd == null) {
	otd = new ArrayList<OTDPromocao>();
}




%>


<body>

<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterPromocao.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>		
							
				<tr>
					<td><label for="<%=PRManterPromocao.ID_REQ_ATR_cdItemCardapio%>">Item do Cardápio:</label></td>
					<td><%= SelectItemCardapio.getInstancia().getHTML(request, PRManterPromocao.ID_REQ_ATR_cdItemCardapio, PRManterPromocao.ID_REQ_ATR_cdItemCardapio, "",false,true)%></td>
				</tr>		
				
				<tr>
					<td><label for="<%=PRManterPromocao.ID_REQ_ATR_inRetornarApenasVigentes%>">Promoção Ativa:</label></td>
					<td><%= SelectSimNao.getInstancia().getHTML(request, PRManterPromocao.ID_REQ_ATR_inRetornarApenasVigentes, PRManterPromocao.ID_REQ_ATR_inRetornarApenasVigentes, "",false,true)%></td>
				</tr>
				
							
				<tr>
					<td><label for="diaPromocao">Informar dia da semana para promoção:</label> </td>
					<td>***********************************************************</td>
				</tr>
								
				
			</table>


			<div id="divTabela">
				<table border="1" id="tab" style="width:100%">
					<tr>
					    <th>Selecione</th>
						<th>Item em Promoção</th>	
						<th>Valor</th>
						<th>Data Início</th>
						<th>Data Fim</th>
						<th>Dia da semana</th>
														
				
					</tr>
		 <% for (OTDPromocao campos : otd) {		 
		
			 %>		 
					<tr>
					<td><INPUT type="radio" id="radio_consulta_promocao" name="<%=PRManterPromocao.ID_REQ_ATR_radio_consulta_promocao%>" value="<%=campos.getCdPromocao()%>"></td>
					
						<td><%=campos.getNmItemCardapio()%></td>
						<td><%=campos.getVlPromocao()%></td>
						<td><%=campos.getDtInicioPromocao() != null ? Util.formataDataParaString(campos.getDtInicioPromocao()) : "" %></td>
						<td><%=campos.getDtFimPromocao() != null ? Util.formataDataParaString(campos.getDtFimPromocao()) : "" %></td>
						<td></td>
					</tr>
			<%} %>	
				</table>
				
				<table>
				<tr>
					<td colspan="2" id="botoes">
					    <input type="button" value="Consultar"	onclick="submeterFormulario('<%=PRManterPromocao.NM_SERVLET%>','<%=PRManterPromocao.EVENTO_PROCESSAR_CONSULTA%>')" id="consultar">
					    <input type="button" value="Incluir"	onclick="submeterFormulario('<%=PRManterPromocao.NM_SERVLET%>','<%=PRManterPromocao.EVENTO_EXIBIR_INCLUSAO%>')" id="incluir"> 
					    <input type="button" value="Alterar" onclick="submeterFormulario('<%=PRManterPromocao.NM_SERVLET%>','<%=PRManterPromocao.EVENTO_EXIBIR_ALTERACAO%>')" id="alterar"> 
					    <input type="button" value="Detalhar" onclick="submeterFormulario('<%=PRManterPromocao.NM_SERVLET%>','<%=PRManterPromocao.EVENTO_EXIBIR_DETALHAMENTO_CONSULTA%>')" id="excluir">
					    <input type="button" value="Excluir" onclick="submeterFormulario('<%=PRManterPromocao.NM_SERVLET%>','<%=PRManterPromocao.EVENTO_EXIBIR_EXCLUSAO%>')" id="excluir">
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>