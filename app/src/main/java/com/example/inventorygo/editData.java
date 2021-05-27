package com.example.inventorygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.myDbClass;
import model.DATA;

public class editData extends AppCompatActivity {
    EditText name;
    EditText price;
    EditText amount;
    EditText supplier;
    EditText sContact;
    Button del;
    String pos;
    int iD;
    DATA data;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        final myDbClass db = new myDbClass(getApplicationContext());

            del = findViewById(R.id.button2);
        name =  findViewById(R.id.name);
        price =  findViewById(R.id.price);
        amount =  findViewById(R.id.amount);
        supplier = findViewById(R.id.supplier);
        sContact = findViewById(R.id.sContact);

        button = findViewById(R.id.createn);

        final Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        price.setText(intent.getStringExtra("price"));
        amount.setText(intent.getStringExtra("amount"));
        supplier.setText(intent.getStringExtra("supplier"));
        sContact.setText(intent.getStringExtra("sContact"));

        pos = intent.getStringExtra("iD");
        iD = Integer.parseInt(pos);




        data = new DATA();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setName(name.getText().toString());
                data.setPrice(price.getText().toString());
                data.setAmount(amount.getText().toString());
                data.setSupplier(supplier.getText().toString());
                data.setsContact(sContact.getText().toString());

                data.setId(pos);
                db.updateData(data);

                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(editData.this, "Your Data has been saved", Toast.LENGTH_SHORT).show();
                getApplicationContext().startActivity(intent1);


            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteDataById(pos);

                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(editData.this, "Item has been deleted", Toast.LENGTH_SHORT).show();
                getApplicationContext().startActivity(intent1);

            }
        });


    }
}