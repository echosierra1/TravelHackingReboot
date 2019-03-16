package com.example.travelhacking;

import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.LinkedList;

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

// Selected Card for update or delete screens
        public static Card currentSelectedCard = null;
        public static Program currentSelectedProgram = null;

        public static LinkedList<String> flights = new LinkedList<String>();
        public static String airportcode = null;
        public static int done = 0;


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

// Encapsulates the code for setting up the Listeners for CreditCards and Loyalty Programs
        public static void dbListener()
        {
            Core.cards.addValueEventListener(new ValueEventListener()
            {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                    Core.theCreditCardsLL.removeAll();
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.

                        for(DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            //de-serialize the card
                            Card tempCC = ds.getValue(Card.class);
                            tempCC.setKey(ds.getKey());
                            Core.addCreditCard(tempCC);
                        }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            Core.programs.addValueEventListener(new ValueEventListener()
            {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                    Core.theProgramsLL.removeAll();

                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.

                        for(DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            //de-serialize the card
                            Program tempp = ds.getValue(Program.class);
                            tempp.setKey(ds.getKey());
                            Core.addLoyaltyProgram(tempp);
                        }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        public  static void addCreditCardDB(Card c)
        {
            Core.cards.push().setValue(c);

        }
        public static void addLoyaltyProgramDB(Program p)
        {
            Core.programs.push().setValue(p);

        }
    }

