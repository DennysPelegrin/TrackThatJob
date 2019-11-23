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

        Intent prevIntent = getIntent();

        listView = (ListView) findViewById(R.id.listView);
        intent = new Intent(this, itemselectedActivity.class);

        data = FileHelper.readData(context);

        if(prevIntent != null) {
            int delPos = prevIntent.getIntExtra("DeletePosition", -1);
            int savePos = prevIntent.getIntExtra("SavePosition", -1);

            if(delPos != -1) {
                data.remove(delPos);
            }
            else if(savePos != -1) {
                String newStatusText = prevIntent.getStringExtra("StatusText");
                String newNotesText = prevIntent.getStringExtra("NotesText");
                data.get(savePos).set(5, newStatusText);
                data.get(savePos).set(7, newNotesText);
            }
        }

        for(int i = 0; i < data.size(); i++) {
            String newItemTitle = "";
            newItemTitle += data.get(i).get(1); //Position
            newItemTitle += "\n";
            newItemTitle += data.get(i).get(2); //Company
            newItemTitle += "\n";
            newItemTitle += data.get(i).get(3); //Location
            newItemTitle += "\n";
            newItemTitle += data.get(i).get(5); //Date time
            newItemTitle += "\n";
            newItemTitle += data.get(i).get(6); //Tags
            itemTitles.add(newItemTitle);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemTitles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listClick);
        FileHelper.writeData(data, context);

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
            FileHelper.writeData(data, context);

            intent.putExtra("Item selected", data.get(position));
            intent.putExtra("Position", position);

            startActivity(intent);
        }
    };

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String type, String position, String location, String datetime, String tags, String notes, String status, String company) {
        /*
        textViewType.setText(type);
        textViewPosition.setText(position);
        textViewLocation.setText(location);
        textViewDateTime.setText(datetime);
        textViewTags.setText(tags);
        textViewNotes.setText(notes);
         */

        ArrayList<String> newItemInfo = new ArrayList<String>();

        //Type, position, company, location, time/date, status, tags, notes
        newItemInfo.add(type);
        newItemInfo.add(position);
        newItemInfo.add(company);
        newItemInfo.add(location);
        newItemInfo.add(datetime);
        newItemInfo.add(status);
        newItemInfo.add(tags);
        newItemInfo.add(notes);

        String newItemTitle = position + "\n" + company + "\n" + location + "\n" + datetime + "\n" + tags;
        itemTitles.add(newItemTitle);
        adapter.notifyDataSetChanged();

        data.add(newItemInfo);
    }
}


