package com.example.getshred;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.Manifest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.fitness.CustomListAdapter;
import com.example.fitness.ExerciseData;
import com.example.fitness.R;
import com.example.gainmuscle.CustomList;
import com.example.gainmuscle.ExerciseD;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class OverWeight extends AppCompatActivity {
    private static final int REQUEST_CODE_WRITE_STORAGE_PERMISSION = 101;

    private ListView listView;
    private Customlists2 adapter;
    private ArrayList<Exercise2> exerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_weight);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE_WRITE_STORAGE_PERMISSION);
        } else {
            Toast.makeText(this, "Permission is already granted.", Toast.LENGTH_SHORT).show();
        }




        listView = findViewById(R.id.listView2);


        // Initialize exerciseList with ExerciseData objects
        exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise2 ("Barbell Squats", "3 sets of 8-12 reps", 0));
        exerciseList.add(new Exercise2 ("Romanian Deadlift", "3 sets of 8-10 reps", 0));
        exerciseList.add(new Exercise2 ("Incline Chest Press", "2 sets of 8-12 reps", 0));
        exerciseList.add(new Exercise2 ("Lateral Raises", "2 sets of 15 reps", 0));
        exerciseList.add(new Exercise2 ("Plank ", "2 sets of 15 reps", 0));
        exerciseList.add(new Exercise2 ("Squats", "2 sets of 25 reps", 0));
        exerciseList.add(new Exercise2 ("sdsds", "2 sets of 25 reps", 0));
        exerciseList.add(new Exercise2 ("Squasdasdaats", "2 sets of 25 reps", 0));
        exerciseList.add(new Exercise2 ("Squasadadats", "2 sets of 25 reps", 0));
        exerciseList.add(new Exercise2 ("Squaasdasdasdsdadwdwadts", "2 sets of 25 reps", 0));






        // Retrieve data from SharedPreferences and update exerciseList
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Set<String> exerciseDataSet = sharedPreferences.getStringSet("exerciseList", new HashSet<>());


        // Parse the data and update exerciseList
        // ExerciseData object format assumed: "ExerciseName|AdditionalText|Repetitions"
        for (String exerciseDataString : exerciseDataSet) {
            String[] exerciseD = exerciseDataString.split("\\|");
            if (exerciseD.length == 3) {
                String exerciseName = exerciseD[0];
                String additionalText = exerciseD[1];
                int repetitions = Integer.parseInt(exerciseD[2]);

                // Find and update the corresponding ExerciseData object
                for (Exercise2 exercise : exerciseList) {
                    if (exercise.getExerciseName().equals(exerciseName)) {
                        exercise.setAdditionalText(additionalText);
                        exercise.setRepetitions(repetitions);
                        break;
                    }
                }
            }
        }

        // Set up the ListView with the retrieved and updated data
        adapter = new Customlists2(this, exerciseList);
        listView.setAdapter(adapter);

        findViewById (R.id.captureSnapshotButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Capture a snapshot of the ListView
                Bitmap listViewBitmap = takeSnapshotOfListView(listView);

                // Save the captured bitmap to the gallery
                saveBitmapToGallery(listViewBitmap);
            }
        });
    }

    // Method to take a snapshot of the ListView
    private Bitmap takeSnapshotOfListView(ListView listView) {
        int totalHeight = listView.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(listView.getWidth(), totalHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        listView.draw(canvas);
        return bitmap;
    }

    // Method to save the bitmap image to the gallery
    private void saveBitmapToGallery(Bitmap bitmap) {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DISPLAY_NAME, "ListViewSnapshot.png");
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
        values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES);

        Uri imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        if (imageUri != null) {
            try {
                OutputStream outputStream = getContentResolver().openOutputStream(imageUri);
                if (outputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                    outputStream.close();
                    Toast.makeText(this, "Image saved to gallery", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
            }
        }
    }

}


