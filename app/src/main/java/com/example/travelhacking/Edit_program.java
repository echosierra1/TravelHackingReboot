package com.example.travelhacking;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
// This class creates a second screen that will take the 3 edittext information pieces and create a
// local object Program with the entered information. This object is saved to a loyalty program
// references in the firebase database.
public class Edit_program extends AppCompatActivity {

    private EditText LoyaltyName,  BankAffiliation, CurrentBalance;
    private edit_cc editprogram;


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
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure?");
        dialog.setTitle("WARNING!!!");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Core.currentSelectedProgram.delete();
                editprogram.finish();
            }
        });
        dialog.setNegativeButton("No", null);
        dialog.show();

    }

    public void onUpdateButtonPressed(View v)
    {
        Core.currentSelectedProgram.Name = this.LoyaltyName.getText().toString();
        Core.currentSelectedProgram.Bank = this.BankAffiliation.getText().toString();
        Core.currentSelectedProgram.Balance = Integer.parseInt(this.CurrentBalance.getText().toString());
        Core.currentSelectedProgram.save();
        this.finish();

    }




}
