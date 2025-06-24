package com.example.datastorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.ContentValues;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab6.R;

public class UserRegistrationActivity extends AppCompatActivity {

    EditText etName, etEmail;
    Button btnRegister, btnViewUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        etName = findViewById(R.id.btnUserRegistration);
        etEmail = findViewById(R.id.etEmail);
        btnRegister = findViewById(R.id.btnRegister);
        btnViewUsers = findViewById(R.id.btnViewUsers);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            com.example.datastorage.DBHelper dbHelper = new DBHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("email", email);

            long result = db.insert("users", null, values);
            db.close();

            if (result != -1) {
                Toast.makeText(this, "User Registered!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
            }
        });

        btnViewUsers.setOnClickListener(v -> {
            com.example.datastorage.DBHelper dbHelper = new com.example.datastorage.DBHelper(this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            Cursor cursor = db.query("users", null, null, null, null, null, null);

            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                Log.d("User Data", "Name: " + name + ", Email: " + email);
            }

            cursor.close();
            db.close();
        });
    }
}

