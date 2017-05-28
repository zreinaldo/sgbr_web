<%@page import="sgbr.util.OTDTipoFuncionario"%>
<%@page import="sgbr.util.Util"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.PRManterTipoFuncionario"%>
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

String cdTpFuncionario = PRManterTipoFuncionario.getAtributoOuParametroStringOpcional(PRManterTipoFuncionario.ID_REQ_ATR_cdTipoFuncionario, request);
String dsTpFuncionario = PRManterTipoFuncionario.getAtributoOuParametroStringOpcional(PRManterTipoFuncionario.ID_REQ_ATR_dsTipoFuncionario, request);



ArrayList<OTDTipoFuncionario> otd =  (ArrayList)PRManterTipoFuncionario.getAtributoOpcional(PRManterTipoFuncionario.ID_REQ_ATR_otdTipoFuncionario,request); 

if (otd == null) {
	otd = new ArrayList<OTDTipoFuncionario>();
}




%>


<body>
<FORM name="form_principal" method="post" action="">

<%@ include file = "../../jsp/util/menu.jsp" %>

		<INPUT type="hidden" id="evento" name="<%=PRManterTipoFuncionario.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>		
							
				<tr>
					<td><label for="cdTpFuncionario">Código Tipo Funcionário:</label></td>
					<td><input type="search" id="<%=PRManterTipoFuncionario.ID_REQ_ATR_cdTipoFuncionario%>" value="<%=cdTpFuncionario%>" name="<%=PRManterTipoFuncionario.ID_REQ_ATR_cdTipoFuncionario%>" maxlength="15"></td>
					
					<td></td>
				</tr>
				
				<tr>
					<td><label for="dsTpFuncionario">Descrição Tipo Funcionário:</label></td>
					<td><input type="search" id="<%=PRManterTipoFuncionario.ID_REQ_ATR_dsTipoFuncionario%>" value="<%=dsTpFuncionario%>" name="<%=PRManterTipoFuncionario.ID_REQ_ATR_dsTipoFuncionario%>" maxlength="15"></td>
				</tr>
								
				
			</table>


			<div id="divTabela">
				<table border="1" id="tab" style="width:100%">
					<tr>
					    <th>Selecione</th>
						<th>Código</th>
						<th>Descrição</th>	
						<th>Data Fim de Vigência</th>								
				
					</tr>
		 <% for (OTDTipoFuncionario campos : otd) {		 
		
			 %>		 
					<tr>
					<td><INPUT type="radio" id="radio_consulta_tipo_funcionario" name="<%=PRManterTipoFuncionario.ID_REQ_ATR_radio_consulta_tipo_funcionario%>" value="<%=campos.getCdTpFuncionario()%>"></td>
					
						<td><%=campos.getCdTpFuncionario()%></td>
						<td><%=campos.getDsTpFuncionario()%></td>
						<td><%= Util.formataDataParaString(campos.getDtFimVigencia())%></td>
						
					</tr>
			<%} %>	
				</table>
				
				<table>
				<tr>
					<td colspan="2" id="botoes">
					    <input type="button" value="Consultar"	onclick="submeterFormulario('<%=PRManterTipoFuncionario.NM_SERVLET%>','<%=PRManterTipoFuncionario.EVENTO_PROCESSAR_CONSULTA%>')" id="consultar">
					    <input type="button" value="Incluir"	onclick="submeterFormulario('<%=PRManterTipoFuncionario.NM_SERVLET%>','<%=PRManterTipoFuncionario.EVENTO_EXIBIR_INCLUSAO%>')" id="incluir"> 
					    <input type="button" value="Alterar" onclick="submeterFormulario('<%=PRManterTipoFuncionario.NM_SERVLET%>','<%=PRManterTipoFuncionario.EVENTO_EXIBIR_ALTERACAO%>')" id="alterar"> 
					    <input type="button" value="Detalhar" onclick="submeterFormulario('<%=PRManterTipoFuncionario.NM_SERVLET%>','<%=PRManterTipoFuncionario.EVENTO_EXIBIR_DETALHAMENTO_CONSULTA%>')" id="excluir">
					    <input type="button" value="Excluir" onclick="submeterFormulario('<%=PRManterTipoFuncionario.NM_SERVLET%>','<%=PRManterTipoFuncionario.EVENTO_EXIBIR_EXCLUSAO%>')" id="excluir">
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>