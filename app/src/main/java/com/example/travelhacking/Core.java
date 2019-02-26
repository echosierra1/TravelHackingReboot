package com.example.travelhacking;

import android.widget.ArrayAdapter;
// Core class for storing global values and encapsulating Linked List creation.
    public class Core
    {
// Creates the Linked List of credit cards and the custom view adapter for that information.
        public static LLCC theCreditCardsLL = new LLCC();
        public static CCAALL ccCustomAdapter;
// Creates the Linked List of Loyalty Programs and the custom view adapter for that information.
        public static LLP theProgramsLL = new LLP();
        public static PAALL pCustomAdapter;

// Encapsulates the code for adding a Loyalty Program.
        public static void addLoyaltyProgram(Program p)
        {
            Core.theProgramsLL.addEnd(p);
            Core.pCustomAdapter.notifyDataSetChanged();
        }
// Encapsulates the code for adding a Credit Card.
        public static void addCreditCard(Card c)
        {
            Core.theCreditCardsLL.addEnd(c);

            Core.ccCustomAdapter.notifyDataSetChanged();
        }
    }

