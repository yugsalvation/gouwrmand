package com.spring.gouwrmand.controllers;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.gouwrmand.dao.CustomerDao;
import com.spring.gouwrmand.dao.FoodItemDao;
import com.spring.gouwrmand.dao.InvoiceDao;
import com.spring.gouwrmand.dao.OrderDao;
import com.spring.gouwrmand.dao.RestaurantStaffDao;
import com.spring.gouwrmand.dao.RoleDao;
import com.spring.gouwrmand.entity.Customer;
import com.spring.gouwrmand.entity.FoodItem;
import com.spring.gouwrmand.entity.Invoice;
import com.spring.gouwrmand.entity.Orders;
import com.spring.gouwrmand.entity.RestaurantStaff;
import com.spring.gouwrmand.entity.Role;

@Controller
public class HomeController {
	@Autowired
	private FoodItemDao fooditemdao;
	
	@Autowired
	private OrderDao ordersdao;
	
	@Autowired
	private RestaurantStaffDao rs;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private InvoiceDao invoiceDao;	
	
	
	@RequestMapping("")
	public String firstPage(HttpServletRequest request,HttpServletResponse response) {
		//invoiceDao.addInvoice(new Invoice());
		//
		response.addHeader("content-disposition", "attachment; filename=JasperTableExample.pdf");
		String dataDirectory = request.getServletContext().getRealPath("/WebContent/resources/");
		 String userHomeDirectory = System.getProperty("user.home");
         /* Output file location */
         String outputFile = userHomeDirectory+File.separatorChar +"Downloads"+ File.separatorChar+"reports"+ File.separatorChar+ "JasperTableExample.pdf";

		Path file = Paths.get(outputFile);
		try
	    {
	        Files.copy(file, response.getOutputStream());
	        response.getOutputStream().flush();
	    }
	    catch (IOException ex) {
	        ex.printStackTrace();
	    }
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
	
	@RequestMapping(value="/updateFoodItem",method=RequestMethod.GET)
	public String updateFoodItem(Model theModel,@RequestParam("fid")int fid) {
		FoodItem fi=fooditemdao.getFoodItem(fid);
		theModel.addAttribute("fi",fi);
		return "updateFoodItem";
	}
	@RequestMapping("/processUpdateFoodItem")
	public String processUpdateFoodItem(Model theModel,@ModelAttribute("fi") FoodItem fi) {
		fooditemdao.updateFoodItem(fi);
		List<FoodItem>f=fooditemdao.getFoodByCategory(fi.getFood_type());
		theModel.addAttribute("foodItems",f);
		theModel.addAttribute("type",fi.getFood_type());
		return "redirect";
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
	@RequestMapping("/viewTodayOrders")
	public String viewTodayOrders(Model theModel) {
		Date d=new Date(Calendar.getInstance().getTime().getTime());
		List<Orders>o=ordersdao.getTodayOrders(d);
		List<String>c=new ArrayList<String>();
		for (Orders order : o) {
			c.add(customerDao.getCustomer(order.getCustomer_id()).getName());
		}
	
		theModel.addAttribute("orders",o);
		theModel.addAttribute("customername",c);
		return "viewTodayOrders";
	}
	@RequestMapping("/viewChangeStatusOrder")
	public String viewChangeStatusOrder(Model theModel,@RequestParam("oid")int oid) {
		ordersdao.changeStatustoReady(oid);
		return "viewChangeStatusOrder";
	}
	@RequestMapping("/viewOrderedItems")
	public String viewOrderedItems(Model theModel,@RequestParam("oid")int oid) {
		Orders o=ordersdao.getOrder(oid);
		List<String> itemsid = new ArrayList<String>(Arrays.asList(o.getOrder_cart().split(",")));
		List<String>itemsname=new ArrayList<String>();
		List<String> itemsquant = new ArrayList<String>(Arrays.asList(o.getItem_quantity().split(",")));
		for(String i:itemsid) {
			itemsname.add(fooditemdao.getFoodItem(Integer.parseInt(i)).getFood_name());
			//System.out.println(itemsname.get(itemsid.indexOf(i)));
		}
		theModel.addAttribute("itemsname",itemsname);
		theModel.addAttribute("quantity",itemsquant);
		return "viewOrderedItems";
	}
	@RequestMapping(value="/deleteFoodItems",method=RequestMethod.GET)
	public String deleteFoodItems(Model theModel,@RequestParam("category")String c,@RequestParam("fid")int fid) {
		fooditemdao.deleteFoodItem(fid);
		List<FoodItem>f=fooditemdao.getFoodByCategory(c);
		theModel.addAttribute("foodItems",f);
		return "viewFoodItems";
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
	
	
	@RequestMapping("/registration")
	public String registration(Model theModel) {
		Customer c = new Customer();
		theModel.addAttribute("c",c);
		return "registration";
	}
	
	@RequestMapping("/processRegistration")
	public String processRegistration(Model theModel,@ModelAttribute("c")  Customer c) {
		customerDao.addCustomer(c);
		return "first";
	}
}
