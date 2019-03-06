package com.example.travelhacking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

// Main Activity and Default GUI Screen.
public class MainActivity extends AppCompatActivity
{
// Declared ListViews for Credit Cards and Programs
    private ListView ccLV, pLV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Sets up event listeners for Credit Cards and Loyalty Programs from firebase DB
        Core.dbListener();


// Creates list views for the credit cards and programs using their custom adapters.


        this.ccLV = (ListView)this.findViewById(R.id.ccLV);
        Core.ccCustomAdapter = new CCAALL(this, R.layout.creditcardrow, Core.theCreditCardsLL);
        this.ccLV.setAdapter(Core.ccCustomAdapter);


        this.pLV = (ListView)this.findViewById(R.id.pLV);
        Core.pCustomAdapter = new PAALL(this, R.layout.programrow, Core.theProgramsLL);
        this.pLV.setAdapter(Core.pCustomAdapter);




    }
// Creates intent for clicking the add Credit Card button.
    public void onAddCardPress(View v)
    {
        Intent i = new Intent(this, Add_Card.class);
        this.startActivity(i);
    }
// Creates intent for clicking the add Loyalty Program button.

    public void onAddLoyaltyPress(View v)
    {
        Intent i = new Intent(this, Add_Loyalty.class);
        this.startActivity(i);
    }
}
