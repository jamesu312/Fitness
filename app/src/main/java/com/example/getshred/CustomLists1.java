package com.example.getshred;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitness.ExerciseData;
import com.example.fitness.R;
import com.example.gainmuscle.ExerciseD;
import com.google.android.material.internal.TextWatcherAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomLists1 extends ArrayAdapter<Exercise1> {
    private final Context context;
    private final ArrayList<Exercise1> exerciseList;

    public CustomLists1 (Context context, ArrayList<Exercise1> exerciseList) {
        super(context, R.layout.item_list1, exerciseList);
        this.context = context;
        this.exerciseList = exerciseList;
    }

    @NonNull
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            listItem = inflater.inflate(R.layout.item_list1, parent, false);
        }

        final Exercise1 currentExercise = exerciseList.get(position);

        TextView exerciseName = listItem.findViewById(R.id.listItemText);
        exerciseName.setText(currentExercise.getExerciseName());

        EditText additionalText = listItem.findViewById(R.id.additionalEditText);
        additionalText.setText(currentExercise.getAdditionalText());
        additionalText.setEnabled(false);

        EditText repetitions = listItem.findViewById(R.id.repetitionsEditText);
        repetitions.setText(String.valueOf(currentExercise.getRepetitions()));

        repetitions.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called to notify you that the characters in the EditText are about to be replaced.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This method is called to notify you that the characters in the EditText have changed.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called to notify you that the characters in the EditText have changed and after the change has been applied.
                String input = s.toString();
                if (!input.isEmpty()) {
                    int newRepetitions = Integer.parseInt(input);
                    currentExercise.setRepetitions(newRepetitions);
                    // Add any actions when repetitions input changes
                }
            }
        });

        return listItem;
    }

}
