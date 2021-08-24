package fr.greta60.ihmexemple1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class IntentResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_result);
        Intent i = getIntent();
        int score = (int) (Math.random()*100);
        i.putExtra("score", score);
        setResult(RESULT_OK, i);
        finish();
    }
}