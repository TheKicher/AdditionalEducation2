package com.hfad.aded.ui.Search;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter_LifecycleAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hfad.aded.Constant;
import com.hfad.aded.R;
import com.hfad.aded.ShowActivity;
import com.hfad.aded.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class SearchFragment extends Fragment implements MyAdapter.OnClickListener {

    RecyclerView recyclerView;
    DatabaseReference database;
    private MyAdapter myAdapter;
    ArrayList<User> list;
    private List<User> listTemp;
    private DatabaseReference mDataBase;
    private String USER_KEY = "User";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_search, container, false);

       EditText search = view.findViewById(R.id.search);
       search.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });

        recyclerView = view.findViewById(R.id.userList);
        database = FirebaseDatabase.getInstance().getReference(USER_KEY);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        listTemp = new ArrayList<>();
        list = new ArrayList<>();

        myAdapter = new MyAdapter(getActivity(), list, this);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);

                }

                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onClick(int position) {
        Log.d(TAG, "onClick: click");
        User user = list.get(position);
        Intent i = new Intent(SearchFragment.this.getActivity(),ShowActivity.class);

        i.putExtra(Constant.USER_CITY,user.getCity());
        i.putExtra(Constant.USER_NAME,user.getName());
        i.putExtra(Constant.USER_PROF,user.getProf());
        i.putExtra(Constant.USER_DISK,user.getDisc());
        i.putExtra(Constant.USER_PRICE,user.getPrice());
        i.putExtra(Constant.USER_PHONE,user.getPhone());
        i.putExtra(Constant.USER_EMAIL,user.getEmail());
        startActivity(i);

    }
}