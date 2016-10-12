package com.example.light;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.RelativeLayout;

public class Background extends Activity {



    private LightBkView light1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        light1 = (LightBkView) findViewById(R.id.light1);
        RelativeLayout layout=(RelativeLayout) findViewById(R.id.layout);
        layout.setBackgroundColor(Color.BLACK);

        //定义单击事件
        light1.setOnClickListener(light1);



    }





}
