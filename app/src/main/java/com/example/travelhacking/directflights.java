package com.example.travelhacking;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.LinkedList;

public class directflights extends AppCompatActivity
{

    private AirportCodeCache acc;
    private ListView directflights;
    private ArrayAdapter<String> df;
    private directflights myContext;
    private LinkedList<String> ll;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.myContext = this;
        setContentView(R.layout.activity_directflights);
        TextView Airportcode = this.findViewById(R.id.Airporrtcode);
        Airportcode.setText(this.getIntent().getStringExtra("airportcode"));
        this.directflights = this.findViewById(R.id.directflights);
        df = new ArrayAdapter<String>(this, R.layout.activity_airportrow, Core.flights);
        this.directflights.setAdapter(df);

        this.directflights.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                String selectedairport = Core.flights.get(position);

                String[] parts = selectedairport.split(" ");

                Intent i = new Intent(myContext, directflights.class);
                i.putExtra("airportCode", parts[parts.length-1].trim());
                String cityName = "";
                for(int j = 0; j < parts.length-1; j++)
                {
                    cityName = cityName + parts[j] + " ";
                }
                i.putExtra("cityName", cityName);
                Core.currentItinerary.push(selectedairport);

                myContext.startActivity(i);
            }
        });


        String cityName = this.getIntent().getStringExtra("cityName");
        String airportCode = this.getIntent().getStringExtra("airportCode").replaceAll("\"","");
        Airportcode.setText(this.getIntent().getStringExtra("airportCode").replaceAll("\"",""));
        AirportDestinationThread adt = new AirportDestinationThread(airportCode, ll, df);
        adt.setPriority(Thread.MAX_PRIORITY);
        adt.start();
        Airportcode.setText(cityName + " - " + airportCode);

        this.acc = new AirportCodeCache(airportCode);
        acc.getData(df , ll);



    }

    public void onDisplayItineraryButtonPressed(View v)
    {
        Intent i = new Intent(myContext, Itinerary.class);
        startActivity(i);

    }

    public void onMonthButtonPressed(View v)
    {
        Intent i = new Intent(myContext, Months.class);
        String airportCode = this.getIntent().getStringExtra("airportCode");
        String cityName = this.getIntent().getStringExtra("cityName");
        i.putExtra("cityName", cityName);
        i.putExtra("airportCode", airportCode);
        startActivity(i);
    }

    @Override
    public void onBackPressed()
    {
        Core.currentItinerary.pop();
        super.onBackPressed();
    }

    public void onReloadCacheButtonPressed(View v)
    {
        this.acc.clearCache(this.df, this.ll);
    }
}