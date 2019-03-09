package com.example.travelhacking;
// This class details the Program object called in Add_Program.

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Program implements Serializable
{
    public String  Name;
    public String  Bank;
    public int     Balance;
    private String key;
    private DatabaseReference ref;

    public Program(String Name, String Bank, int Balance)
    {
        this.Name = Name;
        this.Bank = Bank;
        this.Balance = Balance;


    }
    public Program()
    {


    }


    public void setKey(String key) {
        this.key = key;
        this.ref = Core.programs.child(this.key);

    }
    public void save()
    {
        this.ref.setValue(this);
    }

    public void delete()
    {
        this.ref.removeValue();
    }
    public String toString()
    {
        return "Name: " + this.Name + "Bank: "
                + this.Bank + " Balance: " + this.Balance;
    }
    public void display()
    {

        System.out.println("****" + this.Name + " " + this.Bank + " " + this.Balance);
    }
}
