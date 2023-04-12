package com.example.heal_tech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BuyMedicineDetailsActivity extends AppCompatActivity {

    TextView tvPackageName,tvTotalcost;
    EditText edDetails;
    Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        tvPackageName=findViewById(R.id.textViewBMDcartTitle);
        edDetails=findViewById(R.id.TextviewBMDMultiLine);
        edDetails.setKeyListener(null);
        tvTotalcost=findViewById(R.id.textViewBMDTotalCost);
        btnAddToCart=findViewById(R.id.buttonBMDGoToCart);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalcost.setText("Total Cost : " +intent.getStringExtra("text3")+"/-");

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineDetailsActivity.this,BuyMedicineAcivity.class));
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username =sharedPreferences.getString("username","").toString();
                String product=tvPackageName.getText().toString();
                float price= Float.parseFloat(intent.getStringExtra("text3").toString());
            }
        });

    }
}