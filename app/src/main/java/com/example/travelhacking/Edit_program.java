package com.example.travelhacking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
// This class creates a second screen that will take the 3 edittext information pieces and create a
// local object Program with the entered information. This object is saved to a loyalty program
// Linked List.
public class Edit_program extends AppCompatActivity {

    private EditText LoyaltyName,  BankAffiliation, CurrentBalance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_program);

        this.LoyaltyName = (EditText)this.findViewById(R.id.LoyaltyName);
        this.BankAffiliation = (EditText)this.findViewById(R.id.BankAffiliation);
        this.CurrentBalance = (EditText)this.findViewById(R.id.CurrentBalance);

        this.LoyaltyName.setText(Core.currentSelectedProgram.Name);
        this.BankAffiliation.setText(Core.currentSelectedProgram.Bank + "");
        this.CurrentBalance.setText(Core.currentSelectedProgram.Balance + "");

    }

    public void onDeleteButtonPressed(View v)
    {
        Core.currentSelectedProgram.delete();
        this.finish();
    }

    public void onUpdateButtonPressed(View v)
    {
        String LoyaltyName = this.LoyaltyName.getText().toString();
        String BankAffiliation = this.BankAffiliation.getText().toString();
        int CurrentBalance = Integer.parseInt(this.CurrentBalance.getText().toString());
        Core.currentSelectedProgram.delete();
        Program p = new Program(LoyaltyName,BankAffiliation,CurrentBalance);
        Core.addLoyaltyProgramDB(p);
        this.finish();

    }




}
