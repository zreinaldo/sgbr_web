<%@page import="sgbr.util.web.CheckBoxDiaSemana"%>
<%@page import="sgbr.util.Constantes"%>
<%@page import="sgbr.web.servlet.selects.SelectItemCardapio"%>
<%@page import="sgbr.web.servlet.PRManterPromocao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Promoção</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>
<body>
	<FORM name="form_principal" method="post" action="">


<%@ include file = "../../jsp/util/menu.jsp" %>

		<INPUT type="hidden" id="evento" name="<%=PRManterPromocao.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
				<tr>
					<td><label for="<%=PRManterPromocao.ID_REQ_ATR_cdItemCardapio%>">Item do Cardápio:</label></td>
					<td><%= SelectItemCardapio.getInstancia().getHTML(request, PRManterPromocao.ID_REQ_ATR_cdItemCardapio, PRManterPromocao.ID_REQ_ATR_cdItemCardapio, "",true,false)%></td>
				</tr>			

				<tr>
					<td><label for="<%=PRManterPromocao.ID_REQ_ATR_vlPromocao%>">Valor Promocional:</label></td>
					<td><input type="text" required 
						id="<%=PRManterPromocao.ID_REQ_ATR_vlPromocao%>"
						name="<%=PRManterPromocao.ID_REQ_ATR_vlPromocao%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterPromocao.ID_REQ_ATR_dtInicioPromocao%>">Data Início:</label></td>
					<td><input type="text" required 
						id="<%=PRManterPromocao.ID_REQ_ATR_dtInicioPromocao%>"
						name="<%=PRManterPromocao.ID_REQ_ATR_dtInicioPromocao%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterPromocao.ID_REQ_ATR_dtFimPromocao%>">Data Fim:</label></td>
					<td><input type="text"  
						id="<%=PRManterPromocao.ID_REQ_ATR_dtFimPromocao%>"
						name="<%=PRManterPromocao.ID_REQ_ATR_dtFimPromocao%>"
						maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="diaPromocao">Dias da semana para promoção:</label></td>
					<td>
					      <%=CheckBoxDiaSemana.getInstancia().getHTML(request, PRManterPromocao.ID_REQ_ATR_diasSemanaPromocao, "idSelect", null)%>
					</td>

				</tr>
			
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Incluir"
						onclick="submeterFormulario('<%=PRManterPromocao.NM_SERVLET%>','<%=PRManterPromocao.EVENTO_PROCESSAR_INCLUSAO%>')"
						id="consultar"></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>