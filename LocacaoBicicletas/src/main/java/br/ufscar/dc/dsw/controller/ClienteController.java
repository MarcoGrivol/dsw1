/*
package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/cliente/*")
public class ClienteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cliente cliente = (Cliente) request.getSession().getAttribute("clienteLogado");
		
		if (cliente == null) {
			response.sendRedirect(request.getContextPath());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/cliente/index.jsp");
			dispatcher.forward(request, response);
		}
	}
}
*/