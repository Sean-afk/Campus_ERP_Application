package com.example.xavierscollege.Quiz.QuizHome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.xavierscollege.Common.DbQuery;
import com.example.xavierscollege.Common.LoginSignup.LogIn;
import com.example.xavierscollege.Common.MyCompleteListner;
import com.example.xavierscollege.R;

import java.util.ArrayList;
import java.util.List;


public class QuizHome extends Fragment {

    public QuizHome() {
        // Required empty public constructor
    }

    private GridView gridView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_home, container, false);

        gridView =view.findViewById(R.id.quiz_category);



        CategoryAdapter adapter = new CategoryAdapter(DbQuery.g_categoryList);
        gridView.setAdapter(adapter);









        return view;
    }



}