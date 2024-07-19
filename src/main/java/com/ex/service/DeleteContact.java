package com.ex.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.config.DaoSingleton;
import com.ex.entity.Contact;
import com.ex.entity.User;

@WebServlet("/deleteContact")
public class DeleteContact extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		int contactId = Integer.parseInt(req.getParameter("contactId"));
		List<Contact> contacts = user.getContacts();
		
		for (Contact contact : contacts) {
			if(contact.getContactId() == contactId) {
				contacts.remove(contact);
				break;
			}
		}
		
		user.setContacts(contacts);
		boolean res = DaoSingleton.getUserDao().updateUser(user);
		
		boolean dres = DaoSingleton.getContactDao().deleteContact(contactId);
		
		user = DaoSingleton.getUserDao().findUserById(user.getUserId());
		session.setAttribute("user",user);
	
		if(dres) {
			req.setAttribute("contacts", user.getContacts());
			req.getRequestDispatcher("manageContact.jsp").forward(req, resp);
		}
	}
}
