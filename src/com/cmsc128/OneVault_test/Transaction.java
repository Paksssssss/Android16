package com.cmsc128.OneVault_test;

/**
 * Created by radleyrosal on 10/22/2015.
 */
public class Transaction {

    private int transac_id;
    private double amount;
    private String payment_method;

    Transaction(){}

    public Transaction(double amount, String payment_method){
        this.setTransac_id(transac_id);
        this.setAmount(amount);
        this.setPayment_method(payment_method);
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
