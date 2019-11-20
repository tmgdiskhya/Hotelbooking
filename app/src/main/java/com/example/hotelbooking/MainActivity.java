package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Spinner Spinner1, Spinner2;
    TextView tvcheckin, tvcheckout, tvresult;
    EditText enadults, enchildren, enrooms;
    Button btncalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindProperties();
    }

    public void bindProperties() {
        Spinner1 = findViewById(R.id.Spinner1);
        Spinner2 = findViewById(R.id.Spinner2);
        tvcheckin = findViewById(R.id.tvcheckin);
        tvcheckout = findViewById(R.id.tvcheckout);
        enadults = findViewById(R.id.enadults);
        enchildren = findViewById(R.id.enchildren);
        enrooms = findViewById(R.id.enrooms);
        btncalculate = findViewById(R.id.btncalculate);
        tvresult = findViewById(R.id.tvresult);

        //For Spinner
        String location[] = {"Kathmandu", "Chitwan", "Bhaktapur"};
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, location);
        Spinner1.setAdapter(adapter);

        String Room[] = {"Delux", "AC", "Platinum"};
        ArrayAdapter adapterRoom = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Room);
        Spinner2.setAdapter(adapterRoom);

        Spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, Spinner1.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, Spinner2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tvcheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePickerCheckIn();
            }
        });

        tvcheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePickerCheckOut();
            }
        });
        //ButtonCalculate
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adult, children, room, result, vat, charge;
                adult = Integer.parseInt(enadults.getText().toString());
                children = Integer.parseInt(enchildren.getText().toString());
                room = Integer.parseInt(enrooms.getText().toString());

            }
        });
    }

    //DatePicker
    private void loadDatePickerCheckIn() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = "Year/Month/Day:" + year + "/" + month + "/" + dayOfMonth;
                tvcheckin.setText(date);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void loadDatePickerCheckOut() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date1 = "Year/Month/Day:" + year + "/" + month + "/" + dayOfMonth;
                tvcheckout.setText(date1);
            }
        }, year, month, day);
        datePickerDialog1.show();
    }
}

