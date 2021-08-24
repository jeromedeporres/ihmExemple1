package fr.greta60.ihmexemple1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LayoutExempleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_layout_exemple);
        // récupère le btn "start activity 2 btn"
        Button btn = (Button) findViewById(R.id.visiter_google_btn);
        final Activity a = this;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // créer l'objet Intent (implicite)
                //String url = "https:/google.fr";
                //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                //startActivity(i);


                //send email
                /*Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*//*");
                intent.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"test@test.fr", "test2@test.fr"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "mon message");
                //intent.putExtra(Intent.EXTRA_STREAM, attachment);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);

                }
                else{
                    Toast.makeText(LayoutExempleActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }*/

                // Passer a un autre app "Btn"
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                i.setClassName("fr.greta60.demo", "fr.greta60.demo.MainActivity");
                startActivity(i);
            }
        });
    }
}