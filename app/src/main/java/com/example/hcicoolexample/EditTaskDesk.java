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
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task_desk);

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

        final String keykeyDoes = getIntent().getStringExtra("keydoes");

        reference = FirebaseDatabase.getInstance().getReference().child("HCICoolExample").child("Does" + keykeyDoes);

        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                reference.removeValue();
                //reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>(){
                  // @Override
                   //public void onComplete(@NonNull Task<Void> task){
                       //if(task.isSuccessful()){
                           Intent a = new Intent(EditTaskDesk.this, MainActivity.class);
                           startActivity(a);
                       //}
                       //else{
                          // Toast.makeText(getApplicationContext(), "Failure!", Toast.LENGTH_SHORT).show();
                       //}
                  // }
                //});
            }
        });

        //make an event for button
        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //reference.addValueEventListener(new ValueEventListener(){
                   //@Override
                   //public void onDataChange(DataSnapshot dataSnapshot){
                       reference.child("itemType").setValue(itemType.getText().toString());
                       reference.child("position").setValue(position.getText().toString());
                       reference.child("company").setValue(company.getText().toString());
                       reference.child("location").setValue(location.getText().toString());
                       reference.child("date").setValue(date.getText().toString());
                       reference.child("status").setValue(status.getText().toString());
                       reference.child("tags").setValue(tags.getText().toString());
                       reference.child("notes").setValue(notes.getText().toString());
                       reference.child("keydoes").setValue(keykeyDoes);

                       //go from edit task into main activity
                       Intent a = new Intent(EditTaskDesk.this, MainActivity.class);
                       startActivity(a);
                   //}

                   //@Override
                   //public void onCancelled(DatabaseError databaseError){

                   //}
                //});
            }
        });
    }
}
