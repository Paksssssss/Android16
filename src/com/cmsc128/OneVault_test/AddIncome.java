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

/**
 * Created by radleyrosal on 10/22/2015.
 */
//public class AddIncome extends Activity {
//
//    String payment_method[];
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.addincomelayout);
//
//        payment_method = new String[3];
//        payment_method[0] = "Cash";
//        payment_method[1] = "Credit Card";
//        payment_method[2] = "Check";
//
//        Spinner s = (Spinner) findViewById(R.id.spin_paymethod);
//        ArrayAdapter adapter = new ArrayAdapter(
//                this, android.R.layout.simple_spinner_dropdown_item, payment_method);
//        s.setAdapter(adapter);
//    }
//
//    public void ReturnMain(View view){
//
//        DatabaseHandler db = new DatabaseHandler(this);
//        EditText editText = (EditText) findViewById(R.id.field_amount);
//        Spinner s = (Spinner) findViewById(R.id.spin_paymethod);
//
//        double amount = Double.parseDouble(editText.getText().toString());
//        String method = s.getSelectedItem().toString();
//        Transaction transaction = new Transaction(amount, method);
//
//        db.addIncome(transaction);
//
//        Intent intent = new Intent(this, mainActivity.class);
//        startActivity(intent);
//    }
//
//}