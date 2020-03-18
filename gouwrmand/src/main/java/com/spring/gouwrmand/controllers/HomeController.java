package com.spring.gouwrmand.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		//
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
		return "first";
	}
	
	@RequestMapping(value="/viewFoodItems",method=RequestMethod.GET)
	public String viewFoodItems(Model theModel,@RequestParam("category")String c) {
		List<FoodItem>f=fooditemdao.getFoodByCategory(c);
		theModel.addAttribute("foodItems",f);
		return "viewFoodItems";
	}
	@RequestMapping("/viewCategories")
	public String viewCategories(Model theModel) {
		List<String>f=fooditemdao.getFoodCategories();
		theModel.addAttribute("foodItems",f);
		return "viewCategories";
	}
	
	
}
