<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body bgcolor="#FFFFFF">
	<jsp:useBean id="colecao" class="unidade3.Clientes"/>
	<c:forEach var="nomes" items="${colecao.nomes}">
		<c:out value="${nomes}" />
		<br />
	</c:forEach>
</body>
</html>