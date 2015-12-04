package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.marakana.contacts.repositories.*;
import com.marakana.contacts.entities.*;
import java.util.*;

@WebServlet("/contacts")
public class ContactListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ContactRepository contactRepository = new ContactRepository();
			List<Contact> lstContacts = contactRepository.findAll();
			request.setAttribute("contacts", lstContacts);

			RequestDispatcher view = request.getRequestDispatcher("jsp/contacts.jsp");
			view.forward(request, response);
			
		} catch (Exception e) {
			
			throw new ServletException(e);
			
		}

	}

}
