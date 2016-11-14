package com.enered.listview.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.enered.listview.R;
import com.enered.listview.holders.Model;

import java.util.List;

/**
 * Created by Ionut on 02.10.2016.
 */

public class InteractiveArrayAdapter extends ArrayAdapter<Model> {

    private final List<Model> list;
    private final Activity context;

    public InteractiveArrayAdapter(Activity context, List<Model> list) {
        super(context, R.layout.rowlayout, list);
        this.context = context;
        this.list = list;
    }

    static class ViewHolder {
        protected ImageView img;
        protected TextView text;
        protected CheckBox checkbox;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final long time = System.currentTimeMillis();
        View view = null;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.rowlayout, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) view.findViewById(R.id.txt);
            viewHolder.checkbox = (CheckBox) view.findViewById(R.id.checkbox);
            viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Model element = (Model) viewHolder.checkbox.getTag();
                    element.setSelected(buttonView.isChecked());
                }
            });

            viewHolder.img = (ImageView) view.findViewById(R.id.img);
            view.setTag(viewHolder);
            viewHolder.checkbox.setTag(list.get(position));
        } else {
            view = convertView;
            ((ViewHolder) view.getTag()).checkbox.setTag(list.get(position));
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.text.setText(list.get(position).getName() + "- " + (System.currentTimeMillis() - time));
        holder.checkbox.setChecked(list.get(position).isSelected());

        if (position % 2 == 0) {
            holder.img.setBackgroundResource(R.mipmap.img1);
        } else {
            holder.img.setBackgroundResource(R.mipmap.img2);
        }

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setHasClick(true);
                notifyDataSetChanged();
            }
        });
        if (list.get(position).isHasClick())
            holder.text.setTextColor(context.getResources().getColor(R.color.colorAccent));
        else
            holder.text.setTextColor(context.getResources().getColor(android.R.color.black));

        return view;
    }
}