package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.dao.LocacaoDAO;
import java.util.List;

@WebServlet(urlPatterns = "/locadora/*")
public class LocadoraController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LocacaoDAO daoLocacao;

	@Override
	public void init() {
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

		Locadora locadora = (Locadora) request.getSession().getAttribute("usuarioLogado");
		if (locadora == null) {
			response.sendRedirect(request.getContextPath());
		}

		String action = request.getPathInfo();
		try {
			if (action != null)
			{
				lista(request, response);
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Locacao> listaLocacoes = daoLocacao.getAll();
		request.setAttribute("listaLocacoes", listaLocacoes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/locadora/index.jsp");
		dispatcher.forward(request, response);
	}
}