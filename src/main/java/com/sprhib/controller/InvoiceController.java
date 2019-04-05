package com.sprhib.controller;

import java.util.List;
import java.util.UUID;

import com.sprhib.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.service.InvoiceService;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@Controller
@RequestMapping(value="/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	private Invoice invoice = null;


	private void traverseNodes(NodeList nodeList) {
		Node parent;

		for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);

			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				// get node name and value
				switch (tempNode.getNodeName()){
					case "cac:DespatchLine":
						//System.out.println("Node Name = DespatchLine\n");
						if(invoice == null){
							invoice = new Invoice();
						}
						else{
							UUID uuid = UUID.randomUUID();
							invoice.setID(uuid.toString());
							invoiceService.addInvoice(invoice);
							invoice = new Invoice();
						}
						break;
					case "cbc:ID":
						parent = tempNode.getParentNode();
						if(parent.getNodeName().equals("cac:SellersItemIdentification")){
							//System.out.println("Node Name = SellersItemIdentification ID\n Value = " + tempNode.getTextContent());
							invoice.setSellersIdentificaitonID(tempNode.getTextContent());
						}
						else if(parent.getNodeName().equals("cac:DespatchLine")){
							//System.out.println("Node Name = DespatchLine ID\n Value = " + tempNode.getTextContent());
							invoice.setDespatchID(Integer.parseInt(tempNode.getTextContent()));
						}
						break;
					case "cbc:DeliveredQuantity":
						//System.out.println("Node Name = DeliveredQuantity\n Value = " + tempNode.getTextContent());
						invoice.setDeliveredQuantity(Integer.parseInt(tempNode.getTextContent()));
						break;
					case "cbc:LineID":
						//System.out.println("Node Name = LineID\n Value = " + tempNode.getTextContent());
						invoice.setOrderLineReferanceID(Integer.parseInt(tempNode.getTextContent()));
						break;
					case "cbc:Name":
						parent = tempNode.getParentNode();
						parent = parent.getParentNode();
						if(parent.getNodeName().equals("cac:DespatchLine")){
							//System.out.println("Node Name = Item Name\n Value = " + tempNode.getTextContent());
							invoice.setItemName(tempNode.getTextContent());
						}
						break;
					case "cbc:InvoicedQuantity":
						//System.out.println("Node Name = InvoicedQuantity\n Value = " + tempNode.getTextContent());
						invoice.setInvoiceQuantity(Integer.parseInt(tempNode.getTextContent()));
						break;
					case "cbc:LineExtensionAmount":
						//System.out.println("Node Name = LineExtensionAmount\n Value = " + tempNode.getTextContent());
						invoice.setExtensionAmount(Integer.parseInt(tempNode.getTextContent()));
						break;
					case "cbc:PriceAmount":
						//System.out.println("Node Name = PriceAmount\n Value = " + tempNode.getTextContent());
						invoice.setPrice(Integer.parseInt(tempNode.getTextContent()));
						break;
				}

				if (tempNode.hasChildNodes()) {
					// loop again if has child nodes
					traverseNodes(tempNode.getChildNodes());
				}
			}
		}

	}

	@RequestMapping(value="/parseXML",method=RequestMethod.POST)
	public @ResponseBody String parseXML(@RequestParam("file") CommonsMultipartFile file,
					HttpSession session) throws Exception{

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file.getInputStream());
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("cac:DespatchLine");
		System.out.println("----------------------------");

		traverseNodes(nList);

		return "OK";
	}

	@RequestMapping("/uploadfile")
	public ModelAndView uploadFile(){
		return new ModelAndView("uploadfile");
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addInvoicePage() {
		ModelAndView modelAndView = new ModelAndView("addFile");
		modelAndView.addObject("invoice", new Invoice());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingInvoice(@ModelAttribute Invoice invoice) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		invoiceService.addInvoice(invoice);
		
		String message = "Xml was successfully uploaded.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfInvoice() {
		ModelAndView modelAndView = new ModelAndView("listInvoices");
		
		List<Invoice> invoices = invoiceService.getInvoices();
		modelAndView.addObject("invoices", invoices);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editInvoicePage(@PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView("editInvoice");
		Invoice invoice = invoiceService.getInvoice(id);
		modelAndView.addObject("invoice",invoice);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingInvoice(@ModelAttribute Invoice invoice, @PathVariable String id) {
		
		ModelAndView modelAndView = new ModelAndView("home");

		invoice.setID(id);
		invoiceService.updateInvoice(invoice);
		
		String message = "Invoices was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteInvoice(@PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView("home");
		invoiceService.deleteInvoice(id);
		String message = "Invoice was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
