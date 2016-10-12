package com.example.light;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;

public class LightBkView extends View implements OnClickListener {


    Camera camera = Camera.open();
    // 定义画皮
    Paint paint = new Paint();
    Paint paint1 = new Paint();

    int x = 0;
    int y = 0;
    // 打开闪光灯
    boolean islight;

    public LightBkView(Context context, AttributeSet set) {
        super(context, set);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 获取控件的宽度和高度
        int width = this.getWidth();
        int heigth = this.getHeight();
        // 圆点的坐标
        x = width / 2;
        y = heigth / 2;
        //更换开关背景
        if(!islight){
            paint.setColor(Color.WHITE);
            canvas.drawCircle(x, y, 200, paint);

            invalidate();
        }else{
            paint.setColor(Color.BLACK);
            canvas.drawCircle(x, y, 200, paint);
            paint1.setColor(Color.WHITE);
            paint1.setTextSize(100);
            canvas.drawText("Close", x-100, y, paint1);

            invalidate();
        }
    }

    // 定义View的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getWidth(widthMeasureSpec),
                getHeight(heightMeasureSpec));

    }
    //定义view的宽度
    public int getWidth(int widthMeasureSpec) {
        int reslut = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST) {
            reslut = 500;
        }
        if (widthMode == MeasureSpec.EXACTLY) {
            reslut = MeasureSpec.getSize(widthMeasureSpec);
        }
        return reslut;
    }
    //定义view的高度
    public int getHeight(int heightMeasureSpec) {
        int reslut = 0;
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode == MeasureSpec.AT_MOST) {
            reslut = 500;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            reslut = MeasureSpec.getSize(heightMeasureSpec);
        }
        return reslut;
    }

    // 实现闪光灯的的开关
    @Override
    public void onClick(View v) {



        if (!islight) {


            Parameters mParameters = camera.getParameters();
            mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(mParameters);

            islight = true;
        } else {

            Parameters mParameters = camera.getParameters();
            mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(mParameters);

            islight = false;
        }
    }

}