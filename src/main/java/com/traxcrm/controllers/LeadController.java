package com.traxcrm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.traxcrm.entities.Contact;
import com.traxcrm.entities.Lead;
import com.traxcrm.services.ContactService;
import com.traxcrm.services.LeadService;

@Controller
public class LeadController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private LeadService leadService;
	
@RequestMapping("/")
public String viewLeadPage() {
	return "view_lead_page";
}

@RequestMapping("/saveLead")
public String saveOneLead(@ModelAttribute("lead") Lead lead , ModelMap model) {
	leadService.saveLead(lead);
	model.addAttribute("lead", lead );
	return "lead_info";
}
@RequestMapping(value = "/convertLead" , method = RequestMethod.POST)
public String convertOneLead(@RequestParam("id") long id , Model map) {
	Lead lead = leadService.getLeadById(id);
	
	Contact contact = new Contact();
	contact.setFirstName(lead.getFirstName());
	contact.setLastName(lead.getLastName());
	contact.setEmail(lead.getEmail());
	contact.setGender(lead.getGender());
	contact.setLeadSource(lead.getLeadSource());
	contact.setMobile(lead.getMobile());
	
	contactService.saveContact(contact);
	
	leadService.deleteOneLead(id);
	
	List<Contact> contacts = contactService.listAll();
	map.addAttribute("contacts", contacts);
	return "contact_search_result";
}

@RequestMapping("/listall")
public String getAllLeads(Model map){
	List<Lead> leads = leadService.listAll();
	map.addAttribute("leads" , leads);
	return "lead_search_result";
}

@RequestMapping("/getLeadById")
public String getLeadById(@RequestParam("id") long id , ModelMap model) {
	Lead lead = leadService.getLeadById(id);
	model.addAttribute("lead",lead);
	return "lead_info";
}

@RequestMapping("/getContactById")
public String getContactById(@RequestParam("id") long id , ModelMap model) {
	Contact contact = contactService.findContactById(id);
	model.addAttribute("contact" , contact);
	return "contact_info";
}






















}
