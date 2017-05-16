<%@page import="sgbr.web.servlet.teste.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<FORM name="formPrincipal" method="post" action="">
<INPUT type="hidden" id="evento" name="<%=TesteServlet.ID_REQ_EVENTO%>" value="processarConsulta">

<body>


looo mundoasdsadsadasd  <input type="submit" value="Enviar"> 

<INPUT type="text" id="teste" size="8"  name="teste" maxlength="10" value="teste input"> 


<% String vlSaida = TesteServlet.getAtributoStringOpcional("enviado", false, request); %>


<input type="text" value="aoi" name="valor">


<input type="text" value="<%=vlSaida %>" name="valor">

</body>


</FORM>
</html>