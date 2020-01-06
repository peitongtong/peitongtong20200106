package com.bawei.peitongtong20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.peitongtong20200106.R;
import com.bawei.peitongtong20200106.entity.ClsEntity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder>{
    private Context context;
    private List<ClsEntity.Cls.Category> list;

    public LeftAdapter(Context context, List<ClsEntity.Cls.Category> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.left_item_layout, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(list.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftOnClick.getName(list.get(position).name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
    private LeftOnClick leftOnClick;

    public void setLeftOnClick(LeftOnClick leftOnClick) {
        this.leftOnClick = leftOnClick;
    }

    public interface LeftOnClick{
        void getName(String id);
    }
}
