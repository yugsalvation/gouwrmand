package com.spring.gouwrmand.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("home")
	public String firstPage() {
		return "first";
	}
	@RequestMapping("index")
	public String indexPage() {
		return "homepage";
	}
}
