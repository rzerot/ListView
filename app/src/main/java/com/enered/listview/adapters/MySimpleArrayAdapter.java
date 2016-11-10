package com.enered.listview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.enered.listview.R;

/**
 * Created by Ionut on 02.10.2016.
 */

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MySimpleArrayAdapter(Context context, String[] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        long time = System.currentTimeMillis();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.txt);
        ImageView img = (ImageView) rowView.findViewById(R.id.img);

        if (position % 2 == 0) {
            textView.setText(values[position] + ", pos=" + position);
            img.setBackgroundResource(R.mipmap.img1);
        } else {
            textView.setText(values[position]);
            img.setBackgroundResource(R.mipmap.img2);
        }
        textView.setText(textView.getText() + "- " + (System.currentTimeMillis() - time) );

        return rowView;
    }
}