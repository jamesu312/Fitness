package com.example.fitness3;

import android.content.Context;
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
            listItem = inflater.inflate(R.layout.list_item_with_test2, parent, false);
        }

        ExerciseData3 currentExercise = exerciseList3.get(position);

        TextView exerciseName3 = listItem.findViewById(R.id.listItemText);
        exerciseName3.setText(currentExercise.getExerciseName3());

        EditText additionalText3 = listItem.findViewById(R.id.additionalEditText);
        additionalText3.setText(currentExercise.getAdditionalText3());
        additionalText3.setEnabled(false);

        EditText repetitions3 = listItem.findViewById(R.id.repetitionsEditText);
        repetitions3.setText(String.valueOf(currentExercise.getRepetitions3()));


        return listItem;
    }
}
