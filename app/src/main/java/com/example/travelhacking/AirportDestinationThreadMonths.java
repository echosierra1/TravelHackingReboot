package com.example.travelhacking;

import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DatabaseReference;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

public class AirportDestinationThreadMonths extends Thread
{
    private String airportCode;
    private String Month;
    private AirportDestinationThreadMonths myself;
    private ArrayAdapter<String> aa;



    public AirportDestinationThreadMonths(String airportCode, LinkedList<String> destinationStrings, ArrayAdapter<String> aa, String Months)
    {
        this.airportCode = airportCode;
        this.Month = Core.month;
        this.aa = aa;
        aa.clear();
        this.myself = this;

    }

    public void run()
    {

        try
        {
            URL airportURL = new URL("https://www.flightsfrom.com/" + airportCode + "/destinations?Method=dateFrom=2019-" + Month + "&dateTo=2019-" + Month);
                 System.out.println("***https://www.flightsfrom.com/" + airportCode + "/destinations?Method=dateFrom=2019-" + Month + "&dateTo=2019-" + Month);

            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            //System.out.println("***" + data);
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
//                    System.out.println("***" + part.substring(beforeIndex, afterIndex));
                    Core.flights.add(part.substring(beforeIndex,afterIndex));

                }
            }
            new Handler(Looper.getMainLooper()).post(new Runnable () {
                @Override
                public void run () {
                    myself.aa.notifyDataSetChanged();
                }
            });
        }
        catch(Exception e)
        {
            System.out.println("***" + e.toString());
        }
    }
}