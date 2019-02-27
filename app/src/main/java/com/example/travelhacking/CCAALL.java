package com.example.travelhacking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// This is the Credit Card Array Adapter for Linked Lists (CCAALL). It takes the Linked List of
// Credit Cards (LLCC) and converts it to a display view.

public class CCAALL extends ArrayAdapter
{
    private Context mContext;
    private LLCC creditCardList;
    private int textViewResourceId;

    public CCAALL(Context context, int textViewResourceId,
                                                LLCC list)
    {
        super(context, textViewResourceId);
        this.mContext = context;
        this.creditCardList = list;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public int getCount()
    {
        return this.creditCardList.length();
    }

    @NonNull
    @Override
    // This function will create the list view to display all the items in the linked list. It
    // does so by first inflating the blank space with Card data so the Card information can have
    // somewhere to go. Using getters for the Card Class allows access to the private information
    // which is then adapted into the appropriate textviews and returned to the screen.
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;
        if(listItem == null)
        {
            listItem = LayoutInflater.from(mContext).
                    inflate(this.textViewResourceId,parent,false);
        }

        TextView ccName = (TextView)listItem.findViewById(R.id.ccNameTV);
        TextView ccStartDate = (TextView)listItem.findViewById(R.id.ccStartDateTV);
        TextView ccMinSpend = (TextView)listItem.findViewById(R.id.ccMinSpendTV);
        TextView ccBonusPoints = (TextView)listItem.findViewById(R.id.ccBonusPointsTV);
// gives the credit card payload from the linked list.
        Card cc = this.creditCardList.getAtIndex(position);

        ccName.setText(cc.getName());
        ccStartDate.setText(cc.getStart_date());
        ccMinSpend.setText("" + cc.getMin_spend());
        ccBonusPoints.setText("" + cc.getPoint_bonus());
        //return the View after we have set all of the values
        return listItem;
    }
}