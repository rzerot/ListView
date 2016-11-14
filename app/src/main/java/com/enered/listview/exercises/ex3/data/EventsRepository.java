package com.enered.listview.exercises.ex3.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionut on 05.10.2016.
 */
public class EventsRepository {
    public static final int TOTAL_EVENTS = 100;

    private EventsRepository() {
        throw new AssertionError("No instance allowed");
    }

    public static List<Event> getEvents() {
        List<Event> events = new ArrayList<>(TOTAL_EVENTS);
        for (int i = 0; i < TOTAL_EVENTS; i++) {
            final Event person = new Event("Enered" + i, "Bulevardul Metalurgiei nr" + i, "05.10.201" + (i % 10));
            events.add(person);
        }

        return events;
    }
}