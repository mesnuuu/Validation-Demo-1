package com.mesnu.validation;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

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
