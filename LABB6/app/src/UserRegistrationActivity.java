public class UserRegistrationActivity extends AppCompatActivity {

    EditText etName, etUserEmail;
    Button btnRegister, btnViewUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        etName = findViewById(R.id.etName);
        etUserEmail = findViewById(R.id.etUserEmail);
        btnRegister = findViewById(R.id.btnRegister);
        btnViewUsers = findViewById(R.id.btnViewUsers);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String email = etUserEmail.getText().toString();

            DBHelper dbHelper = new DBHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("email", email);

            long rowId = db.insert("users", null, values);
            db.close();

            if (rowId != -1)
                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
        });

        btnViewUsers.setOnClickListener(v -> {
            DBHelper dbHelper = new DBHelper(this);
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
