package com.bawei.peitongtong20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.peitongtong20200106.R;
import com.bawei.peitongtong20200106.entity.RightEntity;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
    private Context context;
    private List<RightEntity.DataBean> list;

    public RightAdapter(Context context, List<RightEntity.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.right_item_layout, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getGoods_thumb())
                .into(holder.imageView);
        holder.name.setText(list.get(position).getGoods_english_name());
        holder.jieshao.setText(list.get(position).getGoods_name());
        holder.price.setText(list.get(position).getCurrency_price());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,jieshao,price;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name);
            jieshao = itemView.findViewById(R.id.jieshao);
            price = itemView.findViewById(R.id.price);
        }
    }
}
