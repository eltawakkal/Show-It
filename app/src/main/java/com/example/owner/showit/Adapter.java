package com.example.owner.showit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Eltawakkal on 09/09/16.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public List<String> list;
    public Context context;
    ViewHolder viewHolder;

    int lastItem=-1;

    int img[] = {R.drawable.canyon_pangandaran, R.drawable.goabuniayu, R.drawable.kawaputih, R.drawable.kbnrayabogor
            , R.drawable.mekarsari, R.drawable.pangandaran, R.drawable.pantairatu, R.drawable.patenggang,
            R.drawable.tamannusantara, R.drawable.tangkuban, R.drawable.transtudiobandung, R.drawable.ujung_genteng};

    public Adapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view, parent, false);
        viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textTitle.setText(list.get(position));
        Picasso.with(context).load(img[position]).resize(75, 112).onlyScaleDown().into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("judul", list.get(position));
                context.startActivity(intent);
            }
        });

        if(lastItem<position){
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.animasi);
            holder.itemView.setAnimation(animation);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = (TextView)itemView.findViewById(R.id.textViewQ);
            imageView = (ImageView)itemView.findViewById(R.id.imageViewQ);

        }
    }

}
