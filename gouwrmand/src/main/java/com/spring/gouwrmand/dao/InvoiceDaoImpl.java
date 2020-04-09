package com.spring.gouwrmand.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.spring.gouwrmand.entity.FoodItem;
import com.spring.gouwrmand.entity.Invoice;
import com.spring.gouwrmand.entity.Orders;
import com.spring.gouwrmand.model.Invoicedata;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {
	@Autowired
	private FoodItemDao fooditemdao;
	@Autowired
	private CustomerDao customerdao;
	@Autowired
	private EntityManager entityManager;
	@Override
	public Invoice getInvoice(int invoiceid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void addInvoice(Orders o) {
		try {
			Invoice i=new Invoice();
			i.setOrder_id(o.getOrder_id());
			i.setInvoice_document("ddss");
			Session session;
			session = entityManager.unwrap(Session.class);
			session.save(i);
				
			
            /* User home directory location */
            String userHomeDirectory = System.getProperty("user.home");
            /* Output file location */
            String outputFile = userHomeDirectory+File.separatorChar +"Desktop"+ File.separatorChar+"Invoices"+ File.separatorChar+ "IN"+o.getOrder_id()+".pdf";

            /* List to hold Items */
            
            String q,c;
            q=o.getItem_quantity();
            q=q.replaceAll(",", "");
            c=o.getOrder_cart();
            c=c.replaceAll(",","");
          //  System.out.println(Integer.parseInt(c.substring(0,1)));
           
            double total=o.getOrder_total();
            List<Invoicedata> listItems = new ArrayList<Invoicedata>();
            int j;
            for(j=0;j<q.length();j++) {
            	int idd=Integer.parseInt(c.substring(j,j+1));
            	System.out.println(idd);
            	FoodItem fo=fooditemdao.getFoodItem(idd);
            	System.out.println(fo.getFood_id());
            	Invoicedata id=new Invoicedata();
            	id.setItemname(fo.getFood_name());
            	id.setQuantity(q.substring(j,j+1));
            	int quant=Integer.parseInt(q.substring(j,j+1));
            	id.setCost(String.valueOf(quant*fo.getFood_price()));
            	listItems.add(id);
            }
//            Invoicedata i1=new Invoicedata();
//            Invoicedata i2=new Invoicedata();
//            i1.setItemname("dada");
//            i1.setQuantity("1");
//            i1.setCost("infinite");
//            
//            i2.setItemname("dada");
//            i2.setQuantity("1");
//            i2.setCost("infinite");
//            /* Add Items to List */
//            listItems.add(i1);
//            listItems.add(i2);

            /* Convert List to JRBeanCollectionDataSource */
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);
            
            File file = ResourceUtils.getFile("classpath:invoice.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            /* Map to hold Jasper report Parameters */
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("ItemDataSource", itemsJRBean);
            parameters.put("order_total", String.valueOf(o.getOrder_total()));
            String cust_name=customerdao.getCustomer(o.getCustomer_id()).getName();
            parameters.put("customer_name",cust_name);
            parameters.put("order_date",String.valueOf(o.getOrder_date()));
            /* Using compiled version(.jasper) of Jasper report to generate PDF */
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            /* outputStream to create PDF */
            OutputStream outputStream = new FileOutputStream(new File(outputFile));
            /* Write content to PDF file */
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            System.out.println("File Generated");
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

	

	@Override
	public List<Invoice> getInvoices(Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInvoice(Invoice in) {
		// TODO Auto-generated method stub

	}

}
