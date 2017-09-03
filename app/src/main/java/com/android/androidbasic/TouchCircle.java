package com.android.androidbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class TouchCircle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_circle);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root);
        //final Circle circle = new Circle(this);
        final Circle circle = (Circle) findViewById(R.id.circle);
        circle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                circle.x =(int) motionEvent.getX();
                circle.y = (int)motionEvent.getY();
                circle.invalidate();
                return true;
            }
        });


        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circle.flash();
            }
        });


        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circle.stopFlash();
            }
        });
        //linearLayout.addView(circle);
    }

}
