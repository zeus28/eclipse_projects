package com.marakana.contacts.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import com.marakana.contacts.entities.*;
import com.marakana.contacts.repositories.*;

@Controller
public class OfficeController {

	@Autowired
	private OfficeRepository officeRepository;
	@Autowired
	private CompanyRepository companyRepository;

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


	@RequestMapping(value = "/office", params = "add", method = RequestMethod.GET)
	public String getAddContact(@RequestParam("company_id") long company_id, Model model) {
		model.addAttribute("company",companyRepository.findOne(company_id));
		
		return "office/add";

	}

	@RequestMapping(value = "/office", params = "edit", method = RequestMethod.GET)
	public String getEditContact(@RequestParam long id, Model model) {
		model.addAttribute("office", officeRepository.findOne(id));
		return "office/edit";

	}

	@RequestMapping(value = "/office", method = RequestMethod.GET)
	public String getViewContact(@RequestParam long id, Model model) {
		model.addAttribute("office", officeRepository.findOne(id));
		return "office/view";

	}

	@RequestMapping(value = "/office", params = "add", method = RequestMethod.POST)
	public String postAddOffice(@RequestParam long company_id,@RequestParam String name, 
			@RequestParam String street, @RequestParam String city,
			@RequestParam String state, @RequestParam String zip) {
		Address address = new Address(street, city, state, zip);
		Company company = companyRepository.findOne(company_id);
		Office office = new Office(name, address,company);
		office=officeRepository.save(office);
		return "redirect:office?id=" + office.getId();

	}
	@RequestMapping(value = "/office", params = "edit", method = RequestMethod.POST)
	public String postEditOffice(@RequestParam long id,@RequestParam String name, 
			@RequestParam String street, 
			@RequestParam String city,
			@RequestParam String state, 
			@RequestParam String zip) {
		
		Office  office = officeRepository.findOne(id);
		Address address= office.getAddress();
		address.setCity(city);
		address.setState(state);
		address.setStreet(street);
		address.setZip(zip);
		office.setName(name);
		officeRepository.save(office);
		return "redirect:office?id=" + office.getId();
		
	}
	@RequestMapping(value = "/office", params = "delete", method = RequestMethod.POST)
	public String postDeleteOffice(@RequestParam Long id) {
		Office office = officeRepository.findOne(id);
		officeRepository.delete(office);
		return "redirect:" + office.getCompany().getUrl();
	}



	}
