package unidade2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAutenticador
 */
@WebServlet("/ServletAutenticador")
public class ServletAutenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String usuario = "cursojava";
	static String senha = "schema";
	static Connection conexao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutenticador() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpfmascara = request.getParameter("cpf");
		cpfmascara = cpfmascara.replaceAll("[.-]", "");
		long cpf = Long.parseLong(cpfmascara);
		String senha = request.getParameter("senha");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String consulta = "SELECT * FROM Login WHERE cpf='" + cpf + "' and senha='" + senha + "'";
		Statement statement;
		try {
			statement = conexao.createStatement();
			ResultSet rs = statement.executeQuery(consulta);
			if (rs.next())
				out.println("<h2>Usuário Autenticado!</h2>");
			else
				out.println("<h2>Usuário Não Autenticado!</h2>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
