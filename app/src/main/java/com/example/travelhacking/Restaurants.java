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

public class Restaurants extends AppCompatActivity {

    private ListView restaurants;
    private TextView restaurantsTitle;
    private Restaurants myContext;
    private ArrayAdapter<String> aa;
    private LinkedList<String> restaurantsstrings = new LinkedList<>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);



        this.myContext = this;

        this.restaurantsTitle = this.findViewById(R.id.restaurantsTitle);
        String CityState = Core.curtree.payload.city + ", " + Core.curtree.payload.region.split("-")[1];
        CityState = CityState.replaceAll("\"", "");
        restaurantsTitle.setText(CityState);

        this.restaurants = this.findViewById(R.id.restaurants);
        aa = new ArrayAdapter<String>(this, R.layout.activity_airportrow, this.restaurantsstrings);
        this.restaurants.setAdapter(aa);


        this.restaurants.setClickable(true);
        this.restaurants.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                eatery selectedeatery = Core.eatery.get(position);

                Intent in = new Intent(myContext, yelpDetails.class);
                Core.selectedeatery = selectedeatery;
                myContext.startActivity(in);

            }
        });

        YelpAPI Yelp = new YelpAPI(CityState,aa, restaurantsstrings);
        Yelp.setPriority(Thread.MAX_PRIORITY);
        Yelp.start();
    }
}