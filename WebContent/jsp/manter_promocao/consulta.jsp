<%@page import="sgbr.web.servlet.selects.SelectDiaSemana"%>
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


String cdItemCardapio = PRManterPromocao.getAtributoOuParametroStringOpcional(PRManterPromocao.ID_REQ_ATR_cdItemCardapio, request);
String inRetornarApenasVigentes = PRManterPromocao.getAtributoOuParametroStringOpcional(PRManterPromocao.ID_REQ_ATR_inRetornarApenasVigentes, request);
String diaSemanaPromocao = PRManterPromocao.getAtributoOuParametroStringOpcional(PRManterPromocao.ID_REQ_ATR_diasSemanaPromocao, request);
ArrayList<OTDPromocao> otd =  (ArrayList)PRManterPromocao.getAtributoOpcional(PRManterPromocao.ID_REQ_ATR_otdPromocao,request); 

if (otd == null) {
	otd = new ArrayList<OTDPromocao>();
}




%>


<body>

	<FORM name="form_principal" method="post" action="">

<%@ include file = "../../jsp/util/menu.jsp" %>

		<INPUT type="hidden" id="evento" name="<%=PRManterPromocao.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>		
							
				<tr>
					<td><label for="<%=PRManterPromocao.ID_REQ_ATR_cdItemCardapio%>">Item do Cardápio:</label></td>
					<td><%= SelectItemCardapio.getInstancia().getHTML(request, PRManterPromocao.ID_REQ_ATR_cdItemCardapio, PRManterPromocao.ID_REQ_ATR_cdItemCardapio,cdItemCardapio,false,true)%></td>
				</tr>		
				
				<tr>
					<td><label for="<%=PRManterPromocao.ID_REQ_ATR_inRetornarApenasVigentes%>">Promoção Ativa:</label></td>
					<td><%= SelectSimNao.getInstancia().getHTML(request, PRManterPromocao.ID_REQ_ATR_inRetornarApenasVigentes, PRManterPromocao.ID_REQ_ATR_inRetornarApenasVigentes, inRetornarApenasVigentes,false,true)%></td>
				</tr>
				
							
				<tr>
					<td><label for="diaPromocao">Informar dia da semana para promoção:</label> </td>
						<td><%= SelectDiaSemana.getInstancia().getHTML(request, PRManterPromocao.ID_REQ_ATR_diasSemanaPromocao, PRManterPromocao.ID_REQ_ATR_diasSemanaPromocao,diaSemanaPromocao,false,true)%></td>
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
		 <% Integer cdPromocaoAtual = null;
		   Integer cdItemCardapioAtual = null;
		   String dsDiasDePromocao = "";
		 
		 for (OTDPromocao campos : otd) {		 
			 
			if (!campos.getCdPromocao().equals(cdPromocaoAtual) && !campos.getCdItemCardapio().equals(cdItemCardapioAtual) && !dsDiasDePromocao.isEmpty()){
					
			%>
			<td colspan="3"><%=dsDiasDePromocao%></td ></tr>	
			<% dsDiasDePromocao = ""; 
			} else {
					 dsDiasDePromocao = dsDiasDePromocao + ", <br>" + Util.getDsDiaSemana(campos.getCdDiaSemanaPromocao());
			 }			 
			 
			 if (!campos.getCdPromocao().equals(cdPromocaoAtual) && !campos.getCdItemCardapio().equals(cdItemCardapioAtual)){  
						cdPromocaoAtual = campos.getCdPromocao();
						cdItemCardapioAtual = campos.getCdItemCardapio();	%>
					<tr>
					   <td colspan="1"><INPUT type="radio" id="radio_consulta_promocao" name="<%=PRManterPromocao.ID_REQ_ATR_radio_consulta_promocao%>" value="<%=campos.getCdPromocao()%>"></td>
						<td colspan="1"><%=campos.getNmItemCardapio()%></td>
						<td colspan="1"><%=campos.getVlPromocao()%></td>
						<td colspan="1"><%=campos.getDtInicioPromocao() != null ? Util.formataDataParaString(campos.getDtInicioPromocao()) : "" %></td>
						<td  colspan="1"><%=campos.getDtFimPromocao() != null ? Util.formataDataParaString(campos.getDtFimPromocao()) : "" %></td>
					   
						
			<% dsDiasDePromocao = Util.getDsDiaSemana(campos.getCdDiaSemanaPromocao());	}
		}%>	
		 <td colspan="3"><%=dsDiasDePromocao%></td ></tr>	
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