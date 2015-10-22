package com.cmsc128.OneVault_test;

import android.app.admin.DeviceAdminInfo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by radleyrosal on 10/22/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    //INITIALIZE DATABASE
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "transactions";

    //DECLARE INCOME TABLE
    private static final String TABLE_INCOME = "income";
    private static final String KEY_ID = "transac_id";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_PAYMETHOD = "payment_method";

    private static int TRANSACTION_ID = 00000;

    // CREATE INCOME TABLE
    public static final String CREATE_INCOME_TABLE = "CREATE TABLE " + TABLE_INCOME +
            "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_AMOUNT + " DOUBLE," + KEY_PAYMETHOD + " VARCHAR(30) )";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_INCOME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INCOME);

        onCreate(db);
    }

    // add new income transaction
    public void addIncome(Transaction transaction){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID , TRANSACTION_ID++);
        values.put(KEY_AMOUNT, transaction.getAmount());
        values.put(KEY_PAYMETHOD, transaction.getPayment_method());

        db.insert(TABLE_INCOME, null, values);
        db.close();
    }

//    public Transaction getIncomeTransaction(int id){
//        //TODO
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_INCOME, new String[] {KEY_ID, KEY_AMOUNT, KEY_PAYMETHOD}, KEY_ID + "=?",
//                new String[] {String.valueOf(id)}, null, null, null, null);
//
//        if(cursor!=null)
//            cursor.moveToFirst();
//
//        Transaction transaction = new Transaction(cursor.getDouble(1), cursor.getString(2) );
//
//        return transaction;
//    }

    // retrieve income transactions
    public ArrayList<Transaction> getAllIncomeTransactions(){

        ArrayList<Transaction> transactionList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_INCOME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Transaction transaction = new Transaction();
                transaction.setTransac_id(cursor.getInt(0));
                transaction.setAmount(cursor.getDouble(1));
                transaction.setPayment_method(cursor.getString(2));

                transactionList.add(transaction);
            }while(cursor.moveToNext());
        }

        return transactionList;
    }


    public int getIncomeTransactionCount(){
        String query = "SELECT * FROM " + TABLE_INCOME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.close();

        return cursor.getCount();
    }

//    public int updateIncomeTransaction(Transaction transaction){
//
//    }
//
//    public void deleteIncomeTransaction(Transaction transaction){
//
//    }
}
