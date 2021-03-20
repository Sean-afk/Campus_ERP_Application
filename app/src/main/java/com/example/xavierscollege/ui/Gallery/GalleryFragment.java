package com.example.xavierscollege.ui.Gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xavierscollege.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {
    RecyclerView campusRecycler,convoRecycler,festRecycler,sportsRecycler,techRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=  inflater.inflate(R.layout.fragment_gallery, container, false);
        campusRecycler=view.findViewById(R.id.campusRecycler);
        convoRecycler=view.findViewById(R.id.convoRecycler);
        festRecycler=view.findViewById(R.id.festRecycler);
        sportsRecycler=view.findViewById(R.id.sportsRecycler);
        techRecycler=view.findViewById(R.id.techRecycler);

        reference= FirebaseDatabase.getInstance().getReference().child("gallery");
        
        getCampusImage();
        getConvoImage();
        getFestImage();
        getSportsImage();
        getTechImage();

        return view;
    }

    private void getTechImage() {
        reference.child("Transmission").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data =(String)snapshot1.getValue();
                    imageList.add(data);

                }
                adapter=new GalleryAdapter(getContext(),imageList);
                techRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                techRecycler.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast.makeText(GalleryAdapter, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getSportsImage() {
        reference.child("Sparx").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data =(String)snapshot1.getValue();
                    imageList.add(data);

                }
                adapter=new GalleryAdapter(getContext(),imageList);
                sportsRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                sportsRecycler.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast.makeText(GalleryAdapter, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getFestImage() {
        reference.child("Spandan").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data =(String)snapshot1.getValue();
                    imageList.add(data);

                }
                adapter=new GalleryAdapter(getContext(),imageList);
                festRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                festRecycler.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast.makeText(GalleryAdapter, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data =(String)snapshot1.getValue();
                    imageList.add(data);

                }
                adapter=new GalleryAdapter(getContext(),imageList);
                convoRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                convoRecycler.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast.makeText(GalleryAdapter, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getCampusImage() {
        reference.child("Campus").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);

                }
                adapter=new GalleryAdapter(getContext(),imageList);
                campusRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                campusRecycler.setAdapter(adapter);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast.makeText(GalleryAdapter, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }


}