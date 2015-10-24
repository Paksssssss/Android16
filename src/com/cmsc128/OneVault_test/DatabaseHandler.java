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
    //attributes
    private static final String KEY_ID = "transac_id"; //INTEGER
    private static final String KEY_AMOUNT = "amount"; // DOUBLE
    private static final String KEY_DATE = "date"; // DATETIME
    private static final String KEY_REF_CHECK = "ref_check"; // INTEGER
    private static final String KEY_DESCRIPTION = "description"; // VARCHAR(200)
    private static final String KEY_TAX = "tax"; //DOUBLE
    private static final String KEY_QUANTITY = "quantity"; //INTEGER
    private static final String KEY_PAYER = "payer"; //VARCHAR(30)

    //DECLARE EXPENSE TABLE
    private static final String TABLE_EXPENSE = "expense";
    //attributes
    private static final String KEY_ID_EXP = "transac_id"; //INTEGER
    private static final String KEY_AMOUNT_EXP = "amount"; // DOUBLE
    private static final String KEY_DATE_EXP = "date"; //DATETIME
    private static final String KEY_REF_CHECK_EXP = "ref_check"; // INTEGER
    private static final String KEY_DESCRIPTION_EXP = "description"; //VARCHAR(300)
    private static final String KEY_TAX_EXP = "tax";  //DOUBLE
    private static final String KEY_QUANTITY_EXP = "quantity"; //INTEGER
    private static final String KEY_PAYEE = "payee"; //VARCHAR(30)

    //DECLARE CUSTOM TABLE
    private static final String TABLE_CUSTOM = "custom_values";
    //attributes
    private static final String FKEY_ID_CUSTOM = "transac_id";
    private static final String KEY_UNIT ="unit";
    private static final String KEY_PAYMENTMETHOD = "payment_method";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_IS_INCOME_CUSTOM = "is_income";
    private static final String KEY_STATUS = "status";

    //DECLARE RECURRENCES
    private static final String TABLE_RECURRENCE = "recurrence";
    //attributes
    private static final String FKEY_ID_RECURRENCE = "transac_id";
    private static final String KEY_NO_PAYMENTS = "no_of_payment";
    private static final String KEY_FREQUENCY = "frequency";
    private static final String KEY_FIRST_PAYMENT = "first_payment";
    private static final String KEY_IS_INCOME_RECURRENCE = "is_income";

    //DECLARE ACCOUNT
    private static final String TABLE_ACCOUNT = "account";
    //attributes
    private static final String KEY_ID_ACCOUNT = "account_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION_ACCOUNT = "description";
    private static final String KEY_CURRENCY = "currency";
    private static final String KEY_INIT_BALANCE = "init_balance";
    private static final String KEY_HAS_CARD = "has_card";
    private static final String KEY_LIMIT = "card_limit";

    //DECLARE LOG
    private static final String TABLE_LOG = "log";
    //attributes
    private static final String KEY_ID_LOG = "log_id";
    private static final String FKEY_ACCOUNT_ID = "account_id";
    private static final String FKEY_TRANSAC_ID = "transac_id";



    // CREATE INCOME TABLE

    // CREATE EXPENSE TABLE

    // CREATE RECURRENCE TABLE

    // CREATE CUSTOM TABLE


    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(CREATE_INCOME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INCOME);

        onCreate(db);
    }


    /*
        INCOME QUERIES HERE
        CRUD Operations
        If there is a RetrieveAll method,  return an ArrayList
        E suwat ang parameters (input) then unsa iya e return
     */

    // add new income transaction
    public void addIncome(Transaction transaction){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        values.put(KEY_ID , TRANSACTION_ID++);
//        values.put(KEY_AMOUNT, transaction.getAmount());
//        values.put(KEY_PAYMETHOD, transaction.getPayment_method());

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
//    public ArrayList<Transaction> getAllIncomeTransactions(){
////        ArrayList<Transaction> transactionList = new ArrayList<>();
////        String query = "SELECT * FROM " + TABLE_INCOME;
////
////        SQLiteDatabase db = this.getWritableDatabase();
////        Cursor cursor = db.rawQuery(query, null);
////
////        if(cursor.moveToFirst()){
////            do{
////                Transaction transaction = new Transaction();
////                transaction.setTransac_id(cursor.getInt(0));
////                transaction.setAmount(cursor.getDouble(1));
////                transaction.setPayment_method(cursor.getString(2));
////
////                transactionList.add(transaction);
////            }while(cursor.moveToNext());
////        }
////
////        return transactionList;
//
//    }


//    public int getIncomeTransactionCount(){
//        String query = "SELECT * FROM " + TABLE_INCOME;
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//        cursor.close();
//
//        return cursor.getCount();
//    }

//    public int updateIncomeTransaction(Transaction transaction){
//
//    }
//
//    public void deleteIncomeTransaction(Transaction transaction){
//
//    }



     /*
        EXPENSE QUERIES HERE
        CRUD Operations
        If there is a RetrieveAll method,  return an ArrayList
        E suwat ang parameters (input) then unsa iya e return
     */

        //pakson


     /*
        RECURRENCES QUERIES HERE
        CRUD Operations
        If there is a RetrieveAll method,  return an ArrayList
        E suwat ang parameters (input) then unsa iya e return
     */

        //melgo


     /*
        CUSTOM QUERIES HERE
        CRUD Operations
        If there is a RetrieveAll method,  return an ArrayList
        E suwat ang parameters (input) then unsa iya e return
     */

       //melgo
}
