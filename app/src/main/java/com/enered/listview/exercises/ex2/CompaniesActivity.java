package com.enered.listview.exercises.ex2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.enered.listview.R;
import com.enered.listview.exercises.ex2.data.CompaniesRepository;
import com.enered.listview.exercises.ex2.data.Company;

import java.util.List;


/**
 * Created by Ionut on 05.10.2016.
 */
public class CompaniesActivity extends AppCompatActivity {
    private ListView lvCompanies;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companies_activity);

        linkUI();
        setListeners();

        setAdapter();
    }

    private void linkUI() {
        lvCompanies = (ListView) findViewById(R.id.lv_companies);
    }

    private void setListeners() {
        lvCompanies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CompaniesActivity.this, "Clicked on item " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter() {
        List<Company> companies = CompaniesRepository.getCompanies();
        lvCompanies.setAdapter(new CompanyAdapter(this, companies));
    }
}