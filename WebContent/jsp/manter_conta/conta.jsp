<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.Constantes"%>
<%@page import="sgbr.util.OTDContaItemCardapio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.PRManterConta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
tfoot {color:red;}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exibir Conta</title>

<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

</head>
<%


String cdConta = PRManterConta.getAtributoOuParametroStringOpcional(PRManterConta.ID_REQ_ATR_cdConta, request);
String cdMesa = PRManterConta.getAtributoOuParametroStringOpcional(PRManterConta.ID_REQ_ATR_cdMesa, request);
String cdComanda = PRManterConta.getAtributoOuParametroStringOpcional(PRManterConta.ID_REQ_ATR_cdComanda, request);


String inFecharConta = PRManterConta.getAtributoOuParametroStringOpcional(PRManterConta.ID_REQ_ATR_inFecharConta, request);
String inContaDesconto = PRManterConta.getAtributoOuParametroStringOpcional(PRManterConta.ID_REQ_ATR_inContaDesconto, request);


String vlDinheiroDesconto = PRManterConta.getAtributoOuParametroStringOpcional(PRManterConta.ID_REQ_ATR_vlDinheiroDesconto, request);
String vlPercDesconto = PRManterConta.getAtributoOuParametroStringOpcional(PRManterConta.ID_REQ_ATR_vlPercDesconto, request);


ArrayList<OTDContaItemCardapio> otd =  (ArrayList)PRManterConta.getAtributoOpcional(PRManterConta.ID_REQ_ATR_otdContaItemCardapio,request); 



if (otd == null) {
	otd = new ArrayList<OTDContaItemCardapio>();
}




%>


<body>

<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterConta.ID_REQ_EVENTO%>" value="">
		<INPUT type="hidden" id="cdConta" name="<%=PRManterConta.ID_REQ_ATR_cdConta%>" value="<%=cdConta%>">
		<fieldset>
			<table>
<%	if (inFecharConta.equals(Constantes.CD_SIM)) { %>
<th align="left">Encerrar Conta</th>

<%} else {%>
<th align="left">Conta Parcial</th>
<%} %>	
		
			<tr>
					<td><label for="cdMesa">Conta:</label></td>
					<td><input type="text" value="<%=cdConta %>" disabled="disabled" readonly="readonly"> </td>				
				</tr>
			
			<% if (!cdMesa.isEmpty()) {%>
			    <tr>
					<td><label for="cdMesa">Mesa:</label></td>
					<td><input type="text" value="<%=Util.getValorHTML(cdMesa)%>"  disabled="disabled" readonly="readonly"> </td> 				
				</tr>
		     <% }%>
				<% if (!cdComanda.isEmpty()) {%>
			     <tr>
					<td><label for="cdComanda">Comanda:</label></td>
					<td><input type="text" value="<%=Util.getValorHTML(cdComanda)%>"  disabled="disabled" readonly="readonly"> </td>
				</tr>
              <% }%>
			
			  <%if (inFecharConta.equals(Constantes.CD_SIM)) { %>	
				<tr>
					<td><label for="cdMesa">Desconto na conta em R$:</label></td>
					<td><input type="text" value="<%=vlDinheiroDesconto%>"
						id="<%=PRManterConta.ID_REQ_ATR_vlDinheiroDesconto%>"
						name="<%=PRManterConta.ID_REQ_ATR_vlDinheiroDesconto%>"
						maxlength="58"></td>				
				</tr>		
				<tr>
					<td><label for="cdMesa">Desconto na conta em %:</label></td>
					<td><input type="text"  value="<%=vlPercDesconto%>"
						id="<%=PRManterConta.ID_REQ_ATR_vlPercDesconto%>"
						name="<%=PRManterConta.ID_REQ_ATR_vlPercDesconto%>"
						maxlength="58"></td>			
				</tr>					
  <%} %>	
				
			</table>


			<div id="divTabela">
				<table border="1" id="tab" style="width:100%">
					<tr>
					    					    
					    <th>Item Cardápio</th>
						<th>Quantidade</th>
					    <th>Valor Individual</th>
						<th>Valor Total</th>	
						<th>Promoção</th>
									
				
					</tr>
		 <%
		 double vlFinalComDesconto = 0.0d;
		 double vlContaOriginal = 0.0d;
		 
		 for (OTDContaItemCardapio campos : otd) {		 
		
			 vlContaOriginal = vlContaOriginal +campos.getVlTotal();			 
			 %>		 
					<tr>					
	     	 			<td><%=campos.getNmItemCardapio()%></td>
						<td><%=campos.getQtdItemCardapio()%></td>
						<td>R$ <%=campos.getVlItemCardapio()%></td>
						<td>R$ <%=campos.getVlTotal()%></td>
						<td><%=campos.getInPromocao()%></td>					
						
					</tr>
			<%} %>	
			 <tfoot>
				    <tr>
				    <td colspan="3">Valor Total da Conta:</td> 
				    
				    <% if (inContaDesconto.equals(Constantes.CD_SIM)) { 
				    	
				    	if (!vlDinheiroDesconto.isEmpty() && !vlPercDesconto.isEmpty()) {
				    		vlFinalComDesconto = vlContaOriginal - Double.parseDouble(vlDinheiroDesconto) ;
				    		vlFinalComDesconto = vlFinalComDesconto - ( vlFinalComDesconto * (Double.parseDouble(vlPercDesconto) / 100)) ;
				    	}else
				    	
				       
				    	if (!vlDinheiroDesconto.isEmpty()) {
				    		  vlFinalComDesconto = vlContaOriginal - Double.parseDouble(vlDinheiroDesconto) ;
				    	}else
				    	
				    	if (!vlPercDesconto.isEmpty()) {
				    		  vlFinalComDesconto = vlContaOriginal - ( vlContaOriginal * (Double.parseDouble(vlPercDesconto) / 100)) ;
				    	}
				    
				    
				    %>
				     <td colspan="2"> <strike>R$ <%=vlContaOriginal %> </strike> <br> <b>R$ <%=vlFinalComDesconto %> </b> </td>
				    
				    <INPUT type="hidden" id="<%=PRManterConta.ID_REQ_ATR_vlDinheiroDesconto%>" name="<%=PRManterConta.ID_REQ_ATR_vlDinheiroDesconto%>" value="<%=vlDinheiroDesconto%>">
				    <INPUT type="hidden" id="<%=PRManterConta.ID_REQ_ATR_vlPercDesconto%>" name="<%=PRManterConta.ID_REQ_ATR_vlPercDesconto%>" value="<%=vlPercDesconto%>">
				    
				    
				       <%}else { 
				    	   vlFinalComDesconto = vlContaOriginal;
				       %>
				    <td colspan="2"> R$ <%=vlContaOriginal %></td>
				    <%}%>	
				    <INPUT type="hidden" id="<%=PRManterConta.ID_REQ_ATR_vlContaOriginal%>" name="<%=PRManterConta.ID_REQ_ATR_vlContaOriginal%>" value="<%=vlContaOriginal%>">
				    <INPUT type="hidden" id="<%=PRManterConta.ID_REQ_ATR_vlContaFinal%>" name="<%=PRManterConta.ID_REQ_ATR_vlContaFinal%>" value="<%=vlFinalComDesconto%>">
				    </tr>
				  </tfoot >
				  </table>
             <table>
				<tr>
					<td colspan="2" id="botoes">					     
					  <%if (inFecharConta.equals(Constantes.CD_SIM)) { %>					  
					    <input type="button" value="Fechar Conta" onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_PROCESSAR_ENCERRAR_CONTA%>')" id="excluir">
					    <input type="button" value="Aplicar Desconto" onclick="submeterFormulario('<%=PRManterConta.NM_SERVLET%>','<%=PRManterConta.EVENTO_ATUALIZAR_DESCONTO_CONTA%>')" id="excluir">
					   <%}%>
					   <input type="button" value="Voltar"	onclick=" window.history.back();" id="voltar">
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>