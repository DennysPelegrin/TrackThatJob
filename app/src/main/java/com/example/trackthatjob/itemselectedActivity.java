package com.example.trackthatjob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class itemselectedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemselected);

        Intent nextIntent = getIntent();

        String itemInfo[] = nextIntent.getStringArrayExtra("Item selected");

        TextView listItemText = (TextView) findViewById(R.id.listItemType);
        TextView companyNameText = (TextView) findViewById(R.id.companyNameText);
        TextView jobTypeText = (TextView) findViewById(R.id.jobTypeText);
        TextView locationText = (TextView) findViewById(R.id.locationText);
        TextView statusText = (TextView) findViewById(R.id.statusText);
        TextView lastUpdatedText = (TextView) findViewById(R.id.lastUpdatedText);
        TextView notesText = (TextView) findViewById(R.id.notesText);

        companyNameText.setText(itemInfo[0]);
        listItemText.setText(itemInfo[1]);
        jobTypeText.setText(itemInfo[2]);
        locationText.setText(itemInfo[3]);
        statusText.setText(itemInfo[4]);
        lastUpdatedText.setText(itemInfo[5]);
        notesText.setText(itemInfo[6]);
    }
}
