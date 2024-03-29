package com.example.xavierscollege.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.xavierscollege.Common.DbQuery;
import com.example.xavierscollege.MainActivity;
import com.example.xavierscollege.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity2 extends AppCompatActivity {

    Button login;
    Button signUp;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().hide();


        //Transparent Action bar
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        login = findViewById(R.id.btnNewLogin);
        signUp = findViewById(R.id.btnNewSignUp);

        firebaseAuth = FirebaseAuth.getInstance();


        if (firebaseAuth.getCurrentUser() != null) {
            DbQuery.loadCategory();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();

        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Login", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity2.this, LogIn.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Signup", Toast.LENGTH_LONG).show();
                Intent two = new Intent(MainActivity2.this, SignUp.class);
                startActivity(two);
            }
        });


    }
}