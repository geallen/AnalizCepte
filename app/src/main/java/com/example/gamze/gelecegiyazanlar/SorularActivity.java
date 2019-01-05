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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SorularActivity extends AppCompatActivity {


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
        setContentView(R.layout.activity_sorular);

        Intent intent = getIntent();
        final String message = intent.getStringExtra("username");


        Button sonuc = (Button) findViewById(R.id.sonucGoster);
        sonuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(SorularActivity.this, SonucActivity.class);
                intent.putExtra("username", message);
                startActivity(intent);
            }
        });


        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                addUser2(message);
                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

            }
        });
    }
    private void addUser(){
        if(kullaniciAdi.getText().length() >0){
            DatabaseReference dbRef = db.getInstance().getReference("user");


            String key = dbRef.push().getKey();
            dbRef.child(key).child("isim").setValue("gamze");

            dbRef.child(key).child("oy").setValue(5);
        }
    }

    private void addUser2(String username){

        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);

        radioSexGroup2 = (RadioGroup) findViewById(R.id.radioSex1);

        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        int selectedId = radioSexGroup.getCheckedRadioButtonId();
        int selectedId2 = radioSexGroup2.getCheckedRadioButtonId();

        if(selectedId != -1 && selectedId2 != -1) {

            radioSexButton = (RadioButton) findViewById(selectedId);
            radioSexButton2 = (RadioButton) findViewById(selectedId2);

            DatabaseReference dbRef = db.getInstance().getReference("user");
            String key = dbRef.push().getKey();
            dbRef.child(key).child("isim").setValue(username);

            dbRef.child(key).child("oy").setValue(radioSexButton.getText());

            String key2 = dbRef.push().getKey();
            dbRef.child(key2).child("isim").setValue(username);

            dbRef.child(key2).child("oy").setValue(radioSexButton2.getText());
        }else{
            Toast.makeText(SorularActivity.this,
                    "Lutfen tum sorulara cevap veriniz", Toast.LENGTH_SHORT).show();
        }

    }

}
