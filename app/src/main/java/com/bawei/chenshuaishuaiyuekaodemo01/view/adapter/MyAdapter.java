package com.bawei.chenshuaishuaiyuekaodemo01.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.chenshuaishuaiyuekaodemo01.R;
import com.bawei.chenshuaishuaiyuekaodemo01.model.entity.GridEntity;
import com.bawei.chenshuaishuaiyuekaodemo01.view.SecendActivity;
import com.bumptech.glide.Glide;

import java.util.List;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<GridEntity.ResultBean> list;

    public MyAdapter(Context context, List<GridEntity.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, list.get(position).commodityName, Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, SecendActivity.class));
            }
        });


        GridEntity.ResultBean resultBean = list.get(position);
        final String commodityName = resultBean.commodityName;
        final String price = resultBean.price;

        Glide.with(context)
                .load(resultBean.masterPic)
                .into(holder.iv);

        holder.tv1.setText(commodityName);
        holder.tv2.setText(price+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    protected class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv;
        public TextView tv1,tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);

        }
    }
}
