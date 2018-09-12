package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int idformulario;
		int tipoformulario;
		String cpfmascara, nome, email, nomecurso, url, datainscricao;
		long cpf, cdcurso, valorcurso;
		
		idformulario = Integer.parseInt(request.getParameter("idformulario"));
		tipoformulario = Integer.parseInt(request.getParameter("tipoformulario"));
		
		if (idformulario == 1) {
			switch (tipoformulario) {
			case 11:
				/*System.out.println("[1] Consultar Todos");
				TypedQuery<Cliente> query = em.createQuery(""
						+ "SELECT c FROM Cliente c", Cliente.class);
				List<Cliente> clientes = query.getResultList();
				clientes.forEach(System.out::println);*/
				break;
			case 12:
				cpfmascara = request.getParameter("cdcurso");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);
				out.println("<h2> Clientes => Consultar => " + cpf);
				
				//Cliente cliente = em.find(Cliente.class, cpf);
				break;
			case 13:
				cpfmascara = request.getParameter("cpf");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);
				nome = request.getParameter("nome");
				email = request.getParameter("email");
				out.println("<h2> Clientes => Cadastrar => " + cpf + " - " + nome + " - " + email);
				
				/*Cliente cliente = new Cliente(cpf, nome, email);
				tx.begin();
				em.persist(cliente);
				tx.commit();*/
				break;
			case 14:
				cpfmascara = request.getParameter("cpf");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);
				nome = request.getParameter("nome");
				email = request.getParameter("email");
				out.println("<h2> Clientes => Alterar => " + cpf + " - " + nome + " - " + email);
				
				/*Cliente cliente = new Cliente(cpf, nome, email);
				tx.begin();
				em.merge(cliente);
				tx.commit();*/
				break;
			case 15:
				cpfmascara = request.getParameter("cpf");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);
				out.println("<h2> Clientes => Excluir => " + cpf);
				
				/*Cliente cliente = em.find(Cliente.class, cpf);
				tx.begin();
				em.remove(cliente);
				tx.commit();*/
				break;
			}
			
			
		} else if (idformulario == 2) {
			switch (tipoformulario) {
			case 21:
				/*
				TypedQuery<Curso> query = em.createQuery(""
						+ "SELECT c FROM Curso c", Curso.class);
				List<Curso> cursos = query.getResultList();
				cursos.forEach(System.out::println);*/
				break;
			case 22:
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				out.println("<h2> Cursos => Consultar => " + cdcurso);
				
				//Curso curso = em.find(Curso.class, cdcurso);
				break;
			case 23:
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				nomecurso = request.getParameter("nome");
				valorcurso = Long.parseLong(request.getParameter("valor"));
				url = request.getParameter("site");
				out.println("<h2> Cursos => Cadastrar => " + cdcurso + " - " + nomecurso + " - " + valorcurso + " - " + url);
				
				/*Curso curso = new Curso(cdcurso, nome, valor, url);
				tx.begin();
				em.persist(curso);
				tx.commit();*/
				break;
			case 24:
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				nomecurso = request.getParameter("nome");
				valorcurso = Long.parseLong(request.getParameter("valor"));
				url = request.getParameter("site");
				out.println("<h2> Cursos => Alterar => " + cdcurso + " - " + nomecurso + " - " + valorcurso + " - " + url);
				
				/*Curso curso = new Curso(cdcurso, nome, valor, url);
				tx.begin();
				em.merge(curso);
				tx.commit();*/
				break;
			case 25:
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				out.println("<h2> Cursos => Excluir => " + cdcurso);
				
				/*Curso curso = em.find(Curso.class, cdcurso);
				tx.begin();
				em.remove(curso);
				tx.commit();*/
				break;
			}
		} else if (idformulario == 3) {
			switch (tipoformulario) {
			case 31:
				/*
				TypedQuery<Pagamento> query = em.createQuery(""
						+ "SELECT p FROM Pagamento p", Pagamento.class);
				List<Pagamento> pagamentos = query.getResultList();
				pagamentos.forEach(System.out::println);*/
				break;
			case 32:
				cpfmascara = request.getParameter("cdcurso");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);				
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				out.println("<h2> Pagamentos => Consultar => " + cpf + " - " + cdcurso);
				
				//Pagamento pagamento = em.find(Pagamento.class, cpf);
				break;
			case 33:
				cpfmascara = request.getParameter("cdcurso");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);				
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				datainscricao = request.getParameter("datainscricao");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
				LocalDate date = LocalDate.parse(datainscricao, formatter);
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/mm/yyyy");				
				out.println("<h2> Pagamentos => Cadastrar => " + cpf + " - " + cdcurso + " - " + fmt.format(date));
				
				/*Pagamento pagamento = new Pagamento(cpf, nome, email);
				tx.begin();
				em.persist(pagamento);
				tx.commit();*/
				break;
			case 34:
				cpfmascara = request.getParameter("cdcurso");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);				
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				datainscricao = request.getParameter("datainscricao");
				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-mm-dd");
				LocalDate date2 = LocalDate.parse(datainscricao, formatter2);
				DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/mm/yyyy");				
				out.println("<h2> Pagamentos => Alterar => " + cpf + " - " + cdcurso + " - " + fmt2.format(date2));
				
				/*Pagamento pagamento = new Pagamento(cpf, nome, email);
				tx.begin();
				em.merge(pagamento);
				tx.commit();*/
				break;
			case 35:
				cpfmascara = request.getParameter("cdcurso");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);				
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				out.println("<h2> Pagamentos => Excluir => " + cpf + " - " + cdcurso);
				
				/*Pagamento pagamento = em.find(Pagamento.class, cpf);
				tx.begin();
				em.remove(pagamento);
				tx.commit();*/
				break;
			}
		}
	}

}
