package com.hfad.aded;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StartActivity extends AppCompatActivity {
    private EditText edCity, edName, edProf, edDisc, edPric, edPhone, edEmail;
    private DatabaseReference mDataBase;
    private String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        init();
    }
    private void init(){
        edCity = findViewById(R.id.edCity);
        edName = findViewById(R.id.edName);
        edProf = findViewById(R.id.edProf);
        edDisc = findViewById(R.id.edDisc);
        edPric = findViewById(R.id.edPric);
        edPhone = findViewById(R.id.edPhone);
        edEmail = findViewById(R.id.edEmail);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }

    public  void onClickSave (View view){
        String id = mDataBase.getKey();
        String city = edCity.getText().toString();
        String name = edName.getText().toString();
        String prof = edProf.getText().toString();
        String disc = edDisc.getText().toString();
        String price = edPric.getText().toString();
        String phone = edPhone.getText().toString();
        String email = edEmail.getText().toString();
        User newUser = new User(id,city,name,prof,disc,price,phone,email);

        if (!TextUtils.isEmpty(city) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(prof) && !TextUtils.isEmpty(disc) && !TextUtils.isEmpty(price) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(email)){
            mDataBase.push().setValue(newUser);
            Toast.makeText(this,"Сохранено",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"Пустое поле",Toast.LENGTH_SHORT).show();

        }
    }



}