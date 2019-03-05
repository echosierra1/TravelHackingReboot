package com.example.travelhacking;
// This class details the Program object called in Add_Program.

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Program implements Serializable
{
    public String  Name;
    public String  Bank;
    public int     Balance;

    public Program(String Name, String Bank, int Balance)
    {
        this.Name = Name;
        this.Bank = Bank;
        this.Balance = Balance;


    }
    public Program()
    {


    }
    @Exclude
    public String getProgramName() {
        return Name;
    }
    @Exclude
    public String getProgramBank() {
        return Bank;
    }
    @Exclude
    public int getProgramBalance() {
        return Balance;
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
