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

@WebServlet("/addContact")
public class AddContact extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		String contactName = req.getParameter("contactName");
		long contactNumber = Long.parseLong(req.getParameter("contactNumber"));
		
		Contact contact = new Contact();
		
		contact.setContactName(contactName);
		contact.setContactNumber(contactNumber);
		contact.setUser(user);
		
		user.getContacts().add(contact);
		
		boolean res = DaoSingleton.getContactDao().addConatct(contact);
		
		if(res) {
			resp.sendRedirect("manageContact");
		}
		else {
			System.out.println("error");
		}
	}
}
