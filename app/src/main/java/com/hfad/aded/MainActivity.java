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
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<User> listTemp;
    private DatabaseReference mDataBase;
    private String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        init();
//        getDataFromDB();
//        setOnClickItem();

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


    public void onClickAdd(View view){
        Intent i = new Intent(MainActivity.this, StartActivity.class);
        startActivity(i);
    }

    public void onClickSignGoOut(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }

    public void onClickRead(View view){
        Intent i = new Intent(MainActivity.this, ReadActivity.class);
        startActivity(i);
    }


//
//    private void init()
//    {
//        listView = findViewById(R.id.listView);
//        listData = new ArrayList<>();
//        listTemp = new ArrayList<>();
//        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listData);
//        listView.setAdapter(adapter);
//        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
//    }
//    private void getDataFromDB()
//    {
//        ValueEventListener vListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
//            {
//                if(listData.size() > 0)listData.clear();
//                if(listTemp.size() > 0)listTemp.clear();
//                for(DataSnapshot ds : dataSnapshot.getChildren())
//                {
//                    User user = ds.getValue(User.class);
//                    assert user != null;
//                    listData.add(user.name);
//                    listTemp.add(user);
//                }
//                adapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        };
//        mDataBase.addValueEventListener(vListener);
//    }
//    private void setOnClickItem()
//    {
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                User user = listTemp.get(position);
//                Intent i = new Intent(MainActivity.this, ShowActivity.class);
//                i.putExtra(Constant.USER_NAME,user.name);
//                i.putExtra(Constant.USER_SEC_NAME,user.sec_name);
//                i.putExtra(Constant.USER_EMAIL,user.email);
//                startActivity(i);
//
//            }
//        });
//    }

}