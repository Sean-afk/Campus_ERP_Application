package com.example.xavierscollege.Ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.xavierscollege.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {
    private RecyclerView eBookRecycler;
    private DatabaseReference reference;
    private List<EbookData>  list;
    private EbookAdapter ebookAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        eBookRecycler= findViewById(R.id.ebook_recycler);
        reference = FirebaseDatabase.getInstance().getReference().child("file");
        
        getData();

    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1: snapshot.getChildren()){

                    EbookData data = snapshot1.getValue(EbookData.class);
                    list.add(data);

                }
                ebookAdapter = new EbookAdapter(EbookActivity.this,list);
                eBookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                eBookRecycler.setAdapter(ebookAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}