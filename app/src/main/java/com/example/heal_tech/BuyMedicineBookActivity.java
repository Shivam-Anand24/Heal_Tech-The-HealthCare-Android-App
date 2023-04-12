package com.example.heal_tech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heal_tech.model.LabTestBookActivity;

public class BuyMedicineBookActivity extends AppCompatActivity {

    EditText edname, edAddress,edContact,edPincode;
    Button btnBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edname=findViewById(R.id.editTextBMBFullName);
        edAddress=findViewById(R.id.editTextBMBAddress);
        edContact=findViewById(R.id.editTextBMBContactNumber);
        edPincode=findViewById(R.id.editTextBMBPinCode);
        btnBooking=findViewById(R.id.buttonBMBBOOK)

        Intent intent=getIntent();
        String[] price=intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date =intent.getStringExtra("date");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                Database db =new Database(getApplicationContext(),"Heal-tech",null,1);
                db.addOrder(username,edname.getText().toString().edaddress.getText(),edcontact.getText().toString()),date.toString().time.toString(),Float.parseFloat(price[1].toString()),"lab");
                db.removeCart(username,"medicine");
                Toast.makeText(getApplicationContext(),"Your booking is done Successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(BuyMedicineBookActivity.this, HomeActivity.class));
            }
        });
    }
}