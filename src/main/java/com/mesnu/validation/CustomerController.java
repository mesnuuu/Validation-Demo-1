package com.mesnu.validation;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// add an initbinder ... to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	

	@RequestMapping("/")
	public String home(Model theModel) {

		theModel.addAttribute("customer", new Customer());

		return "main-menu";
	}

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		theModel.addAttribute("customer", new Customer());

		return "customer-form";
	}

	@RequestMapping("/processForm")
	
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {

			// Result of Validation placed in BindingResult
		
		if (theBindingResult.hasErrors()){
			return "customer-form";
		}
		
		else {
			return "customer-confirmation";
		}
		
			
		}

}
