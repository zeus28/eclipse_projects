package com.marakana.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.marakana.contacts.entities.*;
import com.marakana.contacts.repositories.*;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("add") != null) {
			request.getRequestDispatcher("jsp/addContact.jsp").forward(request, response);

		} else {
			long id = Long.parseLong(request.getParameter("id"));

			try {

				Contact contact = new ContactRepository().find(id);
				Address address = new AddressRepository().find(contact.getAddressId());
				
				request.setAttribute("address", address);
				request.setAttribute("contact", contact);
				
				request.getRequestDispatcher("jsp/contact").forward(request, response);
				
			} catch (SQLException e) {

				throw new ServletException(e);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("add") != null) {

			Address address = new Address();
			address.setCity(request.getParameter("city"));
			address.setState(request.getParameter("state"));
			address.setStreet(request.getParameter("street"));
			address.setZip(request.getParameter("zip"));

			Contact contact = new Contact();
			contact.setName(request.getParameter("name"));

			try {

				new AddressRepository().create(address);
				contact.setAddressId(address.getId());
				new ContactRepository().create(contact);
				response.sendRedirect("contacts");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
