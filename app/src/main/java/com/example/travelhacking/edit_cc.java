package com.example.travelhacking;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
// This class creates a second screen that will take the 4 edittext information pieces and create a
// local object Card with the entered information. This object is saved to a Credit Card
// reference in the firebase database.
public class edit_cc extends AppCompatActivity {


    private EditText CardName,  CardStartDate, MinSpend, RewardPoints;
    private edit_cc editcc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_cc);

        this.CardName = (EditText)this.findViewById(R.id.CardName);
        this.CardStartDate = (EditText)this.findViewById(R.id.CardStartDate);
        this.MinSpend = (EditText)this.findViewById(R.id.MinSpend);
        this.RewardPoints = (EditText)this.findViewById(R.id.RewardPoints);

        this.CardName.setText(Core.currentSelectedCard.Name);
        this.RewardPoints.setText(Core.currentSelectedCard.points + "");
        this.MinSpend.setText(Core.currentSelectedCard.Spend + "");
        this.CardStartDate.setText(Core.currentSelectedCard.Date);

    }

    public void onDeleteButtonPressed(View v)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure?");
        dialog.setTitle("WARNING!!!");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Core.currentSelectedCard.delete();
                editcc.finish();
            }
        });
        dialog.setNegativeButton("No", null);
        dialog.show();

    }

    public void onUpdateButtonPressed(View v)
    {
        Core.currentSelectedCard.Name = this.CardName.getText().toString();
        Core.currentSelectedCard.Date = this.CardStartDate.getText().toString();
        Core.currentSelectedCard.Spend = Integer.parseInt(this.MinSpend.getText().toString());
        Core.currentSelectedCard.points = Integer.parseInt(this.RewardPoints.getText().toString());;
        Core.currentSelectedCard.save();
        this.finish();

    }
}
