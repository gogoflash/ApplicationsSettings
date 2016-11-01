package com.example.student.applicationssettings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by student on 2016.
 */
public class AppPermittionsDetalize extends AppCompatActivity {

    private TextView permits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_detalize);

        permits = (TextView) findViewById(R.id.permitts);

        Intent intent = getIntent();
        if(intent != null) {
            String name = intent.getStringExtra(MainActivity.APP_PERMITTIONS);
            if(name != null) {
                permits.setText(name);
                permits.setText(Html.fromHtml(name));

            }

            if(intent.hasExtra(MainActivity.APP_NAME))
                ((TextView) findViewById(R.id.app_title)).setText(intent.getStringExtra(MainActivity.APP_NAME));
        }

    }

    @Override
    public void onBackPressed() {
      /*  Intent intent = new Intent();
        intent.putExtra(MainActivity.SAINT_ID, saintId);
        intent.putExtra(MainActivity.SAINT_RATE, ratingBar.getRating());
        setResult(RESULT_OK, intent);*/

        super.onBackPressed();
    }
}

