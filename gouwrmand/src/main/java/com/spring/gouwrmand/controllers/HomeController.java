package com.spring.gouwrmand.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.gouwrmand.dao.CustomerDao;
import com.spring.gouwrmand.dao.FoodItemDao;
import com.spring.gouwrmand.dao.OrderDao;
import com.spring.gouwrmand.dao.RestaurantStaffDao;
import com.spring.gouwrmand.dao.RoleDao;
import com.spring.gouwrmand.entity.Cart;
import com.spring.gouwrmand.entity.Customer;
import com.spring.gouwrmand.entity.FoodItem;
import com.spring.gouwrmand.entity.Orders;
import com.spring.gouwrmand.entity.RestaurantStaff;
import com.spring.gouwrmand.entity.Role;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.spring.gouwrmand.dao.CartDao;

@Controller
public class HomeController {
	@Autowired
	private FoodItemDao fooditemdao;

	@Autowired
	private RestaurantStaffDao rs;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CartDao cartDao;

	@Autowired
	private OrderDao orderDao;

	@RequestMapping("")
	public String firstPage() {
		FoodItem fi = new FoodItem();
		fi.setFood_type("beverages");
		fi.setFood_name("Limbupani");
		fi.setFood_discount(.5);
		fooditemdao.addFoodItem(fi);

		//
		return "first";
	}

	@RequestMapping("/home")
	public String indexPage() {
		// restaurant side home page
		return "homepage";
	}

	@RequestMapping("/addFoodItem")
	public String addFoodItem(Model theModel) {
		FoodItem fi = new FoodItem();
		theModel.addAttribute("fi", fi);
		return "addFoodItem";
	}

	@RequestMapping("/processAddFoodItem")
	public String processAddFoodItem(Model theModel, @ModelAttribute("fi") FoodItem fi) {
		fooditemdao.addFoodItem(fi);
		return "first";
	}

	@RequestMapping(value = "/updateFoodItem", method = RequestMethod.GET)
	public String updateFoodItem(Model theModel, @RequestParam("fid") int fid) {
		FoodItem fi = fooditemdao.getFoodItem(fid);
		theModel.addAttribute("fi", fi);
		return "updateFoodItem";
	}

	@RequestMapping("/processUpdateFoodItem")
	public String processUpdateFoodItem(Model theModel, @ModelAttribute("fi") FoodItem fi) {
		fooditemdao.updateFoodItem(fi);
		List<FoodItem> f = fooditemdao.getFoodByCategory(fi.getFood_type());
		theModel.addAttribute("foodItems", f);
		theModel.addAttribute("type", fi.getFood_type());
		return "redirect";
	}

	@RequestMapping(value = "/viewFoodItems", method = RequestMethod.GET)
	public String viewFoodItems(Model theModel, @RequestParam("category") String c) {
		List<FoodItem> f = fooditemdao.getFoodByCategory(c);

		theModel.addAttribute("foodItems", f);
		return "viewFoodItems";
	}

	@RequestMapping("/viewCategories")
	public String viewCategories(Model theModel) {
		List<String> f = fooditemdao.getFoodCategories();
		theModel.addAttribute("foodItems", f);
		return "viewCategories";
	}

	@RequestMapping(value = "/deleteFoodItems", method = RequestMethod.GET)
	public String deleteFoodItems(Model theModel, @RequestParam("category") String c, @RequestParam("fid") int fid) {
		fooditemdao.deleteFoodItem(fid);
		List<FoodItem> f = fooditemdao.getFoodByCategory(c);
		theModel.addAttribute("foodItems", f);
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
		// cd.addCustomer(c);
//		c=rs.getRestaurantStaff(1);
//		c.setEmail("bha.com");
//		rs.updateStaff(c);
		rs.deleteRestaurantStaff(1);

		return "first";
	}

	@RequestMapping("/registration")
	public String registration(Model theModel) {
		Customer c = new Customer();
		theModel.addAttribute("c", c);
		return "registration";
	}

	@RequestMapping("/processRegistration")
	public String processRegistration(Model theModel, @ModelAttribute("c") Customer c) {
		customerDao.addCustomer(c);
		return "first";
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.GET)
	public String updateCustomer(Model theModel, @RequestParam("cid") int cid) {
		Customer c = customerDao.getCustomer(cid);
		theModel.addAttribute("c", c);
		return "updateCustomer";
	}

	@RequestMapping("/processUpdateCustomer")
	public String processUpdateCustomer(Model theModel, @ModelAttribute("c") Customer c) {
		customerDao.updateCustomer(c);
		return "first";
	}

	@RequestMapping(value = "/viewFoodItemsByCustomer", method = RequestMethod.GET)
	public String viewFoodItemsByCustomer(Model theModel, @RequestParam("category") String c) {
		List<FoodItem> f = fooditemdao.getFoodByCategory(c);
		theModel.addAttribute("foodItems", f);
		return "viewFood";
	}

	@RequestMapping(value = "/addToCart", method = RequestMethod.GET)
	public String addToCart(Model theModel, @RequestParam("fid") int fid) {
		FoodItem fi = fooditemdao.getFoodItem(fid);
		Cart c = cartDao.getCart(1);
		c.setTotal(c.getTotal() + fi.getFood_price());
		if (c.getOrder_cart() == null) {
			c.setOrder_cart("" + fid + ",");
		} else {
			c.setOrder_cart(c.getOrder_cart() + fid + ",");
		}

		if (c.getItem_quantity() == null) {
			c.setItem_quantity("" + 1 + ",");
		} else {
			c.setItem_quantity(c.getItem_quantity() + 1 + ",");
		}

		cartDao.updateCart(c);

		return "first";
	}

	@RequestMapping(value = "/viewCart", method = RequestMethod.GET)
	public String viewCart(Model theModel, @RequestParam("cid") int cid) {
		Cart c = cartDao.getCart(cid);
		String s = c.getOrder_cart();
		String q = c.getItem_quantity();
		System.out.println("dsdfssfsfsd" + s);
		List<FoodItem> list = new ArrayList<FoodItem>();
		double sum = 0;
		double dis;
		int[] l = new int[10];
		int index = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			char p = s.charAt(i);
			if (p != ',') {
				int m = (int) p;
				m = m - 48;
				l[m] = (int) q.charAt(i) - 48;
				list.add(fooditemdao.getFoodItem(m));
				dis = 1 - fooditemdao.getFoodItem(m).getFood_discount();
				sum = sum + dis * (fooditemdao.getFoodItem(m).getFood_price()) * l[m];
			}
		}
		// List<FoodItem> f = fooditemdao.getFoodByCategory(c);
		c.setTotal(sum);
		cartDao.updateCart(c);
		theModel.addAttribute("foodItems", list);
		theModel.addAttribute("sum", sum);
		theModel.addAttribute("l", l);
		theModel.addAttribute("cid", cid);
		return "viewCart";
	}

	@RequestMapping(value = "/addItemQty", method = RequestMethod.GET)
	public String addItemQty(Model theModel, @RequestParam("fid") int fid, @RequestParam("qty") int qty,
			@RequestParam("cid") int cid) {
		Cart c = cartDao.getCart(cid);
		String s = c.getOrder_cart();
		int index = 0;

		while ((int) s.charAt(index) - 48 != fid) {
			index++;
		}

		StringBuilder sb = new StringBuilder(c.getItem_quantity());
		qty += 1;
		sb.replace(index, index + 1, Integer.toString(qty));
		c.setItem_quantity(sb.toString());
		cartDao.updateCart(c);
		theModel.addAttribute("cid", cid);
		return "cartRedirect";
	}

	@RequestMapping(value = "/minusItemQty", method = RequestMethod.GET)
	public String minusItemQty(Model theModel, @RequestParam("fid") int fid, @RequestParam("qty") int qty,
			@RequestParam("cid") int cid) {
		Cart c = cartDao.getCart(cid);
		String s = c.getOrder_cart();
		int index = 0;

		while ((int) s.charAt(index) - 48 != fid) {
			index++;
		}

		StringBuilder sb = new StringBuilder(c.getItem_quantity());
		qty -= 1;
		sb.replace(index, index + 1, Integer.toString(qty));
		c.setItem_quantity(sb.toString());
		cartDao.updateCart(c);
		theModel.addAttribute("cid", cid);
		return "cartRedirect";
	}

	@RequestMapping(value = "/placeOrder", method = RequestMethod.GET)
	public String placeOrder(Model theModel, @RequestParam("cid") int cid) {
		Cart c = cartDao.getCart(cid);
	
	String s = c.getOrder_cart();
	s = s.substring(0, s.length()-1);

		String q = c.getItem_quantity();
		q = q.substring(0, q.length()-1);
		
		System.out.println("dsds "+q+" dfdc"+s);
		
		Orders o = new Orders();
		
		o.setCustomer_id(cid);
		o.setItem_quantity(q);
		o.setOrder_cart(s);
		o.setOrder_date(null);
		o.setOrder_status(1);
		o.setOrder_status(1);
		
		orderDao.addOrder(o);
		
		return "first";
	}

	@RequestMapping(value = "/getReport", method = RequestMethod.GET)
	public String getReport() throws JRException, FileNotFoundException {
		String path = "C:\\Users\\Abc\\Desktop\\Report";
		List<Orders> orders = orderDao.getAllOrder();
		// load file and compile it
		File file = ResourceUtils.getFile("classpath:myOrders.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orders);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Java Techie");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\.pdf");

		return "first";
	}

}
