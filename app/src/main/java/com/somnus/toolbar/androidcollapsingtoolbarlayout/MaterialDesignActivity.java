package com.somnus.toolbar.androidcollapsingtoolbarlayout;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MaterialDesignActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button4;
    private Button button5;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 表示允许使用转换动画，设置方式有两种 1:代码设置
         * 2:
         * <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
         <item name="android:windowContentTransitions">true</item>
         </style>
         */
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_material_design);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        animatorMethod();

    }


    /**
     * 动画效果
     */
    private void animatorMethod() {
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:
                Animator mAnimator = ViewAnimationUtils.createCircularReveal(button4, button4.getWidth() / 2, button4.getHeight() / 2, 0, button4.getHeight());
                mAnimator.setDuration(2000);
                mAnimator.setInterpolator(new AccelerateInterpolator());
                mAnimator.start();

                break;
            case R.id.button5:
                float endRadius = (float) Math.hypot(button5.getWidth(), button5.getHeight());//勾股定理得到斜边长度
                Animator mAnimator1 = ViewAnimationUtils.createCircularReveal(button5, button5.getWidth(), 0, 0, endRadius);
                mAnimator1.setDuration(2000);
                mAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
                mAnimator1.start();


                break;
            case R.id.imageView:
                startAnimatorActivity();
                break;
            default:
                break;
        }
    }

    private void startAnimatorActivity() {
        /**
         *@activity - 当前的activity
         *@sharedElement - 共享的元素视图
         *@sharedElementName - 共享元素的名称
         */
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, "somnus");
        Intent intent = new Intent(this, OptionsCompatActivity.class);
        startActivity(intent, options.toBundle());
    }
}
