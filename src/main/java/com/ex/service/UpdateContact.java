package com.ex.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.config.DaoSingleton;
import com.ex.entity.Contact;
import com.ex.entity.User;

@WebServlet("/updateContact")
public class UpdateContact extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		int contactId= Integer.parseInt(req.getParameter("contactId"));
		String contactName = req.getParameter("contactName");
		Long contactNumber = Long.parseLong(req.getParameter("contactNumber"));
		
		Contact contact = new Contact();
		contact.setContactId(contactId);
		contact.setContactName(contactName);
		contact.setContactNumber(contactNumber);
		contact.setUser(user);
		
		boolean res = DaoSingleton.getContactDao().updateContact(contact);
		
		User user2 = DaoSingleton.getUserDao().findUserById(user.getUserId());
		
		if(res) {
			req.setAttribute("contacts", user2.getContacts());
			req.getRequestDispatcher("manageContact.jsp").forward(req, resp);
		}
	}

}
