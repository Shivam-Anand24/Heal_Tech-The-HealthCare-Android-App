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
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {
TextView tvPackageName, tvTotalCost;
EditText edDetails;
Button buttonAddtocart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        buttonAddtocart=findViewById(R.id.buttonLDGoToCart);
        tvPackageName=findViewById(R.id.textViewCartpackageName);
        tvTotalCost=findViewById(R.id.textViewLDTotalCost);
        edDetails=findViewById(R.id.listviewLTMultiLine);
        edDetails.setKeyListener(null);
        Intent intent =getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost: "+intent.getStringExtra("text3")+"/-");


        getSupportActionBar().setHomeButtonEnabled(true);

    buttonAddtocart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
        }
    });

    buttonAddtocart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            SharedPreferences sharedPreferences=getSharedPreferences("shared prefs", Context.MODE_PRIVATE);
            String username=sharedPreferences.getString("username","").toString();
            String product=tvPackageName.getText().toString();
            float price = Float.parseFloat((intent.getStringExtra("text3").toString()));

           /* Database db =new Database(getApplicationContext(),"heal_tech",null,1);

            if(db.checkCart(username,product)==1) {
                Toast.makeText(getApplicationContext(), "Product Already Added", Toast.LENGTH_SHORT).show();
            }
            else{
                    db.addCart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext(),"Record Inserted to Cart",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
            }*/
            }

    });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        new Intent(LabTestDetailsActivity.this,HomeActivity.class);
    }
}
