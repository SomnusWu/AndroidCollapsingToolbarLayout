package com.somnus.mylib.recycleutils.utils;

import android.view.View;

/**
 * Created by sunger on 15/11/17.
 */
public class WidgetUtils {

    public static void requestFocus(View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }
}
