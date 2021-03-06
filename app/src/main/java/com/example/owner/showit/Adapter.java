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

    int img[] = {R.drawable.monas, R.drawable.borobudur, R.drawable.makkah, R.drawable.eifel
            , R.drawable.roma, R.drawable.ciliwung, R.drawable.burj, R.drawable.twin};

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
        Picasso.with(context).load(img[position]).resize(400, 500).onlyScaleDown().into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StreetView.class);
                intent.putExtra("nama", list.get(position));
                context.startActivity(intent);

            }
        });

        if(lastItem<position){
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.animasi);
            holder.itemView.setAnimation(animation);
            lastItem++;
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










/*AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle(list.get(position));

                WebView wv = new WebView(context);
                //wv.loadUrl("https://developers.google.com/maps/documentation/javascript/streetview?hl=id");
                wv.loadUrl("https://www.google.com/maps/@37.8692783,-122.2547424,3a,64.2y,236h,59.31t/data=!3m6!1e1!3m4!1saLZGjckzYJA2dnqkB3SkzQ!2e0!7i13312!8i6656");
                wv.getSettings().setLoadsImagesAutomatically(true);
                wv.getSettings().setJavaScriptEnabled(true);
                wv.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);

                        return true;
                    }
                });

                alert.setView(wv);
                alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                alert.show();*/
