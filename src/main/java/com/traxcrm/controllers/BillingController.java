package com.traxcrm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.traxcrm.entities.Billing;
import com.traxcrm.entities.Contact;
import com.traxcrm.services.BillingService;
import com.traxcrm.services.ContactService;

@Controller
public class BillingController {

	@Autowired
	public ContactService contactService;
	
	@Autowired
	private BillingService billingService;
	
	@RequestMapping("/generateBilling")
	public String viewBillingPage(@RequestParam("id") long id , ModelMap modelMap) {
	    Contact contact = contactService.findContactById(id);
	    modelMap.addAttribute("contact" , contact);
		return "create_bill_jsp";
	}
	
	@RequestMapping("/saveBill")
	public String saveBill(@ModelAttribute("lead") Billing billing , ModelMap model) {
		       billingService.saveData(billing);  
		       model.addAttribute("billing" , billing);
		       return "Billing_info";
	}
}
