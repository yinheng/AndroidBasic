package com.android.androidbasic;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

/**
 * Created by guohao4 on 2017/8/27.
 * Email: Tornaco@163.com
 */

public class MyPerferenceActivtity extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.perference);
    }
}
