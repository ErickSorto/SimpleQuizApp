package com.example.quizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitQuestions(View view) {

        createSummary();
        score = 0;
    }

    public int getScore() {
        RadioButton question1Answer1 = (RadioButton) findViewById(R.id.question_1_answer_1_rb);
        RadioButton question2Answer3 = (RadioButton) findViewById(R.id.question_2_answer_3_rb);
        RadioButton question3Answer3 = (RadioButton) findViewById(R.id.question_3_answer_3_rb);
        RadioButton question4Answer4 = (RadioButton) findViewById(R.id.question_4_answer_4_rb);

        CheckBox question5Answer1 = (CheckBox) findViewById(R.id.question_5_answer_1_cb);
        Boolean question5Answer1Checked = question5Answer1.isChecked();

        CheckBox question5Answer2 = (CheckBox) findViewById(R.id.question_5_answer_2_cb);
        Boolean question5Answer2Checked = question5Answer2.isChecked();

        CheckBox question5Answer3 = (CheckBox) findViewById(R.id.question_5_answer_3_cb);
        Boolean question5Answer3Checked = question5Answer3.isChecked();

        TextView javaYear = (TextView) findViewById(R.id.java_year_text_view);
        String javaStringYear = javaYear.getText().toString().trim();

        if (question5Answer1Checked && question5Answer2Checked && question5Answer3Checked == false) {
            score += 1;
        }

        if (question1Answer1.isChecked()) {
            score += 1;
        }

        if (question2Answer3.isChecked()) {
            score += 1;
        }

        if (question3Answer3.isChecked()) {
            score += 1;
        }

        if (question4Answer4.isChecked()) {
            score += 1;
        }

        if (javaStringYear.equals("1995")) {
            score += 1;
        }


        return score;
    }

    public void createSummary() {
        Toast toast = null;
        getScore();
        EditText name = (EditText) findViewById(R.id.edit_name);

        if (score == 0) {
            toast = Toast.makeText(getApplicationContext(), name.getText() + " you got 0/6", Toast.LENGTH_SHORT);
        } else if (score == 1) {
            toast = Toast.makeText(getApplicationContext(), name.getText() + " you got 1/6", Toast.LENGTH_SHORT);
        } else if (score == 2) {
            toast = Toast.makeText(getApplicationContext(), name.getText() + " you got 2/6", Toast.LENGTH_SHORT);
        } else if (score == 3) {
            toast = Toast.makeText(getApplicationContext(), name.getText() + " you got 3/6", Toast.LENGTH_SHORT);
        } else if (score == 4) {
            toast = Toast.makeText(getApplicationContext(), name.getText() + " you got 4/6", Toast.LENGTH_SHORT);
        } else if (score == 5) {
            toast = Toast.makeText(getApplicationContext(), name.getText() + " you got 5/6 \n       Almost!", Toast.LENGTH_SHORT);
        } else if (score == 6) {
            toast = Toast.makeText(getApplicationContext(), name.getText() + " you got 6/6 \n       Congrats!", Toast.LENGTH_SHORT);
        }
        toast.show();

        //0 lowest
        //6 highest

    }
}