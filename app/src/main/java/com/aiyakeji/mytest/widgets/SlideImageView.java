package com.aiyakeji.mytest.widgets;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;

/**
 * Author：CWQ
 * Date：2019/3/16
 * Desc:可拖动可点击ImageView
 */
public class SlideImageView extends AppCompatImageView {

    private int screenWidth;
    private int screenHeight;
    private int downY;
    private int downX;
    private int lastX;
    private int lastY;
    private boolean isDrag;

    public SlideImageView(Context context) {
        super(context);
        init();
    }

    public SlideImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SlideImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        getScreenWidthAndHeight(getContext());
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getRawX();
                downY = (int) event.getRawY();
                isDrag = false;
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                isDrag = true;
                int dx = rawX - lastX;
                int dy = rawY - lastY;

                float x = getX() + dx;
                float y = getY() + dy;
                //边缘检测
                x = x < 0 ? 0 : x > screenWidth - getWidth() ? screenWidth - getWidth() : x;
                y = y < 0 ? 0 : y > screenHeight - getHeight() ? screenHeight - getHeight() : y;
                setX(x);
                setY(y);
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_UP:
                int distance = Math.max(Math.abs(rawX - downX), Math.abs(rawY - downY));
                if (distance < 8) {//容错范围
                    isDrag = false;
                }
                if (isDrag) {
                    setPressed(false);
                }
                break;
        }

        return isDrag || super.onTouchEvent(event);
    }


    private void getScreenWidthAndHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
    }
}
