package com.berkhayta;

import java.util.UUID;

public class Customer {
    private String customerID;
    private String customerName;
    private String customerSurname;
    private String customerPhone;
    private String customerMail;

    public Customer(String customerName, String customerSurname, String customerPhone, String customerMail) {
        this.customerID = UUID.randomUUID().toString();
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerPhone = customerPhone;
        this.customerMail = customerMail;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerMail='" + customerMail + '\'' +
                '}';
    }
}
