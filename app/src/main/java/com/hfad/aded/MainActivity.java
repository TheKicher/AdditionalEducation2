package com.hfad.aded;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.hfad.aded.ui.Home.HomeFragment;
import com.hfad.aded.ui.Search.SearchFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_more:
                    fragment = new HomeFragment();
                    break;
                default:
                    fragment = new SearchFragment();
            }

            setFragment(fragment, true);
            return true;
        });


    }


    public void setFragment(Fragment fragment, boolean isAddToBackStack) {
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment);
        if (isAddToBackStack)
            fr.addToBackStack(null);
        fr.commit();
    }


    public void onClickAdd(View view) {
        Intent i = new Intent(MainActivity.this, StartActivity.class);
        startActivity(i);
    }

    public void onClickSignGoOut(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }
}