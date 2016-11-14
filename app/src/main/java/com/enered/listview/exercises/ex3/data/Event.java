package com.enered.listview.exercises.ex3.data;

/**
 * Created by Ionut on 05.10.2016.
 */
public class Event {
    private String name;
    private String location;
    private String date;

    public Event(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}