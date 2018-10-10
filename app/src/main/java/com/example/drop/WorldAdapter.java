package com.example.drop;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class WorldAdapter extends RecyclerView.Adapter<WorldAdapter.ViewHolder> {

    private List<World> mWorldList;

    public WorldAdapter(List<World> worldList) {
        mWorldList = worldList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View worldView;
        ImageView worldImage;
        TextView worldName;

        public ViewHolder(View view){
            super(view);
            worldView = view;
            worldImage = (ImageView) view.findViewById(R.id.WorldTop_image);
            worldName = (TextView) view.findViewById(R.id.WorldTop_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.world_top_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.worldView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                World world = mWorldList.get(position);
                WorldAdapter tag = (WorldAdapter) view.getTag();
                Intent intent  = new Intent(view.getContext(),Web.class);
                intent.putExtra("name", world.getName());
                view.getContext().startActivity(intent);
            }
        });
        holder.worldImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                World world = mWorldList.get(position);
                WorldAdapter tag = (WorldAdapter) view.getTag();
                Intent intent  = new Intent(view.getContext(),Web.class);
                intent.putExtra("name", world.getName());
                view.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        World world = mWorldList.get(position);
        holder.worldImage.setImageResource(world.getImageId());
        holder.worldName.setText(world.getName());
    }

    @Override
    public int getItemCount() {
        return mWorldList.size();
    }

}




