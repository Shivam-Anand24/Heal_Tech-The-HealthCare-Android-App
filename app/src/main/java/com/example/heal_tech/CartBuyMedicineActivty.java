package com.example.heal_tech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;

public class CartBuyMedicineActivty extends AppCompatActivity {

    HashMap list;
    SimpleAdapter sa;
    TextView tvTotal;
    ListView lst;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton,btnCheckout, btnBack;
    private String[][] packages= {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_buy_medicine_activty);

        dateButton=findViewById(R.id.buttonCartDatePicker);
        btnCheckout=findViewById(R.id.buttonCheckoutBMCart);
        tvTotal=findViewById(R.id.textViewBMCartTotalPrice);
        lst=findViewById(R.id.listViewBMCart);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent( CartBuyMedicineActivty.this,BuyMedicineBookActivity.class);
                it.putExtra("price",tvTotal.getText());
                it.putExtra("date",dateButton.getText());

                startActivity(it);
            }
        });

        //datePicker

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
    }
}