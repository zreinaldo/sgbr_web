<%@page import="sgbr.web.servlet.selects.SelectTipoFuncionario"%>
<%@page import="sgbr.web.servlet.PRManterFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Funcionario</title>
</head>
<body>
	<script type="text/javascript">
		function submeterFormulario(pServlet, pEvento) {
			alert(pServlet);
			alert(pEvento);
			document.form_principal.action = pServlet;
			evento = eval("document.form_principal.evento");
			if (evento != null) {
				evento.value = pEvento;
			}

			document.form_principal.submit();

		}
	</script>
	<FORM name="form_principal" method="post" action="">

		<INPUT type="hidden" id="evento"
			name="<%=PRManterFuncionario.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
					
				<tr>
					<td><label for="nmCargo">Cargo:</label></td>

					<td><%= SelectTipoFuncionario.getInstancia().getHTML(request, PRManterFuncionario.ID_REQ_ATR_tpCargo, PRManterFuncionario.ID_REQ_ATR_tpCargo, "2")%></td>
				</tr>
								

				<tr>
					<td><label for="nmFuncionario">Nome:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmFuncionario%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmFuncionario%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nuCPF">CPF:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuCPF%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCPF%>" maxlength="58"></td>
				</tr>

				<tr>
					<td><label for="nuRG">RG:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuRG%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuRG%>" maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nuCarteira">Carteira de Trabalho:</label></td>
					<td><input id="<%=PRManterFuncionario.ID_REQ_ATR_nuCarteira%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCarteira%>"
						maxlength="58"></td>
				</tr>

				<tr>
					<td><label for="dtNascimento">Data Nascimento:</label></td>
					<td><input
						id="<%=PRManterFuncionario.ID_REQ_ATR_dtNascimento%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_dtNascimento%>"
						maxlength="58"></td>
				</tr>

				<tr>
					<td><label for="email">E-mail:</label></td>
					<td><input id="<%=PRManterFuncionario.ID_REQ_ATR_email%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_email%>" maxlength="58"></td>
				</tr>

				<td><label for="dadosBancarios">Dados Bancarios</label></td>
				<td>-</td>
				<tr>
					<td><label for="nmBanco">Banco:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmBanco%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmBanco%>" maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nuAgencia">Ag�ncia:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuAgencia%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuAgencia%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nuCC">N�mero Conta Corrente:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuCC%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCC%>" maxlength="58"></td>
				</tr>

				<tr>
					<td><label for="vlSalario">Sal�rio:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_vlSalario%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_vlSalario%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="dtAdmissao">Data Admiss�o:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_dtAdmissao%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_dtAdmissao%>"
						maxlength="58"></td>
				</tr>
				<td><label for="dadosEndereco">Dados do Endere�o</label></td>
				<td>-</td>			
				<tr>
					<td><label for="nmUF">Estado:</label></td>
					<td><select id="<%=PRManterFuncionario.ID_REQ_ATR_nmUF%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmUF%>">
							<option value="PE">Pernambuco</option>
							<option value="PB" selected="selected">Paraiba</option>
							<option value="RJ">Rio de Janeiro</option>
							<option value="AL">Alagoas</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="nmCidade">Cidade:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmCidade%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmCidade%>" maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nmBairro">Bairro:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmBairro%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmBairro%>" maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="nmLogradouro">Logradouro:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmLogradouro%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmLogradouro%>"
						maxlength="58" size="50"> <label for="nuLogradouro">N�mero:</label><input
						type="text" id="<%=PRManterFuncionario.ID_REQ_ATR_nuLogradouro%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuLogradouro%>"
						maxlength="8" size="10"></td>
				</tr>				
				<tr>
					<td><label for="nuCEP">CEP:</label></td>
					<td><input type="text"
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuCEP%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCEP%>" maxlength="58"></td>
				</tr>
				<tr>
					<td colspan="2" id="botoes"><input type="button"
						value="Incluir"
						onclick="submeterFormulario('<%=PRManterFuncionario.NM_SERVLET%>','<%=PRManterFuncionario.EVENTO_PROCESSAR_INCLUSAO%>')"
						id="consultar"><input type="button" value="Home"
						onClick=""></td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>