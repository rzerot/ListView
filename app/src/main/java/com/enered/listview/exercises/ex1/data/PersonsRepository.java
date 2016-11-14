package com.enered.listview.exercises.ex1.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionut on 05.10.2016.
 */
public class PersonsRepository {
    public static final int TOTAL_PERSONS = 100;

    private PersonsRepository() {
        throw new AssertionError("No instance allowed");
    }

    public static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>(TOTAL_PERSONS);
        for (int i = 0; i < TOTAL_PERSONS; i++) {
            final Person person = new Person("FirstName" + i, "LastName" + i);
            persons.add(person);
        }

        return persons;
    }
}