package com.example.fitness1;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitness.ExerciseData;
import com.example.fitness.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class CustomListAdapter1 extends ArrayAdapter<ExerciseData1> {
    private final Context context;
    private final ArrayList<ExerciseData1> exerciseList1;

    public CustomListAdapter1(Context context, ArrayList<ExerciseData1> exerciseList) {
        super(context, R.layout.list_item_with_text1, exerciseList);
        this.context = context;
        this.exerciseList1 = exerciseList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            listItem = inflater.inflate(R.layout.list_item_with_text1, parent, false);
        }

        final ExerciseData1 currentExercise = exerciseList1.get(position);

        TextView exerciseName = listItem.findViewById(R.id.listItemText);
        exerciseName.setText(currentExercise.getExerciseName1());

        EditText additionalText = listItem.findViewById(R.id.additionalEditText);
        additionalText.setText(currentExercise.getAdditionalText1());
        additionalText.setEnabled(false);

        EditText repetitions = listItem.findViewById(R.id.repetitionsEditText);
        repetitions.setText(String.valueOf(currentExercise.getRepetitions1()));

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
                    currentExercise.setRepetitions1(newRepetitions);
                    // Add any actions when repetitions input changes
                }
            }
        });

        return listItem;
    }
}
