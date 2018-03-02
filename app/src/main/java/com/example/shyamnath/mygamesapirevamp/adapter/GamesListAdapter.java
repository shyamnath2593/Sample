package com.example.shyamnath.mygamesapirevamp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shyamnath.mygamesapirevamp.R;
import com.example.shyamnath.mygamesapirevamp.model.GameDetailModel;

import java.util.ArrayList;

/**
 * Created by Shyamnath on 08-12-2017.
 */

public class GamesListAdapter extends RecyclerView.Adapter<GamesListAdapter.MyViewHolder> {
    Context ctx;
    ArrayList<GameDetailModel> detailModelArrayList;

    public GamesListAdapter(Context ctx, ArrayList<GameDetailModel> detailArraylist) {
        this.ctx=ctx;
        detailModelArrayList=detailArraylist;
    }

    @Override
    public GamesListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(ctx);
        View view=inflater.inflate(R.layout.games_list_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GamesListAdapter.MyViewHolder holder, int position) {
        holder.txtView.setText(detailModelArrayList.get(position).getName());
        Glide.with(ctx).load(detailModelArrayList.get(position).getUrl()).into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return detailModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView;
        TextView txtView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imgView=itemView.findViewById(R.id.img_view);
            txtView=itemView.findViewById(R.id.txt_view);
        }
    }
}
