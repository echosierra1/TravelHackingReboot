package com.example.travelhacking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        Program p = this.programList.getAtIndex(position);

        pName.setText(p.getName());
        pBank.setText(p.getBank());
        pBalance.setText("" + p.getBalance());
        //return the View after we have set all of the values
        return listItem;
    }
}