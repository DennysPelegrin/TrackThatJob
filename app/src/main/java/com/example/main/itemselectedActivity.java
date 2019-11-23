package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

public class itemselectedActivity extends AppCompatActivity {

    Button deleteButton;
    Button saveButton;
    Intent newIntent;
    int arrPos;
    EditText statusText;
    EditText notesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemselected);

        Intent nextIntent = getIntent();

        ArrayList<String> itemInfo = new ArrayList<String>();
        itemInfo = nextIntent.getStringArrayListExtra("Item selected");
        arrPos = nextIntent.getIntExtra("Position", -1);

        TextView listItemText = (TextView) findViewById(R.id.listItemType);
        TextView companyNameText = (TextView) findViewById(R.id.companyNameText);
        TextView jobTypeText = (TextView) findViewById(R.id.jobTypeText);
        TextView locationText = (TextView) findViewById(R.id.locationText);
        statusText = (EditText) findViewById(R.id.statusText);
        TextView tagsText = (TextView) findViewById(R.id.tagsText);
        TextView datetimeText = (TextView) findViewById(R.id.datetimeText);
        notesText = (EditText) findViewById(R.id.notesText);

        listItemText.setText(itemInfo.get(0));
        jobTypeText.setText(itemInfo.get(1));
        companyNameText.setText(itemInfo.get(2));
        locationText.setText(itemInfo.get(3));
        datetimeText.setText(itemInfo.get(4));
        statusText.setText(itemInfo.get(5));
        tagsText.setText(itemInfo.get(6));
        notesText.setText(itemInfo.get(7));

        newIntent = new Intent(this, MainActivity.class);

        deleteButton = (Button) findViewById(R.id.DeleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("DeletePosition", arrPos);
                startActivity(newIntent);
            }

        });

        saveButton = (Button) findViewById(R.id.SaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                newIntent.putExtra("SavePosition", arrPos);
                newIntent.putExtra("StatusText", statusText.getText().toString());
                newIntent.putExtra("NotesText", notesText.getText().toString());
                startActivity(newIntent);
            }
        });


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
