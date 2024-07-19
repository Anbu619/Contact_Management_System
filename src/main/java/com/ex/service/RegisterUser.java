package com.ex.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.config.DaoSingleton;
import com.ex.entity.User;

@WebServlet("/register")
public class RegisterUser extends HttpServlet{

	
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = new User();
		
		user.setUserName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		boolean result = DaoSingleton.getUserDao().addUser(user);
		
		if(result == true) {
			resp.sendRedirect("login.jsp");
		}
		else {
			
		}
		
	}
}
