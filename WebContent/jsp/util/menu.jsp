<%@page import="sgbr.util.Constantes"%>
<%@page import="sgbr.util.OTDUsuario"%>
<SCRIPT language="JavaScript" type="text/javascript" src="js/funcoes_comuns.js"></SCRIPT>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>

<ul>
<% 


OTDUsuario usuario = (OTDUsuario) session.getAttribute("usuario");

if (usuario.getCdTpUsuario().equals(Constantes.CD_TIPO_USUARIO_GESTOR)) { %>

  <li><a href="#">SGBR</a></li>  
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Cadastros Gerenciais</a>
    <div class="dropdown-content">
      <a href="http://localhost:8080/sgbr_web/PRManterFuncionario">Manter Funcionário</a>
      <a href="http://localhost:8080/sgbr_web/PRManterTipoFuncionario">Manter Tipo Funcionário</a>
      <a href="http://localhost:8080/sgbr_web/PRManterCliente">Manter Cliente</a>
      <a href="http://localhost:8080/sgbr_web/PRManterUsuario">Manter Usuário</a>
      <a href="http://localhost:8080/sgbr_web/PRManterComanda">Manter Comanda</a>
      <a href="http://localhost:8080/sgbr_web/PRManterItemCardapio">Manter Item Cardápio</a>
      <a href="http://localhost:8080/sgbr_web/PRManterPromocao">Manter Promoção</a>         
    </div>
  </li>
  
  <%}%>
  
  
  
  
<%if (usuario.getCdTpUsuario().equals(Constantes.CD_TIPO_USUARIO_GARCOM)) { %>

  <li><a href="#">SGBR</a></li>  
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Cadastros</a>
    <div class="dropdown-content">      
      <a href="http://localhost:8080/sgbr_web/PRManterCliente">Manter Cliente</a>
      
      
    </div>
  </li>
  
  <%}%>
  
  
   <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Conta</a>
    <div class="dropdown-content">
    	<a href="http://localhost:8080/sgbr_web/PRManterConta">Manter Conta</a>
     	<a href="http://localhost:8080/sgbr_web/PRManterConta?evento=exibirAbrirContaMesa">Abrir conta por Mesa</a>   
        <a href="http://localhost:8080/sgbr_web/PRManterConta?evento=exibirAbrirContaComanda">Abrir conta por Comanda Individual</a>

    </div>
    
  </li>
  
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Pedidos</a>
    <div class="dropdown-content">
      <a href="http://localhost:8080/sgbr_web/PRManterPedido">Manter Pedidos</a>      
    </div>
    
  </li>
  
  <li><a href="http://localhost:8080/sgbr_web/PRLoginUsuario?evento=processarDeslogarUsuario">Deslogar</a></li>
  
  
  <li><a href="#">Usuario: <%=usuario.getNmFuncionario() %></a></li>  
  <li><a href="#">Tipo Usuario: <%=usuario.getNmTpUsuario() %></a></li>
</ul>
