package com.example.fitness2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitness.R;
import com.example.fitness2.ExerciseData2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class CustomListAdapter2 extends ArrayAdapter<ExerciseData2> {
    private final Context context;
    private final ArrayList<ExerciseData2> exerciseList2;

    public CustomListAdapter2(Context context, ArrayList<ExerciseData2> exerciseList) {
        super(context, R.layout.list_item_with_test2, exerciseList);
        this.context = context;
        this.exerciseList2 = exerciseList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            listItem = inflater.inflate(R.layout.list_item_with_test2, parent, false);
        }

        ExerciseData2 currentExercise = exerciseList2.get(position);

        TextView exerciseName2 = listItem.findViewById(R.id.listItemText);
        exerciseName2.setText(currentExercise.getExerciseName2());

        EditText additionalText2 = listItem.findViewById(R.id.additionalEditText);
        additionalText2.setText(currentExercise.getAdditionalText2());
        additionalText2.setEnabled(false);

        EditText repetitions2 = listItem.findViewById(R.id.repetitionsEditText);
        repetitions2.setText(String.valueOf(currentExercise.getRepetitions2()));


        return listItem;
    }
}
