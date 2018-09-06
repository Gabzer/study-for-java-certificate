package unidade3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ClienteApp {
	
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
	
	public static void inserir (long cpf, String nome, String email) throws SQLException {
		String sql = "INSERT INTO Cliente VALUES (" + cpf + ", '" + nome + "', '" + email +"')";
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		conexao.commit();
	}
	
	public static void inserirPS (long cpf, String nome, String email) throws SQLException {
		String sql = "INSERT INTO Cliente VALUES (?,?,?)";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setLong(1, cpf);
		statement.setString(2, nome);
		statement.setString(3, email);
		statement.executeUpdate();
		conexao.commit();
	}
	
	public static void inserirSP (long cpf, String nome, String email) throws SQLException {
		String sql = "{CALL sp_inserircliente (?,?,?)}";
		CallableStatement cs = conexao.prepareCall(sql);
		cs.setLong(1, cpf);
		cs.setString(2, nome);
		cs.setString(3, email);
		cs.execute();
		conexao.commit();
	}
	
	public static void consultar (long cpf) throws SQLException {
		String sql = "SELECT * FROM Cliente WHERE cpf=" + cpf + "";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println("cpf:" + rs.getInt(1) + 
					" nome:" + rs.getString(2) + " email:" + rs.getString(3));
		}
	}
	
	public static void consultarTodos () throws SQLException {
		String sql = "SELECT * FROM Cliente";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		int cont = 0;
		while (rs.next()) {
			System.out.println("cpf:" + rs.getInt(1) + 
					" nome:" + rs.getString(2) + " email:" + rs.getString(3));
			System.out.println("-----------------------------------------------------");
			cont++;
		}
		System.out.println("Número de clientes listados: " + cont + "\n");
	}
	
	public static void alterar (long cpf, String nome, String email) throws SQLException {
		String sql = "UPDATE Cliente SET nome='" + nome + "', email='" + email +"' WHERE cpf=" + cpf;
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
	}

	public static void excluir (long cpf) throws SQLException {
		String sql = "DELETE FROM Cliente WHERE cpf=" + cpf;
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
	}
	
	public static void main(String[] args) {
		try {
			conectar();
			Scanner entrada = new Scanner(System.in);
			int opcao = 0;
			long cpf;
			String nome, email;
			
			while (opcao != 6) {
				System.out.println("Sistema de Gerenciamento de Clientes");
				System.out.println("====================================");
				System.out.println("Digite [1] para Consultar todos os Clientes");
				System.out.println("Digite [2] para Consultar um Cliente Especifico");
				System.out.println("Digite [3] para Cadastrar um Novo Cliente");
				System.out.println("Digite [4] para Alterar um Cliente");
				System.out.println("Digite [5] para Excluir um Cliente");
				System.out.println("Digite [6] para Sair");
				System.out.println("====================================");
				opcao = entrada.nextInt();
				
				switch (opcao) {
					case 1:
						System.out.println("[1] Consultar Todos");
						consultarTodos();
						break;
					case 2:
						System.out.println("[2] Consultar um Cliente Especifico");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						consultar(cpf);
						break;
					case 3:
						System.out.println("[3] Cadastrar um Novo Cliente");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						entrada.nextLine(); // esvaziar o buffer do teclado
						System.out.println("Favor informar o Nome >>>");
						nome = entrada.nextLine();
						System.out.println("Favor informar o Email >>>");
						email = entrada.nextLine();
						//inserir(cpf, nome, email);
						//inserirPS(cpf, nome, email);
						inserirSP(cpf, nome, email);
						break;
					case 4:
						System.out.println("[4] Alterar um Cliente");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						entrada.nextLine(); // esvaziar o buffer do teclado
						System.out.println("Favor informar o Nome >>>");
						nome = entrada.nextLine();
						System.out.println("Favor informar o Email >>>");
						email = entrada.nextLine();
						alterar(cpf, nome, email);
						break;
					case 5:
						System.out.println("[5] Excluir um Cliente");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						excluir(cpf);
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
