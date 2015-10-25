package com.cmsc128.OneVault_test;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.Date;

/**
 * Created by radleyrosal on 10/22/2015.
 */
public class AddExpense extends Activity {

    String payment_method[];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addexpenselayout);


        payment_method = new String[3];
        payment_method[0] = "Cash";
        payment_method[1] = "Credit Card";
        payment_method[2] = "Check";

        Spinner s = (Spinner) findViewById(R.id.spin_paymethod);
        ArrayAdapter adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_dropdown_item, payment_method);
        s.setAdapter(adapter);
    }

    public void ReturnMain(View view){

        DatabaseHandler db = new DatabaseHandler(this);
        EditText editText = (EditText) findViewById(R.id.field_amount);
        Spinner s = (Spinner) findViewById(R.id.spin_paymethod);

        double amount = Double.parseDouble(editText.getText().toString());
        String method = s.getSelectedItem().toString();

        editText = (EditText) findViewById(R.id.field_refOrChck);
        int refOrCheck = Integer.parseInt(editText.getText().toString());

        editText = (EditText) findViewById(R.id.field_description);
        String description = editText.getText().toString();

        editText = (EditText) findViewById(R.id.field_tax);
        double tax = Double.parseDouble(editText.getText().toString());

        editText = (EditText) findViewById(R.id.field_quantity);
        int quantity = Integer.parseInt(editText.getText().toString());

        editText = (EditText) findViewById(R.id.field_payee);
        String payee = editText.getText().toString();

        editText = (EditText) findViewById(R.id.field_tags);
        String tags = editText.getText().toString();

        Date date = new Date(2012,10,11);

        Transaction transaction = new Transaction(amount, method,date,refOrCheck,description,tax,quantity,payee,tags);

        db.addExpenseTransaction(transaction);

        Intent intent = new Intent(this, mainActivity.class);
        startActivity(intent);
    }

}