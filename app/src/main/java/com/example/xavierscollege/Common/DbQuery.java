package com.example.xavierscollege.Common;

import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;


import com.example.xavierscollege.Quiz.QuizHome.Category;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.WriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DbQuery {

    public static FirebaseFirestore g_fireStore;
    public static List<Category> g_categoryList = new ArrayList<>();

     public static void createUserData(String email, String name,MyCompleteListner completeListner){
        Map<String, Object>  userData = new ArrayMap<>();
        userData.put("EMAIL_ID",email);
        userData.put("NAME",name);
        userData.put("TOTAL_SCORE",0);

         DocumentReference documentReference = g_fireStore.collection("USERS").document(FirebaseAuth.getInstance().getCurrentUser().getUid());

         WriteBatch writeBatch =g_fireStore.batch();

         writeBatch.set(documentReference,userData);

         DocumentReference countDoc = g_fireStore.collection("USERS").document("TOTAL_USERS");
         writeBatch.update(countDoc,"COUNT", FieldValue.increment(1));
         writeBatch.commit()
                 .addOnSuccessListener(new OnSuccessListener<Void>() {
                     @Override
                     public void onSuccess(Void aVoid) {
                         completeListner.onSuccess();

                     }
                 }).addOnFailureListener(new OnFailureListener() {
             @Override
             public void onFailure(@NonNull Exception e) {
                 completeListner.onFailure();

             }
         });



    }
    public static void loadCategory(){
        g_categoryList.clear();

        g_fireStore.collection("QUIZ").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                Map<String, QueryDocumentSnapshot> docList = new ArrayMap<>();

                for(QueryDocumentSnapshot doc:queryDocumentSnapshots){
                    docList.put(doc.getId(),doc);
                }
                QueryDocumentSnapshot catListDoc = docList.get("Categories");

                long catCount= catListDoc.getLong("COUNT");

                for(int i =1; i <= catCount;i++){
                    String catId =catListDoc.getString("CAT"+String.valueOf(i)+"_ID");
                    QueryDocumentSnapshot catDoc =docList.get(catId);
                    int noOfTests= catDoc.getLong("NO_OF_TESTS").intValue();
                    String catName = catDoc.getString("NAME");
                    g_categoryList.add(new Category(catId,catName,noOfTests));
                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {


            }
        });
    }


}
