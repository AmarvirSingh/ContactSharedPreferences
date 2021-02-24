package com.example.contactsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String Key_Name = "keyName";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("contactShared",MODE_PRIVATE);

        ArrayList<Contact> contactList =  new ArrayList<>();
        contactList.add(new Contact("Amarvir Singh","9781355869","Student"));
        contactList.add(new Contact("Simranpreet Kaur","9781355987","Student"));
        contactList.add(new Contact("Avtar Singh","9765432176","Farmer"));

        try {
            Log.i("TAG", "onCreate:before entering "+contactList.size());
            sharedPreferences.edit().putString("contacts",ObjectSerializer.serialize(contactList)).apply();
            Log.i("TAG", "onCreate:after entering "+contactList.size());
            Log.i("TAG", "onCreate: enter data "+ ObjectSerializer.serialize(contactList));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Contact> retrivedNames = new ArrayList<>();

        String deReNames = sharedPreferences.getString("contacts", null);

        try {
            retrivedNames = (ArrayList) ObjectSerializer.deserialize(deReNames);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0 ; i< retrivedNames.size(); i++) {
            Log.i("TAG", +retrivedNames.size() +"\n  Name - " + retrivedNames.get(i).getNames() +" \n Number - "+ retrivedNames.get(i).getNumber() + "\n Ocuupation - "+ retrivedNames.get(i).getOccupation()+"\n-----------");

        }
    }
}