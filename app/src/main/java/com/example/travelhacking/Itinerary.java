package com.example.travelhacking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Itinerary extends AppCompatActivity {

    String places = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary);


        Core.currentItinerary.display();
        places = Core.currentItinerary.print();
        TextView Itinerary = this.findViewById(R.id.Itinerary);
        Itinerary.setText(places);

    }
}
