package com.lgw.coolweather.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lgw.coolweather.R;
import com.lgw.coolweather.utils.LogUtil;


public class MainActivity extends Activity {
    public String TAG = "MainActivity_____________________";
    private EditText city;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city = (EditText) findViewById(R.id.editCity);
        search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cities = city.getText().toString();
                LogUtil.i(TAG, "" + cities);
                if (cities.equals("")) {
                    Toast.makeText(getApplicationContext(), "输入的城市名称为空，请重新输入", Toast.LENGTH_SHORT).show();
                } else {
                    
                }
            }
        });
    }
}
