package com.enered.listview.exercises.ex2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.enered.listview.R;
import com.enered.listview.exercises.ex2.data.Company;

import java.util.List;


/**
 * Created by Ionut on 05.10.2016.
 */
public class CompanyAdapter extends BaseAdapter {
    private static final String TAG = "PersonsAdapter";
    private LayoutInflater layoutInflater;
    private List<Company> companies;

    /**
     * @param context   - activity
     * @param companies - list of companies received from CompaniesRepository
     */
    public CompanyAdapter(Context context, List<Company> companies) {
        this.companies = companies;
        this.layoutInflater = LayoutInflater.from(context);
    }

    /**
     * @return number of companies that will be displayed in the list
     */
    @Override
    public int getCount() {
        return companies.size();
    }

    /**
     * @param position
     * @return the person at the position "position"
     */
    @Override
    public Company getItem(int position) {
        return companies.get(position);
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
            cell = layoutInflater.inflate(R.layout.company_item, parent, false);
        }
        /**
         * TODO
         * 1. use find view by id to get the text views
         * 2. get the company from position "position"
         * 3. display the location and the name of the company
         */
       final TextView companyName = (TextView) cell.findViewById(R.id.txt_company_name);
        final TextView companyLocation =   (TextView) cell.findViewById(R.id.txt_location);

        companyName.setText(companies.get(position).getName());
        companyLocation.setText(companies.get(position).getLocation());
        return cell;
    }
}
