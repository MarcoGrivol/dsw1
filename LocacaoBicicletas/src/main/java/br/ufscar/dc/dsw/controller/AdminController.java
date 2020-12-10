package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.dao.LocacaoDAO;

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.util.Error;

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsuarioDAO daoUsuario;
	private LocadoraDAO daoLocadora;
	private LocacaoDAO daoLocacao;
	
	@Override
	public void init()
	{
		daoUsuario = new UsuarioDAO();
		daoLocadora = new LocadoraDAO();
		daoLocacao = new LocacaoDAO();
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
			erros.add("erroUsuarioNaoAutorizado");
			erros.add("erroApenasAdmin");
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
			case "/CRUD_locadora/remocao":
				removeLocadora(request, response);
				break;
			case "/CRUD_locadora/cadastro":
				apresentaFormCadastroLocadora(request, response);
				break;
			case "/CRUD_locadora/insercao":
				insereLocadora(request, response);
				break;
			case "/CRUD_locadora/edicao":
				apresentaFormEdicaoLocadora(request, response);
				break;
			case "/CRUD_locadora/atualizacao":
				atualizeLocadora(request, response);
				break;
			default:
				lista(request, response, erros);
				break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	// Funções para clientes
	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cpf = request.getParameter("cpf");

		Usuario usuario = new Usuario(cpf);
		daoUsuario.delete(usuario);
		response.sendRedirect("index.jsp");
	}

	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/CRUD_cliente/formulario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Error erros = new Error();
		
		String cpf = request.getParameter("cpf");
		// verifica se ja existe usuario com o mesmo cpf
		if (daoUsuario.getbyCpf(cpf) != null)
		{
			erros.add("erroUsuarioJaExiste");
		} else
		{
			String dataNascimento = request.getParameter("dataNascimento");
			String email = request.getParameter("email");
			String login = request.getParameter("login");
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			String sexo = request.getParameter("sexo");
			String telefone = request.getParameter("telefone");
			String papel = "USER";
			Usuario usuario = new Usuario(cpf, dataNascimento, email, login, nome, senha, sexo, telefone, papel);
			daoUsuario.insert(usuario);
		}
		
		lista(request, response, erros);
	}
	
	private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		Usuario usuario = daoUsuario.getbyCpf(cpf);
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
		
		daoUsuario.update(usuario);
		response.sendRedirect("index.jsp");
	}
	
	//Funções para locadoras
	private void removeLocadora(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cnpj = request.getParameter("cnpj");

		Locadora locadora = new Locadora(cnpj);
		daoLocadora.delete(locadora);
		response.sendRedirect("index.jsp");
	}

	private void apresentaFormEdicaoLocadora(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cnpj = request.getParameter("cnpj");
		Locadora locadora = daoLocadora.getbyCnpj(cnpj);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/CRUD_locadora/formulario.jsp");
		request.setAttribute("locadora", locadora);
		dispatcher.forward(request, response);
	}

	private void atualizeLocadora(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cpf = request.getParameter("cnpj");
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cidade = request.getParameter("cidade");
		String papel = "USER";
		Locadora locadora = new Locadora(cpf, email,nome, senha, cidade, papel);
		
		daoLocadora.update(locadora);
		response.sendRedirect("index.jsp");
	}
	private void apresentaFormCadastroLocadora(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/CRUD_locadora/formulario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insereLocadora(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Error erros = new Error();

		String cnpj = request.getParameter("cnpj");
		if (daoLocadora.getbyCnpj(cnpj) != null)
		{
			erros.add("erroLocadoraJaExiste");
		} else
		{
			String email = request.getParameter("email");
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			String cidade = request.getParameter("cidade");
			String papel = "USER";
			Locadora locadora = new Locadora(cnpj, email, nome, senha,cidade, papel);
			daoLocadora.insert(locadora);
		}
		lista(request, response, erros);
	}


	//Funções para clientes e locadoras
	private void lista(HttpServletRequest request, HttpServletResponse response, Error erros) throws ServletException, IOException {
		request.setAttribute("mensagens", erros);
		List<Usuario> listaUsuarios = daoUsuario.getAll();
		List<Locadora> listaLocadoras = daoLocadora.getAll();
		List<String> listaLocacoesCpf = daoLocacao.getAllCPF();
		List<String> listaLocacoesCnpj = daoLocacao.getAllCNPJ();
		request.setAttribute("listaUsuarios", listaUsuarios);
		request.setAttribute("listaLocadoras", listaLocadoras);
		request.setAttribute("listaLocacoesCpf", listaLocacoesCpf);
		request.setAttribute("listaLocacoesCnpj", listaLocacoesCnpj);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/index.jsp");
		dispatcher.forward(request, response);
	}
	
}
