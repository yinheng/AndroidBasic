package com.android.androidbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        String[] list = {"孙悟空","猪八戒","沙僧"};

        ListView listView = (ListView) findViewById(R.id.ListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice,list);
        listView.setAdapter(arrayAdapter);

    }
}
