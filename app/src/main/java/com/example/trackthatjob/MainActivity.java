package com.example.trackthatjob;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        intent = new Intent(this, itemselectedActivity.class);

        String data[] = {"Horses", "Pineapples", "sombreros"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listClick);
    }

    private AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            String itemInfo [] = new String[7];
            //company name, listItemType, job type, location, status, last updated, notes
            itemInfo[0] = "Example company name (Changed in code)";
            itemInfo[1] = "Interview (Changed in code)";
            itemInfo[2] = "Mid-level engineer (Changed in code)";
            itemInfo[3] = "Bee hive, Australia (Changed in code)";
            itemInfo[4] = "Denied (Changed in code)";
            itemInfo[5] = "Last updated: 10/21/19 (changed in code)";
            itemInfo[6] = "Notes: I hate this class now (Changed in code)";
            //String itemValue = (String) listView.getItemAtPosition(position);

            intent.putExtra("Item selected", itemInfo);

            startActivity(intent);
        }
    };
}