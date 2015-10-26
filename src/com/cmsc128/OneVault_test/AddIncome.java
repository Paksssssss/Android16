package com.cmsc128.OneVault_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by radleyrosal on 10/22/2015.
 */
public class AddIncome extends Activity {

    String payment_method[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addincomescreen);
    }

    public void SaveData(View view){

        ParseDataFromField();
        Intent intent = new Intent(this, mainActivity.class);
        startActivity(intent);
    }

    private void ParseDataFromField() {

        EditText amount = (EditText) findViewById(R.id.field_amount);
        EditText date = (EditText) findViewById(R.id.field_date);
        EditText ref_no = (EditText) findViewById(R.id.field_ref);
        EditText tax = (EditText) findViewById(R.id.field_tax);
        EditText payer = (EditText) findViewById(R.id.field_payee);

        Transaction newTransaction = new Transaction();
        newTransaction.setKEY_AMOUNT(Double.parseDouble(amount.getText().toString()));
        newTransaction.setKEY_DATE(Integer.parseInt(date.getText().toString()));
        newTransaction.setKEY_REF_CHECK(Integer.parseInt(ref_no.getText().toString()));
        newTransaction.setKEY_TAX(Double.parseDouble(tax.getText().toString()));
        newTransaction.setKEY_PAYER(payer.getText().toString());

        DatabaseHandler db = new DatabaseHandler(this);
        db.addIncome(newTransaction);
    }

}