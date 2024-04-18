package com.example.schoolapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize UI elements
        questionTextView = findViewById(R.id.questionTextView1);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup1);
        submitButton = findViewById(R.id.submitButton4);

        // Set the question text
        questionTextView.setText("What is 2 + 2?");

        // Set onClickListener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected radio button ID
                int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();

                if (selectedOptionId == -1) {
                    // No option selected
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                } else {
                    // Get the selected radio button
                    RadioButton selectedRadioButton = findViewById(selectedOptionId);

                    // Check the selected answer
                    if (selectedRadioButton.getText().toString().equals("B. 4")) {
                        // Correct answer
                        Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        // Incorrect answer
                        Toast.makeText(QuizActivity.this, "Incorrect. The correct answer is 4", Toast.LENGTH_SHORT).show();
                    }

                    // Clear the selection
                    optionsRadioGroup.clearCheck();
                }
            }
        });
    }
}
