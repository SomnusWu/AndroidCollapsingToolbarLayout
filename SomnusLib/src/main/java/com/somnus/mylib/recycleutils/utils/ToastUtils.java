package com.somnus.mylib.recycleutils.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;


/**
 * @author Somnus
 * @version v1.0
 * @Title 提示工具类
 * @Description:
 */
public class ToastUtils {
    /**
     * 显示toast信息
     *
     * @param context
     * @param message
     * @Description:
     */
    public static void showToast(Context context, String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, int message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        Toast.makeText(context, message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, int message, int duration) {
        Toast.makeText(context, message, duration).show();
    }
}
