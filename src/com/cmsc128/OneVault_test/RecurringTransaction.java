package com.cmsc128.OneVault_test;

/**
 * Created by dcs-madl03 on 10/26/15.
 */

public class RecurringTransaction extends Transaction {
    protected int KEY_NOPAYMENTS;
    private int KEY_FREQUENCY;
    //private String KEY_REMINDER;
    //private Time KEY_TIMEREMINDER;

    RecurringTransaction(){}

    public RecurringTransaction(double KEY_AMOUNT, int KEY_DATE, int KEY_REF_CHECK, int KEY_NOPAYMENTS, String KEY_DESCRIPTION, double KEY_TAX,
                                int KEY_QUANTITY, String KEY_PAYER, String KEY_PAYMENTMETHOD, String KEY_STATUS, int KEY_FREQUENCY){
        this.KEY_AMOUNT = KEY_AMOUNT;
        this.KEY_DATE = KEY_DATE;
        this.KEY_REF_CHECK = KEY_REF_CHECK;
        this.KEY_DESCRIPTION = KEY_DESCRIPTION;
        this.KEY_TAX = KEY_TAX;
        this.KEY_QUANTITY = KEY_QUANTITY;
        this.KEY_PAYER = KEY_PAYER;
        this.KEY_PAYMENTMETHOD = KEY_PAYMENTMETHOD;
        this.KEY_STATUS = KEY_STATUS;
        this.KEY_NOPAYMENTS = KEY_NOPAYMENTS;
        this.KEY_FREQUENCY = KEY_FREQUENCY;
    }

    public int getKEY_NOPAYMENTS() {
        return KEY_NOPAYMENTS;
    }

    public void setKEY_NOPAYMENTS(int KEY_NOPAYMENTS) {
        this.KEY_NOPAYMENTS = KEY_NOPAYMENTS;
    }

    public int getKEY_FREQUENCY() {
        return KEY_FREQUENCY;
    }

    public void setKEY_FREQUENCY(int KEY_FREQUENCY) {
        this.KEY_FREQUENCY = KEY_FREQUENCY;
    }
}
