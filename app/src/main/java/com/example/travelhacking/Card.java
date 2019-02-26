package com.example.travelhacking;

// This class details the Card object called in Add_Card.
public class Card
{
    private String  Name;
    private String  Date;
    private int     Spend;
    private int     points;

    public Card(String Name, String Date, int Spend, int points)
    {
        this.Name = Name;
        this.Date = Date;
        this.Spend = Spend;
        this.points = points;
    }
    public Card()
    {
        this.Name = "Name";
        this.Date = "Start Date";
        this.Spend = -1;
        this.points = -1;
    }

    public String getName()
    {
        return Name;
    }

    public String getStart_date() {
        return Date;
    }

    public int getMin_spend() {
        return Spend;
    }

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
        System.out.println(this.Name + " " + this.Date + " " + this.Spend + " " + this.points);
    }
}
