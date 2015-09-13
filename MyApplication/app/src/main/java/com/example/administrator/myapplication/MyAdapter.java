package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by somewhater on 2015-08-08.
 */
public class MyAdapter extends BaseAdapter {
    String[] itemsTitles, itemTexts;
    int[] itemImagesRes;
    Context context;
    public MyAdapter(String[] itemsTitles, String[] itemTexts, int[] itemImagesRes,Context context) {
        this.itemsTitles = itemsTitles;
        this.itemTexts = itemTexts;
        this.itemImagesRes = itemImagesRes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemsTitles.length;
    }

    @Override
    public Object getItem(int position) {
        return itemsTitles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = inflater.inflate(R.layout.item, null);
            TextView title = (TextView) itemView.findViewById(R.id.itemTitle);
            title.setText(itemsTitles[position]);
            TextView text = (TextView) itemView.findViewById(R.id.itemText);
            text.setText(itemTexts[position]);
            ImageView image = (ImageView) itemView.findViewById(R.id.itemImage);
            image.setImageResource(itemImagesRes[position]);
            return itemView;
        } else {
            TextView title = (TextView) convertView.findViewById(R.id.itemTitle);
            title.setText(itemsTitles[position]);
            TextView text = (TextView) convertView.findViewById(R.id.itemText);
            text.setText(itemTexts[position]);
            ImageView image = (ImageView) convertView.findViewById(R.id.itemImage);
            image.setImageResource(itemImagesRes[position]);
            return convertView;
        }
    }
}