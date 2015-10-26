package com.cmsc128.OneVault_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


/**
 * Created by dcs-madl03 on 10/26/15.
 */
public class AddRecurring extends Activity {

    String payment_method[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addrecurringscreen);
    }
    public void SaveData(View view){

        ParseDataFromField();
        Intent intent = new Intent(this, mainActivity.class);
        startActivity(intent);
    }

    private void ParseDataFromField() {

        EditText amount = (EditText) findViewById(R.id.amount);
        EditText firstpaymentdate = (EditText) findViewById(R.id.firstpaymentdate);
        EditText nopayments = (EditText) findViewById(R.id.nopayments);
        EditText tax = (EditText) findViewById(R.id.tax);
        EditText frequency = (EditText) findViewById(R.id.frequency);
        EditText payer = (EditText) findViewById(R.id.payer);
        EditText description = (EditText) findViewById(R.id.description);

        RecurringTransaction newRecurringTransaction = new RecurringTransaction();
        newRecurringTransaction.setKEY_AMOUNT(Double.parseDouble(amount.getText().toString()));
        newRecurringTransaction.setKEY_DATE(Integer.parseInt(firstpaymentdate.getText().toString()));
        newRecurringTransaction.setKEY_NOPAYMENTS(Integer.parseInt(nopayments.getText().toString()));
        newRecurringTransaction.setKEY_TAX(Double.parseDouble(tax.getText().toString()));
        newRecurringTransaction.setKEY_FREQUENCY(Integer.parseInt(frequency.getText().toString()));
        newRecurringTransaction.setKEY_PAYER(payer.getText().toString());
        newRecurringTransaction.setKEY_DESCRIPTION(description.getText().toString());

        DatabaseHandler db = new DatabaseHandler(this);
        db.addIncome(newRecurringTransaction);
    }
}
