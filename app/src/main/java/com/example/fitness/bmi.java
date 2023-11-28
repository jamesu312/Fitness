package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitness1.normalweight;
import com.example.fitness2.overweight;
import com.example.fitness3.obese;

public class bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        EditText editTextWeight = findViewById(R.id.Weight);
        EditText editTextHeight = findViewById(R.id.Height);
        TextView textViewResult = findViewById(R.id.textViewResult);
        Button button = findViewById(R.id.btnCalculate);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float height = Float.parseFloat(String.valueOf(editTextHeight.getText())) / 100;
                float weight = Float.parseFloat(String.valueOf(editTextWeight.getText()));

                // Calculate BMI
                float bmi = weight / (height * height);

                // Round BMI to the nearest whole number
                int roundedBMI = Math.round(bmi);

                // Display result without decimal places
                textViewResult.setText("Your BMI: " + roundedBMI);

                if (roundedBMI < 18.5) {
                    // Underweight
                    Intent intent = new Intent(bmi.this, underweight.class);
                    startActivity(intent);
                    //
                }else if (roundedBMI >= 18.5 && roundedBMI < 25) {
                    // Normal weight
                    Intent intent = new Intent(bmi.this, normalweight.class);
                    startActivity(intent);
                }else if (roundedBMI >= 25 && roundedBMI < 30) {
                    // Overweight
                    Intent intent = new Intent(bmi.this, overweight.class);
                    startActivity(intent);
                }else {
                    // Obese
                    Intent intent = new Intent(bmi.this, obese.class);
                    startActivity(intent);
                }
            }

        });
    }

}