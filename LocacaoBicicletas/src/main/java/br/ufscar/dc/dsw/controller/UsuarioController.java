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
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.util.Error;
import java.util.ArrayList;

import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.dao.LocacaoDAO;

@WebServlet(urlPatterns = "/usuario/*")
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LocacaoDAO daoLocacao;
	private LocadoraDAO daoLocadora;

	@Override
	public void init() {
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
		} else if (!usuario.getPapel().equals("USER")) {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas Papel [USER] tem acesso a essa página");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
		}
		String action = request.getPathInfo();
		if (action == null) {
			action = "";
		}

		switch (action) {
		case "/FormularioAluguel":
			MostrarFormsAluguel(request, response, usuario);
			break;
		case "/cadastroAluguel":
			Cadastro(request, response);
			break;
		default:
			lista(request, response, usuario);
			break;
		}

	}

	private void MostrarFormsAluguel(HttpServletRequest request, HttpServletResponse response, Usuario usuario)
			throws ServletException, IOException {
		List<Locadora> lista_locadoras = daoLocadora.getAll();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/formulario.jsp");
		request.setAttribute("ListaLocadoras", lista_locadoras);
		request.setAttribute("usuario", usuario);
		dispatcher.forward(request, response);
	}

	private void Cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Error erros = new Error();
		String cnpj = request.getParameter("locadora");
		String cpf = request.getParameter("usuario");
		String data = request.getParameter("Data");
		String hora = request.getParameter("hora");
		if (daoLocacao.getbydata_cnpj(data, hora, cnpj) == null){
			if (daoLocacao.getbydata_cpf(data, hora, cpf) == null){
				Locacao locacao = new Locacao(cnpj, cpf, data, hora);

				daoLocacao.insert(locacao);
				response.sendRedirect("index");
			}else {
				erros.add("Locação não autorizada!");
				erros.add("Você ja possuiu uma locação nesse horario");
				request.setAttribute("mensagens", erros);
				lista(request, response, (Usuario) request.getSession().getAttribute("usuarioLogado"));
			}
		}else {
				erros.add("Locação não autorizada!");
				erros.add("Este horario ja está reservado");
				request.setAttribute("mensagens", erros);
				lista(request, response, (Usuario) request.getSession().getAttribute("usuarioLogado"));
			}
	}

	private void lista(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		List<Locacao> listaLocacoes = daoLocacao.getAll();
		request.setAttribute("listaLocacoes", listaLocacoes);
		List<Locacao> listaLocacoes_cpf = daoLocacao.getbyCpf(usuario.getCpf());
		request.setAttribute("listaLocacoes_cpf", listaLocacoes_cpf);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/index.jsp");
		dispatcher.forward(request, response);
	}
}