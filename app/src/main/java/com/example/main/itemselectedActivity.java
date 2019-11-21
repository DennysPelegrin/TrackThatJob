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
        TextView tagsText = (TextView) findViewById(R.id.tagsText);
        TextView datetimeText = (TextView) findViewById(R.id.datetimeText);
        TextView notesText = (TextView) findViewById(R.id.notesText);

        listItemText.setText(itemInfo.get(0));
        jobTypeText.setText(itemInfo.get(1));
        companyNameText.setText(itemInfo.get(2));
        locationText.setText(itemInfo.get(3));
        datetimeText.setText(itemInfo.get(4));
        statusText.setText(itemInfo.get(5));
        tagsText.setText(itemInfo.get(6));
        notesText.setText(itemInfo.get(7));

        /*
        newItemInfo.add(company);
        newItemInfo.add(type);
        newItemInfo.add(position);
        newItemInfo.add(location);
        newItemInfo.add(status);
        newItemInfo.add(tags);
        newItemInfo.add(datetime);
        newItemInfo.add(notes);
         */
    }
}
