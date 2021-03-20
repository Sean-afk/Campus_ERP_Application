package com.example.xavierscollege.ui.About;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xavierscollege.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private CourseAdapter adapter;
    private List<CourseModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list= new ArrayList<>();
        list.add(new CourseModel(R.drawable.computer,R.drawable.ces,"ComputerEngineering","Computer Engineering Branch Of Xaviers"));
        list.add(new CourseModel(R.drawable.laptop,R.drawable.it,"Information Technology","Information Technology Branch"));
        list.add(new CourseModel(R.drawable.signal,R.drawable.extc,"Electronics & Telecommunication","Extc Branch "));
        list.add(new CourseModel(R.drawable.science,R.drawable.ces,"Applied Sciences","Applied Sciences Branch"));


        adapter = new CourseAdapter(getContext(),list);
        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        return view;
    }
}