package com.example.travelhacking;

import android.widget.ArrayAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

// Core class for storing global values and encapsulating Linked List creation.
    public class Core
    {
// Creates the Linked List of credit cards and the custom view adapter for that information.
        public static LLCC theCreditCardsLL = new LLCC();
        public static CCAALL ccCustomAdapter;
// Creates the Linked List of Loyalty Programs and the custom view adapter for that information.
        public static LLP theProgramsLL = new LLP();
        public static PAALL pCustomAdapter;

// Set up writing a message to the database
        public static FirebaseDatabase database = FirebaseDatabase.getInstance();
        public static DatabaseReference cards = database.getReference("cards");
        public static DatabaseReference programs = database.getReference("programs");
        public static int ccfirstrun = 1;
        public static int pfirstrun = 1;


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

