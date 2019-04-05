package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.InvoiceDAO;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceDAO invoiceDAO;

	public void addInvoice(Invoice invoice) {
		invoiceDAO.addInvoice(invoice);
	}

	public void updateInvoice(Invoice invoice) {
		invoiceDAO.updateInvoice(invoice);
	}

	public Invoice getInvoice(String id) {
		return invoiceDAO.getInvoice(id);
	}

	@Override
	public void deleteInvoice(String id) { invoiceDAO.deleteInvoice(id); }

	public List<Invoice> getInvoices() {
		return invoiceDAO.getInvoices();
	}

}
