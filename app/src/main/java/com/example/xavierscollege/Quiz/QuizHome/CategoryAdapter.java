package com.example.xavierscollege.Quiz.QuizHome;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xavierscollege.R;
import com.example.xavierscollege.Test.TestActivity;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {

    private List<Category> categoryList;

    public CategoryAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
           view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_layout, parent,false);

        } else {
            view = convertView;
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TestActivity.class);
                intent.putExtra("Cat_Index",position);
                v.getContext().startActivity(intent);
            }
        });

        TextView catName = view.findViewById(R.id.cat_name);
        TextView noTest = view.findViewById(R.id.cat_test);

        catName.setText(categoryList.get(position).getName());
        noTest.setText(String.valueOf(categoryList.get(position).getNoOfTests()) + " Tests");



        return view;
    }
}
