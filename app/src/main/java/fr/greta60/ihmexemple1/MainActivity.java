package fr.greta60.ihmexemple1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int GET_SCORE_ACTIVITY = 1;
    //pour filtrer les messages
    private static final String TAG = "MainActivity_LifeCycle";

    private int score = 0;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "dans onCreate");
        setContentView(R.layout.main);
        //vérifie si Bundle n'est pas null
        if(null != savedInstanceState){
            //recupère score stocké dans Bundle
            this.score = savedInstanceState.getInt("score", 0);
        }
        this.tv = findViewById(R.id.mainActivity_text);
        tv.setText(""+this.score);
        //récupérer le bouton "start_activity_2_btn"
        Button btn = (Button)findViewById(R.id.start_activity_2_btn);
        final Activity a = this;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //créer l'objet Intent (explicite)
                Intent i = new Intent(a, LayoutExempleActivity.class);
                startActivity(i);
                //finish();
            }
        });
        /*btn.setOnClickListener(()->{
            Intent i = new Intent(MainActivity.this, LayoutExempleActivity.class);
            startActivity(i);
        });*/
        //récupérer le bouton "start_activity_2_btn"
        Button btn2 = (Button)findViewById(R.id.get_score_activity);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //créer l'objet Intent (explicite)
                Intent i = new Intent(a, IntentResultActivity.class);
                startActivityForResult(i, GET_SCORE_ACTIVITY);
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "dans onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "dans onStart");
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "dans onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "dans onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "dans onStop");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("score", this.score);
        Log.d(TAG, "dans onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "dans onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "dans onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_CANCELED) return;

        switch (requestCode){
            case GET_SCORE_ACTIVITY:
                //afficher le score
                if(data != null){
                    this.score = data.getIntExtra("score", 0);
                    Log.d("MainActivity", ""+this.score);
                    //TextView tv = findViewById(R.id.main_activity_text);
                    this.tv.setText("Score : "+ this.score);
                }
                break;
            default:
                break;
        }
    }
}
