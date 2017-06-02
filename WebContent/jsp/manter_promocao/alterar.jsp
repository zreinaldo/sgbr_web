<%@page import="sgbr.web.servlet.selects.SelectItemCardapio"%>
<%@page import="sgbr.web.servlet.PRManterPromocao"%>
<%@page import="sgbr.entidades.Promocao"%>
<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.OTDPromocao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Promoção</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	
	<%
	

	Promocao promocao =  (Promocao) PRManterPromocao.getAtributoOpcional(PRManterPromocao.ID_REQ_ATR_Promocao,request); 

		
	%>

<body>


	<FORM name="form_principal" method="post" action="">
<%@ include file = "../../jsp/util/menu.jsp" %>
		<INPUT type="hidden" id="evento" name="<%=PRManterPromocao.ID_REQ_EVENTO%>" value="">
		<INPUT type="hidden" id="cdPromocao" name="<%=PRManterPromocao.ID_REQ_ATR_cdPromocao%>" value="">
		<INPUT type="hidden" id="cdDiasPromocao" name="<%=PRManterPromocao.ID_REQ_ATR_diasSemanaPromocao%>" value="">


		<fieldset>
			<table>
				<tr>
					<td><label for="<%=PRManterPromocao.ID_REQ_ATR_cdItemCardapio%>">Item do Cardápio:</label></td>
					<td><%= SelectItemCardapio.getInstancia().getHTML(request, PRManterPromocao.ID_REQ_ATR_cdItemCardapio, PRManterPromocao.ID_REQ_ATR_cdItemCardapio, promocao.getCdItemCardapio().toString(),true,false)%></td>
				
				</tr>
				<td><label for="<%=PRManterPromocao.ID_REQ_ATR_vlPromocao%>">Valor Promocional:</label></td>
					<td><input type="text" required 
						id="<%=PRManterPromocao.ID_REQ_ATR_vlPromocao%>"
						name="<%=PRManterPromocao.ID_REQ_ATR_vlPromocao%>" value="<%=promocao.getVlPromocao()%>"
						maxlength="58"></td>
			
			
			<tr>
					<td><label for="<%=PRManterPromocao.ID_REQ_ATR_dtInicioPromocao%>">Data Início:</label></td>
					<td><input type="text" required 
						id="<%=PRManterPromocao.ID_REQ_ATR_dtInicioPromocao%>"
						name="<%=PRManterPromocao.ID_REQ_ATR_dtInicioPromocao%>" value="<%=Util.formataDataParaString(promocao.getDtInicioPromocao())%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterPromocao.ID_REQ_ATR_dtFimPromocao%>">Data Fim:</label></td>
					<td><input type="text"  
						id="<%=PRManterPromocao.ID_REQ_ATR_dtFimPromocao%>"
						name="<%=PRManterPromocao.ID_REQ_ATR_dtFimPromocao%>"  value="<%=Util.formataDataParaString(promocao.getDtFimPromocao())%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="diaPromocao">Informar dias da semana para promoção:</label></td>
					<td>*******************************************************</td>
				</tr>

				
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Alterar"
						onclick="submeterFormulario('<%=PRManterPromocao.NM_SERVLET%>','<%=PRManterPromocao.EVENTO_PROCESSAR_ALTERACAO%>')"
						id="alterar"><input type="button" value="Home"
						onClick=""></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>