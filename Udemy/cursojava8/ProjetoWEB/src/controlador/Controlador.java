package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abctreinamentos.Cliente;
import com.abctreinamentos.Curso;
import com.abctreinamentos.Pagamento;
import com.abctreinamentos.PagamentoId;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAApp");
	EntityManager em = emf.createEntityManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	this.doPost(req, resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int idformulario;
		int tipoformulario;
		String cpfmascara, nome, email, nomecurso, url, datainscricao;
		long cpf, cdcurso, valorcurso;
		
		idformulario = Integer.parseInt(request.getParameter("idformulario"));
		tipoformulario = Integer.parseInt(request.getParameter("tipoformulario"));
		EntityTransaction tx = em.getTransaction();
		HttpSession session = request.getSession();
		
		if (idformulario == 1) {
			switch (tipoformulario) {
			case 11:
				TypedQuery<Cliente> query = em.createQuery(""
						+ "SELECT c FROM Cliente c", Cliente.class);
				List<Cliente> clientes = query.getResultList();
				session.setAttribute("mensagem", "Total de Cliente(s): " + clientes.size());
				session.setAttribute("clientes", clientes);
				response.sendRedirect("clientes/consultarTodos.jsp");
				break;
			case 12:
				cpfmascara = request.getParameter("cpf");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);
				
				Cliente cliente = em.find(Cliente.class, cpf);				
				if (cliente != null) {
					session.setAttribute("mensagem", "Cliente " + cpf + " encontrado!");
					session.setAttribute("cliente", cliente);
				} else {
					session.setAttribute("mensagem", "Cliente " + cpf + " não encontrado!");
					session.setAttribute("cliente", null);
				}
				response.sendRedirect("clientes/resultado.jsp");			
				break;
			case 13:
				cpfmascara = request.getParameter("cpf");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);
				nome = request.getParameter("nome");
				email = request.getParameter("email");
				
				cliente = new Cliente(cpf, nome, email);
				tx.begin();
				em.persist(cliente);
				tx.commit();
				session.setAttribute("mensagem", "Cliente " + cpf + " cadastrado!");
				session.setAttribute("cliente", cliente);
				response.sendRedirect("clientes/resultado.jsp");				
				break;
			case 14:
				cpfmascara = request.getParameter("cpf");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);
				nome = request.getParameter("nome");
				email = request.getParameter("email");
				
				cliente = em.find(Cliente.class, cpf);				
				if (cliente != null) {
					cliente = new Cliente(cpf, nome, email);
					tx.begin();
					em.merge(cliente);
					tx.commit();
					session.setAttribute("mensagem", "Cliente " + cpf + " alterado!");
					session.setAttribute("cliente", cliente);
				} else {
					session.setAttribute("mensagem", "Cliente " + cpf + " não encontrado! Alteração cancelada!");
					session.setAttribute("cliente", null);
				}
				response.sendRedirect("clientes/resultado.jsp");
				break;
			case 15:
				cpfmascara = request.getParameter("cpf");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);
				cliente = em.find(Cliente.class, cpf);				
				if (cliente != null) {
					tx.begin();
					em.remove(cliente);
					tx.commit();
					session.setAttribute("mensagem", "Cliente " + cpf + " excluído!");
					session.setAttribute("cliente", cliente);
				} else {
					session.setAttribute("mensagem", "Cliente " + cpf + " não encontrado! Exclusão cancelada!");
				}
				session.setAttribute("cliente", null);
				response.sendRedirect("clientes/resultado.jsp");				
				break;
			}
			
			
		} else if (idformulario == 2) {
			switch (tipoformulario) {
			case 21:
				TypedQuery<Curso> query = em.createQuery(""
						+ "SELECT c FROM Curso c", Curso.class);
				List<Curso> cursos = query.getResultList();
				session.setAttribute("mensagem", "Total de Curso(s): " + cursos.size());
				session.setAttribute("cursos", cursos);
				response.sendRedirect("cursos/consultarTodos.jsp");
				break;
			case 22:
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				
				Curso curso = em.find(Curso.class, cdcurso);
				if (curso != null) {
					session.setAttribute("mensagem", "Curso " + cdcurso + " encontrado!");
					session.setAttribute("curso", curso);
				} else {
					session.setAttribute("mensagem", "Curso " + cdcurso + " não encontrado!");
					session.setAttribute("curso", null);
				}
				response.sendRedirect("cursos/resultado.jsp");	
				break;
			case 23:
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				nomecurso = request.getParameter("nome");
				valorcurso = Long.parseLong(request.getParameter("valor"));
				url = request.getParameter("site");
				
				curso = new Curso(cdcurso, nomecurso, valorcurso, url);
				tx.begin();
				em.persist(curso);
				tx.commit();
				session.setAttribute("mensagem", "Curso " + cdcurso + " cadastrado!");
				session.setAttribute("curso", curso);
				response.sendRedirect("cursos/resultado.jsp");	
				break;
			case 24:
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				nomecurso = request.getParameter("nome");
				valorcurso = Long.parseLong(request.getParameter("valor"));
				url = request.getParameter("site");
				
				curso = em.find(Curso.class, cdcurso);
				if (curso != null) {
					curso = new Curso(cdcurso, nomecurso, valorcurso, url);
					tx.begin();
					em.merge(curso);
					tx.commit();
					session.setAttribute("mensagem", "Curso " + cdcurso + " alterado!");
					session.setAttribute("curso", curso);
				} else {
					session.setAttribute("mensagem", "Curso " + cdcurso + " não encontrado! Alteração cancelada!");
					session.setAttribute("curso", null);
				}
				response.sendRedirect("cursos/resultado.jsp");
				break;
			case 25:
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				
				curso = em.find(Curso.class, cdcurso);
				if (curso != null) {
					tx.begin();
					em.remove(curso);
					tx.commit();
					session.setAttribute("mensagem", "Curso " + cdcurso + " excluído!");
					session.setAttribute("curso", curso);
				} else {
					session.setAttribute("mensagem", "Curso " + cdcurso + " não encontrado! Exclusão cancelada!");
				}
				session.setAttribute("curso", null);
				response.sendRedirect("cursos/resultado.jsp");
				break;
			}
		} else if (idformulario == 3) {
			switch (tipoformulario) {
			case 31:
				TypedQuery<Pagamento> query = em.createQuery(""
						+ "SELECT p FROM Pagamento p", Pagamento.class);
				List<Pagamento> pagamentos = query.getResultList();
				session.setAttribute("mensagem", "Total de Pagamento(s): " + pagamentos.size());
				session.setAttribute("pagamentos", pagamentos);
				response.sendRedirect("pagamentos/consultarTodos.jsp");
				break;
			case 32:
				cpfmascara = request.getParameter("cpf");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);				
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				
				PagamentoId pgtoid = new PagamentoId(cpf, cdcurso);
				Pagamento pagamento = em.find(Pagamento.class, pgtoid);
				System.out.println(pagamento);
				if (pagamento != null) {
					session.setAttribute("mensagem", "Pagamento " + cpf + " - " + cdcurso + " encontrado!");
					session.setAttribute("pagamento", pagamento);
				} else {
					session.setAttribute("mensagem", "Pagamento "  + cpf + " - " + cdcurso + " não encontrado!");
					session.setAttribute("pagamento", null);
				}
				response.sendRedirect("pagamentos/resultado.jsp");
				break;
			case 33:
				cpfmascara = request.getParameter("cpf");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);				
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				datainscricao = request.getParameter("datainscricao");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate date = LocalDate.parse(datainscricao, formatter);
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");				
				
				pgtoid = new PagamentoId(cpf, cdcurso);
				pagamento = new Pagamento(pgtoid, fmt.format(date));
				tx.begin();
				em.persist(pagamento);
				tx.commit();
				session.setAttribute("mensagem", "Pagamento " + cpf + " - " + cdcurso + " cadastrado!");
				session.setAttribute("pagamento", pagamento);
				response.sendRedirect("pagamentos/resultado.jsp");
				break;
			case 34:
				cpfmascara = request.getParameter("cpf");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);				
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				datainscricao = request.getParameter("datainscricao");
				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate date2 = LocalDate.parse(datainscricao, formatter2);
				DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");				
				
				pgtoid = new PagamentoId(cpf, cdcurso);
				pagamento = new Pagamento(pgtoid, fmt2.format(date2));
				pagamento = em.find(Pagamento.class, pgtoid);
				
				if (pagamento != null) {
					pagamento = new Pagamento(pgtoid, fmt2.format(date2));
					tx.begin();
					em.merge(pagamento);
					tx.commit();
					session.setAttribute("mensagem", "Pagamento " + cpf + " - " + cdcurso + " alterado!");
					session.setAttribute("pagamento", pagamento);
				} else {
					session.setAttribute("mensagem", "Pagamento " + cpf + " - " + cdcurso + " não encontrado! Alteração cancelada!");
					session.setAttribute("pagamento", null);
				}
				response.sendRedirect("pagamentos/resultado.jsp");
				break;
			case 35:
				cpfmascara = request.getParameter("cpf");
				cpfmascara = cpfmascara.replaceAll("[.-]", "");
				cpf = Long.parseLong(cpfmascara);				
				cdcurso = Long.parseLong(request.getParameter("cdcurso"));
				
				pgtoid = new PagamentoId(cpf, cdcurso);
				pagamento = em.find(Pagamento.class, pgtoid);
				if (pagamento != null) {
					tx.begin();
					em.remove(pagamento);
					tx.commit();
					session.setAttribute("mensagem", "Pagamento " + cpf + " - " + cdcurso + " excluído!");
					session.setAttribute("pagamento", pagamento);
				} else {
					session.setAttribute("mensagem", "Pagamento " + cpf + " - " + cdcurso + " não encontrado! Exclusão cancelada!");
				}
				session.setAttribute("pagamento", null);
				response.sendRedirect("pagamentos/resultado.jsp");
				break;
			}
		}
	}

}
