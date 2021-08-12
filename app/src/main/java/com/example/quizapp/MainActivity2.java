package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String answer = intent.getStringExtra(MainActivity.EXTRA_ANSWER);
        String actualAnswer = answer.substring(1,answer.length()-1);
        String[] split = actualAnswer.split(",");
        TextView textView1 = findViewById(R.id.textView5);
        for (int index = 0; index < 5; index++) {
            textView1.append(MainActivity.questions[index] + "\n");
            textView1.append("Correct answer: " + MainActivity.answers[index] + "\n");
            textView1.append("Your Answer: " + split[index] + "\n\n");
        }
        TextView textView = findViewById(R.id.textView3);
        String score = intent.getStringExtra(MainActivity.EXTRA_NAME);
        textView.setText("your Score is " + score);
        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button button1 = findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "I have scored "+ score);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, "sending score");
                startActivity(shareIntent);
            }
        });
    }
}