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

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.spring.gouwrmand.entity.Invoice;
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

	@Override
	public Invoice getInvoice(int invoiceid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addInvoice(Invoice in) {
		try {
            /* User home directory location */
            String userHomeDirectory = System.getProperty("user.home");
            /* Output file location */
            String outputFile = userHomeDirectory+File.separatorChar +"Downloads"+ File.separatorChar+"reports"+ File.separatorChar+ "JasperTableExample.pdf";

            /* List to hold Items */
            List<Invoicedata> listItems = new ArrayList<Invoicedata>();

            Invoicedata i1=new Invoicedata();
            Invoicedata i2=new Invoicedata();
            i1.setItemname("dada");
            i1.setQuantity("1");
            i1.setCost("infinite");
            
            i2.setItemname("dada");
            i2.setQuantity("1");
            i2.setCost("infinite");
            /* Add Items to List */
            listItems.add(i1);
            listItems.add(i2);

            /* Convert List to JRBeanCollectionDataSource */
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);
            
            File file = ResourceUtils.getFile("classpath:invoice.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            /* Map to hold Jasper report Parameters */
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("ItemDataSource", itemsJRBean);

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
