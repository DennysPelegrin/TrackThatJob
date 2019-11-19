package com.example.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.main.R;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editTextType;
    private EditText editTextPosition;
    private EditText editTextLocation;
    private EditText editTextDateTime;
    private EditText editTextTags;
    private EditText editTextNotes;
    private ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
            .setTitle("Login")
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String type = editTextType.getText().toString();
                        String position = editTextPosition.getText().toString();
                        String location = editTextLocation.getText().toString();
                        String datetime = editTextDateTime.getText().toString();
                        String tags = editTextTags.getText().toString();
                        String notes = editTextNotes.getText().toString();

                        listener.applyTexts(type, position, location, datetime, tags, notes);
                    }
                });

        editTextType = view.findViewById(R.id.edit_type);
        editTextPosition = view.findViewById(R.id.edit_position);
        editTextLocation = view.findViewById(R.id.edit_location);
        editTextDateTime = view.findViewById(R.id.edit_date_time);
        editTextTags = view.findViewById(R.id.edit_tags);
        editTextNotes = view.findViewById(R.id.edit_notes);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String type, String position, String location, String datetime, String tags, String notes);
    }
}
