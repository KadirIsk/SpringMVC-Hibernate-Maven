package com.sprhib.model;


import javax.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    private String ID;

    private int DespatchID;

    private int DeliveredQuantity;

    private int OrderLineReferanceID;

    private String ItemName;

    private String SellersIdentificaitonID;

    private int InvoiceQuantity;

    private int ExtensionAmount;

    private int Price;

    public Invoice(){}

    public Invoice(int quantity, int referanceID,
                   String itemName, String identificationID,
                   int invoiceQuantity, int amount, int price){
        this.DeliveredQuantity = quantity;
        this.OrderLineReferanceID = referanceID;
        this.ItemName = itemName;
        this.SellersIdentificaitonID = identificationID;
        this.InvoiceQuantity = invoiceQuantity;
        this.ExtensionAmount = amount;
        this.Price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getDespatchID() {
        return DespatchID;
    }

    public void setDespatchID(int despatchID) {
        DespatchID = despatchID;
    }

    public int getDeliveredQuantity() {
        return DeliveredQuantity;
    }

    public void setDeliveredQuantity(int deliveredQuantity) {
        DeliveredQuantity = deliveredQuantity;
    }

    public int getOrderLineReferanceID() {
        return OrderLineReferanceID;
    }

    public void setOrderLineReferanceID(int orderLineReferanceID) {
        OrderLineReferanceID = orderLineReferanceID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getSellersIdentificaitonID() {
        return SellersIdentificaitonID;
    }

    public void setSellersIdentificaitonID(String sellersIdentificaitonID) {
        SellersIdentificaitonID = sellersIdentificaitonID;
    }

    public int getInvoiceQuantity() {
        return InvoiceQuantity;
    }

    public void setInvoiceQuantity(int invoiceQuantity) {
        InvoiceQuantity = invoiceQuantity;
    }

    public int getExtensionAmount() {
        return ExtensionAmount;
    }

    public void setExtensionAmount(int extensionAmount) {
        ExtensionAmount = extensionAmount;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
