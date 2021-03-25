package com.example.xavierscollege.Quiz.QuizHome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.xavierscollege.R;

import java.util.ArrayList;
import java.util.List;


public class QuizHome extends Fragment {

    public QuizHome() {
        // Required empty public constructor
    }

    private GridView gridView;
    private List<Category> categoryList = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_home, container, false);

        gridView =view.findViewById(R.id.quiz_category);

        return view;
    }
}