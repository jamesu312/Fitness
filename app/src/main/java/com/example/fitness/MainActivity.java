package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton Btn1, Btn2, Btn3, Btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn1 = (ImageButton)findViewById(R.id.imgBtn1);
        Btn2 = (ImageButton)findViewById(R.id.imgBtn2);
        Btn3 = (ImageButton)findViewById(R.id.imgBtn3);
        Btn4 = (ImageButton)findViewById(R.id.imgBtn4);

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity2();
            }
        });
        ;
    }

    private void Activity2() {
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }
}