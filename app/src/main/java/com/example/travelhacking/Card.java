package com.example.travelhacking;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.io.Serializable;

// This class details the Card object called in Add_Card.
public class Card implements Serializable
{
    public String  Name;
    public String  Date;
    public int     Spend;
    public int     points;
    private String key;
    private DatabaseReference ref;

    public Card(String Name, String Date, int Spend, int points)
    {
        this.Name = Name;
        this.Date = Date;
        this.Spend = Spend;
        this.points = points;
    }
// Empty Class for serialization
    public Card()
    {

    }

// Allows for firebase references to be stored for update.

    public void setKey(String key) {
        this.key = key;
        this.ref = Core.cards.child(this.key);

    }


// Saved Record to firebase
    public void save()
    {
        this.ref.setValue(this);
    }
//Delete record from firebase

    public void delete()
    {
        this.ref.removeValue();
    }

    public String toString()
    {
        return "Name: " + this.Name +
                " (" + this.Date + ") - Min Spend: "
                + this.Spend + " - Bonus: " + this.points;
    }
    public void display()
    {
        System.out.println("****"+ this.Name + " " + this.Date + " " + this.Spend + " " + this.points);
    }
}
