package com.example.list_searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int TIME_INTERVAL = 3000;
    private long backPressed;

    ListView listView;
    SearchView searchView;

    String month[]={"January","February","March","April","May","June","July","August","September","October",
                    "November","December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.monthList);
        searchView=findViewById(R.id.search);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,month);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String select= (String) listView.getItemAtPosition(i);

                Intent intent=new Intent(MainActivity.this,MonthDetail.class);
                intent.putExtra("select",select);
                startActivity(intent);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                arrayAdapter.getFilter().filter(s);
                return true;
            }
        });

    }

@Override
    public void onBackPressed(){
        if(backPressed + TIME_INTERVAL > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }
        else {
            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }
}