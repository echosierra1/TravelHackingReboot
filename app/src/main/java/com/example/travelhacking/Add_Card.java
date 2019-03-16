package com.example.travelhacking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
// This class creates a second screen that will take the 4 edittext information pieces and create a
// local object Card with the entered information. This object is saved to a Credit Card
// Linked List.
public class Add_Card extends AppCompatActivity {

    private EditText CardName,  CardStartDate, MinSpend, RewardPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__card);

        this.CardName = (EditText)this.findViewById(R.id.CardName);
        this.CardStartDate = (EditText)this.findViewById(R.id.CardStartDate);
        this.MinSpend = (EditText)this.findViewById(R.id.MinSpend);
        this.RewardPoints = (EditText)this.findViewById(R.id.RewardPoints);

    }

    // This function creates the Card object by converting the edit texts to strings and ints,
    // saving them to a Card object built from the card class,
    // and calls Core to save Card to the firebase database.
    public void onAddCard(View v)
    {
        String CardName = this.CardName.getText().toString();
        String CardStartDate = this.CardStartDate.getText().toString();
        int MinSpend = Integer.parseInt(this.MinSpend.getText().toString());
        int RewardPoints = Integer.parseInt(this.RewardPoints.getText().toString());

        Card c = new Card(CardName,CardStartDate,MinSpend,RewardPoints);
        Core.addCreditCardDB(c);
        this.finish();
    }

}

