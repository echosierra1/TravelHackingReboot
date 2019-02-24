package com.example.travelhacking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
