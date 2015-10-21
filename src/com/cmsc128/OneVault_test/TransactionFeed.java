package com.cmsc128.OneVault_test;

import android.provider.BaseColumns;

/**
 * Created by radleyrosal on 10/22/2015.
 */
public final class TransactionFeed {

    public TransactionFeed(){}

    public static abstract class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "income";
        public static final String COL_TRANS_ID = "transac_id";
        public static final String COL_NAME_AMOUNT = "amount";
        public static final String COL_PAY_METHOD = "payment_method";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry.COL_TRANS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FeedEntry.COL_NAME_AMOUNT + " DOUBLE," +
                    FeedEntry.COL_PAY_METHOD + " VARCHAR(30) )";

    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
}
