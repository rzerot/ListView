package com.enered.listview.exercises.ex3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.enered.listview.R;
import com.enered.listview.exercises.ex3.data.Event;

import java.util.List;


/**
 * Created by Ionut on 05.10.2016.
 */
public class EventsAdapter extends BaseAdapter {
    private static final String TAG = "PersonsAdapter";
    private LayoutInflater layoutInflater;
    private List<Event> events;
    private Context context;

    /**
     * @param context - activity
     * @param persons - list of events received from EventsRepository
     */
    public EventsAdapter(Context context, List<Event> persons) {
        this.events = persons;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    /**
     * @return number of events that will be displayed in the list
     */
    @Override
    public int getCount() {
        return events.size();
    }

    /**
     * @param position
     * @return the person at the position "position"
     */
    @Override
    public Event getItem(int position) {
        return events.get(position);
    }

    //ignore
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View cell;

        if (convertView != null) {
            cell = convertView;
        } else {
            cell = layoutInflater.inflate(R.layout.event_item, parent, false);


        }
        final TextView eventName =(TextView) cell.findViewById(R.id.txt_name);
        final TextView eventLocation = (TextView)cell.findViewById(R.id.txt_location);
        final TextView eventDate = (TextView) cell.findViewById(R.id.txt_date);

        final Event event = events.get(position);

        eventName.setText(event.getName());
        eventLocation.setText(event.getLocation());
        eventDate.setText(event.getDate());
        /**
         * TODO
         * - implement the method in order to display the name, location and date of the event in the cell
         * - need implement performance adapter
         * - cell layout: R.layout.event_item
         */


        return cell;

    }

}