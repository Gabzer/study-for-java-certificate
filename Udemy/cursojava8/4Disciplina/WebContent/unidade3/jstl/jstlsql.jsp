<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="bd" driver="oracle.jdbc.driver.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:XE" user="cursojava"
	password="schema" />
	
<sql:query dataSource="${bd}" var="result">SELECT * from Login</sql:query>

<table border="1" width="100%">
	<tr>
		<th>CPF</th>
		<th>Senha</th>
	</tr>
	<c:forEach var="row" items="${result.rows}">
		<tr>
			<td><c:out value="${row.cpf}" /></td>
			<td><c:out value="${row.senha}" /></td>
		</tr>
	</c:forEach>
</table>