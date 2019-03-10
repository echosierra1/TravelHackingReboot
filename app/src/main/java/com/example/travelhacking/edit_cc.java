package com.example.travelhacking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
// This class creates a second screen that will take the 4 edittext information pieces and create a
// local object Card with the entered information. This object is saved to a Credit Card
// Linked List.
public class edit_cc extends AppCompatActivity {


    private EditText CardName,  CardStartDate, MinSpend, RewardPoints;

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
        Core.currentSelectedCard.delete();
        this.finish();
    }

    public void onUpdateButtonPressed(View v)
    {
        String CardName = this.CardName.getText().toString();
        String CardStartDate = this.CardStartDate.getText().toString();
        int MinSpend = Integer.parseInt(this.MinSpend.getText().toString());
        int RewardPoints = Integer.parseInt(this.RewardPoints.getText().toString());
        Core.currentSelectedCard.delete();
        Card c = new Card(CardName,CardStartDate,MinSpend,RewardPoints);
        Core.addCreditCardDB(c);
        this.finish();

    }
}
