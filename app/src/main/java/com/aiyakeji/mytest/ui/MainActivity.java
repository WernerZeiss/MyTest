package com.aiyakeji.mytest.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.aiyakeji.mytest.R;
import com.nineoldandroids.view.ViewHelper;

import static com.aiyakeji.mytest.R.id.main_btn_one;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
    private Button btn_five;
    private Button btn_six;
    private Button btn_seven;
    private Button btn_eight;
    private Button btn_nine;
    private Button btn_rajava_retrofit2;

    private Toolbar toolbar;
    private ImageView iv_menu_toggle;
    private DrawerLayout mDrawerLayout;
    private ListView lvLeftMenu;
    private String[] lvs = {"List Item 01", "List Item 02", "List Item 03", "List Item 04"};
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initView();
        initEvents();
    }


    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        iv_menu_toggle = (ImageView) findViewById(R.id.main_iv__menu_toggle);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
        mDrawerLayout.setScrimColor(0x00000000);

        button = (Button) findViewById(main_btn_one);
        btn_two = (Button) findViewById(R.id.main_btn_two);
        btn_three = (Button) findViewById(R.id.main_btn_three);
        btn_four = (Button) findViewById(R.id.main_btn_four);
        btn_five = (Button) findViewById(R.id.main_btn_five);
        btn_six = (Button) findViewById(R.id.main_btn_six);
        btn_seven = (Button) findViewById(R.id.main_btn_seven);
        btn_eight = (Button) findViewById(R.id.main_btn_eight);
        btn_nine = (Button) findViewById(R.id.main_btn_nine);
        btn_rajava_retrofit2 = (Button) findViewById(R.id.main_btn_rajava_retrofit2);

        lvLeftMenu = (ListView) findViewById(R.id.left_lv_menu);

        iv_menu_toggle.setOnClickListener(this);
        button.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_rajava_retrofit2.setOnClickListener(this);
    }


    private void initView() {
        toolbar.setTitle("Toolbar");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }

        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        lvLeftMenu.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_iv__menu_toggle://侧边栏开关
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.main_btn_one://打开新页面
                startActivity(new Intent(MainActivity.this, OneActivity.class));
                overridePendingTransition(R.anim.payactivity_open, 0);
                break;
            case R.id.main_btn_two://打开页面二
                startActivity(new Intent(MainActivity.this, TwoActivity.class));
                break;
            case R.id.main_btn_three://页面三
                startActivity(new Intent(MainActivity.this, ThreeActivity.class));
                break;
            case R.id.main_btn_four://页面四
                startActivity(new Intent(this, FourActivity.class));
                break;
            case R.id.main_btn_five://页面五
                startActivity(new Intent(this, FiveActivity.class));
                break;
            case R.id.main_btn_six://页面6
                startActivity(new Intent(this, SixActivity.class));
                break;
            case R.id.main_btn_seven://页面七
                startActivity(new Intent(this, SevenActivity.class));
                break;
            case R.id.main_btn_eight://页面八
                startActivity(new Intent(this, EightActivity.class));
                break;
        }
    }

    private void initEvents() {
        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerStateChanged(int newState) {
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = mDrawerLayout.getChildAt(0);
                View mMenu = drawerView;
                float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;

                float leftScale = 1 - 0.3f * scale;

                ViewHelper.setScaleX(mMenu, leftScale);
                ViewHelper.setScaleY(mMenu, leftScale);
                ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
                ViewHelper.setTranslationX(mContent, mMenu.getMeasuredWidth() * (1 - scale));
                ViewHelper.setPivotX(mContent, 0);
                ViewHelper.setPivotY(mContent, mContent.getMeasuredHeight() / 2);
                mContent.invalidate();
                ViewHelper.setScaleX(mContent, rightScale);
                ViewHelper.setScaleY(mContent, rightScale);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
//                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
            }
        });
    }
}
