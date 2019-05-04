package com.example.travelhacking;

import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DatabaseReference;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;


public class YelpAPI extends Thread
{
    String CityState;
    YelpAPI myself;
    private ArrayAdapter<String> aa;
    private LinkedList<String> restaurantStrings;
    eatery places;

    public YelpAPI(String data, ArrayAdapter<String> aa, LinkedList<String> restaurantStrings)
    {
        CityState = data;
        this.myself = this;
        this.aa = aa;
        this.restaurantStrings = restaurantStrings;

        run();
    }

    public void run()
    {
        try
        {

            URL airportURL = new URL("https://api.yelp.com/v3/businesses/search?location=" + CityState +"&categories=restaurants");
            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            conn.setRequestProperty("Authorization", "Bearer VtfQ9hHIsB6WELRUjUKTQ5ZUtD5EBAN4Oe6Aix1ECE59jVYhm_Ea9T8tobLd0WB-OzTX-gEkt5MRm5PRzkoKzvm1kLVkFETl4XbLyIeO1yz5Lt-Yv89C4qBDz5_MXHYx");
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();
            System.out.println("*** DATA: " + data);
            JSONObject obj = new JSONObject(data);
            JSONArray businesses = obj.getJSONArray("businesses");
            for(int i = 0; i < businesses.length(); i++)
            {
                String name = businesses.getJSONObject(i).getString("name");
                String phone = businesses.getJSONObject(i).getString("display_phone");
                String URL = businesses.getJSONObject(i).getString("url");
                String picture = businesses.getJSONObject(i).getString("image_url");
                String reviews = businesses.getJSONObject(i).getString("review_count");
                String rating = businesses.getJSONObject(i).getString("rating");
                String address = businesses.getJSONObject(i).getString("location");

                String temp[] = address.split(",");
                address = temp[7] + temp[8] +temp[9];
                int foo = address.length() -2;
                address = address.substring(19, foo);

                address = address.replaceAll("\"", " ");


                eatery places = new eatery(name, address, phone, reviews, URL, picture, rating);
                Core.eatery.add(places);

                restaurantStrings.add(name);
                System.out.println("*** " + name);
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
            System.out.println("*** " + e.toString());
        }
    }
}