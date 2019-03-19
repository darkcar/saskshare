package ca.saskshare.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.saskshare.domain.User;
import ca.saskshare.service.impl.BussinessServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BussinessServiceImpl bussinessServiceImpl = new BussinessServiceImpl();
		User user = bussinessServiceImpl.login(username, password);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		request.setAttribute("message", "Username or password wrong!!!");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
