<jsp:useBean id="obj" class="unidade3.Calc" />
<%
int cubo = obj.cubo(5);
out.print("Cubo de 5 é "+cubo);
%>