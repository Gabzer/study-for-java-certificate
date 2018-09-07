package com.abctreinamentos;

import java.util.List;
import java.util.Scanner;

public class LojaVirtual {

	static Scanner entrada = new Scanner(System.in);
	static int opcao = -1;

	public static void areaCliente() {
		long cpf;
		String nome, email;
		ClienteDAO daoCli = new ClienteDAO();

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
				List<Cliente> clientes = daoCli.findAll();
				clientes.forEach(System.out::println);
				break;
			case 2:
				System.out.println("[2] Consultar um Cliente Especifico");
				System.out.println("Favor informar o CPF >>>");
				cpf = entrada.nextLong();
				System.out.println(daoCli.find(cpf));
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
				Cliente cliente = new Cliente(cpf, nome, email);
				daoCli.persist(cliente);
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
				cliente = new Cliente(cpf, nome, email);
				daoCli.merge(cliente);
				break;
			case 5:
				System.out.println("[5] Excluir um Cliente");
				System.out.println("Favor informar o CPF >>>");
				cpf = entrada.nextLong();
				cliente = daoCli.find(cpf);
				daoCli.delete(cliente);
				break;
			case 6:
				System.out.println("Saindo da Área do Cliente...");
				break;
			}
		}
	}

	public static void areaCurso() {
		long cdcurso, valor;
		String nome, url;
		CursoDAO daoCur = new CursoDAO();
		
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
				List<Curso> cursos = daoCur.findAll();
				cursos.forEach(System.out::println);
				break;
			case 2:
				System.out.println("[2] Consultar um Curso Especifico");
				System.out.println("Favor informar o Código do Curso >>>");
				cdcurso = entrada.nextLong();
				System.out.println(daoCur.find(cdcurso));
				break;
			case 3:
				System.out.println("[3] Cadastrar um Novo Curso");
				System.out.println("Favor informar o Código do Curso >>>");
				cdcurso = entrada.nextLong();
				entrada.nextLine(); // esvaziar o buffer do teclado
				System.out.println("Favor informar o Nome >>>");
				nome = entrada.nextLine();
				System.out.println("Favor informar o Valor >>>");
				valor = entrada.nextLong();
				entrada.nextLine(); // esvaziar o buffer do teclado
				System.out.println("Favor informar a Url >>>");
				url = entrada.nextLine();
				Curso Curso = new Curso(cdcurso, nome, valor, url);
				daoCur.persist(Curso);
				break;
			case 4:
				System.out.println("[4] Alterar um Curso");
				System.out.println("Favor informar o Código do Curso >>>");
				cdcurso = entrada.nextLong();
				entrada.nextLine(); // esvaziar o buffer do teclado
				System.out.println("Favor informar o Nome >>>");
				nome = entrada.nextLine();
				System.out.println("Favor informar o Valor >>>");
				valor = entrada.nextLong();
				entrada.nextLine(); // esvaziar o buffer do teclado
				System.out.println("Favor informar a Url >>>");
				url = entrada.nextLine();
				Curso = new Curso(cdcurso, nome, valor, url);
				daoCur.merge(Curso);
				break;
			case 5:
				System.out.println("[5] Excluir um Curso");
				System.out.println("Favor informar o Código do Curso >>>");
				cdcurso = entrada.nextLong();
				Curso = daoCur.find(cdcurso);
				daoCur.delete(Curso);
				break;
			case 6:
				System.out.println("Saindo da Área do Curso...");
				break;
			}
		}
	}

	public static void areaPagamento() {
		long cpf, cdcurso;
		String datainscricao;
		PagamentoDAO daoPag = new PagamentoDAO();
		
		while (opcao != 6) {
			System.out.println("Sistema de Gerenciamento de Pagamentos");
			System.out.println("====================================");
			System.out.println("Digite [1] para Consultar todos os Pagamentos");
			System.out.println("Digite [2] para Consultar um Pagamento Especifico");
			System.out.println("Digite [3] para Cadastrar um Novo Pagamento");
			System.out.println("Digite [4] para Alterar um Pagamento");
			System.out.println("Digite [5] para Excluir um Pagamento");
			System.out.println("Digite [6] para Sair");
			System.out.println("====================================");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("[1] Consultar Todos");
				List<Pagamento> pagamentos = daoPag.findAll();
				pagamentos.forEach(System.out::println);
				break;
			case 2:
				System.out.println("[2] Consultar um Pagamento Especifico");
				System.out.println("Favor informar o CPF >>>");
				cpf = entrada.nextLong();
				entrada.nextLine(); // esvaziar o buffer do teclado
				System.out.println("Favor informar o Código do Pagamento >>>");
				cdcurso = entrada.nextLong();
				PagamentoId pgtoid = new PagamentoId(cpf, cdcurso);
				System.out.println(daoPag.find(pgtoid));
				break;
			case 3:
				System.out.println("[3] Cadastrar um Novo Pagamento");
				System.out.println("Favor informar o CPF >>>");
				cpf = entrada.nextLong();
				entrada.nextLine(); // esvaziar o buffer do teclado
				System.out.println("Favor informar o Código do Pagamento >>>");
				cdcurso = entrada.nextLong();
				entrada.nextLine(); // esvaziar o buffer do teclado
				System.out.println("Favor informar a Data de Inscrição >>>");
				datainscricao = entrada.nextLine();
				pgtoid = new PagamentoId(cpf, cdcurso);
				Pagamento pagamento = new Pagamento(pgtoid, datainscricao);
				daoPag.persist(pagamento);
				break;
			case 4:
				System.out.println("[4] Alterar um Pagamento");
				System.out.println("Favor informar o CPF >>>");
				cpf = entrada.nextLong();
				entrada.nextLine(); // esvaziar o buffer do teclado
				System.out.println("Favor informar o Código do Pagamento >>>");
				cdcurso = entrada.nextLong();
				entrada.nextLine(); // esvaziar o buffer do teclado
				System.out.println("Favor informar a Data de Inscrição >>>");
				datainscricao = entrada.nextLine();
				pgtoid = new PagamentoId(cpf, cdcurso);
				pagamento = new Pagamento(pgtoid, datainscricao);
				daoPag.merge(pagamento);
				break;
			case 5:
				System.out.println("[5] Excluir um Pagamento");
				System.out.println("Favor informar o CPF >>>");
				cpf = entrada.nextLong();
				entrada.nextLine(); // esvaziar o buffer do teclado
				System.out.println("Favor informar o Código do Pagamento >>>");
				cdcurso = entrada.nextLong();
				pgtoid = new PagamentoId(cpf, cdcurso);
				pagamento = daoPag.find(pgtoid);
				daoPag.delete(pagamento);
				break;
			case 6:
				System.out.println("Saindo da Área de Pagamento...");
				break;
			}
		}
	}

	public static void main(String[] args) {

		while (opcao != 0) {
			System.out.println("Sistema de Gerenciamento da Loja");
			System.out.println("====================================");
			System.out.println("Digite [1] para ir à Clientes");
			System.out.println("Digite [2] para ir à Cursos");
			System.out.println("Digite [3] para ir à Pagamentos");
			System.out.println("Digite [0] para Sair");
			System.out.println("====================================");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				areaCliente();
				break;
			case 2:
				areaCurso();
				break;
			case 3:
				areaPagamento();
				break;
			case 0:
				System.out.println("Encerrando o Sistema...");
				break;
			}
		}
		entrada.close();
	}

}
