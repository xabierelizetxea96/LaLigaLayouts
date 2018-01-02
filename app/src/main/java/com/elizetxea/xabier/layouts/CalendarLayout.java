package com.elizetxea.xabier.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class CalendarLayout extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> calendar_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_layout);

        String[] calendar = getResources().getStringArray(R.array.calendar);
        calendar_list = new ArrayList<>(Arrays.asList(calendar));

        ListView list = (ListView) findViewById(R.id.team_list);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, calendar_list);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View item, int pos, long id) {


            }
        });



    }
}
