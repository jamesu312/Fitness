package com.example.fitness1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

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

        ExerciseData1 currentExercise = exerciseList1.get(position);

        TextView exerciseName = listItem.findViewById(R.id.listItemText);
        exerciseName.setText(currentExercise.getExerciseName1());

        EditText additionalText = listItem.findViewById(R.id.additionalEditText);
        additionalText.setText(currentExercise.getAdditionalText1());
        additionalText.setEnabled(false);

        EditText repetitions = listItem.findViewById(R.id.repetitionsEditText);
        repetitions.setText(String.valueOf(currentExercise.getRepetitions1()));


        return listItem;
    }
}
