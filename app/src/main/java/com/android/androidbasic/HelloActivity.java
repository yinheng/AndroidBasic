package com.android.androidbasic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HelloActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Nick", "onCreate!");

        boolean autoRotate = PreferenceManager.getDefaultSharedPreferences(getApplicationContext())
                .getBoolean("key_auto_rotate", false);

        Button start = (Button)findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelloActivity.this, ButtonActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Nick", "onStart!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Nick", "onResume!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Nick", "onPause!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Nick", "onStop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Nick", "onDestroy!");
    }
}
