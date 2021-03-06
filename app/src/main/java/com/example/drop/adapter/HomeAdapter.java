package com.example.drop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drop.R;
import com.example.drop.classes.TakePhoto;
import com.example.drop.classes.Chat;
import com.example.drop.utils.BitmapBuilder;
import com.example.drop.utils.ScreamIfo;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<Chat> mHomeList;

    private Context mContext;

    public HomeAdapter( Context mContext, List<Chat> chatList ) {
        this.mHomeList = chatList;
        this.mContext = mContext;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View homeView;
        ImageView homeImage;
        TextView homeName;

        public ViewHolder(View view){
            super(view);
            homeView = view;
            homeImage = view.findViewById(R.id.home_image);
            homeName  = view.findViewById(R.id.home_name);
        }
    }


    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        final HomeAdapter.ViewHolder holder = new HomeAdapter.ViewHolder(view);
        holder.homeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TakePhoto.class);
                view.getContext().startActivity(intent);
            }
        });
        holder.homeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TakePhoto.class);
                view.getContext().startActivity(intent);
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        Chat home = mHomeList.get(position);
        holder.homeImage.setImageBitmap(BitmapBuilder.decodeBitmapById(mContext.getResources(),
                home.getImageId(), ScreamIfo.getSCREAMWIDTH() / 2, ScreamIfo.getSCREAMHEIGHT() / 4));
        holder.homeName.setText(home.getName());
    }

    @Override
    public int getItemCount() {
        return mHomeList.size();
    }
}
