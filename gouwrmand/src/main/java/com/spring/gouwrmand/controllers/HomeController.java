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

import java.util.Collection;
import java.util.Collections;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.gouwrmand.dao.CustomerDao;
import com.spring.gouwrmand.dao.FoodItemDao;

import com.spring.gouwrmand.dao.InvoiceDao;
import com.spring.gouwrmand.dao.OrderDao;
import com.spring.gouwrmand.dao.RestaurantStaffDao;
import com.spring.gouwrmand.entity.Cart;
import com.spring.gouwrmand.entity.Customer;
import com.spring.gouwrmand.entity.FoodItem;

import com.spring.gouwrmand.entity.Invoice;
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
	private OrderDao ordersdao;
	
	@Autowired
	private RestaurantStaffDao rs;

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private InvoiceDao invoiceDao;	
  @Autowired
	private CartDao cartDao;

	@Autowired
	private OrderDao orderDao;
	
	
	@RequestMapping("")
	public String firstPage(HttpServletRequest request,HttpServletResponse response) {
		//invoiceDao.addInvoice(new Invoice());	
		Orders o=orderDao.getOrder(1);
		invoiceDao.addInvoice(o);

		//
//		response.addHeader("content-disposition", "attachment; filename=JasperTableExample.pdf");
//		 String userHomeDirectory = System.getProperty("user.home");
//         /* Output file location */
//         String outputFile = userHomeDirectory+File.separatorChar +"Downloads"+ File.separatorChar+"reports"+ File.separatorChar+ "JasperTableExample.pdf";
//
//		Path file = Paths.get(outputFile);
//		try
//	    {
//	        Files.copy(file, response.getOutputStream());
//	        response.getOutputStream().flush();
//	    }
//	    catch (IOException ex) {
//	        ex.printStackTrace();
//	    }
		return "first";
	}

	@RequestMapping("/home")
	public String indexPage() {
		// restaurant side home page
		return "homepage";
	}
	
	@RequestMapping("/homepage")
	public String indexPageOfCustomer() {
		// restaurant side home page
		return "customerHomepage";
	}
	
	@RequestMapping("/login")
	public String login() {
		// restaurant side home page
		return "logIn";
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
	
	@RequestMapping("/viewCategoriesByCustomer")
	public String viewCategoriesByCustomer(Model theModel) {
		List<String> f = fooditemdao.getFoodCategories();
		theModel.addAttribute("foodItems", f);
		return "viewCategoriesByCustomer";
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
	public String updateCustomer(Model theModel) {
		Customer c = customerDao.getCustomer(1);
		theModel.addAttribute("c", c);
		return "updateCustomer";
	}

	@RequestMapping("/processUpdateCustomer")
	public String processUpdateCustomer(Model theModel, @ModelAttribute("c") Customer c) {
		customerDao.updateCustomer(c);
		return "updateCustomer";
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

		return "categoriesRedirect";
	}

	@RequestMapping(value = "/viewCart", method = RequestMethod.GET)
	public String viewCart(Model theModel) {
		Cart c = cartDao.getCart(1);
		String s = c.getOrder_cart();
		if(s==null) {
			return "empty";
		}
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
		//theModel.addAttribute("cid", 1);
		return "viewCart";
	}

	@RequestMapping(value = "/addItemQty", method = RequestMethod.GET)
	public String addItemQty(Model theModel, @RequestParam("fid") int fid, @RequestParam("qty") int qty) {
		Cart c = cartDao.getCart(1);
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
		theModel.addAttribute("cid", 1);
		return "cartRedirect";
	}

	@RequestMapping(value = "/minusItemQty", method = RequestMethod.GET)
	public String minusItemQty(Model theModel, @RequestParam("fid") int fid, @RequestParam("qty") int qty) {
		Cart c = cartDao.getCart(1);
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
		theModel.addAttribute("cid", 1);
		return "cartRedirect";
	}

	@RequestMapping(value = "/placeOrder", method = RequestMethod.GET)
	public String placeOrder(Model theModel, @RequestParam("sum") double sum) {
		Cart c = cartDao.getCart(1);

	
	String s = c.getOrder_cart();
	s = s.substring(0, s.length()-1);

		String q = c.getItem_quantity();
		q = q.substring(0, q.length()-1);
		
		System.out.println("dsds "+q+" dfdc"+s);
		
		Orders o = new Orders();
		
		o.setCustomer_id(1);
		o.setItem_quantity(q);
		o.setOrder_cart(s);
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
		
		o.setOrder_date(date);
		o.setOrder_status(0);
		o.setOrder_total(sum);
		orderDao.addOrder(o);
		
		List<Orders> orders = orderDao.getAllOrder();
		Collections.reverse(orders);
		
		
		c.setItem_quantity(null);
		c.setOrder_cart(null);
		c.setTotal(0);
		
		cartDao.updateCart(c);
		theModel.addAttribute("cid", 1);
		
		invoiceDao.addInvoice(orders.get(0));
		theModel.addAttribute("oid", orders.get(0).getOrder_id());
		return "cartRedirect";

	}

	@RequestMapping(value = "/getReport", method = RequestMethod.GET)
	public String getReport(HttpServletRequest request,HttpServletResponse response) throws JRException, FileNotFoundException {
		//String path = "C:\\Users\\Abc\\Desktop\\Report";
		
		String userHomeDirectory = System.getProperty("user.home");

        /* Output file location */

//		List<Orders> orders = orderDao.getAllOrder();
		long millis=System.currentTimeMillis();  
        java.sql.Date from=new java.sql.Date(millis);  
        
        long milli=System.currentTimeMillis();  
        java.sql.Date to=new java.sql.Date(milli);  
        
        String path = userHomeDirectory+File.separatorChar +"Desktop"+ File.separatorChar+"reports"+ File.separatorChar+to+".pdf";
		List<Orders> orders = orderDao.getOrders(from, to);
		// load file and compile it
		File file = ResourceUtils.getFile("classpath:myOrders.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orders);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Java Techie");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, path);
		
		response.addHeader("content-disposition", "attachment; filename="+to+".pdf");
	// String userHomeDirectory = System.getProperty("user.home");
        /* Output file location */
        //String outputFile = userHomeDirectory+File.separatorChar +"Downloads"+ File.separatorChar+"reports"+ File.separatorChar+ "JasperTableExample.pdf";

		Path file2 = Paths.get(path);
		try
	    {
	        Files.copy(file2, response.getOutputStream());
	        response.getOutputStream().flush();
	    }
	    catch (IOException ex) {
	        ex.printStackTrace();
	    }
		
		return "first";
	}
	
	@RequestMapping("/viewMyOrders")
	public String viewMyOrders(Model theModel) {
		String status=null;
		List<Orders>o=ordersdao.getMyOrders(1);
		Collections.reverse(o);
		List<String>c=new ArrayList<String>();
		List<String> st=new ArrayList<String>();
		for (Orders order : o) {
			c.add(customerDao.getCustomer(order.getCustomer_id()).getName());
			if(order.getOrder_status()==1) {
				status = "Your order is ready";
			}
			else {
			status = "Being Prepared";
			
			}
			st.add(status);
		}
	
		theModel.addAttribute("orders",o);
		theModel.addAttribute("customername",c);
		theModel.addAttribute("status",st);
		return "viewMyOrder";
	}

}
