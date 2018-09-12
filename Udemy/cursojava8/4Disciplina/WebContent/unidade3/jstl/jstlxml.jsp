<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<html>
<body>
	<h3>Informações:</h3>
	<c:import var="clienteInfo" url="http://localhost/4Disciplina/unidade3/jstl/clientes.xml" />
	<x:parse xml="${clienteInfo}" var="output" />
	<b>CPF</b>:
	<x:out select="$output/clientes/cliente/cpf" />
	<br>
	<b>Nome</b>:
	<x:out select="$output/clientes/cliente/nome" />
	<br>
</body>
</html>