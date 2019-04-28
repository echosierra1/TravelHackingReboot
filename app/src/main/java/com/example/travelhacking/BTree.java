package com.example.travelhacking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class BTree extends AppCompatActivity {
    private ArrayAdapter<String> aa;
    private TextView Airport;
    private LinkedList<String> theAirportCodeStrings = new LinkedList<String>();
    private Button LeftChildButton;
    private Button RightChildButton;

    BTree myContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btree);

        this.myContext = this;

        this.Airport = this.findViewById(R.id.Airport);
        this.Airport.setText(this.getIntent().getStringExtra("apc"));
        this.LeftChildButton = this.findViewById(R.id.LeftChildButton);
        this.RightChildButton = this.findViewById(R.id.RightChildButton);
        if (Core.bst.visitLeftChild().compareTo("")== 0)
        {
            LeftChildButton.setVisibility(View.GONE);
        }
        if (Core.bst.visitRightChild().compareTo("") == 0)
        {
            RightChildButton.setVisibility(View.GONE);
        }

    }

    public void onLeftChildPress(View v)
    {
        Intent i = new Intent(myContext, BTree.class);
        i.putExtra("apc", Core.bst.visitLeftChild());
        startActivity(i);
    }
    public void onRightChildPress(View v)
    {
        Intent i = new Intent(myContext, BTree.class);
        i.putExtra("apc", Core.bst.visitRightChild());
        startActivity(i);
    }



}
