package com.example.travelhacking;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

// This class details the Card object called in Add_Card.
public class Card implements Serializable
{
    public String  Name;
    public String  Date;
    public int     Spend;
    public int     points;

    public Card(String Name, String Date, int Spend, int points)
    {
        this.Name = Name;
        this.Date = Date;
        this.Spend = Spend;
        this.points = points;
    }
    public Card()
    {

    }
    @Exclude
    public String getCreditName()
    {
        return Name;
    }
    @Exclude
    public String getStart_date() {
        return Date;
    }
    @Exclude
    public int getMin_spend() {
        return Spend;
    }
    @Exclude
    public int getPoint_bonus() {
        return points;
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
