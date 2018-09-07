package unidade3.com.abctreinamentos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CursoDAO {
	
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String usuario = "curso_java";
	static String senha = "schema";
	static Connection conexao;
	
	public static void conectar() throws SQLException {
		conexao = DriverManager.getConnection(url,usuario,senha);
		DatabaseMetaData meta = conexao.getMetaData();
		conexao.setAutoCommit(false);
		System.out.println(">>> Conectado ao Banco de Dados " + meta.getDatabaseProductVersion());
	}
	
	public static void desconectar() throws SQLException {
		conexao.close();
	}
	
	public static void inserir (Curso curso) throws SQLException {
		String sql = "INSERT INTO Curso VALUES (" + curso.getCdCurso() + ", '" + curso.getNome() + "', " + curso.getValor() + ", " + curso.getUrl() + ")";
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		conexao.commit();
	}
	
	public static Curso consultar (long cdCurso) throws SQLException {
		String sql = "SELECT * FROM Curso WHERE cdCurso=" + cdCurso + "";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Curso curso = null;
		while (rs.next()) {
			curso = new Curso(
					rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getDouble(4)
				);
		}
		return curso;
	}
	
	public static List<Curso> consultarTodos () throws SQLException {
		String sql = "SELECT * FROM Curso";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<Curso> cursos = new LinkedList<>();
		while (rs.next()) {
			Curso curso = new Curso(
					rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getDouble(4)
				);
			cursos.add(curso);
		}
		return cursos;
	}
	
	public static void alterar (Curso curso) throws SQLException {
		String sql = "UPDATE Curso SET nome='" + curso.getNome() + "', url='" + curso.getUrl() +"', valor=" + curso.getValor() + " WHERE cdCurso=" + curso.getCdCurso();
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
	}

	public static void excluir (long cdCurso) throws SQLException {
		String sql = "DELETE FROM Curso WHERE cdCurso=" + cdCurso;
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
	}
	
	public static void main(String[] args) {
		try {
			conectar();
			Scanner entrada = new Scanner(System.in);
			int opcao = 0;
			long cdCurso;
			String nome, url;
			double valor;
			
			while (opcao != 6) {
				System.out.println("Sistema de Gerenciamento de Cursos");
				System.out.println("====================================");
				System.out.println("Digite [1] para Consultar todos os Cursos");
				System.out.println("Digite [2] para Consultar um Curso Especifico");
				System.out.println("Digite [3] para Cadastrar um Novo Curso");
				System.out.println("Digite [4] para Alterar um Curso");
				System.out.println("Digite [5] para Excluir um Curso");
				System.out.println("Digite [6] para Sair");
				System.out.println("====================================");
				opcao = entrada.nextInt();
				
				switch (opcao) {
					case 1:
						System.out.println("[1] Consultar Todos");
						List<Curso> cursos = CursoDAO.consultarTodos();
						cursos.forEach(System.out::println);
						System.out.println("Número de Cursos: " + cursos.size() + "\n");
						break;
					case 2:
						System.out.println("[2] Consultar um Curso Especifico");
						System.out.println("Favor informar o Código do Curso >>>");
						cdCurso = entrada.nextLong();
						Curso curso = CursoDAO.consultar(cdCurso);
						System.out.println(curso);
						break;
					case 3:
						System.out.println("[3] Cadastrar um Novo Curso");
						System.out.println("Favor informar o Código do Curso >>>");
						cdCurso = entrada.nextLong();
						entrada.nextLine(); // esvaziar o buffer do teclado
						System.out.println("Favor informar o Nome >>>");
						nome = entrada.nextLine();
						System.out.println("Favor informar o Url >>>");
						url = entrada.nextLine();
						System.out.println("Favor informar o Valor >>>");
						valor = entrada.nextDouble();
						Curso curso2 = new Curso(cdCurso, nome, url, valor);
						CursoDAO.inserir(curso2);
						break;
					case 4:
						System.out.println("[4] Alterar um Curso");
						System.out.println("Favor informar o Código do Curso >>>");
						cdCurso = entrada.nextLong();
						entrada.nextLine(); // esvaziar o buffer do teclado
						System.out.println("Favor informar o Nome >>>");
						nome = entrada.nextLine();
						System.out.println("Favor informar o Url >>>");
						url = entrada.nextLine();
						System.out.println("Favor informar o Valor >>>");
						valor = entrada.nextDouble();
						Curso curso3 = new Curso(cdCurso, nome, url, valor);
						CursoDAO.alterar(curso3);
						break;
					case 5:
						System.out.println("[5] Excluir um Curso");
						System.out.println("Favor informar o Código do Curso >>>");
						cdCurso = entrada.nextLong();
						CursoDAO.excluir(cdCurso);
						break;
					case 6:
						System.out.println("Encerrando o Sistema...");
						break;						
					default:
						break;
				}
			}
			entrada.close();
			desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
