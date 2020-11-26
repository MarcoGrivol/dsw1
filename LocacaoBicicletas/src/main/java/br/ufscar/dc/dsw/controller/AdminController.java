package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.util.Error;

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;
	
	@Override
	public void init()
	{
		dao = new UsuarioDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		Error erros = new Error();

		if (usuario == null) {
			response.sendRedirect(request.getContextPath());
		} else if (!usuario.getPapel().equals("ADMIN")) {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas Papel [ADMIN] tem acesso a essa página");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
		}

		/*
		 cadastro -> insercao
		 edicao -> atualizacao
		 remocao
		 lista (default)
		 */
		
		String action = request.getPathInfo();
		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
			case "/CRUD_cliente/remocao":
				remove(request, response);
				break;
			case "/CRUD_cliente/cadastro":
				apresentaFormCadastro(request, response);
				break;
			case "/CRUD_cliente/insercao":
				insere(request, response);
				break;
			case "/CRUD_cliente/edicao":
				apresentaFormEdicao(request, response);
				break;
			case "/CRUD_cliente/atualizacao":
				atualize(request, response);
				break;
			default:
				lista(request, response);
				break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cpf = request.getParameter("cpf");

		Usuario usuario = new Usuario(cpf);
		dao.delete(usuario);
		response.sendRedirect("lista");
	}

	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/CRUD_cliente/formulario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cpf = request.getParameter("cpf");
		String dataNascimento = request.getParameter("dataNascimento");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String sexo = request.getParameter("sexo");
		String telefone = request.getParameter("telefone");
		String papel = "USER";
		Usuario usuario = new Usuario(cpf, dataNascimento, email, login, nome, senha, sexo, telefone, papel);

		dao.insert(usuario);
		response.sendRedirect("lista");
	}
	
	private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		Usuario usuario = dao.getbyCpf(cpf);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/CRUD_cliente/formulario.jsp");
		request.setAttribute("usuario", usuario);
		dispatcher.forward(request, response);
	}
	
	private void atualize(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cpf = request.getParameter("cpf");
		String dataNascimento = request.getParameter("dataNascimento");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String sexo = request.getParameter("sexo");
		String telefone = request.getParameter("telefone");
		String papel = "USER";
		Usuario usuario = new Usuario(cpf, dataNascimento, email, login, nome, senha, sexo, telefone, papel);
		
		dao.update(usuario);
		response.sendRedirect("lista");
	}
	
	private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> listaUsuarios = dao.getAll();
		request.setAttribute("listaUsuarios", listaUsuarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/lista.jsp");
		dispatcher.forward(request, response);
	}
	
}
