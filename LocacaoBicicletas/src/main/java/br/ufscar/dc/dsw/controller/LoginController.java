package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.util.Error;

@WebServlet(name = "Login", urlPatterns = "/login.jsp")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Error erros = new Error();
		if (request.getParameter("bOK") != null) {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			if (login == null || login.isEmpty()) {
				erros.add("erroEmptyLogin");
			}
			if (senha == null || senha.isEmpty()) {
				erros.add("erroEmptyPassword");
			}
			if (!erros.isExisteErros()) {
				UsuarioDAO dao = new UsuarioDAO();
				Usuario usuario = dao.getbyLogin(login);
				if (usuario != null) {
					if (usuario.getSenha().equals(senha)) {
						request.getSession().setAttribute("usuarioLogado", usuario);
						if (usuario.getPapel().equals("ADMIN")) {
							response.sendRedirect("admin/");
						} else {
							response.sendRedirect("usuario/");
						}
						return;
					} else {
						erros.add("erroLogin");
					}	
				} else {
					LocadoraDAO daolocadora = new LocadoraDAO();
					Locadora locadora = daolocadora.getbyEmail(login);
					if (locadora != null && locadora.getSenha().equals(senha)) {
						request.getSession().setAttribute("usuarioLogado", locadora);
						response.sendRedirect("locadora/");
						return;
						}
					 else {
						erros.add("erroLogin");
					}
				}
			}
		
		request.getSession().invalidate();
		request.setAttribute("mensagens", erros);
		String URL = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);
	}
	 }
}