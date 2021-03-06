package unidade3.com.abctreinamentos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ClienteDAO {
	
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
	
	public static void inserir (Cliente cliente) throws SQLException {
		String sql = "INSERT INTO Cliente VALUES (" + cliente.getCpf() + ", '" + cliente.getNome() + "', '" + cliente.getEmail() +"')";
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
	
	public static Cliente consultar (long cpf) throws SQLException {
		String sql = "SELECT * FROM Cliente WHERE cpf=" + cpf + "";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Cliente cliente = null;
		while (rs.next()) {
			cliente = new Cliente(
					rs.getLong(1),
					rs.getString(2),
					rs.getString(3)
				);
		}
		return cliente;
	}
	
	public static List<Cliente> consultarTodos () throws SQLException {
		String sql = "SELECT * FROM Cliente";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<Cliente> clientes = new LinkedList<>();
		while (rs.next()) {
			Cliente cliente = new Cliente(
					rs.getLong(1),
					rs.getString(2),
					rs.getString(3)
				);
			clientes.add(cliente);
		}
		return clientes;
	}
	
	public static void alterar (Cliente cliente) throws SQLException {
		String sql = "UPDATE Cliente SET nome='" + cliente.getNome() + "', email='" + cliente.getEmail() +"' WHERE cpf=" + cliente.getCpf();
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
						List<Cliente> clientes = ClienteDAO.consultarTodos();
						clientes.forEach(System.out::println);
						System.out.println("N�mero de Clientes: " + clientes.size() + "\n");
						break;
					case 2:
						System.out.println("[2] Consultar um Cliente Especifico");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						Cliente cliente = ClienteDAO.consultar(cpf);
						System.out.println(cliente);
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
						Cliente cliente2 = new Cliente(cpf, nome, email);
						ClienteDAO.inserir(cliente2);
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
						Cliente cliente3 = new Cliente(cpf, nome, email);
						ClienteDAO.alterar(cliente3);
						break;
					case 5:
						System.out.println("[5] Excluir um Cliente");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						ClienteDAO.excluir(cpf);
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
