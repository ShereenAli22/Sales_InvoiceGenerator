package com.Frame;

import java.util.Date;

public class Invoice {
    private int InvoiceNo;
    private Date InvoiceDate;
    private String CustomerName;
    private String ItemName;
    private double ItemPrice;
    private int Count;

    public int getInvoiceNo(){
        return InvoiceNo;
    }
    public Date getInvoiceDate(){
        return InvoiceDate;
    }
    public String getCustomerName(){
        return CustomerName;
    }
    public String getItemName(){
        return ItemName;
    }

    public double getItemPrice(){
        return ItemPrice;
    }
    public int getCount(){
        return Count;
    }

public void setInvoiceNo(int InvoiceNo){
 this.InvoiceNo=InvoiceNo;
}
    public void setCount(int Count){
        this.Count=Count;
    }
    public void setInvoiceDate(Date InvoiceDate){
        this.InvoiceDate=InvoiceDate;
    }
    public void setItemName(String ItemName){
        this.ItemName=ItemName;
    }

    public void setCustomerName(String CustomerName){
        this.CustomerName=CustomerName;
    }

    public void setItemPrice(double ItemPrice){
        this.ItemPrice=ItemPrice;
    }


}
