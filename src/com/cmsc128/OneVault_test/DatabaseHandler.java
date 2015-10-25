package com.cmsc128.OneVault_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by radleyrosal on 10/22/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    //INITIALIZE DATABASE
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "transactions";

    // column ids for each attributes
    private final int INDEX_INCOME_ID = 0;
    private final int INDEX_INCOME_AMOUNT = 1;
    private final int INDEX_INCOME_DATE = 2;
    private final int INDEX_INCOME_REF_CHECK = 3;
    private final int INDEX_INCOME_DESCRIPTION = 4;
    private final int INDEX_INCOME_TAX = 5;
    private final int INDEX_INCOME_QUANTITY = 6;
    private final int INDEX_INCOME_PAYER = 7;

    //DECLARE INCOME TABLE
    private static final String TABLE_INCOME = "income";
    //attributes
    private static final String KEY_ID_INCOME = "transac_id"; //INTEGER
    private static final String KEY_AMOUNT_INCOME = "amount"; // DOUBLE
    private static final String KEY_DATE_INCOME = "date"; // DATETIME
    private static final String KEY_REF_CHECK_INCOME = "ref_check"; // INTEGER
    private static final String KEY_DESCRIPTION_INCOME = "description"; // VARCHAR(200)
    private static final String KEY_TAX_INCOME = "tax"; //DOUBLE
    private static final String KEY_QUANTITY_INCOME = "quantity"; //INTEGER
    private static final String KEY_PAYER_INCOME = "payer"; //VARCHAR(30)

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
    private static final String CREATE_INCOME_TABLE =
            "CREATE TABLE " + TABLE_INCOME + " (" + KEY_ID_INCOME + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_AMOUNT_INCOME + " DOUBLE, " + KEY_DATE_INCOME + " DATETIME, " + KEY_REF_CHECK_INCOME + " INTEGER, " +
                    KEY_DESCRIPTION_INCOME + " VARCHAR(200), " + KEY_TAX_INCOME + " DOUBLE, " + KEY_QUANTITY_INCOME + " INTEGER, " +
                    KEY_PAYER_INCOME + " VARCHAR(30))";

    // CREATE EXPENSE TABLE

    // CREATE RECURRENCE TABLE

    // CREATE CUSTOM TABLE


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

        values.put(KEY_AMOUNT_INCOME, transaction.getKEY_AMOUNT());
        values.put(KEY_DATE_INCOME, transaction.getKEY_DATE());
        values.put(KEY_REF_CHECK_INCOME, transaction.getKEY_REF_CHECK());
        values.put(KEY_DESCRIPTION_INCOME, transaction.getKEY_DESCRIPTION());
        values.put(KEY_TAX_INCOME, transaction.getKEY_TAX());
        values.put(KEY_QUANTITY_INCOME, transaction.getKEY_QUANTITY());
        values.put(KEY_PAYER_INCOME, transaction.getKEY_PAYER());

        db.insert(TABLE_INCOME, null, values);
        db.close();
    }

    public Transaction getIncomeTransaction(int id){
        //TODO
        return null;
    }


    public ArrayList<Transaction> getAllIncomeTransactions(){
        ArrayList<Transaction> transactionList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_INCOME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Transaction transaction = new Transaction();
                transaction.setKEY_AMOUNT(cursor.getDouble(INDEX_INCOME_AMOUNT));
                transaction.setKEY_DATE(cursor.getInt(INDEX_INCOME_DATE));
                transaction.setKEY_REF_CHECK(cursor.getInt(INDEX_INCOME_REF_CHECK));
                transaction.setKEY_DESCRIPTION(cursor.getString(INDEX_INCOME_DESCRIPTION));
                transaction.setKEY_TAX(cursor.getDouble(INDEX_INCOME_TAX));
                transaction.setKEY_QUANTITY(cursor.getInt(INDEX_INCOME_QUANTITY));
                transaction.setKEY_PAYER(cursor.getString(INDEX_INCOME_PAYER));
                transactionList.add(transaction);
            }while(cursor.moveToNext());
        }

        return transactionList;

    }

    // return income transaction count
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
