package com.example.fitness;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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
                activity_3();
            }
        });

        imgB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity_4();
            }
        });

        imgB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity_5();
            }
        });
    }

    private void activity_3() {
        Intent intent = new Intent(this,activity_3.class);
        startActivity(intent);
    }


    private void activity_4() {
        Intent intent = new Intent(this,activity_4.class);
        startActivity(intent);
    }

    private void activity_5() {
        Intent intent = new Intent(this,activity_5.class);
        startActivity(intent);
    }

}