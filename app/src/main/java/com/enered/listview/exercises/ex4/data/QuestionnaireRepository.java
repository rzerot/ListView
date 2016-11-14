package com.enered.listview.exercises.ex4.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionut on 05.10.2016.
 */
public class QuestionnaireRepository {

    public static final int TOTAL_QUESTIONNAIRES = 100;

    private QuestionnaireRepository() {
        throw new AssertionError("No instance allowed");
    }

    public static List<Questionnaire> getQuestionnaires() {
        List<Questionnaire> questionnaires = new ArrayList<>(TOTAL_QUESTIONNAIRES);
        for (int i = 0; i < TOTAL_QUESTIONNAIRES; i++) {
            final Questionnaire questionnaire = new Questionnaire("Enered" + i, String.valueOf(i * 10));
            questionnaires.add(questionnaire);
        }

        return questionnaires;
    }
}