package com.cmsc128.OneVault_test;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by radleyrosal on 10/22/2015.
 */
public class AddExpense extends Activity {
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    String payment_method[];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addexpenselayout);


        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        payment_method = new String[3];
        payment_method[0] = "Cash";
        payment_method[1] = "Credit Card";
        payment_method[2] = "Check";

        Spinner s = (Spinner) findViewById(R.id.spin_paymethod);
        ArrayAdapter adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_dropdown_item, payment_method);
        s.setAdapter(adapter);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Set Date", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            year = arg1;
            month = arg2 +1;
            day = arg3;
            System.out.println(year);
            System.out.println(month);
            System.out.println(day);
        }
    };

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

        Date date = new Date(year,month,day);

        Transaction transaction = new Transaction(amount, method,date,refOrCheck,description,tax,quantity,payee,tags);

        db.addExpenseTransaction(transaction);

        Intent intent = new Intent(this, mainActivity.class);
        startActivity(intent);
    }

}