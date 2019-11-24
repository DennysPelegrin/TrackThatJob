package com.example.hcicoolexample;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.content.Context;
import android.widget.TextView;

public class DoesAdapter extends RecyclerView.Adapter<DoesAdapter.MyViewHolder> {
    Context context;
    ArrayList<MyDoes> myDoes;

    public DoesAdapter(Context c, ArrayList<MyDoes> p){
        context = c;
        myDoes = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does , viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i){
        myViewHolder.titledoes.setText(myDoes.get(i).getPosition());
        myViewHolder.descdoes.setText(myDoes.get(i).getCompany());
        myViewHolder.datedoes.setText(myDoes.get(i).getStatus());

        final String getItemType = myDoes.get(i).getItemType();
        final String getPosition = myDoes.get(i).getPosition();
        final String getCompany = myDoes.get(i).getCompany();
        final String getLocation = myDoes.get(i).getLocation();
        final String getDate = myDoes.get(i).getDate();
        final String getStatus = myDoes.get(i).getStatus();
        final String getTags = myDoes.get(i).getTags();
        final String getNotes = myDoes.get(i).getNotes();
        final String getKeyDoes = myDoes.get(i).getKeydoes();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent aa = new Intent(context, EditTaskDesk.class);
                aa.putExtra("itemType", getItemType);
                aa.putExtra("position", getPosition);
                aa.putExtra("company", getCompany);
                aa.putExtra("location", getLocation);
                aa.putExtra("date", getDate);
                aa.putExtra("status", getStatus);
                aa.putExtra("tags", getTags);
                aa.putExtra("notes", getNotes);
                aa.putExtra("keydoes", getKeyDoes);
                context.startActivity(aa);
            }
        });
    }

    @Override
    public int getItemCount(){
        return myDoes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titledoes;
        TextView descdoes;
        TextView datedoes;
        TextView keydoes;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            //this is based on the "item_does.xml" file.
            titledoes = (TextView) itemView.findViewById(R.id.titledoes);
            descdoes = (TextView) itemView.findViewById(R.id.descdoes);
            datedoes = (TextView) itemView.findViewById(R.id.datedoes);
        }
    }
}
