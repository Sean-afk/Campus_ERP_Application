package com.example.xavierscollege.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xavierscollege.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    private TextView already;
    private ImageView userImage;
    private Button register;
    private EditText mUsername, mEmail, mPassword, mPhone,mId;
    private FirebaseAuth firebaseAuth;
    private final int REQ = 1;
    private Bitmap bitmap;
    private String name, number, email, password,id;
    private DatabaseReference reference, databaseReference;
    private StorageReference storageReference;

    String downloadUrl = " ";

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();



        already = findViewById(R.id.already);
        register = findViewById(R.id.registerbtn);
        userImage = findViewById(R.id.profile_image);
        mUsername = findViewById(R.id.editTextPersonName);
        mPhone = findViewById(R.id.editTextPhone);
        mEmail = findViewById(R.id.editTextEmailAddress2);
        mPassword = findViewById(R.id.editTextPassword2);
        mId= findViewById(R.id.xie_Id);
        progressBar = findViewById(R.id.progressBar);


        reference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

        firebaseAuth = FirebaseAuth.getInstance();


        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
            }
        });

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();

            }
        });

    }


    private void validateData() {
        name = mUsername.getText().toString().trim();
        number = mPhone.getText().toString().trim();
        email = mEmail.getText().toString().trim();
        id = mId.getText().toString().trim();
        password = mPassword.getText().toString().trim();

        if (name.isEmpty()) {
            mUsername.setError("Enter Name");
            mUsername.requestFocus();
            return;
        } else if (number.isEmpty()) {
            mPhone.setError("Enter Phone");
            mPhone.requestFocus();
            return;

        }else if (id.isEmpty()) {
            mId.setError("Enter Xie Id");
            mId.requestFocus();
            return;


        } else if (email.isEmpty()) {
            mEmail.setError("Required");
            mEmail.requestFocus();
            return;
        } else if (password.isEmpty()) {
            mPassword.setError("Required");
            mPassword.requestFocus();
            return;
        } else if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            mPassword.requestFocus();
            return;
        } else {

            progressBar.setVisibility(View.VISIBLE);
            //create user
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                uploadData();
                                //uploadImage();
                            } else {
                                Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                finish();
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(SignUp.this, "Error" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void uploadImage() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] finalImg = baos.toByteArray();
        final StorageReference filePath;
        filePath = storageReference.child("UserImage").child(finalImg + "jpg");
        final UploadTask uploadTask = filePath.putBytes(finalImg);
        uploadTask.addOnCompleteListener(SignUp.this, new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if (task.isSuccessful()) {
                    uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    downloadUrl = String.valueOf(uri);
                                    uploadData();
                                }
                            });

                        }
                    });
                } else {
                    Toast.makeText(SignUp.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void uploadData() {
        databaseReference = reference.child("users");
        String key = databaseReference.push().getKey();

        HashMap<String, String> user = new HashMap<>();
        user.put("key", key);
        user.put("name", name);
        user.put("number", number);
        user.put("email", number);

        databaseReference.child(key).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LogIn.class));
                        } else {
                            Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void openGallery() {
        Intent picImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(picImage, REQ);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            userImage.setImageBitmap(bitmap);
        }
    }
}