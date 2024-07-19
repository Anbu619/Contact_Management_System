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

@WebServlet("/updateAccount")
public class UpdateAccount extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		user.setUserName(req.getParameter("userName"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		
		boolean res = DaoSingleton.getUserDao().updateUser(user);
		
		if(res) {
			resp.sendRedirect("manageAccount.jsp");
		}
		else {
			req.setAttribute("error","Update failure");
			req.getRequestDispatcher("updateAccount.jsp").forward(req, resp);
		}
		
	}
}
