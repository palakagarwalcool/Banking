package com.example.bankpayment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectingCustomer extends AppCompatActivity {
    MySqliteHelper db;
    ArrayList name;
    ArrayList id;
    RecyclerView recyclerView;
    CustomAdapter2 customAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting_customer);
        recyclerView=findViewById(R.id.recyclerViewselection);
        db = new MySqliteHelper(SelectingCustomer.this);
        name = new ArrayList();
        id = new ArrayList();
        displayData();
        customAdapter2 = new CustomAdapter2(SelectingCustomer.this,name,id);
        recyclerView.setAdapter(customAdapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(SelectingCustomer.this));
    }
    void displayData()
    {
        Cursor cursor = db.readAllData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(SelectingCustomer.this,"No data",Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                id.add(cursor.getInt(0));
                name.add(cursor.getString(1));
            }
        }
    }
}