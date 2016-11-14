package com.enered.listview.exercises.ex1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.enered.listview.R;
import com.enered.listview.exercises.ex1.data.Person;
import com.enered.listview.exercises.ex1.data.PersonsRepository;

import java.util.List;

/**
 * Created by Ionut on 05.10.2016.
 */
public class PersonsActivity extends AppCompatActivity {
    private ListView lvPersons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persons_activity);

        linkUI();
        setListeners();

        setAdapter();
    }

    private void linkUI() {
        lvPersons = (ListView) findViewById(R.id.lv_persons);
    }

    private void setListeners() {
        lvPersons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PersonsActivity.this, "Clicked on item " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter() {
        List<Person> persons = PersonsRepository.getPersons();
        lvPersons.setAdapter(new PersonsAdapter(this, persons));
    }
}