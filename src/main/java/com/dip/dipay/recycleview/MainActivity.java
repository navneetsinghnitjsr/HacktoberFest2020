package com.dip.dipay.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    RecyclerAdapter recyclerAdapter;
    ArrayList<Model> arrayList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler=findViewById(R.id.recycler);


        arrayList.add(new Model(R.mipmap.ic_launcher,"deep","7432974296"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));
        arrayList.add(new Model(R.mipmap.ic_launcher,"akash","7908803492"));

        recyclerAdapter=new RecyclerAdapter(this,arrayList);
        /*ListView Purpose*/
        //linearLayoutManager=new LinearLayoutManager(this);//By default Vertical view present in RecyclerView
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        /*ListView Purpose*/

        recycler.setLayoutManager(linearLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());

        recycler.setAdapter(recyclerAdapter);
    }


    }

