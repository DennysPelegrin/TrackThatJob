package com.example.hcicoolexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditTaskDesk extends AppCompatActivity {
    EditText itemType, position, company, location, date, status, tags, notes;
    Button btnSaveUpdate, btnDelete;
    int arrPos;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task_desk);

        arrPos = getIntent().getIntExtra("Position", -5);
        itemType = (EditText) findViewById(R.id.itemTypeText);
        position = (EditText) findViewById((R.id.positionText));
        company = (EditText) findViewById((R.id.companyText));
        location = (EditText) findViewById(R.id.locationText);
        date = (EditText) findViewById((R.id.dateText));
        status = (EditText) findViewById((R.id.statusText));
        tags = (EditText) findViewById(R.id.tagsText);
        notes = (EditText) findViewById((R.id.notesText));

        btnSaveUpdate = findViewById(R.id.btnSaveUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        //get a value from previous page
        itemType.setText(getIntent().getStringExtra("itemType"));
        position.setText(getIntent().getStringExtra("position"));
        company.setText(getIntent().getStringExtra("company"));
        location.setText(getIntent().getStringExtra("location"));
        date.setText(getIntent().getStringExtra("date"));
        status.setText(getIntent().getStringExtra("status"));
        tags.setText(getIntent().getStringExtra("tags"));
        notes.setText(getIntent().getStringExtra("notes"));

        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                   Intent a = new Intent(EditTaskDesk.this, MainActivity.class);
                   a.putExtra("DeletePosition", arrPos);
                   startActivity(a);
            }
        });


        //make an event for button
        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(EditTaskDesk.this, MainActivity.class);
                a.putExtra("ChangePosition", arrPos);
                String[] newInfo = {itemType.getText().toString(), position.getText().toString(), company.getText().toString(), location.getText().toString(), date.getText().toString(), status.getText().toString(), tags.getText().toString(), notes.getText().toString()};
                a.putExtra("NewInfo", newInfo);
                startActivity(a);
            }
        });
    }
}
