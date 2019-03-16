package com.example.travelhacking;

import com.google.firebase.database.DatabaseReference;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

public class NetworkingthreadLoad extends Thread{

    public void run()
    {
        try
        {
            URL airportURL = new URL("http://ourairports.com/data/airports.csv");

            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";
            LinkedList<Airport> ll = new LinkedList<>();

            DatabaseReference ref = Core.database.getReference("world_airports");
            Airport temp;
            while(input.hasNextLine())
            {
                String[] parts = input.nextLine().split(",");
                if(parts.length >=14){
                    temp = new Airport(parts[3],parts[8], parts[9], parts[10], parts[13]);

                    if(temp.airportCode.length() >0)
                    {
                        ll.add(temp);
                    }
                }

            }
            System.out.println("***Number of Airports" + ll.size());
            ref.setValue(ll);
            System.out.println("*** Done");

        }
        catch(Exception e)
        {
            System.out.println("***" + e.toString());
        }
    }
}