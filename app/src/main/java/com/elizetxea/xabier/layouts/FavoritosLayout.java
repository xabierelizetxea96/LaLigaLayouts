package com.elizetxea.xabier.layouts;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class FavoritosLayout extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> team_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos_layout);

        String[] teams = getResources().getStringArray(R.array.teams);
        team_list = new ArrayList<>(Arrays.asList(teams));

        ListView list = (ListView) findViewById(R.id.team_list);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, team_list);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View item, int pos, long id) {
                Toast.makeText(
                        FavoritosLayout.this,
                        String.format("Has escogido '%s'", team_list.get(pos)),
                        Toast.LENGTH_SHORT
                ).show();

            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View item, final int pos, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FavoritosLayout.this);
                builder.setTitle(R.string.confirm);
                String msg = getResources().getString(R.string.confirm_message);
                builder.setMessage(msg + " " + team_list.get(pos) + "?");
                builder.setPositiveButton(R.string.erase, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        team_list.remove(pos);
                        adapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton(android.R.string.cancel, null);
                builder.create().show();
                return true;
            }
        });
    }
}
