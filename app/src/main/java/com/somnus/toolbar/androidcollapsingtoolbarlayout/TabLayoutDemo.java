package com.somnus.toolbar.androidcollapsingtoolbarlayout;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.somnus.toolbar.androidcollapsingtoolbarlayout.adapter.TabLayoutFragmentAdapter;
import com.somnus.toolbar.androidcollapsingtoolbarlayout.fragment.Fragment1;
import com.somnus.toolbar.androidcollapsingtoolbarlayout.fragment.Fragment2;
import com.somnus.toolbar.androidcollapsingtoolbarlayout.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutDemo extends AppCompatActivity {

    private Fragment1 mfragment1;
    private Fragment2 mfragment2;
    private Fragment3 mfragment3;

    private ViewPager view_pager_layout;
    private TabLayoutFragmentAdapter fAdapter;                               //定义adapter
    private TabLayout tab_layout;

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private String[] list_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStatuBarTransparent();
        setContentView(R.layout.activity_tab_layout_demo);
        initView();
        initFragment();
    }

    private void initView() {
        view_pager_layout = (ViewPager) findViewById(R.id.view_pager_layout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_tab_layout);
        setSupportActionBar(toolbar);
        //  给左上角图标的左边加上一个返回的
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tab_layout = (TabLayout) findViewById(R.id.tab_layout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        mfragment1 = new Fragment1();
        mfragment2 = new Fragment2();
        mfragment3 = new Fragment3();

        list_fragment = new ArrayList<>();
        list_fragment.add(mfragment1);
        list_fragment.add(mfragment2);
        list_fragment.add(mfragment3);

        list_title = new String[0];
        list_title = getResources().getStringArray(R.array.tab_title);
        tab_layout.addTab(tab_layout.newTab().setText(list_title[0]));
        tab_layout.addTab(tab_layout.newTab().setText(list_title[1]));
        tab_layout.addTab(tab_layout.newTab().setText(list_title[2]));

        fAdapter = new TabLayoutFragmentAdapter(getSupportFragmentManager(), list_fragment, list_title);
        //viewpager加载adapter
        view_pager_layout.setAdapter(fAdapter);
        //TabLayout加载viewpager
        tab_layout.setupWithViewPager(view_pager_layout);
    }

    private void setStatuBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

    }

}
