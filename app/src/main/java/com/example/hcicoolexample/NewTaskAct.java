package com.example.hcicoolexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NewTaskAct extends AppCompatActivity {
    TextView titlepage, itemTypeTitle, positionTitle, companyTitle, locationTitle, dateTitle, statusTitle, tagsTitle, notesTitle;
    EditText itemType, position, company, location, date, status, tags, notes;
    Button btnSaveTask, btnCancel;
    DatabaseReference reference;
    Integer doesNum = new Random().nextInt(); //use this as id of does
    String keydoes = Integer.toString(doesNum);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        titlepage = findViewById(R.id.titlepage);

        itemTypeTitle = findViewById(R.id.itemType);
        itemType = findViewById(R.id.itemTypeText);
        positionTitle= findViewById(R.id.position);
        position = findViewById(R.id.positionText);
        companyTitle = findViewById(R.id.company);
        company = findViewById(R.id.companyText);
        locationTitle = findViewById(R.id.location);
        location = findViewById(R.id.locationText);
        dateTitle = findViewById(R.id.date);
        date = findViewById(R.id.dateText);
        statusTitle = findViewById(R.id.status);
        status = findViewById(R.id.statusText);
        tagsTitle = findViewById(R.id.tags);
        tags = findViewById(R.id.tagsText);
        notesTitle = findViewById(R.id.notes);
        notes = findViewById(R.id.notesText);




        btnSaveTask = findViewById(R.id.btnSaveTask);
        btnCancel = findViewById((R.id.btnCancel));

        btnSaveTask.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //inset data to database
                //creates new directory called BoxDoes based on teh main acitivty
                reference = FirebaseDatabase.getInstance().getReference().child("HCICoolExample").child("Does" + doesNum);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("itemType").setValue(itemType.getText().toString());
                        dataSnapshot.getRef().child("position").setValue(position.getText().toString());
                        dataSnapshot.getRef().child("company").setValue(company.getText().toString());
                        dataSnapshot.getRef().child("location").setValue(location.getText().toString());
                        dataSnapshot.getRef().child("date").setValue(date.getText().toString());
                        dataSnapshot.getRef().child("status").setValue(status.getText().toString());
                        dataSnapshot.getRef().child("tags").setValue(tags.getText().toString());
                        dataSnapshot.getRef().child("notes").setValue(notes.getText().toString());
                        dataSnapshot.getRef().child("keydoes").setValue(keydoes);

                        //going back into the main activity?
                        Intent a = new Intent(NewTaskAct.this, MainActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");

        //customize font
        titlepage.setTypeface(MMedium);
        itemTypeTitle.setTypeface(MLight);
        itemType.setTypeface(MMedium);
        positionTitle.setTypeface(MLight);
        position.setTypeface(MMedium);
        companyTitle.setTypeface(MLight);
        company.setTypeface(MMedium);
        locationTitle.setTypeface(MLight);
        location.setTypeface(MMedium);
        dateTitle.setTypeface(MLight);
        date.setTypeface(MMedium);
        statusTitle.setTypeface(MLight);
        status.setTypeface(MMedium);
        tagsTitle.setTypeface(MLight);
        tags.setTypeface(MMedium);
        notesTitle.setTypeface(MLight);
        notes.setTypeface(MMedium);
        btnSaveTask.setTypeface(MMedium);
        btnCancel.setTypeface(MLight);
    }

}
