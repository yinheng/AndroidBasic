package com.android.androidbasic;

import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class ImageActivity extends AppCompatActivity {

    private static final int MSG_CHANGE_IMG = 1;
    int[] images = new int[] {R.drawable.ic_comments_smiley, R.drawable.ic_assistant, R.drawable.ic_microsoft_alt};
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        final ImageView imageView = (ImageView)findViewById(R.id.imageView);

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == MSG_CHANGE_IMG){

                    imageView.setImageResource(images[index++]);
                    if(index == images.length) {
                        index = 0;
                    }
                }
            }
        };
        Button button = (Button) findViewById(R.id.button3);


        String size = PreferenceManager.getDefaultSharedPreferences(this).getString("key_size", "12");
        button.setTextSize(Integer.parseInt(size));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(MSG_CHANGE_IMG);
                    }
                }, 0, 1000);
            }
        });
    }
}
