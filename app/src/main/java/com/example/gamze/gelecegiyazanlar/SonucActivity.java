package com.example.gamze.gelecegiyazanlar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SonucActivity extends AppCompatActivity {

    List<User> userList = new ArrayList<>();
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        Intent intent = getIntent();
        final String isim = intent.getStringExtra("username");

        final ListView userListesiView = (ListView) findViewById(R.id.sonucListesi);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        dbRef = FirebaseDatabase.getInstance().getReference("user");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    if (dataSnapshot1.child("isim").getValue().toString().equals(isim)) {
                        String isim = dataSnapshot1.child("isim").getValue().toString();
                        String oy = dataSnapshot1.child("oy").getValue().toString();

                        User userObj = new User(isim, oy);

                        userList.add(userObj);
                    }
                }
                UserAdapter adapter = new UserAdapter(userList, SonucActivity.this);
                userListesiView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }
}
