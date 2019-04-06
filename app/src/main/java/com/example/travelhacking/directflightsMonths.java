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



public class directflightsMonths extends AppCompatActivity {
    private AirportCodeCache acc;
    private ListView directflights;
    private ArrayAdapter<String> df;
    private directflightsMonths myContext;
    private LinkedList<String> ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directflights_months);
        this.myContext = this;


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

            Intent i = new Intent(myContext, directflightsMonths.class);
            i.putExtra("airportCode", parts[parts.length-1].trim());
            String cityName = "";
            for(int j = 0; j < parts.length-1; j++)
            {
                cityName = cityName + parts[j] + " ";
            }
            i.putExtra("cityName", cityName);

            myContext.startActivity(i);
        }
    });


    String cityName = this.getIntent().getStringExtra("cityName");
    String airportCode = this.getIntent().getStringExtra("airportCode").replaceAll("\"","");
    Airportcode.setText(this.getIntent().getStringExtra("airportCode").replaceAll("\"",""));
    String Months = Core.month;
    AirportDestinationThreadMonths adt = new AirportDestinationThreadMonths(airportCode, ll, df, Months);
        adt.setPriority(Thread.MAX_PRIORITY);
        adt.start();
        Airportcode.setText(cityName + " - " + airportCode + " - Month: "+ Months);




}


}








