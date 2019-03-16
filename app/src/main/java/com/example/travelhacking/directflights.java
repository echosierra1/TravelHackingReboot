package com.example.travelhacking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class directflights extends AppCompatActivity {

    private ListView directflights;
    private ArrayAdapter<String> df;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directflights);
        this.directflights = this.findViewById(R.id.directflights);
        df = new ArrayAdapter<String>(this, R.layout.activity_airportrow, Core.flights);
        this.directflights.setAdapter(df);
        while(Core.done ==0)
        {
            if(Core.done ==1) {
                df.notifyDataSetChanged();
            }
        }

    }
}
