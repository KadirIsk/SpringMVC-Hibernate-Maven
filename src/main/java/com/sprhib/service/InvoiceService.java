package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Invoice;

public interface InvoiceService {
	
	public void addInvoice(Invoice invoice);
	public void updateInvoice(Invoice invoice);
	public Invoice getInvoice(String id);
	public void deleteInvoice(String id);
	public List<Invoice> getInvoices();

}
