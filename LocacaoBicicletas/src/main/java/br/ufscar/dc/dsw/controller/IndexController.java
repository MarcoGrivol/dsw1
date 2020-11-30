package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.dao.LocadoraDAO;

// index.jsp foi movido para WEB-INF para garantir que nao sera chamado ao carregar a pagina inicial.
// Este servlet sera chamado em seu lugar e carregara index com as informacoes a serem exibidas
@WebServlet(urlPatterns = "/index.jsp")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private LocadoraDAO daoLocadora;
	
	@Override
	public void init()
	{
		daoLocadora = new LocadoraDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Locadora> listaLocadoras = daoLocadora.getAll();
		request.setAttribute("listaLocadoras", listaLocadoras);
		
		// !importante manter esse request dispatcher para garantir que a pagina inicial sera carregada!
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
