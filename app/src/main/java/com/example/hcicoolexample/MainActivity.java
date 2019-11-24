package com.example.hcicoolexample;

import android.graphics.Typeface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    TextView titlepage, subtitlepage, endpage;
    RecyclerView ourdoes;
    Intent intent;
    ArrayList<MyDoes> list;
    DoesAdapter doesAdapter;
    Button btnAddNew;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        endpage = findViewById(R.id.endpage);
        btnAddNew = findViewById(R.id.btnAddNew);

        //import fonts
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");

        //customize font
        titlepage.setTypeface(MMedium);
        subtitlepage.setTypeface(MLight);
        endpage.setTypeface(MLight);
        btnAddNew.setTypeface(MLight);

        btnAddNew.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent a = new Intent(MainActivity.this, NewTaskAct.class);
                startActivity(a);
            }
        });

        ourdoes = findViewById(R.id.ourdoes);
        ourdoes.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MyDoes>();

        intent = new Intent(this, EditTaskDesk.class);

        //get data from Firebase
        ArrayList<ArrayList<String>> data = FileHelper.readData(this);
        for(int i = 0; i < data.size(); i++) {
            MyDoes newMyDoes = new MyDoes(data.get(i).get(0), data.get(i).get(1), data.get(i).get(2), data.get(i).get(3), data.get(i).get(4), data.get(i).get(5), data.get(i).get(6), data.get(i).get(7));
            list.add(newMyDoes);
        }

        Intent prevIntent = getIntent();
        if(prevIntent != null) {
            String newData[] = prevIntent.getStringArrayExtra("NewData");
            if(newData != null) {
                MyDoes newMyDoes = new MyDoes(newData[0], newData[1], newData[2], newData[3], newData[4], newData[5], newData[6], newData[7]);
                data.add(newMyDoes.getInfo());
                list.add(newMyDoes);
            }

            int pos = prevIntent.getIntExtra("DeletePosition", -5);
            if(pos != -5) {
                data.remove(pos);
                list.remove(pos);
            }

            int changePos = prevIntent.getIntExtra("ChangePosition", -3);
            if(changePos != -3) {
                String[] newInfo = prevIntent.getStringArrayExtra("NewInfo");
                MyDoes newMyDoes = new MyDoes(newInfo[0], newInfo[1], newInfo[2], newInfo[3], newInfo[4], newInfo[5], newInfo[6], newInfo[7]);
                data.remove(changePos);
                data.add(newMyDoes.getInfo());
                list.remove(changePos);
                list.add(newMyDoes);

            }
        }

        doesAdapter = new DoesAdapter(MainActivity.this, list);
        ourdoes.setAdapter(doesAdapter);
        doesAdapter.notifyDataSetChanged();
        FileHelper.writeData(data, this);
    }
}
