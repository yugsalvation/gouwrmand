package com.spring.gouwrmand.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.gouwrmand.dao.RoleDao;
import com.spring.gouwrmand.entity.Customer;
import com.spring.gouwrmand.entity.Role;


@Controller
public class HomeController {
	@Autowired
	RoleDao r;
	
	@RequestMapping("home")
	public String firstPage() {
		Role role = new Role();
		role.setRole_id(1);
		role.setRole_title("admin");
		role.setRole_description("high");
		// = new RoleDaoImpl();
		r.updateRole(role);
		System.out.println("Hello......");
		return "first";
	}
	@RequestMapping("login")
	public String loginPage() {
		return "login";
	}
	
//	@GetMapping("registration")
//	public String showRegistration() {
//		return "registration";
//	}
//	
//	@PostMapping("registration")
//    public String makeRegistration(@ModelAttribute("userForm") Customer c) {
//
//        
//        return "login";
//    }
	
	 @RequestMapping(value = "/registration", method = RequestMethod.GET)
	    public String add(Model model) {
	        model.addAttribute("customer", new Customer());
	        return "registration";
	    }

	    @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public String processAdd(@Valid Customer c, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "registration";
	        }

	        return "person-added-successfully";
	    }
}
