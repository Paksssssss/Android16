package com.cmsc128.OneVault_test;

import android.app.admin.DeviceAdminInfo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private static final String KEY_PAYMENT_METHOD_EXP = "payment_method"; // DOUBLE
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
    public static final String CREATE_EXPENSE_TABLE = "CREATE TABLE " + TABLE_EXPENSE +
            "(" + KEY_ID_EXP + " INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " + KEY_AMOUNT_EXP + " DOUBLE,"+KEY_PAYMENT_METHOD_EXP +
            " STRING,"+ KEY_DATE_EXP + " DATETIME, "+KEY_REF_CHECK_EXP+" INTEGER,"+KEY_DESCRIPTION_EXP+" VARCHAR(300), "
            +KEY_TAX_EXP+" DOUBLE, "+KEY_QUANTITY_EXP+" INTEGER, "+KEY_PAYEE+" VARCHAR(30), )ENGINE=InnoDB AUTO_INCREMENT=16598";
    // CREATE RECURRENCE TABLE

    // CREATE CUSTOM TABLE


    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EXPENSE_TABLE);
        //db.db.execSQL(CREATE_INCOME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSE);

        onCreate(db);
    }


    /*
        INCOME QUERIES HERE
        CRUD Operations
        If there is a RetrieveAll method,  return an ArrayList
        E suwat ang parameters (input) then unsa iya e return
     */

    // add new income transaction
//    public void addIncome(Transaction transaction){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
////        values.put(KEY_ID , TRANSACTION_ID++);
////        values.put(KEY_AMOUNT, transaction.getAmount());
////        values.put(KEY_PAYMETHOD, transaction.getPayment_method());
//
//        db.insert(TABLE_INCOME, null, values);
//        db.close();
//    }

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
    //Create Expense
     public void addExpenseTransaction(Transaction transaction){
         SQLiteDatabase db = this.getWritableDatabase();

         ContentValues values = new ContentValues();
         values.put(KEY_AMOUNT_EXP, transaction.getPayment_amount());
         values.put(KEY_PAYMENT_METHOD_EXP, transaction.getPayment_method());
         values.put(KEY_DATE_EXP, String.valueOf(transaction.getPayment_date()));
         values.put(KEY_REF_CHECK_EXP, transaction.getPayment_ref_chck());
         values.put(KEY_DESCRIPTION_EXP, transaction.getPayment_description());
         values.put(KEY_TAX_EXP, transaction.getPayment_tax());
         values.put(KEY_QUANTITY_EXP, transaction.getPayment_quantity());
         values.put(KEY_PAYEE, transaction.getPayment_payee_payer());

         db.insert(TABLE_EXPENSE, null, values);
         db.close();
     }

     //retrieve a specific expense transaction
     public Transaction getExpenseTransaction(int id)throws ParseException {
        //TODO
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_EXPENSE + "WHERE KEY_ID_EXP = "+id;
        Cursor cursor = db.rawQuery(query,null);

        if(cursor!=null)
            cursor.moveToFirst();

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = sdf1.parse(cursor.getString(3));
        Date dates = new Date(date.getTime());
        Transaction transaction = new Transaction(cursor.getInt(0), cursor.getDouble(1),
                cursor.getString(2),dates,cursor.getInt(4),cursor.getString(5),
                cursor.getDouble(6),cursor.getInt(7),cursor.getString(8));
        return transaction;
     }

    // retrieve all expense transactions
     public ArrayList<Transaction> getAllExpenseTransactions() throws ParseException {
        ArrayList<Transaction> transactionList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_EXPENSE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Transaction transaction = new Transaction();
                transaction.setTransac_id(cursor.getInt(0));
                transaction.setPayment_amount(cursor.getDouble(1));
                transaction.setPayment_method(cursor.getString(2));
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date date = sdf1.parse(cursor.getString(3));
                transaction.setPayment_date(new java.sql.Date(date.getTime()));
                transaction.setPayment_ref_chck(cursor.getInt(4));
                transaction.setPayment_description(cursor.getString(5));
                transaction.setPayment_tax(cursor.getDouble(6));
                transaction.setPayment_quantity(cursor.getInt(7));
                transaction.setPayment_payee_payer(cursor.getString(8));

                transactionList.add(transaction);
            }while(cursor.moveToNext());
        }

        return transactionList;

     }

    //update a specific expense transaction
    public void updateExpenseTransaction(Transaction transaction){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, transaction.getTransac_id());
        values.put(KEY_AMOUNT_EXP, transaction.getPayment_amount());
        values.put(KEY_PAYMENT_METHOD_EXP, transaction.getPayment_method());
        values.put(KEY_DATE_EXP, String.valueOf(transaction.getPayment_date()));
        values.put(KEY_REF_CHECK_EXP, transaction.getPayment_ref_chck());
        values.put(KEY_DESCRIPTION_EXP, transaction.getPayment_description());
        values.put(KEY_TAX_EXP, transaction.getPayment_tax());
        values.put(KEY_QUANTITY_EXP, transaction.getPayment_quantity());
        values.put(KEY_PAYEE, transaction.getPayment_payee_payer());

        String[] string = {Integer.toString(transaction.getTransac_id())};

        db.update(TABLE_EXPENSE,values,KEY_ID,string);
        db.close();


    }

    //delete all expense transactions
    public void deleteAllExpenseTransactions(){
        String query = "DELETE FROM " + TABLE_EXPENSE;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(query);
        db.close();

    }

    //delete a specific expense transaction
    public void deleteExpenseTransaction(int id){
        String[] string = {Integer.toString(id)};
        this.getWritableDatabase().delete(TABLE_EXPENSE,KEY_ID_EXP,string);
    }

    //get the numbers of transactions
    public int getExpenseTransactionCount(){
        String query = "SELECT * FROM " + TABLE_EXPENSE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.close();

        return cursor.getCount();
    }

     /*
        RECURRENCES QUERIES HERE
        CRUD Operations
        If there is a RetrieveAll method,  return an ArrayList
        E suwat ang parameters (input) then unsa iya e return
     */




     /*
        CUSTOM QUERIES HERE
        CRUD Operations
        If there is a RetrieveAll method,  return an ArrayList
        E suwat ang parameters (input) then unsa iya e return
     */


}
