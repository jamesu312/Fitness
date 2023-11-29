package com.example.fitness;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.gainmuscle.bmi2;
import com.example.getshred.bmi3;

import java.util.Objects;

public class Activity2 extends AppCompatActivity {

    private ImageButton imgB1, imgB2, imgB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        imgB1 = (ImageButton)findViewById(R.id.imgBtnLw);
        imgB2 = (ImageButton)findViewById(R.id.imgBtnGm);
        imgB3 = (ImageButton)findViewById(R.id.imgBtnGs);


        imgB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bmi();
            }
        });

        imgB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bmi2();
            }
        });

        imgB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bmi3();
            }
        });
    }
    private void bmi() {
        Intent intent = new Intent(this,bmi.class);
        startActivity(intent);
    }

    private void bmi2() {
        Intent intent = new Intent(this, bmi2.class);
        startActivity(intent);
    }


    private void bmi3() {
        Intent intent = new Intent(this, bmi3.class);
        startActivity(intent);
    }


}