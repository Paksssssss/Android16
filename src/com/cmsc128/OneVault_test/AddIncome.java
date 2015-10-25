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
public class AddIncome extends Activity {

    String payment_method[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addincomelayout);
    }

    public void SaveData(View view){
        Intent intent = new Intent(this, mainActivity.class);
        startActivity(intent);
    }

}