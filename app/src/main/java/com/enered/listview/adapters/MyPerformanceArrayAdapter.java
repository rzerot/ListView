package com.enered.listview.adapters;

import android.app.Activity;
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

public class MyPerformanceArrayAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] names;

    static class ViewHolder {
        public TextView text;
        public ImageView image;
    }

    public MyPerformanceArrayAdapter(Activity context, String[] names) {
        super(context, R.layout.rowlayout, names);
        this.context = context;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        long time = System.currentTimeMillis();
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.rowlayout, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.txt);
            viewHolder.image = (ImageView) rowView.findViewById(R.id.img);
            rowView.setTag(viewHolder);
        }

        // fill data
        final ViewHolder holder = (ViewHolder) rowView.getTag();
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.text.setTextColor(context.getResources().getColor(android.R.color.holo_orange_dark));
            }
        });

        if (position % 2 == 0) {
            holder.text.setText(names[position] + ", pos=" + position);
        } else {
            holder.text.setText(names[position]);
        }

        holder.text.setText(holder.text.getText() + "- " + (System.currentTimeMillis() - time));

        return rowView;
    }


}