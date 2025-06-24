package com.example.datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    EditText etUsername, etEmail;
    Button btnSave;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        btnSave = findViewById(R.id.btnSave);

        prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        etUsername.setText(prefs.getString("username_key", ""));
        etEmail.setText(prefs.getString("email_key", ""));

        btnSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("username_key", etUsername.getText().toString());
            editor.putString("email_key", etEmail.getText().toString());
            editor.apply();

            Toast.makeText(this, "Settings Saved", Toast.LENGTH_SHORT).show();
        });
    }
}
