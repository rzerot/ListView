package com.enered.listview.exercises.ex3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.enered.listview.R;
import com.enered.listview.exercises.ex3.data.Event;
import com.enered.listview.exercises.ex3.data.EventsRepository;

import java.util.List;


/**
 * Created by Ionut on 05.10.2016.
 */
public class EventsActivity extends AppCompatActivity {
    private ListView lvEvents;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_activity);

        linkUI();
        setListeners();

        setAdapter();
    }

    private void linkUI() {
        lvEvents = (ListView) findViewById(R.id.lv_events);
    }

    private void setListeners() {
        lvEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(EventsActivity.this, "Clicked on item " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter() {
        List<Event> events = EventsRepository.getEvents();
        lvEvents.setAdapter(new EventsAdapter(this, events));
    }
}