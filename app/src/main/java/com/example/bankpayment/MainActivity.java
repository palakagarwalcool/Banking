package com.example.bankpayment;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
FloatingActionButton add_button;
MySqliteHelper mydb;
ArrayList<String> name;
ArrayList id;
CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        add_button=findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MySqliteHelper(MainActivity.this);
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });
        mydb=new MySqliteHelper(MainActivity.this);

        name = new ArrayList<>();
        id = new ArrayList();

        storeDataInArray();
        customAdapter = new CustomAdapter(MainActivity.this,name,id);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
    void storeDataInArray()
    {
        Cursor cursor = mydb.readAllData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();

        }
        else
        {
            while(cursor.moveToNext())
            {
                name.add(cursor.getString(1));
                id.add(cursor.getInt(0));
            }
        }
    }
}