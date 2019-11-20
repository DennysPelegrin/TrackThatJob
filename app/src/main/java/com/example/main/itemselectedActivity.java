package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

public class itemselectedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemselected);

        Intent nextIntent = getIntent();

        ArrayList<String> itemInfo = new ArrayList<String>();
        itemInfo = nextIntent.getStringArrayListExtra("Item selected");

        TextView listItemText = (TextView) findViewById(R.id.listItemType);
        TextView companyNameText = (TextView) findViewById(R.id.companyNameText);
        TextView jobTypeText = (TextView) findViewById(R.id.jobTypeText);
        TextView locationText = (TextView) findViewById(R.id.locationText);
        TextView statusText = (TextView) findViewById(R.id.statusText);
        TextView lastUpdatedText = (TextView) findViewById(R.id.lastUpdatedText);
        TextView notesText = (TextView) findViewById(R.id.notesText);

        companyNameText.setText(itemInfo.get(0));
        listItemText.setText(itemInfo.get(1));
        jobTypeText.setText(itemInfo.get(2));
        locationText.setText(itemInfo.get(3));
        statusText.setText(itemInfo.get(4));
        lastUpdatedText.setText(itemInfo.get(5));
        notesText.setText(itemInfo.get(6));
    }
}
