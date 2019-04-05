package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Invoice;

public interface InvoiceDAO {
	
	public void addInvoice(Invoice invoice);
	public void updateInvoice(Invoice invoice);
	public Invoice getInvoice(String id);
	public void deleteInvoice(String id);
	public List<Invoice> getInvoices();

}
