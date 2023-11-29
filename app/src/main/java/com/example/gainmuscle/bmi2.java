package com.example.gainmuscle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitness.R;
import com.example.fitness2.overweight;
import com.example.fitness3.obese;

public class bmi2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi2);
        EditText editTextWeight = findViewById(R.id.Weight);
        EditText editTextHeight = findViewById(R.id.Height);
        TextView textViewResult = findViewById(R.id.textViewResult);
        Button button = findViewById(R.id.btnCalculate);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float height = Float.parseFloat(String.valueOf(editTextHeight.getText())) / 100;
                float weight = Float.parseFloat(String.valueOf(editTextWeight.getText()));

                // Calculate BMI
                float bmi2  = weight / (height * height);

                // Round BMI to the nearest whole number
                int roundedBMI = Math.round(bmi2);

                // Display result without decimal places


                if (roundedBMI <= 18.5 && roundedBMI < 25) {
                    // Normal weight
                    Intent intent = new Intent(bmi2.this, normalweight.class);
                    startActivity(intent);
                }else if (roundedBMI >= 25 && roundedBMI < 30) {
                    // Overweight
                    Intent intent = new Intent(bmi2.this, Overweight.class);
                    startActivity(intent);
                }else if (roundedBMI >30){
                        // Obese
                        Intent intent = new Intent(bmi2.this, Obese.class);
                        startActivity(intent);
                    }
                }
                

        });
    }
}