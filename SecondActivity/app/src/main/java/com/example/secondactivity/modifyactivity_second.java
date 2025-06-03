package com.example.intentdemojava; // Replace with your actual package name

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button btnFinishSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnFinishSecondActivity = findViewById(R.id.btnFinishSecondActivity);

        btnFinishSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // This closes the current activity (SecondActivity)
            }
        });
    }
}