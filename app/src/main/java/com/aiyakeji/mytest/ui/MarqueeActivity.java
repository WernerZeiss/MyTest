package com.aiyakeji.mytest.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ViewFlipper;

import com.aiyakeji.mytest.R;
import com.aiyakeji.mytest.widgets.MarqueeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author：CWQ
 * Date：2019/3/3
 * Desc:跑马灯测试
 */
public class MarqueeActivity extends AppCompatActivity implements View.OnClickListener {

    String[] arr = {"这个就是你，说也说不清楚", "心中有阳光，脚底有力量！"};
    private ViewFlipper mViewFlipper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marquee);

        MarqueeView mv = findViewById(R.id.marqueeView);
//        mv.startWithList(Arrays.asList(arr));

        List<View> viewList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_marqueeview, null);
            viewList.add(view);
        }
        mv.startWithViewList(viewList);


        mViewFlipper = findViewById(R.id.viewFlipper);
        findViewById(R.id.tvFirstNext).setOnClickListener(this);
        findViewById(R.id.tvSecondNext).setOnClickListener(this);
        findViewById(R.id.tvThirdNext).setOnClickListener(this);
        mViewFlipper.setAutoStart(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvFirstNext:
                mViewFlipper.showNext();
                break;
            case R.id.tvSecondNext:
                mViewFlipper.showNext();
                break;
            case R.id.tvThirdNext:
                mViewFlipper.showNext();
                break;
        }
    }
}
