package com.example.list_searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MonthDetail extends AppCompatActivity {

    TextView txtMonthName,txtDays,txtHour;
    int days;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_detail);

        getSupportActionBar().setTitle("Showing Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtMonthName=findViewById(R.id.monthName);
        txtDays = findViewById(R.id.txtDays);
        txtHour = findViewById(R.id.txtHours);

        Intent intent=getIntent();
        txtMonthName.setText(intent.getStringExtra("select"));
        String monthName=txtMonthName.getText().toString();

        if (monthName.equals("April")
        ||monthName.equals("June")
        ||monthName.equals("September")
        ||monthName.equals("November")){
            days=30;
            txtDays.setText(txtDays.getText()+" "+days);

        }else if(monthName.equals("February")){
            days=28;
            txtDays.setText(txtDays.getText()+" "+days);
        }
        else{
            days=31;
            txtDays.setText(txtDays.getText()+" "+days);
        }
        txtHour.setText(txtHour.getText()+" "+days*24);


    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}