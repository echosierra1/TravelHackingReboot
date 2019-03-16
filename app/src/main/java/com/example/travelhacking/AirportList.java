package com.example.travelhacking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class AirportList extends AppCompatActivity
{
    private ListView airport;
    private LinkedList<String> theAirportStrings = new LinkedList<String>();
    private LinkedList<Airport> theAirports = new LinkedList<Airport>();
    private ArrayAdapter<String> aa;
    private EditText filter;
    private AirportList myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_list);
        this.myContext = this;

        this.filter = this.findViewById(R.id.filter);
        this.airport = this.findViewById(R.id.airport);
        aa = new ArrayAdapter<String>(this, R.layout.activity_airportrow, this.theAirportStrings);
        this.airport.setAdapter(aa);

        this.airport.setClickable(true);
        this.airport.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                Airport selectedairport = theAirports.get(position);
                Core.airportcode = selectedairport.airportCode;
                Core.airportcode = Core.airportcode.replaceAll("\"", "");
                NetworkThread nt = new NetworkThread(Core.airportcode);
                nt.start();
                Intent in = new Intent(myContext, directflights.class);
                myContext.startActivity(in);

            }
        });

        DatabaseReference ref = Core.database.getReference("world_airports");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                Airport temp;
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    temp = ds.getValue(Airport.class);
                    theAirports.add(temp);
                    theAirportStrings.add(temp.toString());
                }
                aa.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
    }

    public void onFilterButtonPressed(View v)
    {
        String filterString = this.filter.getText().toString();
        this.theAirportStrings.clear();
        for(Airport a : this.theAirports)
        {
            if(a.filterApplies(filterString))
            {
                this.theAirportStrings.add(a.toString());
            }
        }
     aa.notifyDataSetChanged();
    }
}