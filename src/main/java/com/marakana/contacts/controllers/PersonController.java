package com.marakana.contacts.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marakana.contacts.entities.Address;

import com.marakana.contacts.entities.Person;
import com.marakana.contacts.repositories.PersonRepository;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	/*
	 * @RequestMapping(value = "/contacts", method = RequestMethod.GET) public
	 * void getContactList(HttpServletRequest request, HttpServletResponse
	 * response) throws IOException, ServletException {
	 * 
	 * request.setAttribute("contacts", contactRepository.findAll());
	 * RequestDispatcher view =
	 * request.getRequestDispatcher("view/contact/list.jsp");
	 * view.forward(request, response);
	 * 
	 * }
	 */


	@RequestMapping(value = "/person", params = "add", method = RequestMethod.GET)
	public String getAddContact() {

		return "person/add";

	}

	@RequestMapping(value = "/person", params = "edit", method = RequestMethod.GET)
	public String getEditContact(@RequestParam long id, Model model) {
		model.addAttribute("person", personRepository.findOne(id));
		return "person/edit";

	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String getViewContact(@RequestParam long id, Model model) {
		model.addAttribute("person", personRepository.findOne(id));
		return "person/view";

	}

	@RequestMapping(value = "/person", params = "add", method = RequestMethod.POST)
	public String postAddPerson(@RequestParam String name, @RequestParam String street, @RequestParam String city,
			@RequestParam String state, @RequestParam String zip) {
		Address address = new Address(street, city, state, zip,"dali");
		Person person = new Person(name, address);
		person=personRepository.save(person);
		return "redirect:person?id=" + person.getId();

	}
	@RequestMapping(value = "/person", params = "edit", method = RequestMethod.POST)
	public String postEditPerson(@RequestParam Long id,@RequestParam String name, 
			@RequestParam String street, 
			@RequestParam String city,
			@RequestParam String state, @RequestParam String zip) {
		Person  person = personRepository.findOne(id);
		Address address= person.getAddress();
		address.setCity(city);
		address.setState(state);
		address.setStreet(street);
		address.setZip(zip);
		person.setName(name);
		personRepository.save(person);
		return "redirect:person?id=" + person.getId();
	}
	@RequestMapping(value = "/person", params = "delete", method = RequestMethod.POST)
	public String postDeletePerson(@RequestParam Long id) {
		personRepository.delete(id);
		return "redirect:contacts";
	}



	/*
	 * @RequestMapping(value = "/contact", method = RequestMethod.POST) public
	 * void postContact(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { if
	 * (request.getParameter("add") != null) { Address address = new
	 * Address(request.getParameter("street"), request.getParameter("city"),
	 * request.getParameter("state"), request.getParameter("zip")); Contact
	 * contact = new Contact(request.getParameter("name"), address); contact =
	 * contactRepository.save(contact); response.sendRedirect("/contact?id=" +
	 * contact.getId());
	 * 
	 * } else if (request.getParameter("edit") != null) { long id =
	 * Long.parseLong(request.getParameter("id")); Contact contact =
	 * contactRepository.findOne(id); Address address = contact.getAddress();
	 * 
	 * address.setCity(request.getParameter("city"));
	 * address.setState(request.getParameter("state"));
	 * address.setStreet(request.getParameter("street"));
	 * address.setZip(request.getParameter("zip"));
	 * contact.setName(request.getParameter("name"));
	 * contact.setAddress(address); contactRepository.save(contact);
	 * response.sendRedirect("contact?id=" + contact.getId());
	 * 
	 * 
	 * } }
	 */

	/*
	 * @RequestMapping(value = "/contact", method = RequestMethod.GET) public
	 * void getContact(HttpServletRequest request, HttpServletResponse response)
	 * throws IOException, ServletException {
	 * 
	 * if (request.getParameter("add") != null) {
	 * request.getRequestDispatcher("view/contact/add.jsp").forward(request,
	 * response);
	 * 
	 * }else { long id=Long.parseLong(request.getParameter("id")); //Contact
	 * contact = contactRepository.find(id);
	 * //request.setAttribute("contact",contact);
	 * 
	 * if (request.getParameter("edit") != null){
	 * 
	 * request.getRequestDispatcher("view/contact/edit.jsp").forward(request,
	 * response);
	 * 
	 * }else {
	 * request.getRequestDispatcher("view/contact/view.jsp").forward(request,
	 * response); }
	 * 
	 * 
	 * }
	 * 
	 * }
	 */}
