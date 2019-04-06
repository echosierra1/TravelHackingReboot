package com.example.travelhacking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Months extends AppCompatActivity {
    private  Months myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);


        this.myContext = this;
    }

    public void onJAN(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "01";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }
    public void onFEB(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "02";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }
    public void onMAR(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "03";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }
    public void onAPR(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "04";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }
    public void onMAY(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "05";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }
    public void onJUN(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "06";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }
    public void onJUL(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "07";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }
    public void onAUG(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "08";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }
    public void onSEP(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "09";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }
    public void onOCT(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "10";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }
    public void onNOV(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "11";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }
    public void onDEC(View v)
    {
        Intent i = new Intent(myContext, directflightsMonths.class);
        Core.month = "12";
        Core.month = Core.month.replaceAll("\"", "");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        myContext.startActivity(i);
    }

}
