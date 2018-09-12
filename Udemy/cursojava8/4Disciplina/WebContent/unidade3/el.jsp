<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expression Language</title>
</head>
<body>
	${1<2}
	${1+2+3}
	${10.2 + 20.3}
	${50 mod 8}
	${(10==20) ? "true" : "false"}
	${param.cpf}
	${param.senha}
</body>
</html>