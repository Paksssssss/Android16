package com.cmsc128.OneVault_test;

import java.sql.Date;

/**
 * Created by radleyrosal on 10/22/2015.
 */
public class Transaction {

    private int transac_id;
    private double payment_amount;
    private String payment_method;
    private Date payment_date;
    private int payment_ref_chck;
    private String payment_description;
    private double payment_tax;
    private int payment_quantity;
    private String payment_payee_payer;
    Transaction(){}

    public Transaction( double payment_amount,
                       String payment_method, Date payment_date,
                       int payment_ref_chck, String payment_description,
                       double payment_tax, int payment_quantity,
                       String payment_payee_payer) {
        this.payment_amount = payment_amount;
        this.payment_method = payment_method;
        this.payment_date = payment_date;
        this.payment_ref_chck = payment_ref_chck;
        this.payment_description = payment_description;
        this.payment_tax = payment_tax;
        this.payment_quantity = payment_quantity;
        this.payment_payee_payer = payment_payee_payer;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public int getTransac_id() {
        return transac_id;
    }

    public void setTransac_id(int transac_id) {
        this.transac_id = transac_id;
    }

    public double getPayment_amount() {return payment_amount;}

    public void setPayment_amount(double payment_amount) {this.payment_amount = payment_amount;}

    public Date getPayment_date() {return payment_date;}

    public void setPayment_date(Date payment_date) {this.payment_date = payment_date;}

    public int getPayment_ref_chck() {return payment_ref_chck;}

    public void setPayment_ref_chck(int payment_ref_chck) {this.payment_ref_chck = payment_ref_chck;}

    public String getPayment_description() {return payment_description;}

    public void setPayment_description(String payment_description) {this.payment_description = payment_description;}

    public double getPayment_tax() {return payment_tax;}

    public void setPayment_tax(double payment_tax) {this.payment_tax = payment_tax;}

    public int getPayment_quantity() {return payment_quantity;}

    public void setPayment_quantity(int payment_quantity) {this.payment_quantity = payment_quantity;}

    public String getPayment_payee_payer() {return payment_payee_payer;}

    public void setPayment_payee_payer(String payment_payee_payer) {this.payment_payee_payer = payment_payee_payer;}
}
