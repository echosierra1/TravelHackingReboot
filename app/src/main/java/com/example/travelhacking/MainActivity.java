package com.example.travelhacking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView ccLV, pLV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ccLV = (ListView)this.findViewById(R.id.ccLV);

        Core.ccCustomAdapter = new CCAALL(this, R.layout.creditcardrow, Core.theCreditCardsLL);
        this.ccLV.setAdapter(Core.ccCustomAdapter);

        this.pLV = (ListView)this.findViewById(R.id.pLV);

        Core.pCustomAdapter = new PAALL(this, R.layout.programrow, Core.theProgramsLL);
        this.pLV.setAdapter(Core.pCustomAdapter);




    }
    public void onAddCardPress(View v)
    {
        Intent i = new Intent(this, Add_Card.class);
        this.startActivity(i);
    }
    public void onAddLoyaltyPress(View v)
    {
        Intent i = new Intent(this, Add_Loyalty.class);
        this.startActivity(i);
    }
}
