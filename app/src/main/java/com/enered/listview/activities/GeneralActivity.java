package com.enered.listview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.enered.listview.R;

/**
 * Created by Ionut on 05.10.2016.
 */

public class GeneralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_listview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GeneralActivity.this, MainActivity.class));
            }
        });

        findViewById(R.id.btn_expandable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GeneralActivity.this, ExpandableListActivity.class));
            }
        });

        findViewById(R.id.btn_exercises).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GeneralActivity.this, ExercisesActivity.class));
            }
        });
    }
}
