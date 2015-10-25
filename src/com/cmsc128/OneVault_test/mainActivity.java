package com.cmsc128.OneVault_test;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class mainActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DatabaseHandler db = new DatabaseHandler(this);
        ListView view = (ListView) findViewById(R.id.listView_transac);
        createListener(view);
        ArrayList<Transaction> e = null;
        try {
            e = db.getAllExpenseTransactions();
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        ArrayList<String> transaction = new ArrayList<>();

        if(!e.isEmpty()) {
            for (Transaction t : e) {
                transaction.add("Transaction ID:  " + t.getTransac_id() + "\nAmount: " + t.getPayment_amount() +
                         "\nPayment Method: " + t.getPayment_method() + "\nDate: " + t.getPayment_date() +
                        "\nReference/cheque: " + t.getPayment_ref_chck() + "\nDescription: " + t.getPayment_description() +
                        "\nTax: " + t.getPayment_tax() + "\nQuantity: " + t.getPayment_quantity() +
                        "\nPayee: " + t.getPayment_payee_payer());
            }
        }
        else{
            transaction.add("There are no transactions at the moments");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, transaction);
        view.setAdapter(arrayAdapter);

    }

    private void createListener(ListView Listview) {
        Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) (Listview.getItemAtPosition(position));
                selectedItem = selectedItem.replaceAll("\\s" , "");

            }
        });
    }

    public void AddExpenses(View view){
        //intent will trigger an activity
        //An Intent is an object that provides runtime binding between separate components
        // (such as two activities).
        // The Intent represents an app�s "intent to do something."
        // You can use intents for a wide variety of tasks, but most often they�re used to start another activity.
        Intent intent = new Intent(this, AddExpense.class);
        startActivity(intent);
    }
}
