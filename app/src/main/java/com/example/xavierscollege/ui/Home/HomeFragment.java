package com.example.xavierscollege.ui.Home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.xavierscollege.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;


public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=  inflater.inflate(R.layout.fragment_home, container, false);

       sliderLayout=view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SLIDE);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);

        setSliderViews();

        map= view.findViewById(R.id.map);


        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();

            }
        });


        return view;
    }

    private void openMap() {
        Uri uri= Uri.parse("geo:0,0?q= Xavier Institute Of Engineering");
        Intent intent=new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderViews() {
        for(int i=0; i<5;i++){
           DefaultSliderView sliderView=new DefaultSliderView(getContext());
           switch (i){
               case 0:
                   sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/bunny-hub.appspot.com/o/gallery%2F%5BB%401237bf9jpg?alt=media&token=8b74de82-18d6-495f-af86-67aafc927d07");
                   break;

                   case 1:
                   sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/bunny-hub.appspot.com/o/gallery%2F%5BB%40b2d90e9jpg?alt=media&token=81f06028-deca-4ca8-a6e3-046e1e90a571");
                   break;

                   case 2:
                   sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/bunny-hub.appspot.com/o/gallery%2F%5BB%40bc65561jpg?alt=media&token=49c28e0a-4f87-4b5a-b148-929feaa7ead5");
                   break;

                   case 3:
                   sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/bunny-hub.appspot.com/o/gallery%2F%5BB%403581887jpg?alt=media&token=1920784b-0330-4d7a-86d8-c2b78fee5955");
                   break;

                   case 4:
                   sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/bunny-hub.appspot.com/o/gallery%2F%5BB%40143d7ejpg?alt=media&token=130df7e7-3175-4150-b026-98b969b9ef37");
                   break;

           }
           sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);
           sliderLayout.addSliderView(sliderView);
        }
    }
}