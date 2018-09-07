package com.abctreinamentos;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PagamentoApp {

	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		long cpf, cdcurso;
		String datainscricao;
		PagamentoDAO dao = new PagamentoDAO();

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
				List<Pagamento> pagamentos = dao.findAll();
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
				System.out.println(dao.find(pgtoid));
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
				dao.persist(pagamento);
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
				dao.merge(pagamento);
				break;
			case 5:
				System.out.println("[5] Excluir um Pagamento");
				System.out.println("Favor informar o CPF >>>");
				cpf = entrada.nextLong();
				entrada.nextLine(); // esvaziar o buffer do teclado
				System.out.println("Favor informar o Código do Pagamento >>>");
				cdcurso = entrada.nextLong();
				pgtoid = new PagamentoId(cpf, cdcurso);
				pagamento = dao.find(pgtoid);
				dao.delete(pagamento);
				break;
			case 6:
				System.out.println("Encerrando o Sistema...");
				break;
			}
		}
		entrada.close();

	}
}
