package com.example.travelhacking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    public void onAddCard(View v)
    {
        String CardName = this.CardName.getText().toString();
        String CardStartDate = this.CardStartDate.getText().toString();
        int MinSpend = Integer.parseInt(this.MinSpend.getText().toString());
        int RewardPoints = Integer.parseInt(this.RewardPoints.getText().toString());

        Card c = new Card(CardName,CardStartDate,MinSpend,RewardPoints);
        Core.addCreditCard(c);
        this.finish();
    }

}

