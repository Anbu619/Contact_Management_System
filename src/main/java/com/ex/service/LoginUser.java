package com.ex.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.config.DaoSingleton;
import com.ex.entity.User;

@WebServlet("/login")
public class LoginUser extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = DaoSingleton.getUserDao().findUserByEmailAndPassword(email,password);
		
		if(user != null ) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			
			resp.sendRedirect("home.jsp");
		}
		else {
			req.setAttribute("error","Email or Password is incorrect!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
