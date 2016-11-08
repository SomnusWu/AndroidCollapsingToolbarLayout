package com.somnus.mylib.recycleutils.utils;

import android.util.Log;

/**
 * 统一管理log类
 * 
 * @author Somnus
 * @version 1.0
 */
public class LogManag  {
	private static final String TAG = "LogManag";
	private static final boolean LOGGER = true;

	public static void i(String msg) {
		if (LOGGER) {
			System.out.println(msg);
		}
	}

	public static void i(String tag, String msg) {
		if (LOGGER) {
			Log.i(TAG, tag + "-->" + msg);
		}
	}

	public static void v(String tag, String msg) {
		if (LOGGER) {
			Log.v(TAG, tag + "-->" + msg);
		}
	}

	public static void d(String tag, String msg) {
		if (LOGGER) {
			Log.d(TAG, tag + "-->" + msg);
		}
	}
	public static void d(String msg) {
		if (LOGGER) {
			Log.d(TAG,  "-->" + msg);
		}
	}


	public static void w(String tag, String msg) {
		if (LOGGER) {
			Log.v(TAG, tag + "-->" + msg);
		}
	}

	public static void e(String tag, String msg) {
		if (LOGGER) {
			Log.e(TAG, tag + "-->" + msg);
		}
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (LOGGER) {
			Log.e(TAG, tag + "-->" + msg);
		}
	}
}
