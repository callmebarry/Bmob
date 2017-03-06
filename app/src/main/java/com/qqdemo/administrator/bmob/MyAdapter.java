package com.qqdemo.administrator.bmob;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Person> mList;
    private Context mContext;
    public MyAdapter(Context mContext,List<Person> mList) {
        this.mContext=mContext;
        this.mList=mList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(mList.get(position).getName());
        holder.age.setText(String.valueOf(mList.get(position).getAge()));
        holder.address.setText(mList.get(position).getAddress());
        Glide.with(mContext).load(mList.get(position).getImg()).fitCenter().into(holder.img);
    }



    @Override
    public int getItemCount() {
        return mList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView age;
        TextView address;
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (android.widget.TextView) itemView.findViewById(R.id.name);
            age = (android.widget.TextView) itemView.findViewById(R.id.age);
            address = (android.widget.TextView) itemView.findViewById(R.id.address);
            img= (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
