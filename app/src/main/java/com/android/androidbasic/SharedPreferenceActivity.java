package com.android.androidbasic;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedPreferenceActivity extends AppCompatActivity {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        prefs = getSharedPreferences("crazyit", MODE_WORLD_READABLE);
        editor = prefs.edit();

        int count = prefs.getInt("Count", 0);
        Toast.makeText(this, "Count=" + count, Toast.LENGTH_SHORT).show();
        editor.putInt("Count", ++count).commit();

        Button read = (Button) findViewById(R.id.read);
        Button write = (Button) findViewById(R.id.write);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = prefs.getString("Time", null);
                int radom = prefs.getInt("Radom", 0);

                String result = time == null ? "您暂时还未写入数据" : "写入的时间为：" + time + "\n上次的随机数为：" + radom;
                Toast.makeText(SharedPreferenceActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日" + "hh:mm:ss");
                String time = sdf.format(new Date());
                editor.putString("Time", time);
                editor.putInt("Radom", (int) (Math.random() * 10000000));
                editor.commit();
            }
        });

    }
}
