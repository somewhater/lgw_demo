package com.lgw.coolweather.utils;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.lgw.coolweather.constant.MainMessage;

/**
 * Created by lgw on 2016-01-03.
 */
public class MainHandler extends Handler {
    private TextView mTextView;

    public MainHandler(TextView mTextView) {
        this.mTextView = mTextView;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case MainMessage.SHOW_RESPONSE:
                String response = (String) msg.obj;
                mTextView.setText(response);
        }
    }
}