package com.cmsc128.OneVault_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class mainActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);
        DatabaseHandler db = new DatabaseHandler(this);

        ListView view = (ListView) findViewById(R.id.listView_transac);
        createListener(view);
        ArrayList<Transaction> e = db.getAllIncomeTransactions();
        ArrayList<String> transaction = new ArrayList<>();

        if(!e.isEmpty()) {
            for (Transaction t : e) {
               transaction.add("Date: " + t.getKEY_DATE() + "\nAmount: " + t.getKEY_AMOUNT() +
                    "\nDescription: " + t.getKEY_DESCRIPTION());
            }
        }
        else{
            transaction.add("No transactions at the moment");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, transaction);
        view.setAdapter(arrayAdapter);
//
    }

    private void createListener(ListView Listview) {
        Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) (Listview.getItemAtPosition(position));


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

    public void AddRecurring(View view){
        Intent intent = new Intent(this, AddRecurring.class);
        startActivity(intent);
    }
}
