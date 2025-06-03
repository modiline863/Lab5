import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewProfileName, textViewProfileId, textViewProfileTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewProfileName = findViewById(R.id.textViewProfileName);
        textViewProfileId = findViewById(R.id.textViewProfileId);
        textViewProfileTopic = findViewById(R.id.textViewProfileTopic);

        // Get the Intent that started this activity
        Intent intent = getIntent();

        // Check if the intent has extras
        if (intent != null && intent.getExtras() != null) {
            String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
            String studentId = intent.getStringExtra(MainActivity.EXTRA_STUDENT_ID);
            String researchTopic = intent.getStringExtra(MainActivity.EXTRA_RESEARCH_TOPIC);

            // Display the data
            // Using "Name: " + name directly in setText is okay for simplicity here.
            // For more complex strings or localization, use string resources.
            textViewProfileName.setText("Name: " + (name != null ? name : "N/A"));
            textViewProfileId.setText("Student ID: " + (studentId != null ? studentId : "N/A"));
            textViewProfileTopic.setText("Research Topic: " + (researchTopic != null && !researchTopic.isEmpty() ? researchTopic : "N/A"));
        } else {
            // Handle the case where no data was passed (optional)
            textViewProfileName.setText("Name: Error loading data");
            textViewProfileId.setText("Student ID: Error loading data");
            textViewProfileTopic.setText("Research Topic: Error loading data");
        }
    }
}

