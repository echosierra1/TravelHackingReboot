package com.example.travelhacking;

public class Program
{
    private String  Name;
    private String  Bank;
    private int     Balance;

    public Program(String Name, String Bank, int Balance)
    {
        this.Name = Name;
        this.Bank = Bank;
        this.Balance = Balance;


    }
    public Program()
    {
        this.Name = "Name";
        this.Bank =  "Bank";
        this.Balance = -1;

    }

    public String getName() {
        return Name;
    }

    public String getBank() {
        return Bank;
    }

    public int getBalance() {
        return Balance;
    }
    public String toString()
    {
        return "Name: " + this.Name + "Bank: "
                + this.Bank + " Balance: " + this.Balance;
    }
    public void display()
    {

        System.out.println(this.Name + " " + this.Bank + " " + this.Balance);
    }
}
