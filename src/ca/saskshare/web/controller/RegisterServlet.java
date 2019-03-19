package ca.saskshare.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.saskshare.domain.User;
import ca.saskshare.service.UserExistException;
import ca.saskshare.service.impl.BussinessServiceImpl;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// form data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String realname = request.getParameter("realname");
		if (!password.equals(repassword)) {
			request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request, response);
			return;
		}
	
		User user = new User();
		user.setId(new Random().nextLong());
		user.setUsername(username);
		user.setRealname(realname);
		user.setPassword(password);
		user.setLastAccessDate(new Date());
		user.setRegisterDate(new Date());
		user.setActive(true);
		BussinessServiceImpl bussinessServiceImpl = new BussinessServiceImpl();
		try {
			bussinessServiceImpl.register(user);
			request.setAttribute("message", "Register success!!!");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
