package com.example.travelhacking;

import android.widget.ArrayAdapter;

    public class Core
    {
        public static LLCC theCreditCardsLL = new LLCC();

        public static CCAALL ccCustomAdapter;

        public static LLP theProgramsLL = new LLP();
        public static PAALL pCustomAdapter;


        public static void addLoyaltyProgram(Program p)
        {
            Core.theProgramsLL.addEnd(p);
            Core.pCustomAdapter.notifyDataSetChanged();
        }

        public static void addCreditCard(Card c)
        {
            Core.theCreditCardsLL.addEnd(c);

            Core.ccCustomAdapter.notifyDataSetChanged();
        }
    }

