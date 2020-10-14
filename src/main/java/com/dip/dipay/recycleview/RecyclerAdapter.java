package com.dip.dipay.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    Context context;
    ArrayList<Model> modelArrayList = new ArrayList<>();

    MyViewHolder viewholder;

    public RecyclerAdapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txt_name,txt_ph;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_name=itemView.findViewById(R.id.txt_name);
            txt_ph=itemView.findViewById(R.id.txt_ph);
            img=itemView.findViewById(R.id.img);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_demo,viewGroup,false);


        viewholder=new MyViewHolder(view);
        return viewholder;


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewholder, int position) {

        myViewholder.txt_name.setText(modelArrayList.get(position).getName());
        myViewholder.txt_ph.setText(modelArrayList.get(position).getPh());
        myViewholder.img.setImageResource(modelArrayList.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }


}
