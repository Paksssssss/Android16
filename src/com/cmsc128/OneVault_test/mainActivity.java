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
        ArrayList<Transaction> e = db.getAllIncomeTransactions();
        ArrayList<String> transaction = new ArrayList<>();

        if(!e.isEmpty()) {
            for (Transaction t : e) {
                transaction.add("Transaction ID:  " + t.getTransac_id() + "\nAmount: " + t.getAmount() +
                        "\nPayment Method: " + t.getPayment_method());
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

    public void AddIncome(View view){
        //intent will trigger an activity
        //An Intent is an object that provides runtime binding between separate components
        // (such as two activities).
        // The Intent represents an app’s "intent to do something."
        // You can use intents for a wide variety of tasks, but most often they’re used to start another activity.
        Intent intent = new Intent(this, AddIncome.class);
        startActivity(intent);
    }
}
