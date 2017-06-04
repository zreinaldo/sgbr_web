<%@page import="sgbr.util.OTDPromocao"%>
<%@page import="sgbr.web.servlet.PRManterPromocao"%>
<%@page import="sgbr.entidades.Promocao"%>
<%@page import="sgbr.util.Util"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<%
	boolean indicadorExclusao = false;
	indicadorExclusao = (Boolean) PRManterPromocao.getAtributoOpcional(PRManterPromocao.ID_REQ_indicadorExclusao, request);
	if (indicadorExclusao) {
%>
<title>Excluir Promoção</title>
<%
	} else {
%>
<title>Detalhar Promoção</title>
<%
	}
%>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	
	<%
	

	OTDPromocao otdPromocao =  (OTDPromocao) PRManterPromocao.getAtributoOpcional(PRManterPromocao.ID_REQ_ATR_otdPromocao,request); 

		
	%>

<body>
<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterPromocao.ID_REQ_EVENTO%>" value="">
			<INPUT type="hidden" id="cdPromocao" name="<%=PRManterPromocao.ID_REQ_ATR_cdPromocao%>" value="<%=otdPromocao.getCdPromocao()%> ">


		<fieldset>
			<table>
				

				<tr>
					<td><label for="nmItemCardapio">Item Cardápio:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterPromocao.ID_REQ_ATR_nmItemCardapio%>"
						name="<%=PRManterPromocao.ID_REQ_ATR_nmItemCardapio%>" value="<%=otdPromocao.getNmItemCardapio() %>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="vlPromocao">Valor Promocional:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterPromocao.ID_REQ_ATR_vlPromocao%>"
						name="<%=PRManterPromocao.ID_REQ_ATR_vlPromocao%>" value="<%=otdPromocao.getVlPromocao() %>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="dtInicioPromocao">Data de Início:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterPromocao.ID_REQ_ATR_dtInicioPromocao%>"
						name="<%=PRManterPromocao.ID_REQ_ATR_dtInicioPromocao%>" value="<%=Util.formataDataParaString(otdPromocao.getDtInicioPromocao()) %>"
						maxlength="58"></td>
				</tr>
				
								<tr>
					<td><label for="dtFimPromocao">Data de Início:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterPromocao.ID_REQ_ATR_dtFimPromocao%>"
						name="<%=PRManterPromocao.ID_REQ_ATR_dtFimPromocao%>" value="<%=Util.formataDataParaString(otdPromocao.getDtFimPromocao()) %>"
						maxlength="58"></td>
				</tr>

				<tr>
					<td><label for="diasSemanaPromocao">Dias da Semana:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterPromocao.ID_REQ_ATR_diasSemanaPromocao%>"
						name="<%=PRManterPromocao.ID_REQ_ATR_diasSemanaPromocao%>" value="<%=otdPromocao.getColecaoDsPromocaoDiasSemana() %>"
						maxlength="100" size="100"></td>
				</tr>


				<tr>
					<td colspan="2" id="botoes">
							<%
							if (indicadorExclusao) {
						%>
						<input type="button"
						value="Excluir"
						onclick="submeterFormulario('<%=PRManterPromocao.NM_SERVLET%>','<%=PRManterPromocao.EVENTO_PROCESSAR_EXCLUSAO%>')"
						id="excluir">
						<%}%>                      
						<input type="button" value="Voltar"
						onclick=" window.history.back();" id="voltar">

                    </td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>