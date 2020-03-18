package com.spring.gouwrmand.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.gouwrmand.dao.CustomerDao;
import com.spring.gouwrmand.dao.FoodItemDao;
import com.spring.gouwrmand.dao.RestaurantStaffDao;
import com.spring.gouwrmand.dao.RoleDao;
import com.spring.gouwrmand.entity.Customer;
import com.spring.gouwrmand.entity.FoodItem;
import com.spring.gouwrmand.entity.RestaurantStaff;
import com.spring.gouwrmand.entity.Role;

@Controller
public class HomeController {
	@Autowired
	private FoodItemDao fooditemdao;
	
	@Autowired
	private RestaurantStaffDao rs;
	
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
	
	
	@RequestMapping("/check")
	public String checking() {
		RestaurantStaff c = new RestaurantStaff();
//		c.setAddress("sdda");
//		c.setDate_of_birth(new java.util.Date());
//		c.setEmail("msi.com");
//		c.setName("mkmkdssn");
//		c.setPassword("dadads");
//		c.setPhone_no(3999999);
//		c.setRole_id(1);
//		c.setStaff_status(1);
		
//		rs.addStaff(c);
		//cd.addCustomer(c);
//		c=rs.getRestaurantStaff(1);
//		c.setEmail("bha.com");
//		rs.updateStaff(c);
		rs.deleteRestaurantStaff(1);
		
		return "first";
	}
	
	
}
