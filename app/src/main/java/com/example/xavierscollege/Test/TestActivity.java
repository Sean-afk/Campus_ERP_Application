package com.example.xavierscollege.Test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;


import com.example.xavierscollege.Common.DbQuery;

import com.example.xavierscollege.R;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private RecyclerView testRecycler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        testRecycler = findViewById(R.id.test_recycler);





        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(DbQuery.g_categoryList.get(DbQuery.g_cat_selected_index).getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        testRecycler.setLayoutManager(layoutManager);
        
        DbQuery.loadTestData();

        TestAdapter adapter = new TestAdapter(DbQuery.g_testList);
        testRecycler.setAdapter(adapter);


    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            TestActivity.this.finish();

        }

        return super.onOptionsItemSelected(item);
    }
}

