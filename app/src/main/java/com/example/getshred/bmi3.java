package com.example.getshred;

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
import com.example.gainmuscle.Obese;
import com.example.gainmuscle.Overweight;
import com.example.gainmuscle.bmi2;

public class bmi3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi3);
        EditText editTextWeight = findViewById(R.id.Weight);
        EditText editTextHeight = findViewById(R.id.Height);
        TextView textViewResult = findViewById(R.id.textViewResult);
        Button button = findViewById(R.id.btnCalculate);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float height = Float.parseFloat(String.valueOf(editTextHeight.getText())) / 100;
                float weight = Float.parseFloat(String.valueOf(editTextWeight.getText()));

                // Calculate BMI
                float bmi3  = weight / (height * height);

                // Round BMI to the nearest whole number
                int roundedBMI = Math.round(bmi3);

                // Display result without decimal places


                if (roundedBMI <= 18.5 && roundedBMI < 25) {
                    // Normal weight
                    Intent intent = new Intent(bmi3.this,NormalWeight.class);
                    startActivity(intent);
                }else if (roundedBMI >= 25 && roundedBMI < 30) {
                    // Overweight
                    Intent intent = new Intent(bmi3.this, OverWeight.class);
                    startActivity(intent);
                }else if (roundedBMI >30){
                    // Obese
                    Intent intent = new Intent(bmi3.this, Obesee.class);
                    startActivity(intent);
                }
            }


        });
    }
}