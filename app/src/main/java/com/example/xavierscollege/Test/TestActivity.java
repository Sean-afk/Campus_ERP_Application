package com.example.xavierscollege.Test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.xavierscollege.Common.DbQuery;
import com.example.xavierscollege.Quiz.QuizHome.Category;
import com.example.xavierscollege.Quiz.QuizHome.QuizHome;
import com.example.xavierscollege.R;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private RecyclerView testRecycler;
    private List<Test> testList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        testRecycler = findViewById(R.id.test_recycler);

        int cat_index = getIntent().getIntExtra("Cat_Index",0);



        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(DbQuery.g_categoryList.get(cat_index).getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        testRecycler.setLayoutManager(layoutManager);
        
        loadTestData();

        TestAdapter adapter = new TestAdapter(testList);
        testRecycler.setAdapter(adapter);


    }

    private void loadTestData() {
        testList = new ArrayList<>();
        testList.add(new Test("1",50,20));
        testList.add(new Test("2",80,20));
        testList.add(new Test("3",60,20));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            TestActivity.this.finish();

        }

        return super.onOptionsItemSelected(item);
    }
}

