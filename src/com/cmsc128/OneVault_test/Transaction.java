package com.cmsc128.OneVault_test;

/**
 * Created by radleyrosal on 10/22/2015.
 */
public class Transaction {

    private int KEY_QUANTITY;
    private int KEY_DATE; // DATETIME
    private int KEY_REF_CHECK;
    private double KEY_AMOUNT ;
    private double KEY_TAX;
    private String KEY_PAYER;
    private String KEY_DESCRIPTION;

    Transaction(){}

    public Transaction(double KEY_AMOUNT, int KEY_DATE, int KEY_REF_CHECK, String KEY_DESCRIPTION, double KEY_TAX,
                       int KEY_QUANTITY, String KEY_PAYER){
        this.KEY_AMOUNT = KEY_AMOUNT;
        this.KEY_DATE = KEY_DATE;
        this.KEY_REF_CHECK = KEY_REF_CHECK;
        this.KEY_DESCRIPTION = KEY_DESCRIPTION;
        this.KEY_TAX = KEY_TAX;
        this.KEY_QUANTITY = KEY_QUANTITY;
        this.KEY_PAYER = KEY_PAYER;
    }

    public double getKEY_AMOUNT() {
        return KEY_AMOUNT;
    }

    public void setKEY_AMOUNT(double KEY_AMOUNT) {
        this.KEY_AMOUNT = KEY_AMOUNT;
    }

    public int getKEY_DATE() {
        return KEY_DATE;
    }

    public void setKEY_DATE(int KEY_DATE) {
        this.KEY_DATE = KEY_DATE;
    }

    public int getKEY_REF_CHECK() {
        return KEY_REF_CHECK;
    }

    public void setKEY_REF_CHECK(int KEY_REF_CHECK) {
        this.KEY_REF_CHECK = KEY_REF_CHECK;
    }

    public String getKEY_DESCRIPTION() {
        return KEY_DESCRIPTION;
    }

    public void setKEY_DESCRIPTION(String KEY_DESCRIPTION) {
        this.KEY_DESCRIPTION = KEY_DESCRIPTION;
    }

    public double getKEY_TAX() {
        return KEY_TAX;
    }

    public void setKEY_TAX(double KEY_TAX) {
        this.KEY_TAX = KEY_TAX;
    }

    public int getKEY_QUANTITY() {
        return KEY_QUANTITY;
    }

    public void setKEY_QUANTITY(int KEY_QUANTITY) {
        this.KEY_QUANTITY = KEY_QUANTITY;
    }

    public String getKEY_PAYER() {
        return KEY_PAYER;
    }

    public void setKEY_PAYER(String KEY_PAYER) {
        this.KEY_PAYER = KEY_PAYER;
    }
}
