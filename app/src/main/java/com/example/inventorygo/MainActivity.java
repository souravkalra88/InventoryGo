package com.example.inventorygo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import adapter.RecyclerViewAdapter;
import data.myDbClass;
import model.DATA;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    List<DATA> dll;
    Button button;
    Button delAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final myDbClass db = new myDbClass(MainActivity.this);


             delAll = findViewById(R.id.deleteAll);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        button = findViewById(R.id.create);


        delAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete All")
                        .setMessage("Do you want to delete all the data! ")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {

                                db.deleteAll();
                                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                startActivity(intent);
                            }})
                        .setNegativeButton(android.R.string.no, null).show();

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,newData.class);
                startActivity(intent);
            }
        });





         dll = db.getAll();
        for(DATA d : dll){
            Log.d("FINAL", "ID " + d.getId() + "\n" + "Name " + d.getName() + " price " + d.getPrice());
        }
        Log.d("LAST" , "" + db.getCount());

        adapter = new RecyclerViewAdapter(MainActivity.this, dll);
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(adapter);

        Log.d("dbSK", "Bro you have "+ db.getCount()+ " contacts in your database");


    }
}