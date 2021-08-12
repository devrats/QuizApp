package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int index = 0;
    public static final String EXTRA_NAME = "com.example.firstmultiscreen.extra.NAME";
    public static final String EXTRA_ANSWER = "com.example.firstmultiscreen.extra.ANSWER";
    public static String[] questions = {"1. Narendra Modi is 14th prime minister of india",
            "2. Pikachu is a ground type pokemon", "3.The name of the smart parceling currency is coins",
            "4. Hemant is maharaj of bharatpur", "5. gangs of wasseypur is a Manoj bajpayee starer"};
    public static boolean[] answers = {true, false, false, true, true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Boolean[] actualAnswer = new Boolean[5];
        TextView textView = findViewById(R.id.textView2);
        textView.setText(questions[index]);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answers[index]) {
                    score++;
                }
                actualAnswer[index] = true;
                index++;
                if(index<questions.length) {
                    textView.setText(questions[index]);
                } else {
                    Toast.makeText(MainActivity.this, "Calculating score ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra(EXTRA_NAME, String.valueOf(score));
                    intent.putExtra(EXTRA_ANSWER, Arrays.toString(actualAnswer));
                    startActivity(intent);
                    finish();
                }

            }
        });
        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answers[index]) {
                    score++;
                }
                actualAnswer[index] = false;
                index++;
                if(index<questions.length) {
                    textView.setText(questions[index]);
                } else {
                    Toast.makeText(MainActivity.this, "Calculating score ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra(EXTRA_NAME, String.valueOf(score));
                    intent.putExtra(EXTRA_ANSWER, Arrays.toString(actualAnswer));
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}