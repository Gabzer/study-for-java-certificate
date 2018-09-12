<%@ page isErrorPage="true" %>
<html>
<head>
	<title>Página de Erro</title>
</head>
<body>
	<pre>
		<% exception.printStackTrace
		(response.getWriter()); %>
	</pre>
</body>
</html>