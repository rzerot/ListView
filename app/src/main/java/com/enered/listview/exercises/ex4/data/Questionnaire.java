package com.enered.listview.exercises.ex4.data;

/**
 * Created by Ionut on 05.10.2016.
 */
public class Questionnaire {
    private String name;
    private String nrQuestions;

    public Questionnaire(String name, String nrQuestions) {
        this.name = name;
        this.nrQuestions = nrQuestions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNrQuestions() {
        return nrQuestions;
    }

    public void setNrQuestions(String nrQuestions) {
        this.nrQuestions = nrQuestions;
    }
}