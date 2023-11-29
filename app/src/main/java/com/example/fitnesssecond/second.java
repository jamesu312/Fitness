package com.example.fitnesssecond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.fitness.R;
import com.example.fitnesssecond1.bbmi1;

public class second extends AppCompatActivity {

    private ImageButton imgB1, imgB2, imgB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        imgB1 = (ImageButton)findViewById(R.id.imgBtnLw);
        imgB2 = (ImageButton)findViewById(R.id.imgBtnGm);
        imgB3 = (ImageButton)findViewById(R.id.imgBtnGs);


        imgB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bbmi();
            }
        });

        imgB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bbmi1();
            }
        });

        imgB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bbmi();
            }
        });
    }

    private void bbmi1() {
        Intent intent = new Intent(this, bbmi1.class);
        startActivity(intent);
    }

    private void bbmi() {
        Intent intent = new Intent(this, bbmi.class);
        startActivity(intent);
    }



}