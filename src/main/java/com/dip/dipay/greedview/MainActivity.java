package com.dip.dipay.greedview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    GridView GridView;
    ArrayList<model> arrayList = new ArrayList<>();
    CustomAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView=findViewById(R.id.GridView);

        arrayList.add(new model(R.mipmap.ic_launcher));
        arrayList.add(new model(R.mipmap.ic_launcher));
        arrayList.add(new model(R.mipmap.ic_launcher));
        arrayList.add(new model(R.mipmap.ic_launcher));
        arrayList.add(new model(R.mipmap.ic_launcher));
        arrayList.add(new model(R.mipmap.ic_launcher));
        arrayList.add(new model(R.mipmap.ic_launcher));
        arrayList.add(new model(R.mipmap.ic_launcher));
        adapter=new CustomAdapter(arrayList,this);
        GridView.setAdapter(adapter);



    }
}