package com.dip.dipay.greedview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
   ArrayList<model> arrayList =new ArrayList<>();
   Context context;
    public CustomAdapter(ArrayList<model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;

    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Viewholder{
        ImageView imggrid;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Viewholder viewholder;

        if(convertView==null){

            convertView=inflater.inflate(R.layout.demo,null);
            viewholder=new Viewholder();

            viewholder.imggrid=convertView.findViewById(R.id.imggrid);


            convertView.setTag(viewholder);
        }
        else{
            viewholder=(Viewholder)convertView.getTag();
        }

        viewholder.imggrid.setImageResource(arrayList.get(position).getImg());


        return convertView;


    }
}
