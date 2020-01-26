package com.jkapps.cardviewwithrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Model> dataSet;
    private Context mContext;

    public MyRecyclerViewAdapter(Context context, ArrayList<Model> data) {
        this.dataSet = data;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        Log.d(TAG, "onBindViewHolder: called."); // for debugging

        ImageView imageView = holder.imageView;
        final TextView tv_title = holder.tv_title;
        TextView tv_description = holder.tv_description;
        TextView tv_buyNow = holder.tv_buyNow;

        imageView.setImageResource(dataSet.get(listPosition).getImage());
        tv_title.setText(dataSet.get(listPosition).getTitle());
        tv_description.setText(dataSet.get(listPosition).getDescription());
        tv_buyNow.setText("Buy Now");
        tv_buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext != null) {
                    //Log.d(TAG, "onClick: clicked on: " + dataSet.get(listPosition).getTitle());
                    Toast.makeText(mContext, dataSet.get(listPosition).getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra("shopUrl", dataSet.get(listPosition).getShopUrl());
                    mContext.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tv_title;
        TextView tv_description;
        TextView tv_buyNow;
        TextView tv_shopUrl;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.tv_title = itemView.findViewById(R.id.tv_title);
            this.tv_description = itemView.findViewById(R.id.tv_description);
            this.tv_buyNow = itemView.findViewById(R.id.tv_buyNow);
            this.tv_shopUrl = itemView.findViewById(R.id.tv_shopUrl);
        }
    }
}