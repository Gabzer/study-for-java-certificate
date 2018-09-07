package unidade3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CursoApp {
	
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String usuario = "curso_java";
	static String senha = "schema";
	static Connection conexao;
	
	public static void conectar() throws SQLException {
		conexao = DriverManager.getConnection(url,usuario,senha);
		conexao.setAutoCommit(false);
	}
	
	public static void desconectar() throws SQLException {
		conexao.close();
	}
	
	public static void inserir (long cdCurso, String nome, double valor, String url) throws SQLException {
		String sql = "INSERT INTO Curso VALUES (" + cdCurso + ", '" + nome + "', " + valor + ", '" + url +"')";
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		conexao.commit();
	}
	
	public static void inserirPS (long cdCurso, String nome, double valor, String url) throws SQLException {
		String sql = "INSERT INTO Curso VALUES (?,?,?,?)";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setLong(1, cdCurso);
		statement.setString(2, nome);
		statement.setDouble(3, valor);
		statement.setString(4, url);
		statement.executeUpdate();
		conexao.commit();
	}
	
	public static void inserirSP (long cdCurso, String nome, double valor, String url) throws SQLException {
		String sql = "{CALL sp_inserircliente (?,?,?,?)}";
		CallableStatement cs = conexao.prepareCall(sql);
		cs.setLong(1, cdCurso);
		cs.setString(2, nome);
		cs.setDouble(3, valor);
		cs.setString(4, url);
		cs.execute();
		conexao.commit();
	}
	
	public static void consultar (long cdCurso) throws SQLException {
		String sql = "SELECT * FROM Curso WHERE cdCurso=" + cdCurso + "";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println("cdCurso:" + rs.getInt(1) + 
					" nome:" + rs.getString(2) + " valor:" + rs.getDouble(3) + " url:" + rs.getString(4));
		}
	}
	
	public static void consultarTodos () throws SQLException {
		String sql = "SELECT * FROM Curso";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		int cont = 0;
		while (rs.next()) {
			System.out.println("cdCurso:" + rs.getInt(1) + 
					" nome:" + rs.getString(2) + " valor:" + rs.getDouble(3) + " url:" + rs.getString(4));
			System.out.println("-----------------------------------------------------");
			cont++;
		}
		System.out.println("Número de clientes listados: " + cont + "\n");
	}
	
	public static void alterar (long cdCurso, String nome, double valor, String url) throws SQLException {
		String sql = "UPDATE Curso SET nome='" + nome + "', valor=" + valor + ", url='" + url +"' WHERE cdCurso=" + cdCurso;
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
						consultarTodos();
						break;
					case 2:
						System.out.println("[2] Consultar um Curso Especifico");
						System.out.println("Favor informar o Código do Curso >>>");
						cdCurso = entrada.nextLong();
						consultar(cdCurso);
						break;
					case 3:
						System.out.println("[3] Cadastrar um Novo Curso");
						System.out.println("Favor informar o Código do Curso >>>");
						cdCurso = entrada.nextLong();
						entrada.nextLine(); // esvaziar o buffer do teclado
						System.out.println("Favor informar o Nome >>>");
						nome = entrada.nextLine();
						System.out.println("Favor informar o Valor >>>");
						valor = entrada.nextDouble();
						entrada.nextLine(); // esvaziar o buffer do teclado
						System.out.println("Favor informar o Url >>>");
						url = entrada.nextLine();
						//inserir(cdCurso, nome, valor, url);
						inserirPS(cdCurso, nome, valor, url);
						//inserirSP(cdCurso, nome, valor, url);
						break;
					case 4:
						System.out.println("[4] Alterar um Curso");
						System.out.println("Favor informar o Código do Curso >>>");
						cdCurso = entrada.nextLong();
						entrada.nextLine(); // esvaziar o buffer do teclado
						System.out.println("Favor informar o Nome >>>");
						nome = entrada.nextLine();
						System.out.println("Favor informar o Valor >>>");
						valor = entrada.nextDouble();
						entrada.nextLine(); // esvaziar o buffer do teclado
						System.out.println("Favor informar o Url >>>");
						url = entrada.nextLine();
						alterar(cdCurso, nome, valor, url);
						break;
					case 5:
						System.out.println("[5] Excluir um Curso");
						System.out.println("Favor informar o Código do Curso >>>");
						cdCurso = entrada.nextLong();
						excluir(cdCurso);
						break;
					case 6:
						System.out.println("Encerrando o Sistema...");
						break;						
					default:
						break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
