package com.example.fitnesssecond2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitness.R;
import com.example.fitness.bmi;
import com.example.fitness1.normalweight;
import com.example.fitness2.overweight;
import com.example.fitness3.obese;
import com.example.fitnesssecond.Normalweights;
import com.example.fitnesssecond.Overweights;
import com.example.fitnesssecond.bbmi;
import com.example.gainmuscle.Obese;
import com.example.gainmuscle.Overweight;
import com.example.gainmuscle.bmi2;
import com.example.getshred.NormalWeight;
import com.example.getshred.Obesee;
import com.example.getshred.OverWeight;
import com.example.getshred.bmi3;

public class bbmi2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbmi2);
        EditText editTextWeight = findViewById(R.id.Weight);
        EditText editTextHeight = findViewById(R.id.Height);
        TextView textViewResult = findViewById(R.id.textViewResult);
        Button button = findViewById(R.id.btnCalculate);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float height = Float.parseFloat(String.valueOf(editTextHeight.getText())) / 100;
                float weight = Float.parseFloat(String.valueOf(editTextWeight.getText()));

                // Calculate BMI
                float bbmi2  = weight / (height * height);

                // Round BMI to the nearest whole number
                int roundedBMI = Math.round(bbmi2);

                // Display result without decimal places

                if (roundedBMI < 25) {
                    // Normal weight
                    Intent intent = new Intent(bbmi2.this, normsweight.class);
                    startActivity(intent);
                }else if (roundedBMI >= 25 && roundedBMI < 30) {
                    // Overweight
                    Intent intent = new Intent( bbmi2.this, oversweightss.class);
                    startActivity(intent);
                }else if (roundedBMI >= 30){
                    // Obese
                    Intent intent = new Intent(bbmi2.this, obessee.class);
                    startActivity(intent);
                }
            }


        });
    }
}