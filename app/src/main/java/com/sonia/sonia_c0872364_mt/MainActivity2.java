package com.sonia.sonia_c0872364_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        ArrayList<String> myStrings = intent.getStringArrayListExtra("rentDetails");


        ArrayAdapter<String> adapter = new ArrayAdapter(
                MainActivity2.this,
                android.R.layout.simple_list_item_1,
                myStrings
        );

        ListView list = findViewById(R.id.listDetail);
        list.setAdapter(adapter);
    }
}