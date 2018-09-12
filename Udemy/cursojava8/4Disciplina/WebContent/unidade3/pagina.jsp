<%@ page errorPage="erro.jsp" %>
<%
// Throw uma exceção para chamar erro.jsp
int x = 1;
if (x == 1)
{
throw new RuntimeException("Erro!");
}
%>