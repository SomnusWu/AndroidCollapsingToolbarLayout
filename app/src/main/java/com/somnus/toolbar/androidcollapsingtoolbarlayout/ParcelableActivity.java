package com.somnus.toolbar.androidcollapsingtoolbarlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.somnus.toolbar.androidcollapsingtoolbarlayout.bean.ParcelableBean;

public class ParcelableActivity extends AppCompatActivity {

    private TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);
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


        tv_text = (TextView) findViewById(R.id.tv_text);
        ParcelableBean mPerson = (ParcelableBean)getIntent().getParcelableExtra(ParcelableBean.KEY);
        tv_text.setText("name= "+mPerson.getName()+"age="+mPerson.getAge());



    }

}
