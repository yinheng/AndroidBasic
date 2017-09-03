package com.android.androidbasic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guohao4 on 2017/9/3.
 * Email: Tornaco@163.com
 */

public class UserLoader {


    public List<SQLiteTestActivity.Usr> getAllUser(Context context) {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(context.getFilesDir().toString() + SQLiteTestActivity.DB_NAME, null);
        Cursor cursor = db.rawQuery("select * from user_inf", null);

        cursor.moveToFirst();
        List<SQLiteTestActivity.Usr> usrs = new ArrayList<>();

        while (!cursor.isAfterLast()) {
            SQLiteTestActivity.Usr user = new SQLiteTestActivity.Usr();

            user.setId(cursor.getString(cursor.getColumnIndex("user_id")));
            user.setName(cursor.getString(cursor.getColumnIndex("user_name")));
            user.setPass(cursor.getString(cursor.getColumnIndex("user_pass")));
            usrs.add(user);

            cursor.moveToNext();
        }
        return usrs;
    }
}
