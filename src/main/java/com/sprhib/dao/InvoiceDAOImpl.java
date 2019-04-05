package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Invoice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class InvoiceDAOImpl implements InvoiceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addInvoice(Invoice invoice) {
		getCurrentSession().save(invoice);
	}

	public void updateInvoice(Invoice invoice) {
		Invoice invoiceToUpdate = getInvoice(invoice.getID());

		invoiceToUpdate.setDespatchID(invoice.getDespatchID());
		invoiceToUpdate.setDeliveredQuantity(invoice.getDeliveredQuantity());
		invoiceToUpdate.setOrderLineReferanceID(invoice.getOrderLineReferanceID());
		invoiceToUpdate.setItemName(invoice.getItemName());
		invoiceToUpdate.setSellersIdentificaitonID(invoice.getSellersIdentificaitonID());
		invoiceToUpdate.setInvoiceQuantity(invoice.getInvoiceQuantity());
		invoiceToUpdate.setExtensionAmount(invoice.getExtensionAmount());
		invoiceToUpdate.setPrice(invoice.getPrice());

		getCurrentSession().update(invoiceToUpdate);
		
	}

	public Invoice getInvoice(String id) {
		Invoice invoice = (Invoice) getCurrentSession().get(Invoice.class, id);
		return invoice;
	}

	public void deleteInvoice(String id) {
		Invoice invoice = getInvoice(id);
		if (invoice != null)
			getCurrentSession().delete(invoice);
	}

	@SuppressWarnings("unchecked")
	public List<Invoice> getInvoices() {
		return getCurrentSession().createQuery("from Invoice").list();
	}

}
