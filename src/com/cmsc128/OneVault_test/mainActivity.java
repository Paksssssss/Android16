package com.cmsc128.OneVault_test;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class mainActivity extends Activity {

    TransactionDBHelper dbHelper = new TransactionDBHelper(getBaseContext());
    SQLiteDatabase db = dbHelper.getReadableDatabase();

    String projection[] = {
            TransactionFeed.FeedEntry.COL_NAME_AMOUNT,
            TransactionFeed.FeedEntry.COL_PAY_METHOD
    };


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//        ListView listView = (ListView) findViewById(R.id.listView_transac);
//        Cursor c = db.query(
//                TransactionFeed.FeedEntry.TABLE_NAME,
//                projection,
//                null,
//                null,
//                null,
//                null,
//                TransactionFeed.FeedEntry.COL_NAME_AMOUNT + " DESC"
//        );
//
//        String values[] = new String[c.getCount()];
//        int i = 0;
//        while(!c.isClosed()){
//            values[i++] = c.getDouble(0) + c.getString(1);
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1, android.R.id.text1, values
//        );
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
