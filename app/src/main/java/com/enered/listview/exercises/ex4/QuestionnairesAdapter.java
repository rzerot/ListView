package com.enered.listview.exercises.ex4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.enered.listview.R;
import com.enered.listview.exercises.ex4.data.Questionnaire;

import java.util.List;


/**
 * Created by Ionut on 05.10.2016.
 */
public class QuestionnairesAdapter extends BaseAdapter {
   private List<Questionnaire> questionnaires;
    private Context context;
    private LayoutInflater layoutInflater;
    public QuestionnairesAdapter(Context context, List<Questionnaire> questionnaires) {
        questionnaires = questionnaires;
        context=context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return questionnaires.size();
    }

    @Override
    public Object getItem(int position) {
        return questionnaires.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View cell;

        if (convertView != null) {

            cell = convertView;
        } else {

            cell = layoutInflater.inflate(R.layout.questionnaire_item, parent, false);
        }
        final TextView questionName = (TextView) cell.findViewById(R.id.txt_questionnaire_name);
        final TextView questionNumber = (TextView) cell.findViewById(R.id.txt_nr_questions);

        questionName.setText(questionnaires.get(position).getName());
        questionNumber.setText(questionnaires.get(position).getNrQuestions());

        return cell;

        /**
         * TODO
         * cell layout: R.layout.questionnaire_item
         */
    }
}
