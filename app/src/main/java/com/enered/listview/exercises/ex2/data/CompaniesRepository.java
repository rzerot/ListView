package com.enered.listview.exercises.ex2.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionut on 05.10.2016.
 */
public class CompaniesRepository {
    public static final int TOTAL_COMPANIES = 100;

    private CompaniesRepository() {
        throw new AssertionError("No instance allowed");
    }

    public static List<Company> getCompanies() {
        List<Company> companies = new ArrayList<>(TOTAL_COMPANIES);
        for (int i = 0; i < TOTAL_COMPANIES; i++) {
            final Company person = new Company("Google " + i, "Str Principala nr " + i);
            companies.add(person);
        }

        return companies;
    }
}