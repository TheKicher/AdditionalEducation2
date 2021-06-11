package com.hfad.aded;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;



public class ShowActivity extends AppCompatActivity {

    private TextView tvCity, tvName, tvProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        init();
        getIntentMain();
    }
    private void init()
    {
        tvCity = findViewById(R.id.tvCity);
        tvName = findViewById(R.id.tvName);
        tvProf = findViewById(R.id.tvProf);
    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            tvCity.setText(i.getStringExtra(Constant.USER_CITY));
            tvName.setText(i.getStringExtra(Constant.USER_NAME));
            tvProf.setText(i.getStringExtra(Constant.USER_PROF));
        }
    }
}