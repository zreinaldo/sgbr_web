<%@page import="sgbr.web.servlet.selects.SelectSimNao"%>
<%@page import="sgbr.web.servlet.selects.SelectFuncionario"%>
<%@page import="sgbr.web.servlet.selects.SelectTipoUsuario"%>
<%@page import="sgbr.util.OTDUsuario"%>
<%@page import="sgbr.util.Util"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sgbr.web.servlet.PRManterUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manter Usuário</title>

<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

</head>
<%

String cdTpUsuario = PRManterUsuario.getAtributoOuParametroStringOpcional(PRManterUsuario.ID_REQ_ATR_cdTpUsuario, request);
String cdFuncionario = PRManterUsuario.getAtributoOuParametroStringOpcional(PRManterUsuario.ID_REQ_ATR_cdFuncionario, request);
String loginUsuario = PRManterUsuario.getAtributoOuParametroStringOpcional(PRManterUsuario.ID_REQ_ATR_loginUsuario, request);
String inBloqueioUsuario = PRManterUsuario.getAtributoOuParametroStringOpcional(PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario, request);


ArrayList<OTDUsuario> otd =  (ArrayList)PRManterUsuario.getAtributoOpcional(PRManterUsuario.ID_REQ_ATR_otdUsuario,request); 

if (otd == null) {
	otd = new ArrayList<OTDUsuario>();
}




%>


<body>

<%@ include file = "../../jsp/util/menu.jsp" %>

	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento" name="<%=PRManterUsuario.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
		
					<tr>
			<th align="left">Manter Usuário</th>
			</tr>							
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_cdFuncionario%>">Funcionário:</label></td>
					<td><%= SelectFuncionario.getInstancia().getHTML(request, PRManterUsuario.ID_REQ_ATR_cdFuncionario, PRManterUsuario.ID_REQ_ATR_cdFuncionario, cdFuncionario,false,true,false)%></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>">Login Usuário:</label></td>
					<td><input type="search" id="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>" value="<%=loginUsuario%>" name="<%=PRManterUsuario.ID_REQ_ATR_loginUsuario%>" maxlength="15"></td>
					
				</tr>
				
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_cdTpUsuario%>">Tipo de Usuário:</label></td>
					<td><%= SelectTipoUsuario.getInstancia().getHTML(request, PRManterUsuario.ID_REQ_ATR_cdTpUsuario, PRManterUsuario.ID_REQ_ATR_cdTpUsuario, cdTpUsuario,false,true)%></td>
				</tr>
				
				<tr>
					<td><label for="<%=PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario%>">Usuário Bloqueado:</label></td>
					<td><%= SelectSimNao.getInstancia().getHTML(request, PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario, PRManterUsuario.ID_REQ_ATR_inBloqueioUsuario, inBloqueioUsuario,false,true)%></td>
				</tr>
								
				
			</table>


			<div id="divTabela">
				<table border="1" id="tab" style="width:100%">
					<tr>
						<th>Selecione</th>
					    <th>Login</th>
						<th>Tipo Usuário</th>
						<th>Funcionário</th>	
						<th>Bloqueado</th>
														
				
					</tr>
		 <% for (OTDUsuario campos : otd) {		 
		
			 %>		 
					<tr>
					<td><INPUT type="radio" id="<%=PRManterUsuario.ID_REQ_ATR_radio_consulta_usuario%>" name="<%=PRManterUsuario.ID_REQ_ATR_radio_consulta_usuario%>" value="<%=campos.getCdUsuario()%>"></td>
					
						<td><%=campos.getLoginUsuario()%></td>
						<td><%=campos.getNmTpUsuario()%></td>
						<td><%=campos.getNmFuncionario()%></td>
						<td><%=Util.getDsSimNao(campos.getInBloqueioUsuario())%></td>
						
					</tr>
			<%} %>	
				</table>
				
				<table>
				<tr>
					<td colspan="2" id="botoes">
					    <input type="button" value="Consultar"	onclick="submeterFormulario('<%=PRManterUsuario.NM_SERVLET%>','<%=PRManterUsuario.EVENTO_PROCESSAR_CONSULTA%>')" id="consultar">
					    <input type="button" value="Incluir"	onclick="submeterFormulario('<%=PRManterUsuario.NM_SERVLET%>','<%=PRManterUsuario.EVENTO_EXIBIR_INCLUSAO%>')" id="incluir"> 
					    <input type="button" value="Alterar" onclick="submeterFormulario('<%=PRManterUsuario.NM_SERVLET%>','<%=PRManterUsuario.EVENTO_EXIBIR_ALTERACAO%>')" id="alterar"> 
					    <input type="button" value="Detalhar" onclick="submeterFormulario('<%=PRManterUsuario.NM_SERVLET%>','<%=PRManterUsuario.EVENTO_EXIBIR_DETALHAMENTO_CONSULTA%>')" id="excluir">
					    <input type="button" value="Excluir" onclick="submeterFormulario('<%=PRManterUsuario.NM_SERVLET%>','<%=PRManterUsuario.EVENTO_EXIBIR_EXCLUSAO%>')" id="excluir">
					</td>
				</tr>
			</table>
				
			</div>
		</fieldset>
	</FORM>
</body>
</html>