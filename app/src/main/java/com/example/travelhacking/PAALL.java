package com.example.travelhacking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// This is the Program Array Adapter for Linked Lists (PAALL). It takes the Linked List of
// Programs (LLP) and converts it to a display view.
public class PAALL extends ArrayAdapter
{
    private Context mContext;
    private LLP programList;
    private int textViewResourceId;

    public PAALL(Context context, int textViewResourceId,
                 LLP list)
    {
        super(context, textViewResourceId);
        this.mContext = context;
        this.programList = list;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public int getCount()
    {
        return this.programList.length();
    }

    @NonNull
    @Override
    // This function will create the list view to display all the items in the linked list. It
    // does so by first inflating the blank space with Program data so the Program information can have
    // somewhere to go. Using getters for the Program Class allows access to the private information
    // which is then adapted into the appropriate textviews and returned to the screen.
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;
        if(listItem == null)
        {
            listItem = LayoutInflater.from(mContext).
                    inflate(this.textViewResourceId,parent,false);
        }

        TextView pName = (TextView)listItem.findViewById(R.id.programTV);
        TextView pBank = (TextView)listItem.findViewById(R.id.bankTV);
        TextView pBalance = (TextView)listItem.findViewById(R.id.balanceTV);
// gives the Program payload from the linked list.
        Program p = this.programList.getAtIndex(position);

        pName.setText(p.getProgramName());
        pBank.setText(p.getProgramBank());
        pBalance.setText("" + p.getProgramBalance());
        //return the View after we have set all of the values
        return listItem;
    }
}