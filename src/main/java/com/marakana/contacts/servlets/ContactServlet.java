package com.marakana.contacts.servlets;

import java.io.IOException;
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
	private AddressRepository addressRepository = new AddressRepository();
	private ContactRepository contactRepository = new ContactRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("add") != null) {
			request.getRequestDispatcher("jsp/addContact.jsp").forward(request, response);

		} else {
			long id = Long.parseLong(request.getParameter("id"));

			Contact contact = contactRepository.find(id);
			Address address = addressRepository.find(contact.getAddressId());
			request.setAttribute("address", address);
			request.setAttribute("contact", contact);
			if (request.getParameter("edit") != null) {
				request.getRequestDispatcher("jsp/editContact.jsp").forward(request, response);

			} else {

				request.getRequestDispatcher("jsp/viewContact.jsp").forward(request, response);
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

			addressRepository.save(address);
			contact.setAddressId(address.getId());
			contactRepository.save(contact);
			response.sendRedirect("contact?id=" + contact.getId());
			

		} else if (request.getParameter("edit") != null) {

			long id = Long.parseLong(request.getParameter("id"));

			Contact contact = contactRepository.find(id);
			Address address = addressRepository.find(contact.getAddressId());

			contact.setName(request.getParameter("name"));
			address.setCity(request.getParameter("city"));
			address.setState(request.getParameter("state"));
			address.setStreet(request.getParameter("street"));
			address.setZip(request.getParameter("zip"));
			contactRepository.save(contact);
			addressRepository.save(address);
			response.sendRedirect("contact?id=" + contact.getId());

		} else if (request.getParameter("delete") != null) {

			long id = Long.parseLong(request.getParameter("id"));

			Contact contact = contactRepository.find(id);
			Address address = addressRepository.find(contact.getAddressId());
			contactRepository.delete(contact);
			addressRepository.delete(address);
			response.sendRedirect("contacts");

		}

	}

}
