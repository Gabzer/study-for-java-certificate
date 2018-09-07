package com.abctreinamentos;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CursoApp {

	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		long cdcurso, valor;
		String nome, url;
		CursoDAO dao = new CursoDAO();

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
				List<Curso> cursos = dao.findAll();
				cursos.forEach(System.out::println);
				break;
			case 2:
				System.out.println("[2] Consultar um Curso Especifico");
				System.out.println("Favor informar o C�digo do Curso >>>");
				cdcurso = entrada.nextLong();
				System.out.println(dao.find(cdcurso));
				break;
			case 3:
				System.out.println("[3] Cadastrar um Novo Curso");
				System.out.println("Favor informar o C�digo do Curso >>>");
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
				dao.persist(Curso);
				break;
			case 4:
				System.out.println("[4] Alterar um Curso");
				System.out.println("Favor informar o C�digo do Curso >>>");
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
				dao.merge(Curso);
				break;
			case 5:
				System.out.println("[5] Excluir um Curso");
				System.out.println("Favor informar o C�digo do Curso >>>");
				cdcurso = entrada.nextLong();
				Curso = dao.find(cdcurso);
				dao.delete(Curso);
				break;
			case 6:
				System.out.println("Encerrando o Sistema...");
				break;
			default:
				break;
			}
		}
		entrada.close();

	}
}
