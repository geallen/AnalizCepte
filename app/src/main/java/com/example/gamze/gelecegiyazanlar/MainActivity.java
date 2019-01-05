package com.example.gamze.gelecegiyazanlar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;
    private EditText kullaniciAdi;
    List<User> userList = new ArrayList<>();
    private RadioGroup radioSexGroup;
    private RadioGroup radioSexGroup2;
    private RadioButton radioSexButton;
    private RadioButton radioSexButton2;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button ekle = (Button) findViewById(R.id.ekle);
        kullaniciAdi = (EditText) findViewById(R.id.userName);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SorularActivity.class);
                intent.putExtra("username", kullaniciAdi.getText().toString());
                startActivity(intent);
//
            }
        });
    }
}

//        ekle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addUser2();
//            }
//        });
//
//        Button sonuc = (Button) findViewById(R.id.sonucGoster);
//        sonuc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//              Intent intent = new Intent(MainActivity.this, SonucActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
//        btnDisplay = (Button) findViewById(R.id.btnDisplay);
//
//        btnDisplay.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                // get selected radio button from radioGroup
//                int selectedId = radioSexGroup.getCheckedRadioButtonId();
//
//                // find the radiobutton by returned id
//                radioSexButton = (RadioButton) findViewById(selectedId);
//                Toast.makeText(MainActivity.this,
//                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//    private void addUser(){
//        if(kullaniciAdi.getText().length() >0){
//            DatabaseReference dbRef = db.getInstance().getReference("user");
//            String key = dbRef.push().getKey();
//            dbRef.child(key).child("isim").setValue("gamze");
//
//            dbRef.child(key).child("oy").setValue(5);
//        }
//    }
//
//    private void addUser2(){
//      //  if(kullaniciAdi.getText().length() >0){
//        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
//
//        radioSexGroup2 = (RadioGroup) findViewById(R.id.radioSex1);
//
//        btnDisplay = (Button) findViewById(R.id.btnDisplay);
//        int selectedId = radioSexGroup.getCheckedRadioButtonId();
//        int selectedId2 = radioSexGroup2.getCheckedRadioButtonId();
//
//
//        // find the radiobutton by returned id
//        radioSexButton = (RadioButton) findViewById(selectedId);
//        radioSexButton2 = (RadioButton) findViewById(selectedId2);
//
//            DatabaseReference dbRef = db.getInstance().getReference("user");
//            String key = dbRef.push().getKey();
//            dbRef.child(key).child("isim").setValue("gamze");
//            //   dbRef.child(primaryKey).child("username").setValue(uname);
//            dbRef.child(key).child("oy").setValue(radioSexButton.getText());
//
//
//       // DatabaseReference dbRef = db.getInstance().getReference("user");
//        String key2 = dbRef.push().getKey();
//        dbRef.child(key2).child("isim").setValue("gamze");
//        //   dbRef.child(primaryKey).child("username").setValue(uname);
//        dbRef.child(key2).child("oy").setValue(radioSexButton2.getText());
//      //  }
//    }
//
////    public void showResult(){
////        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
////        firebaseDatabase.getReference("users").addListenerForSingleValueEvent(new ValueEventListener() {
////            @Override
////            public void onDataChange(DataSnapshot dataSnapshot) {
////                GenericTypeIndicator<HashMap<String, User>> t = new GenericTypeIndicator<HashMap<String, User>>(){};
////                HashMap<String, User> dataset = dataSnapshot.getValue(t);
////                if (dataset != null) {
////                    for (String id : dataset.keySet()) {
////
////                        User user = new User();
////                        user.setUsername(dataset.get(id).getUsername());
////                        user.setOy(dataset.get(id).getOy());
////                        userList.add(user);
////                    }
////                }
////
////                UserAdapter adapter = new UserAdapter(userList, MainActivity.this);
////                usersLW.setAdapter(adapter);
////
////
////            }
////
////            @Override
////            public void onCancelled(DatabaseError databaseError) {
////
////            }
////        });
////
////    }
//
//
//
//}
