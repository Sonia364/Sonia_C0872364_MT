package com.sonia.sonia_c0872364_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener , View.OnClickListener {

    Spinner spinner;
    EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.carsList);
        price = findViewById(R.id.carPrice);

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cars, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        String selectedItem = String.valueOf(adapterView.getItemAtPosition(pos));
        String priceVal = "";
        switch (selectedItem){
            case "BMW":
                priceVal = "4000";
                break;
            case "Audi":
                priceVal = "6000";
                break;
            case "Cadillac":
                priceVal = "4500";
                break;
            case "Volks Wagon":
                priceVal = "5000";
                break;
            case "Mercedes":
                priceVal = "8000";
                break;
            case "Peugeot":
                priceVal = "6500";
                break;

        }
        price.setText(priceVal);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

    }
}