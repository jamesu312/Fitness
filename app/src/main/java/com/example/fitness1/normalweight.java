package com.example.fitness1;

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

import com.example.fitness1.CustomListAdapter1;
import com.example.fitness1.ExerciseData1;

import com.example.fitness.R;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class normalweight extends AppCompatActivity {
    private static final int REQUEST_CODE_WRITE_STORAGE_PERMISSION = 101;

    private ListView listView1;
    private CustomListAdapter1 adapter;
    private ArrayList<ExerciseData1> exerciseList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normalweight);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE_WRITE_STORAGE_PERMISSION);
        } else {
            // Permission is already granted
            // Proceed with your logic or show a message
            Toast.makeText(this, "Permission is already granted.", Toast.LENGTH_SHORT).show();
            // Continue with your app logic
        }



        listView1 = findViewById(R.id.listView1);


        // Initialize exerciseList with ExerciseData objects
        exerciseList1 = new ArrayList<>();
        exerciseList1.add(new ExerciseData1 ("Push Up", "40 seconds", 0));
        exerciseList1.add(new ExerciseData1 ("Plank", "1 Minute", 0));
        exerciseList1.add(new ExerciseData1 ("Jumping Jacks", "1 Minute", 0));
        exerciseList1.add(new ExerciseData1 ("Jogging", "750 Meters", 0));
        exerciseList1.add(new ExerciseData1 ("Standing Knee Raises Both sides", "1Minute 30 Seconds", 0));
        exerciseList1.add(new ExerciseData1 ( "Squats", "50 reps", 0));

        // Retrieve data from SharedPreferences and update exerciseList
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Set<String> exerciseDataSet = sharedPreferences.getStringSet("exerciseList", new HashSet<>());

        // Parse the data and update exerciseList
        // ExerciseData object format assumed: "ExerciseName|AdditionalText|Repetitions"
        for (String exerciseDataString : exerciseDataSet) {
            String[] exerciseData1 = exerciseDataString.split("\\|");
            if (exerciseData1   .length == 3) {
                String exerciseName = exerciseData1[0];
                String additionalText = exerciseData1[1];
                int repetitions = Integer.parseInt(exerciseData1[2]);

                // Find and update the corresponding ExerciseData object
                for (ExerciseData1 exercise : exerciseList1) {
                    if (exercise.getExerciseName1().equals(exerciseName)) {
                        exercise.setAdditionalText1(additionalText);
                        exercise.setRepetitions1(repetitions);
                        break;
                    }
                }
            }
        }

        // Set up the ListView with the retrieved and updated data
        adapter = new CustomListAdapter1(this, exerciseList1);
        listView1.setAdapter(adapter);

        findViewById (R.id.captureSnapshotButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Capture a snapshot of the ListView
                Bitmap listViewBitmap = takeSnapshotOfListView(listView1);

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


