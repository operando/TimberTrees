package com.os.operando.timber.tree.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.log).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timber.w("log test");
            }
        });

        findViewById(R.id.error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timber.e(new Exception("error test"), "error test");
            }
        });
    }
}