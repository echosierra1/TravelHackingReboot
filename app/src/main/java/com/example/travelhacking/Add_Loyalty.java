package com.example.travelhacking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
// This class creates a second screen that will take the 3 edittext information pieces and create a
// local object Program with the entered information. This object is saved to a loyalty program
// Linked List.
public class Add_Loyalty extends AppCompatActivity {

    private EditText LoyaltyName,  BankAffiliation, CurrentBalance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__loyalty);

        this.LoyaltyName = (EditText)this.findViewById(R.id.LoyaltyName);
        this.BankAffiliation = (EditText)this.findViewById(R.id.BankAffiliation);
        this.CurrentBalance = (EditText)this.findViewById(R.id.CurrentBalance);

    }
    // This function creates the Program object by converting the edit texts to strings and an int,
    // saving them to a Program object built from the Program class,
    // and calls Core to save Program to a linked list.
    public void onAddLoyalty(View v)
    {
        String LoyaltyName = this.LoyaltyName.getText().toString();
        String BankAffiliation = this.BankAffiliation.getText().toString();
        int CurrentBalance = Integer.parseInt(this.CurrentBalance.getText().toString());

        Program p = new Program(LoyaltyName,BankAffiliation,CurrentBalance);
        Core.addLoyaltyProgram(p);
        this.finish();
    }


}
