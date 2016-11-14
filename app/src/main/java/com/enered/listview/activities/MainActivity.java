package com.enered.listview.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.enered.listview.R;
import com.enered.listview.adapters.InteractiveArrayAdapter;
import com.enered.listview.holders.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> list = new ArrayList<String>();
    private  String[] values;
    private ListView listview;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkUi();
        init();
        setListener();
    }

    private void linkUi() {
        listview = (ListView) findViewById(R.id.listview);
    }

    private void init() {
       values = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile","test","test","test","test","test","test","test","test"};

        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        addHeaderAndFooter();

//         adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
//        adapter = new MySimpleArrayAdapter(this, values);
//         adapter = new MyPerformanceArrayAdapter(this, values);
        adapter = new InteractiveArrayAdapter(this, getModel());
        listview.setAdapter(adapter);
    }

    private void setListener() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
//                final String item = (String) parent.getItemAtPosition(position);
//                list.remove(item);
//                adapter.notifyDataSetChanged();
                view.setSelected(true);
            }
        });
    }

    private List<Model> getModel() {
        List<Model> list = new ArrayList<Model>();
        list.add(get("Linux"));
        list.add(get("Windows7"));
        list.add(get("Suse"));
        list.add(get("Eclipse"));
        list.add(get("Ubuntu"));
        list.add(get("Solaris"));
        list.add(get("Android"));
        list.add(get("iPhone"));
        list.add(get("Android1"));
        list.add(get("Android2"));
        list.add(get("Android3"));
        list.add(get("Android4"));
        list.add(get("Android5"));
        list.add(get("Android6"));
        list.add(get("Android7"));
        list.add(get("Android8"));
        list.add(get("Android9"));
        list.add(get("Android10"));
        list.add(get("Android11"));
        list.add(get("Android12"));
        list.add(get("Android8"));
        list.add(get("Android9"));
        list.add(get("Android10"));
        list.add(get("Android11"));
        list.add(get("Android12"));
        list.addAll(list);


        // Initially select one of the items
        list.get(1).setSelected(true);
        return list;
    }

    private Model get(String s) {
        return new Model(s);
    }

    private void addHeaderAndFooter() {
        View header = getLayoutInflater().inflate(R.layout.header, listview, false);
        View footer = getLayoutInflater().inflate(R.layout.footer, listview, false);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add("addddd");
                adapter.notifyDataSetChanged();
            }
        });
        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                listview.smoothScrollToPosition(10);
                listview.setSelection(10);
            }
        });
        listview.addHeaderView(header, null, false);
        listview.addFooterView(footer, null, false);
    }
}