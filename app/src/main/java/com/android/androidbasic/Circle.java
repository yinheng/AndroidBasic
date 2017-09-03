package com.android.androidbasic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by guohao4 on 2017/8/31.
 * Email: Tornaco@163.com
 */

public class Circle extends View {
    int x = 100;
    int y = 100;


    final static int CHANGE_COLOR = 0;
    final static int STOP_CHANGE_COLOR = 1;

    int[] colors = {Color.RED, Color.GREEN, Color.YELLOW};

    int i = 0;

    private Handler handler;

    final Timer timer = new Timer();


    public Circle(Context context) {
        super(context);
    }

    public Circle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == CHANGE_COLOR) {
                    i++;
                    if (i == colors.length) {
                        i = 0;
                    }
                    invalidate();
                } else if (msg.what == STOP_CHANGE_COLOR) {
                    i = 0;
                    timer.cancel();
                    timer.purge();
                }
            }
        };
    }

    public void stopFlash() {
        handler.sendEmptyMessage(STOP_CHANGE_COLOR);
    }

    public void flash() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(CHANGE_COLOR);
            }
        }, 5000, 1000);
    }


    @Override
    public void onDraw(Canvas canvas) {
        Log.d("Yinheng", "onDraw");
        Paint paint = new Paint();
        paint.setColor(colors[i]);
        canvas.drawCircle(x, y, 100, paint);
    }


}
