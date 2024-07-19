package com.ex.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.config.DaoSingleton;
import com.ex.entity.Contact;

@WebServlet("/findContact")
public class LoadContact extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int contactId = Integer.parseInt(req.getParameter("contactId"));
		Contact contact = DaoSingleton.getContactDao().findContactById(contactId);
		if(contact != null ) {
			req.setAttribute("contact", contact);
			req.getRequestDispatcher("updateContact.jsp").forward(req, resp);
		}
		else {
			System.err.println("Contact id not found");
		}
	}
}
