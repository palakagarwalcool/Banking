package com.example.bankpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SendingMoney extends AppCompatActivity {
int id;
EditText money;
int m;
Button transferMoney;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_money);
        money = findViewById(R.id.money);
        transferMoney = findViewById(R.id.transfermoney);
        transferMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SendingMoney.this,"Transferring Money........",Toast.LENGTH_SHORT).show();
                m = Integer.parseInt(money.getText().toString());
                Intent intent = new Intent(SendingMoney.this,SelectingCustomer.class);
                intent.putExtra("Money",m);
                getData();
                intent.putExtra("id",id);
                Toast.makeText(SendingMoney.this,"Money deducted from id no "+id+" .. Money deducted is Rs. "+m,Toast.LENGTH_SHORT).show();
                startActivity(intent);



            }
        });

    }
    void getData()
    {
        if(getIntent().hasExtra("id"))
        {
            id=getIntent().getIntExtra("id",1);

        }

    }

}