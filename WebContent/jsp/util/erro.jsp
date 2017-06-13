<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Falha no Sistema</title>
</head>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>

	

<body>

	<FORM name="form_principal" method="post" action="">
<%@ include file = "../../jsp/util/menu.jsp" %>
		
<fieldset>
			<table>
					
				<tr>
					<td><label for="erro"><p>Ops, algo não ocorreu como o planejado...  </p>
					         <p>Você pode ter digitado algo errado ou feito algo que não deveria.</p>
					         <p>Vamos tentar outra vez.</p>
					         </label></td>
					
				</tr>
					
				<tr>
				<td colspan="2" id="botoes">
							          
						<input type="button" value="Voltar"
						onclick=" window.history.back();" id="voltar">

                    </td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>

