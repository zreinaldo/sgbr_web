
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
