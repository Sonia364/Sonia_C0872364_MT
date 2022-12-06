package com.sonia.sonia_c0872364_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener , View.OnClickListener {

    Spinner spinner;
    EditText price;
    SeekBar seekbar;
    int days = 0;
    TextView daysTextVal;
    RadioGroup radio_group;
    RadioButton radioBtn;
    CheckBox gps;
    CheckBox childSeat;
    CheckBox unlimitedMillage;
    String age;
    final int TAX = 13;
    String priceVal;
    EditText amountVal;
    EditText totalPayment;
    Button viewBtn;
    ArrayList<String> rentInfo;
    String selectedItem;
    String checkItems;
    int rentAmount = 0;
    int totalAmount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.carsList);
        price = findViewById(R.id.carPrice);
        seekbar = findViewById(R.id.daysSeekbar);
        daysTextVal = findViewById(R.id.daysText);
        radio_group = findViewById(R.id.radioGroup);
        gps = findViewById(R.id.gpsCheckbox);
        childSeat = findViewById(R.id.childCheckbox);
        unlimitedMillage = findViewById(R.id.unlimitedCheckbox);
        amountVal = findViewById(R.id.amount);
        totalPayment = findViewById(R.id.totalPayment);
        viewBtn = findViewById(R.id.viewBtn);


        //  spinner functionality
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cars, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // seekbar functionality
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                days = progressChangedValue;
                daysTextVal.setText(String.valueOf(days));
            }
        });

        // radio button functionality

        findViewById(R.id.lessRadio).setOnClickListener(this);
        findViewById(R.id.betweenRadio).setOnClickListener(this);
        findViewById(R.id.aboveRadio).setOnClickListener(this);

        // checkbox functionality
        gps.setOnClickListener(
                v->{
                    if(gps.isChecked()){
                        calculateAmount();
                        checkItems = "GPS";
                    }
                }
        );
        childSeat.setOnClickListener(
                v->{
                    if(childSeat.isChecked()){
                        calculateAmount();
                        checkItems = "Child Seat";
                    }
                }
        );
        unlimitedMillage.setOnClickListener(
                v->{
                    if(unlimitedMillage.isChecked()){
                        calculateAmount();
                        checkItems = "Unlimited Millage";
                    }
                }
        );

        // view button functionality
        viewBtn.setOnClickListener(
                v ->{
                    if(selectedItem.equals("Please choose a car") || days == 0 || age.isEmpty()){
                        Toast.makeText(this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        ArrayList<String> myStrings = new ArrayList<>();
                        myStrings.add("Selected Car is: "+ selectedItem);
                        myStrings.add("Rent is: "+ priceVal);
                        myStrings.add("Rent for days : "+ days);
                        myStrings.add("Age is: "+ age);
                        myStrings.add("Options: "+ checkItems);
                        myStrings.add("Amount is: "+ rentAmount);
                        myStrings.add("Total Payment is: "+ totalAmount);
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("rentDetails", myStrings);
                        startActivity(intent);
                    }

                }
        );
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        selectedItem = String.valueOf(adapterView.getItemAtPosition(pos));
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lessRadio:
                age = "Less than 20";
                break;
            case R.id.betweenRadio:
                age = "Between 21 and 60";
                break;
            case R.id.aboveRadio:
                age = "Above 60";
                break;
        }
        calculateAmount();

    }


    public void calculateAmount(){
          rentAmount = Integer.parseInt(priceVal);
            switch (age){
                case "Less than 20":
                    rentAmount = rentAmount + 5;
                    break;
                case "Above 60":
                    rentAmount = rentAmount - 10;
                    break;
            }
        if(gps.isChecked()){
            rentAmount += 5;
        }
        if(childSeat.isChecked()){
            rentAmount += 7;
        }
        if(unlimitedMillage.isChecked()){
            rentAmount += 10;
        }

         amountVal.setText(String.valueOf(rentAmount));
         int taxAmount = (rentAmount * TAX)/100;
         totalAmount = rentAmount + taxAmount;
         totalPayment.setText(String.valueOf(totalAmount));
    }





}