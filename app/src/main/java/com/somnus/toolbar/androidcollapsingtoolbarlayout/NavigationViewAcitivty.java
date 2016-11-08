package com.somnus.toolbar.androidcollapsingtoolbarlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;

import com.dd.processbutton.iml.ActionProcessButton;
import com.somnus.mylib.recycleutils.utils.FormValidation;
import com.somnus.mylib.recycleutils.utils.KeyboardUtils;
import com.somnus.mylib.recycleutils.utils.LogManag;
import com.somnus.mylib.recycleutils.utils.WidgetUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NavigationViewAcitivty extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Bind(R.id.textInputLayout_phone)
    TextInputLayout textInputLayoutPhone;
    @Bind(R.id.textInputLayout_password)
    TextInputLayout textInputLayoutPassword;
    @Bind(R.id.button_sign)
    ActionProcessButton buttonSign;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_navigation_view_acitivty);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        initTextInputLayout();
    }

    //initTextInputlayout
    private void initTextInputLayout() {
        textInputLayoutPhone.getEditText().addTextChangedListener(new com.somnus.toolbar.androidcollapsingtoolbarlayout.utils.TextWatcher(textInputLayoutPhone) {
            @Override
            public void afterTextChanged(Editable s) {
                if (getEditString().length() > 10)
                    if (FormValidation.isMobile(getEditString())) {
                        textInputLayoutPhone.setErrorEnabled(false);
                    } else {
                        setEditTextError(textInputLayoutPhone, R.string.msg_error_phone);
                    }
            }
        });
        textInputLayoutPassword.getEditText().addTextChangedListener(new com.somnus.toolbar.androidcollapsingtoolbarlayout.utils.TextWatcher(textInputLayoutPassword) {
            @Override
            public void afterTextChanged(Editable s) {
                if (getEditString().length() > 5)
                    if (FormValidation.isSimplePassword(getEditString())) {
                        textInputLayoutPassword.setErrorEnabled(false);
                    } else {
                        setEditTextError(textInputLayoutPassword, R.string.msg_error_password);
                    }
            }
        });
    }

    private void setEditTextError(TextInputLayout layout, int msgId) {
        layout.setErrorEnabled(true);
        layout.setError(getString(msgId));
    }


    /***
     * onNavigationItemSelected
     *
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean valid(String phone, String password) {
        if (!FormValidation.isMobile(phone)) {
            WidgetUtils.requestFocus(textInputLayoutPhone.getEditText());
            setEditTextError(textInputLayoutPhone, R.string.msg_error_phone);
            return true;
        }
        if (!FormValidation.isSimplePassword(password)) {
            WidgetUtils.requestFocus(textInputLayoutPassword.getEditText());
            setEditTextError(textInputLayoutPassword, R.string.msg_error_password);
            return true;
        }
        return false;
    }

    /**
     * 登录按钮点击事件
     *
     * @param view
     */
    public void login(View view) {
        LogManag.d("login...");
        KeyboardUtils.hide(this);
        String phone = textInputLayoutPhone.getEditText().getText().toString();
        String password = textInputLayoutPassword.getEditText().getText().toString();
        if (valid(phone,password))
            return;

        buttonSign.setMode(ActionProcessButton.Mode.ENDLESS);

        buttonSign.setProgress(50);

        buttonSign.postDelayed(new Runnable() {
            @Override
            public void run() {
//                buttonSign.setProgress(100);
                buttonSign.setProgress(-1);
            }
        },2000);
    }
}
