<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<body>
	<c:set var="string1" value="Antonio Sampaio Jr." />
	<c:set var="string2" value="Professor do Curso Java8." />
	<p>Tamanho da String (1) : ${fn:length(string1)}</p>
	<p>Tamanho da String (2) : ${fn:length(string2)}</p>
</body>
</html>