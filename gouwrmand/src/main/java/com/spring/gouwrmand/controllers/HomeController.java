package com.spring.gouwrmand.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.gouwrmand.dao.FoodItemDao;
import com.spring.gouwrmand.entity.FoodItem;

@Controller
public class HomeController {
	@Autowired
	private FoodItemDao fooditemdao;
	@RequestMapping("")
	public String firstPage() {
		FoodItem fi=new FoodItem();
		fi.setFood_type("beverages");
		fi.setFood_name("Limbupani");
		fi.setFood_discount(.5);
		fooditemdao.addFoodItem(fi);
		
		
		return "first";
	}
	@RequestMapping("/home")
	public String indexPage() {
		//restaurant side home page
		return "homepage";
	}
	@RequestMapping("/addFoodItem")
	public String addFoodItem(Model theModel) {
		FoodItem fi=new FoodItem();
		theModel.addAttribute("fi",fi);
		return "addFoodItem";
	}
	@RequestMapping("/processAddFoodItem")
	public String processAddFoodItem(Model theModel,@ModelAttribute("fi") FoodItem fi) {
		fooditemdao.addFoodItem(fi);
		double d=fi.getFood_status();
		theModel.addAttribute("description",d);
		return "first";
	}
	
	
}
