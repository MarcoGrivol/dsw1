package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.bean.BuscaPorCidadeBean;

// index.jsp foi movido para WEB-INF para garantir que nao sera chamado ao carregar a pagina inicial.
// Este servlet sera chamado em seu lugar e carregara index com as informacoes a serem exibidas
@WebServlet(urlPatterns = "/index.jsp")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// listaLocadoras sao as cidades exibidas pela tabela
        String cidade = request.getParameter("cidade");
		List<Locadora> listaLocadoras = new BuscaPorCidadeBean().getLocadoras(cidade);
		request.setAttribute("listaLocadoras",  listaLocadoras);		
		// listaLocadoraOpcoes sao as cidades exibidas no dropdown menu
//		List<Locadora> lostaLocadoraOpcoes = new BuscaPorCidadeBean().getLocadoras("");
		List<String> listaLocadoraOpcoes = new BuscaPorCidadeBean().getAllCidade();
		request.setAttribute("listaLocadorasOpcoes", listaLocadoraOpcoes);
		
		// !importante manter esse request dispatcher para garantir que a pagina inicial sera carregada!
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}