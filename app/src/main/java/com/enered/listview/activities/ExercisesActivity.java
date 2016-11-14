package com.enered.listview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.enered.listview.R;
import com.enered.listview.exercises.ex1.PersonsActivity;
import com.enered.listview.exercises.ex2.CompaniesActivity;
import com.enered.listview.exercises.ex3.EventsActivity;
import com.enered.listview.exercises.ex4.QuestionnairesActivity;

/**
 * Created by Ionut on 05.10.2016.
 */

public class ExercisesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exercises);

        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_ex1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExercisesActivity.this, PersonsActivity.class));
            }
        });

        findViewById(R.id.btn_ex2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExercisesActivity.this, CompaniesActivity.class));
            }
        });

        findViewById(R.id.btn_ex3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExercisesActivity.this, EventsActivity.class));
            }
        });

        findViewById(R.id.btn_ex4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExercisesActivity.this, QuestionnairesActivity.class));
            }
        });
    }
}
