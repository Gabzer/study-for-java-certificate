<jsp:directive.page import="java.sql.*" />
<jsp:declaration>
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String usuario = "cursojava";
	static String senha = "schema";
	static Connection conexao;
	
	public void init() throws ServletException {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(url,usuario,senha);
			conexao.setAutoCommit(false);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
</jsp:declaration>
<jsp:scriptlet>
	System.out.println("Entrou aqui");
	String cpfmascara = request.getParameter("cpf");
	cpfmascara = cpfmascara.replaceAll("[.-]", "");
	long cpf = Long.parseLong(cpfmascara);
	String senha = request.getParameter("senha");
	String consulta = "SELECT * FROM Login WHERE cpf='" + cpf + "' and senha='" + senha + "'";
	Statement statement;
	try {
		statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(consulta);
		if (rs.next()) {
			session.setAttribute("mensagem", "Usu�rio Autenticado!");
			response.sendRedirect("sucesso.jsp");
		}else{
			session.setAttribute("mensagem", "Usu�rio N�o Autenticado!");
			response.sendRedirect("login.jsp");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
</jsp:scriptlet>