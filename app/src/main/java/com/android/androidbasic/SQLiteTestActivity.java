package com.android.androidbasic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SQLiteTestActivity extends AppCompatActivity {
    final static String DB_NAME = "/my.db3";

    static class Usr {
        String id;
        String name;
        String pass;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        @Override
        public String toString() {
            return "id:" + id + "name:" + name + "pass" + pass;
        }
    }

    private PowerManager powerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        powerManager = (PowerManager) getSystemService(POWER_SERVICE);

        setContentView(R.layout.activity_sqlite_test);
        final SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString() + DB_NAME, null);
        String sql = "create table if not exists user_inf (user_id integer primary key, user_name varchar(255), user_pass varchar(255))";
        db.execSQL(sql);
        // db.execSQL("insert into user_inf values(?, ?, ?)", new String[]{"3", "hello", "999887"});

        final TextView textView = (TextView) findViewById(R.id.textView);
        Button show = (Button) findViewById(R.id.show);
        Button write = (Button) findViewById(R.id.write);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserLoader userLoader = new UserLoader();
                StringBuilder sb = new StringBuilder();
                List<Usr> usrs = userLoader.getAllUser(SQLiteTestActivity.this);
                for(int i = 0; i < usrs.size(); i ++) {
                    sb.append(usrs.get(i)).append("\n");
                }
                textView.setText(sb);

                Log.d("Nick", "All users:" + usrs);
            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("insert into user_inf values(null, ?, ?)", new String[]{"nihao", "111111"});
            }
        });
    }



}
