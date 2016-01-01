package com.lgw.coolweather.utils;

import android.util.Log;

/**
 * Created by lgw on 2016-01-01
 * 调整LEVEL控制日志打印
 */
public class LogUtil {
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;
    public static final int LEVEL = VERBOSE;

    /**
     * verbose级别日志打印
     *
     * @param tag 标签,信息头
     * @param msg 要打印的信息
     */
    public static void v(String tag, String msg) {
        if (LEVEL <= VERBOSE) {
            Log.v(tag, msg);
        }
    }

    /**
     * debug级别日志打印
     *
     * @param tag 标签,信息头
     * @param msg 要打印的信息
     */
    public static void d(String tag, String msg) {
        if (LEVEL <= DEBUG) {
            Log.d(tag, msg);
        }
    }

    /**
     * info级别日志打印
     *
     * @param tag 标签,信息头
     * @param msg 要打印的信息
     */
    public static void i(String tag, String msg) {
        if (LEVEL <= INFO) {
            Log.i(tag, msg);
        }
    }

    /**
     * warn级别日志打印
     *
     * @param tag 标签,信息头
     * @param msg 要打印的信息
     */
    public static void w(String tag, String msg) {
        if (LEVEL <= WARN) {
            Log.w(tag, msg);
        }
    }

    /**
     * error级别日志打印
     *
     * @param tag 标签,信息头
     * @param msg 要打印的信息
     */
    public static void e(String tag, String msg) {
        if (LEVEL <= ERROR) {
            Log.e(tag, msg);
        }
    }

}
