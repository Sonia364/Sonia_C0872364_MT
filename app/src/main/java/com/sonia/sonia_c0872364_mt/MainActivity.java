package com.sonia.sonia_c0872364_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener , View.OnClickListener {

    Spinner spinner;
    EditText price;
    SeekBar seekbar;
    int days = 1;
    TextView daysTextVal;
    RadioGroup radio_group;
    RadioButton radioBtn;
    CheckBox gps;
    CheckBox childSeat;
    CheckBox unlimitedMillage;
    int age;
    final int Tax = 13;

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
//                Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
//                        Toast.LENGTH_SHORT).show();
            }
        });

        // radio button functionality

        findViewById(R.id.lessRadio).setOnClickListener(this);
        findViewById(R.id.betweenRadio).setOnClickListener(this);
        findViewById(R.id.aboveRadio).setOnClickListener(this);

        radio_group.setOnClickListener(
                v->{
                    int selectedId= radio_group.getCheckedRadioButtonId();
                    radioBtn = findViewById(selectedId);
                    age = Integer.parseInt(String.valueOf(radioBtn.getText()));
                    //Toast.makeText(MainActivity.this,radioBtn.getText(),Toast.LENGTH_SHORT).show();
                }
        );
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