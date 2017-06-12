<%@page import="sgbr.web.servlet.selects.SelectEstado"%>
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
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>
<body>
	<FORM name="form_principal" method="post" action="">
<%@ include file = "../../jsp/util/menu.jsp" %>
		<INPUT type="hidden" id="evento"
			name="<%=PRManterFuncionario.ID_REQ_EVENTO%>" value="">


		<fieldset>
			<table>
	<tr>
			<th align="left">Incluir Funcionário</th>
			</tr>	
					
				<tr>
					<td><label for="nmCargo">Cargo:</label></td>

					<td><%= SelectTipoFuncionario.getInstancia().getHTML(request, PRManterFuncionario.ID_REQ_ATR_tpCargo, PRManterFuncionario.ID_REQ_ATR_tpCargo, "",true,false)%></td>
				</tr>
								

				<tr>
					<td><label for="nmFuncionario">Nome:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmFuncionario%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmFuncionario%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nuCPF">CPF:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuCPF%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCPF%>" maxlength="58"></td>
				</tr>

				<tr>
					<td><label for="nuRG">RG:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuRG%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuRG%>" maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nuCarteira">Carteira de Trabalho:</label></td>
					<td><input id="<%=PRManterFuncionario.ID_REQ_ATR_nuCarteira%>" required 
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCarteira%>"
						maxlength="58"></td>
				</tr>

				<tr>
					<td><label for="dtNascimento">Data Nascimento:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_dtNascimento%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_dtNascimento%>"
						maxlength="58"></td>
				</tr>
				
						
				<tr>
				<td><label for="convencional">Telefone Convencional:</label></td>
					<td><input type="text" size="4" 			
						id="<%=PRManterFuncionario.ID_REQ_ATR_dddTelefoneConvencional%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_dddTelefoneConvencional%>"
						maxlength="3"> - <input type="text"  
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuTelefoneConvencional%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuTelefoneConvencional%>"
						maxlength="10"> </td>
				</tr>
				
						
				<tr>
				<td><label for="celular">Telefone Celular:</label></td>
					<td><input type="text" size="4" 			
						id="<%=PRManterFuncionario.ID_REQ_ATR_dddTelefoneCelular%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_dddTelefoneCelular%>"
						maxlength="3"> - <input type="text"  
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuTelefoneCelular%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuTelefoneCelular%>"
						maxlength="10"> </td>
				</tr>

				<tr>
					<td><label for="email">E-mail:</label></td>
					<td><input type="email" id="<%=PRManterFuncionario.ID_REQ_ATR_email%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_email%>" maxlength="58"></td>
				</tr>

				<td><label for="dadosBancarios">Dados Bancarios</label></td>
				<td>-</td>
				<tr>
					<td><label for="nmBanco">Banco:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmBanco%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmBanco%>" maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nuAgencia">Agência:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuAgencia%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuAgencia%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nuCC">Número Conta Corrente:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuCC%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCC%>" maxlength="58"></td>
				</tr>

				<tr>
					<td><label for="vlSalario">Salário:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_vlSalario%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_vlSalario%>"
						maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="dtAdmissao">Data Admissão:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_dtAdmissao%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_dtAdmissao%>"
						maxlength="58"></td>
				</tr>
				<td><label for="dadosEndereco">Dados do Endereço</label></td>
				<td>-</td>			
				<tr>
					<td><label for="nmUF">Estado:</label></td>
					<td><%=SelectEstado.getInstancia().getHTML(request, PRManterFuncionario.ID_REQ_ATR_nmUF, PRManterFuncionario.ID_REQ_ATR_nmUF, "", true, false) %></td>
				</tr>
				<tr>
					<td><label for="nmCidade">Cidade:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmCidade%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmCidade%>" maxlength="58"></td>
				</tr>
				<tr>
					<td><label for="nmBairro">Bairro:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmBairro%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmBairro%>" maxlength="58"></td>
				</tr>
				
				<tr>
					<td><label for="nmLogradouro">Logradouro:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_nmLogradouro%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nmLogradouro%>"
						maxlength="58" size="50"> <label for="nuLogradouro">Número:</label><input
						type="text" id="<%=PRManterFuncionario.ID_REQ_ATR_nuLogradouro%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuLogradouro%>"
						maxlength="8" size="10"></td>
				</tr>				
				<tr>
					<td><label for="nuCEP">CEP:</label></td>
					<td><input type="text" required 
						id="<%=PRManterFuncionario.ID_REQ_ATR_nuCEP%>"
						name="<%=PRManterFuncionario.ID_REQ_ATR_nuCEP%>" maxlength="58"></td>
				</tr>
				<tr>
					<td colspan="2" id="botoes"><input type="submit"
						value="Incluir"
						onclick="submeterFormulario('<%=PRManterFuncionario.NM_SERVLET%>','<%=PRManterFuncionario.EVENTO_PROCESSAR_INCLUSAO%>')"
						id="incluir"> <input type="button" value="Voltar"
						onclick=" window.history.back();" id="voltar"> </td>
				</tr>
			</table>

		</fieldset>
	</FORM>
</body>
</html>