package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by somewhater on 2015-08-08.
 */
public class MyListView extends Activity {
    ListView listView;
    TextView showInfo;
    String[] titles = {"测试1", "测试2", "测试3", "测试4", "测试5"};
    String[] texts = {"18565470997", "18565470993", "18565470995", "18565470992", "18565470990"};
    int buf = R.drawable.ic_launcher;
    int[] resIds = {buf, buf, buf, buf, buf};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listView = (ListView) findViewById(R.id.list);
        showInfo = (TextView) findViewById(R.id.T1);
        listView.setAdapter(new MyAdapter(titles, texts, resIds, this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView title = (TextView) view.findViewById(R.id.itemTitle);
                String info = "单击的联系人是：" + title.getText();
                TextView text = (TextView) view.findViewById(R.id.itemText);
                info = info + "\n联系电话：" + text.getText();
                showInfo.setText(info);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
