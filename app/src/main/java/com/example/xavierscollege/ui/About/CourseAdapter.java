package com.example.xavierscollege.ui.About;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.xavierscollege.R;

import java.util.List;

public class CourseAdapter extends PagerAdapter {
    private Context context;
    private List<CourseModel> list;

    public CourseAdapter(Context context, List<CourseModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_item_layout,container,false);

        ImageView brIcon,brImage;
        TextView brTitle,brDes;

        brIcon = view.findViewById(R.id.branch_icon);
        brImage = view.findViewById(R.id.branch_img);
        brTitle = view.findViewById(R.id.branch_title);
        brDes = view.findViewById(R.id.branch_des);

        brIcon.setImageResource(list.get(position).getImg());
        brImage.setImageResource(list.get(position).getImage());
        brTitle.setText(list.get(position).getTitle());
        brDes.setText(list.get(position).getDescription());

        container.addView(view,0);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
