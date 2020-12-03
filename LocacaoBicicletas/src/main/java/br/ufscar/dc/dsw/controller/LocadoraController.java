package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.util.Error;

@WebServlet(urlPatterns = "/locadora/*")
public class LocadoraController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Locadora locadora = (Locadora) request.getSession().getAttribute("usuarioLogado");
		Error erros = new Error();
		
		if (locadora == null) {
			response.sendRedirect(request.getContextPath());
		} else if (locadora.getPapel().equals("USER")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/locadora/index.jsp");
			dispatcher.forward(request, response);
		} else {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas Papel [USER] tem acesso a essa página");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
		}
	}
}