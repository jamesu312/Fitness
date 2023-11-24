package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class logo extends AppCompatActivity {

    ImageButton img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        img1 = (ImageButton)findViewById(R.id.logo);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity();
            }
        });
    }

    private void MainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}