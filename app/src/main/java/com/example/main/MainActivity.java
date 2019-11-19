package com.example.main;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

    private TextView textViewType;
    private TextView textViewPosition;
    private TextView textViewLocation;
    private TextView textViewDateTime;
    private TextView textViewTags;
    private TextView textViewNotes;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewType = (TextView) findViewById(R.id.textview_type);
        textViewPosition = (TextView) findViewById(R.id.textview_position);
        textViewLocation = (TextView) findViewById(R.id.textview_location);
        textViewDateTime = (TextView) findViewById(R.id.textview_date_time);
        textViewTags = (TextView) findViewById(R.id.textview_tags);
        textViewNotes = (TextView) findViewById(R.id.textview_notes);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

        });
    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String type, String position, String location, String datetime, String tags, String notes) {
        textViewType.setText(type);
        textViewPosition.setText(position);
        textViewLocation.setText(location);
        textViewDateTime.setText(datetime);
        textViewTags.setText(tags);
        textViewNotes.setText(notes);
    }
}


