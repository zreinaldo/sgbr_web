<%@page import="sgbr.web.servlet.PRManterTipoFuncionario"%>
<%@page import="sgbr.entidades.TipoFuncionario"%>
<%@page import="sgbr.util.Util"%>
<%@page import="sgbr.util.OTDTipoFuncionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.PRManterTipoFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<%
	boolean indicadorExclusao = false;
	indicadorExclusao = (Boolean) PRManterTipoFuncionario.getAtributoOpcional(PRManterTipoFuncionario.ID_REQ_indicadorExclusao, request);
	if (indicadorExclusao) {
%>
<title>Excluir Tipo Funcionário</title>
<%
	} else {
%>
<title>Detalhar Tipo Funcionário</title>
<%
	}
%>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	
	<%
	

	TipoFuncionario tpFuncionario =  (TipoFuncionario) PRManterTipoFuncionario.getAtributoOpcional(PRManterTipoFuncionario.ID_REQ_ATR_TipoFuncionario,request); 

		
	%>

<body>
<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterTipoFuncionario.ID_REQ_EVENTO%>" value="">
			<INPUT type="hidden" id="cdTipoFuncionario" name="<%=PRManterTipoFuncionario.ID_REQ_ATR_cdTipoFuncionario%>" value="<%=tpFuncionario.getCdTpFuncionario()%> ">


		<fieldset>
			<table>
				

				<tr>
					<td><label for="cdTipoFuncionario">Código Tipo Funcionário:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterTipoFuncionario.ID_REQ_ATR_cdTipoFuncionario%>"
						name="<%=PRManterTipoFuncionario.ID_REQ_ATR_cdTipoFuncionario%>" value="<%=tpFuncionario.getCdTpFuncionario() %>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="cdTipoFuncionario">Descrição Tipo Funcionário:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterTipoFuncionario.ID_REQ_ATR_dsTipoFuncionario%>"
						name="<%=PRManterTipoFuncionario.ID_REQ_ATR_dsTipoFuncionario%>" value="<%=tpFuncionario.getDsTpFuncionario() %>"
						maxlength="58"></td>
				</tr>

					<tr>
					<td><label for="dtFimValidade">Data Fim Validade:</label></td>
					<td><input type="text" disabled="disabled"
						id="<%=PRManterTipoFuncionario.ID_REQ_ATR_dtFimVigencia%>"
						name="<%=PRManterTipoFuncionario.ID_REQ_ATR_dtFimVigencia%>" maxlength="58" value="<%=Util.formataDataParaString(tpFuncionario.getDtFimVigencia())%>"> </td>
				</tr>
			

				
				<tr>
					<td colspan="2" id="botoes">
							<%
							if (indicadorExclusao) {
						%>
						<input type="button"
						value="Excluir"
						onclick="submeterFormulario('<%=PRManterTipoFuncionario.NM_SERVLET%>','<%=PRManterTipoFuncionario.EVENTO_PROCESSAR_EXCLUSAO%>')"
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