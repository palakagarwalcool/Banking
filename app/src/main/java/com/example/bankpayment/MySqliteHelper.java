package com.example.bankpayment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MySqliteHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME="BankingPayment.db";


    public MySqliteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table Customers ( id integer primary key autoincrement , name text , email text , balance integer)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Customers");
        onCreate(db);

    }
    void addCustomer(String name,String email,int balance)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name",name);
        cv.put("email",email);
        cv.put("balance",balance);
        long result = db.insert("Customers", null, cv);
        if(result == -1)
        {
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"Added Successfully!",Toast.LENGTH_SHORT).show();
        }

    }
    Cursor readAllData()
    {
        String query = "select * from Customers";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null)
        {
            cursor = db.rawQuery(query,null);

        }
        return cursor;

    }
}
