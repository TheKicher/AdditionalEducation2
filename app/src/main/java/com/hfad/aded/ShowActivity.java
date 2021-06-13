package com.hfad.aded;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class ShowActivity extends AppCompatActivity {

    private TextView tvCity, tvName, tvProf, tvDisc, tvPrice, tvPhone, tvEmail;

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
        tvDisc = findViewById(R.id.tvDisc);
        tvPrice = findViewById(R.id.tvPrice);
        tvPhone = findViewById(R.id.tvPhone);
        tvEmail = findViewById(R.id.tvEmail);

    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            tvCity.setText(i.getStringExtra(Constant.USER_CITY));
            tvName.setText(i.getStringExtra(Constant.USER_NAME));
            tvProf.setText(i.getStringExtra(Constant.USER_PROF));
            tvDisc.setText(i.getStringExtra(Constant.USER_DISK));
            tvPrice.setText(i.getStringExtra(Constant.USER_PRICE));
            tvPhone.setText(i.getStringExtra(Constant.USER_PHONE));
            tvEmail.setText(i.getStringExtra(Constant.USER_EMAIL));
        }
    }

    public void onSendCall (View v) {
        TextView number=(TextView) findViewById(R.id.tvPhone);
        String toCall=number.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + toCall));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }



    public void onSendMessage (View v) {
        TextView massage=(TextView) findViewById(R.id.tvEmail);
        EditText message=(EditText)findViewById(R.id.message);
        String toSms="smsto:"+massage.getText().toString();
        String messageText= message.getText().toString();
        Intent sms=new Intent(Intent.ACTION_SENDTO, Uri.parse(toSms));

        sms.putExtra("sms_body", messageText);
        startActivity(sms);

    }
}