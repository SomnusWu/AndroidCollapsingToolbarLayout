package com.somnus.toolbar.androidcollapsingtoolbarlayout;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.somnus.toolbar.androidcollapsingtoolbarlayout.adapter.MyRecyclerViewAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * http://www.open-open.com/lib/view/open1438265746378.html
 */
public class CollapsingToolbarLayoutActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatuBarTransparent();
        setContentView(R.layout.activity_collapsing_toolbar_layout);
        initDate();
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        //  给左上角图标的左边加上一个返回的
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置背景颜色
//        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle("CollapsingToolbarLayout");
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色
        //扩张时候的title颜色
//        mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorAccent));
//        收缩后在Toolbar上显示时的title的颜色
//        mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));

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

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            setTranslucentStatus(true);
//            SystemBarTintManager tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setStatusBarTintResource(R.color.titlec);// 通知栏颜色
//        }

    }

    private void initDate() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(this, datas));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                Toast.makeText(this, "点击了item1", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
