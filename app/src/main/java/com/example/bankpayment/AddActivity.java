package com.example.bankpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
EditText name,email,balance;
Button savebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name=findViewById(R.id.editTextTextPersonName);
        email=findViewById(R.id.Email);
        balance=findViewById(R.id.current_balance);
        savebutton=findViewById(R.id.addbutton);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySqliteHelper mydb = new MySqliteHelper(AddActivity.this);
                mydb.addCustomer(name.getText().toString().trim(),
                        email.getText().toString().trim(),
                        Integer.valueOf(balance.getText().toString().trim()));
            }
        });
    }
}