package com.android.androidbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileActivity extends AppCompatActivity {

    final String FILE_NAME = "crazyit.bin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);
        final Button write = (Button) findViewById(R.id.write);
        Button read = (Button)findViewById(R.id.read);
        final TextView writeText = (TextView)findViewById(R.id.writeText);
        final TextView readText = (TextView)findViewById(R.id.readText);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = writeText.getText().toString();
                writeText.setText("");
                write(content);

            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readText.setText(read());
            }
        });

    }

    public void write(String content) {
       try {
           FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
           PrintStream ps = new PrintStream(fos);
           ps.println(content);
           ps.flush();
           ps.close();

       }
       catch (FileNotFoundException e) {
           e.printStackTrace();
       }
    }

    public StringBuilder read() {
        StringBuilder sb = new StringBuilder("");
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            byte[] buff = new byte[1024];

            int hasRead = 0;
            while ((hasRead = fis.read(buff)) != -1) {
                sb.append(new String(buff, 0 , hasRead));
            }

            fis.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return sb;

    }
}
