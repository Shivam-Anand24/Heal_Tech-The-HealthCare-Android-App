package com.example.heal_tech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.heal_tech.model.LabTestBookActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class CartLabActivity extends AppCompatActivity {

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    TextView tvTotal;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton, btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_lab);

        dateButton=findViewById(R.id.buttonCartDatePicker);
        timeButton=findViewById(R.id.buttonCartTime);
        btnCheckout=findViewById(R.id.buttonCheckoutBMCart);

        /*

        lst =findViewById(R.id.listviewCart);
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username =sharedPreferences.getString("username","").toString();

        Database db =new Database(getApplicationContext()."Heal-Tech",null,1);

        float totalAmount=0;
        ArrayList dbData = db.getCartData(username,"lab");
        Toast.makeText(getApplicationContext(),""+dbData,Toast.LENGTH_SHORT).show();

        packages =new String[dbData.size()][];
        for(int i=0;i<packages.length;i++)
        {
            packages[i]=new String[5];
        }
        for (int i=0;i<dbData.size();i++)
        {
            String arrData dbData.get(i).toString();
            String[] strData=arrData.split(java.util.regex.Pattern.quote("$"));
            packages[i][0]=strData[0];
            packages[i][4]="Cost : "+strData[1]+"/-";
            totalAmount=totalAmount+Float.parseFloat(strData[1]);
        }
        tvTotal.setText("Total Cost : "+totalAmount);

        list=new ArrayList();
        for (int i=0;i<packages.length;i++)
        {
            item=new HashMap<String, String>();
            item.put("line1", package[i][0]);
            item.put("line2", package[i][1]);
            item.put("line3", package[i][2]);
            item.put("line4", package[i]3);
            item.put("line5", package[i][4]);
            list.add(item);

        }

        sa=new SimpleAdapter(this,list.R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_c,R.id.line_e});


        lst.setAdapter(sa);



         */
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartLabActivity.this, LabTestBookActivity.class));

                Intent it =new Intent(CartLabActivity.this,LabTestBookActivity.class);
                it.putExtra("price",tvTotal.getText());
                it.putExtra("date",tvTotal.getText());
                it.putExtra("time",timeButton.getText());
                startActivity(it);
            }
        });




        //datepicker
        //initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        //timePicker
        //initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

    }
}