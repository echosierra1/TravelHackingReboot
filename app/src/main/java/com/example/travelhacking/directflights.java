package com.example.travelhacking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class directflights extends AppCompatActivity {

    private ListView directflights;
    private ArrayAdapter<String> df;
    private directflights myContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.myContext = this;
        setContentView(R.layout.activity_directflights);
        TextView Airportcode = this.findViewById(R.id.Airporrtcode);
        Airportcode.setText(this.getIntent().getStringExtra("airportcode"));
        this.directflights = this.findViewById(R.id.directflights);
        df = new ArrayAdapter<String>(this, R.layout.activity_airportrow, Core.flights);
        this.directflights.setAdapter(df);
        while(Core.done ==0)
        {
            if(Core.done ==1) {
                df.notifyDataSetChanged();
            }
        }

        this.directflights.setClickable(true);
        this.directflights.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                String selectedairport = Core.flights.get(position);
                Core.airportcode = Core.airportcode.replaceAll("\"", "");
                String[] airporttxt = selectedairport.split(" ");
                Core.airportcode = airporttxt[2];
                NetworkThread nt = new NetworkThread(Core.airportcode);
                nt.setPriority(Thread.MAX_PRIORITY);
                nt.start();
                Intent in = new Intent(myContext, directflights.class);
                in.putExtra("airportcode", Core.airportcode);
                myContext.startActivity(in);
            }
        });
    }



}
