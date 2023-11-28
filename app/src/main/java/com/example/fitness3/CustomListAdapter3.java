package com.example.fitness3;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitness.R;
import com.example.fitness2.ExerciseData2;
import com.example.fitness3.ExerciseData3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class CustomListAdapter3 extends ArrayAdapter<ExerciseData3> {
    private final Context context;
    private final ArrayList<ExerciseData3> exerciseList3;

    public CustomListAdapter3(Context context, ArrayList<ExerciseData3> exerciseList) {
        super(context, R.layout.list_item_with_text3, exerciseList);
        this.context = context;
        this.exerciseList3 = exerciseList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            listItem = inflater.inflate(R.layout.list_item_with_text3, parent, false);
        }

        final ExerciseData3 currentExercise = exerciseList3.get(position);

        TextView exerciseName = listItem.findViewById(R.id.listItemText);
        exerciseName.setText(currentExercise.getExerciseName3());

        EditText additionalText = listItem.findViewById(R.id.additionalEditText);
        additionalText.setText(currentExercise.getAdditionalText3());
        additionalText.setEnabled(false);

        EditText repetitions = listItem.findViewById(R.id.repetitionsEditText);
        repetitions.setText(String.valueOf(currentExercise.getRepetitions3()));

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
                    currentExercise.setRepetitions3(newRepetitions);
                    // Add any actions when repetitions input changes
                }
            }
        });

        return listItem;
    }
}
