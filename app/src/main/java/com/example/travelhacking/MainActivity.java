package com.example.travelhacking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;



// Main Activity and Default GUI Screen.
public class MainActivity extends AppCompatActivity
{
// Declared ListViews for Credit Cards and Programs
    private ListView ccLV, pLV;
    private MainActivity myContext;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        NetworkingthreadLoad nt = new NetworkingthreadLoad();
//        nt.start();

        this.myContext = this;
// Sets up event listeners for Credit Cards and Loyalty Programs from firebase DB
        Core.dbListener();


// Creates list views for the credit cards and programs using their custom adapters.

        this.ccLV = (ListView)this.findViewById(R.id.ccLV);
        Core.ccCustomAdapter = new CCAALL(this, R.layout.creditcardrow, Core.theCreditCardsLL);
        this.ccLV.setAdapter(Core.ccCustomAdapter);

        this.pLV = (ListView)this.findViewById(R.id.pLV);
        Core.pCustomAdapter = new PAALL(this, R.layout.programrow, Core.theProgramsLL);
        this.pLV.setAdapter(Core.pCustomAdapter);

// Allows for the Credit Cards and Programs listviews to be clickable and start a new activity
// the new activity calls myContext to allows for activities to be started.

        this.ccLV.setClickable(true);
        this.ccLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                Card selectedCard = Core.theCreditCardsLL.getAtIndex(position);
                Intent in = new Intent(myContext, edit_cc.class);
                Core.currentSelectedCard = selectedCard;
                myContext.startActivity(in);

            }
        });

        this.pLV.setClickable(true);
        this.pLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                Program selectedprogram = Core.theProgramsLL.getAtIndex(position);
                Intent in = new Intent(myContext, Edit_program.class);
                Core.currentSelectedProgram = selectedprogram;
                myContext.startActivity(in);

            }
        });

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
    public void onAirportListButtonPressed(View v)
    {
        Intent i = new Intent(this, AirportList.class);
        this.startActivity(i);
    }
}
