package com.enered.listview.exercises.ex1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.enered.listview.R;
import com.enered.listview.exercises.ex1.data.Person;

import java.util.List;

/**
 * Created by Ionut on 05.10.2016.
 */
public class PersonsAdapter extends BaseAdapter {
    private static final String TAG = "PersonsAdapter";
    private LayoutInflater layoutInflater;
    private List<Person> persons;

    /**
     * @param context - activity
     * @param persons - list of persons received from PersonsRepository
     */
    public PersonsAdapter(Context context, List<Person> persons) {
        this.persons = persons;
        this.layoutInflater = LayoutInflater.from(context);
    }

    /**
     * @return number of persons that will be displayed in the list
     */
    @Override
    public int getCount() {
        return persons.size();
    }

    /**
     * @param position
     * @return the person at the position "position"
     */
    @Override
    public Person getItem(int position) {
        return persons.get(position);
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
            Log.d(TAG, "getView - invisible cell is recycled");
            cell = convertView;
        } else {
            Log.d(TAG, "getView - creating new cell");
            cell = layoutInflater.inflate(R.layout.person_item, parent, false);
        }

        final TextView txtFirstName = (TextView) cell.findViewById(R.id.txt_first_name);
        final TextView txtLastName = (TextView) cell.findViewById(R.id.txt_last_name);

        final Person person = persons.get(position);

        //TODO - set the first name and last name in the text views
        txtFirstName.setText(person.getFirstName());
        txtLastName.setText(person.getLastName());


        return cell;
    }


}