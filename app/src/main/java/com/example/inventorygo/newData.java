package com.example.inventorygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.myDbClass;
import model.DATA;

public class newData extends AppCompatActivity {
    EditText name;
    EditText price;
    EditText amount;
    EditText supplier;
    EditText sContact;

    int id;
    DATA data;
    Button button;
    Button del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_data);
        final myDbClass db = new myDbClass(newData.this);
        data = new DATA();


        name =  findViewById(R.id.name);
        price =  findViewById(R.id.price);
        amount =  findViewById(R.id.amount);
        supplier = findViewById(R.id.supplier);
        sContact = findViewById(R.id.sContact);
        button = findViewById(R.id.createn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   data.setName(name.getText().toString());
                   data.setPrice(price.getText().toString());
                   data.setAmount(amount.getText().toString());
                   data.setSupplier(supplier.getText().toString());
                   data.setsContact(sContact.getText().toString());

                   db.addDATA(data);

                   Intent intent1 = new Intent(newData.this,MainActivity.class);
                   intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   Toast.makeText(newData.this, "Your Data has been saved", Toast.LENGTH_SHORT).show();
                   getApplicationContext().startActivity(intent1);

               }catch (Exception e){
                   Log.d("ERR NEW",e.toString());
                   Toast.makeText(newData.this, "Please Enter complete Credentials", Toast.LENGTH_SHORT).show();

               }

            }
            });


}
}