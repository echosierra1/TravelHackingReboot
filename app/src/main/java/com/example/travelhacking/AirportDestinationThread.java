package com.example.travelhacking;

import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DatabaseReference;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

public class AirportDestinationThread extends Thread
{
    private String airportCode;
    private LinkedList<String> destinationStrings;
    private ArrayAdapter<String> aa;
    private AirportDestinationThread myself;
    public AirportDestinationThread(String airportCode, LinkedList<String> destinationStrings, ArrayAdapter<String> aa)
    {
        this.airportCode = airportCode;
        this.destinationStrings = destinationStrings;
        this.aa = aa;
        this.myself = this;
    }

    //get the data from screen scraping, add it to the linked list, and notify the array adapter
    public void run()
    {
        try
        {
            URL airportURL = new URL("https://www.flightsfrom.com/" + this.airportCode + "/destinations");
           // System.out.println("***airportURL: " + airportURL);

            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();
          //  System.out.println("*** HAVE DATA!!!!!");
           // System.out.println("***" + data);
            String[] parts = data.split("airport-content-destination-list-name");
            String beforeVal = "destination-search-item\">";
            String afterVal = "</span>";
            int beforeIndex, afterIndex;

            for(String part : parts)
            {
                beforeIndex = part.indexOf(beforeVal);
                if(beforeIndex != -1)
                {
                    beforeIndex += beforeVal.length();
                    afterIndex = part.indexOf(afterVal, beforeIndex);
                  //  System.out.println("***substrings:" + part.substring(beforeIndex, afterIndex));
                    Core.flights.add(part.substring(beforeIndex,afterIndex));
                }
            }
         //   System.out.println("*** Done");

            new Handler(Looper.getMainLooper()).post(new Runnable () {
                @Override
                public void run () {
                    myself.aa.notifyDataSetChanged();
                    DatabaseReference ref = Core.database.getReference("airport_code_cache").child(myself.airportCode.toUpperCase());
                    ref.setValue(Core.flights);
                }
            });


        }
        catch(Exception e)
        {
            System.out.println("***error" + e.toString());
        }
    }
}