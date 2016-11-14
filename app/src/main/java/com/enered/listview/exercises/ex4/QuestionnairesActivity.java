package com.enered.listview.exercises.ex4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.enered.listview.R;
import com.enered.listview.exercises.ex4.data.Questionnaire;
import com.enered.listview.exercises.ex4.data.QuestionnaireRepository;

import java.util.List;


/**
 * Created by Ionut on 05.10.2016.
 */
public class QuestionnairesActivity extends AppCompatActivity {
    private ListView lvQuestionnaires;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaires_activity);

        linkUI();
        setListeners();

        setAdapter();
    }

    private void linkUI() {
        lvQuestionnaires = (ListView) findViewById(R.id.lv_questionnaires);
    }

    private void setListeners() {
        lvQuestionnaires.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(QuestionnairesActivity.this, "Clicked on item " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter() {
        List<Questionnaire> questionnaires = QuestionnaireRepository.getQuestionnaires();
        lvQuestionnaires.setAdapter(new QuestionnairesAdapter(this, questionnaires));
    }
}