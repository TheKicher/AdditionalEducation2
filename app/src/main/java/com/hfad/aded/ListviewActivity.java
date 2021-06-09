package com.hfad.aded;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListviewActivity extends AppCompatActivity {

    private ArrayList <HashMap<String, Object>> myBooks;
    private static final String BOOKKEY = "bookname";
    private static final String PRICEKEY = "bookprice";
    private static final String IMGKEY = "iconfromraw";  //Наша будущая картинка

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = (ListView)findViewById(R.id.list);
        myBooks = new ArrayList<HashMap<String,Object>>();
        HashMap<String, Object> hm;

        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, "Коробке");
        hm.put(PRICEKEY, "какой-то текст");
       // hm.put(IMGKEY, R.drawable.ic_launcher); //тут мы её добавляем для отображения

        myBooks.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, "Футболке");
        hm.put(PRICEKEY, "какой-то текст");
       // hm.put(IMGKEY,  R.drawable.ic_launcher); //тут мы её добавляем для отображения

        myBooks.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, "Робад");
        hm.put(PRICEKEY, "какой-то текст");
       // hm.put(IMGKEY,  R.drawable.ic_launcher); //тут мы её добавляем для отображения

        myBooks.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, "Еще коробке");
        hm.put(PRICEKEY, "какой-то текст");
       // hm.put(IMGKEY,  R.drawable.ic_launcher); //тут мы её добавляем для отображения

        myBooks.add(hm);

        SimpleAdapter adapter = new SimpleAdapter(this,
                myBooks,
                R.layout.list, new String[]{
                BOOKKEY,         //верхний текст
                PRICEKEY,        //нижний теккт
                IMGKEY          //наша картинка
        }, new int[]{
                R.id.text1, //ссылка на объект отображающий текст
                R.id.text2, //ссылка на объект отображающий текст
                R.id.img}); //добавили ссылку в чем отображать картинки из list.xml

        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}


