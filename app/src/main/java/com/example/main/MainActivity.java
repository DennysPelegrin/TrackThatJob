package com.example.main;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;
import android.content.Intent;
import android.widget.AdapterView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

    /*
    private TextView textViewType;
    private TextView textViewPosition;
    private TextView textViewLocation;
    private TextView textViewDateTime;
    private TextView textViewTags;
    private TextView textViewNotes;
    */
    private Button button;
    Context context;
    ListView listView;
    Intent intent;
    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    ArrayList<String> itemTitles = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        /*
        textViewType = (TextView) findViewById(R.id.textview_type);
        textViewPosition = (TextView) findViewById(R.id.textview_position);
        textViewLocation = (TextView) findViewById(R.id.textview_location);
        textViewDateTime = (TextView) findViewById(R.id.textview_date_time);
        textViewTags = (TextView) findViewById(R.id.textview_tags);
        textViewNotes = (TextView) findViewById(R.id.textview_notes);
         */

        listView = (ListView) findViewById(R.id.listView);
        intent = new Intent(this, itemselectedActivity.class);

        data = FileHelper.readData(context);

        for(int i = 0; i < data.size(); i++) {
            String newItemTitle = "";
            newItemTitle += data.get(i).get(2);
            newItemTitle += "\nCompanyName\n";
            newItemTitle += data.get(i).get(3);
            newItemTitle += "\n";
            newItemTitle += data.get(i).get(5);
            newItemTitle += "\n";
            newItemTitle += data.get(i).get(4);
            itemTitles.add(newItemTitle);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemTitles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listClick);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

        });
    }

    private AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            //String itemInfo [] = new String[7];
            //company name, listItemType, job type, location, status, last updated, notes
            //itemInfo[0] = "Example company name (Changed in code)";
            //itemInfo[1] = "Interview (Changed in code)";
            //itemInfo[2] = "Mid-level engineer (Changed in code)";
            //itemInfo[3] = "Bee hive, Australia (Changed in code)";
            //itemInfo[4] = "Denied (Changed in code)";
            //itemInfo[5] = "Last updated: 10/21/19 (changed in code)";
            //itemInfo[6] = "Notes: I hate this class now (Changed in code)";
            //String itemValue = (String) listView.getItemAtPosition(position);

            FileHelper.writeData(data, context);

            intent.putExtra("Item selected", data.get(position));

            startActivity(intent);
        }
    };

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String type, String position, String location, String datetime, String tags, String notes) {
        /*
        textViewType.setText(type);
        textViewPosition.setText(position);
        textViewLocation.setText(location);
        textViewDateTime.setText(datetime);
        textViewTags.setText(tags);
        textViewNotes.setText(notes);
         */

        //company name, listItemType, job position, location, status, last updated, notes
        ArrayList<String> newItemInfo = new ArrayList<String>();

        newItemInfo.add("Company name here");
        newItemInfo.add(type);
        newItemInfo.add(position);
        newItemInfo.add(location);
        newItemInfo.add(tags);
        newItemInfo.add(datetime);
        newItemInfo.add(notes);

        String newItemTitle = position + "\nCompany name\n" + location + "\n" + datetime + "\n" + tags;
        itemTitles.add(newItemTitle);
        adapter.notifyDataSetChanged();

        data.add(newItemInfo);
    }
}


