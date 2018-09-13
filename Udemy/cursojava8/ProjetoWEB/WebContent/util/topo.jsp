<%
	if (session.getAttribute("login") != "true") {
		session.setAttribute("mensagem", "Acesso Proibido! Favor se Autenticar.");
%>
<jsp:forward page="/login.jsp"></jsp:forward>
<%  } %>