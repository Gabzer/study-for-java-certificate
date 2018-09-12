<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body bgcolor="#FFFFFF">
	<c:set var="agora" value="<%=new java.util.Date()%>" />
	<p>
		Hora: <strong><fmt:formatDate type="time" value="${agora}" /></strong>
	</p>
	<p>
		Dia: <strong><fmt:formatDate type="date" value="${agora}" /></strong>
	</p>
</body>
</html>