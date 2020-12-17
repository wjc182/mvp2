package com.example.p7day03work.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.p7day03work.R;
import com.example.p7day03work.bean.Bean;

import java.util.ArrayList;

public class  Myadafel extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Bean.DataDTO> list;

    public Myadafel(Context context, ArrayList<Bean.DataDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rew_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Bean.DataDTO dto = list.get(position);
        ViewHolder v= (ViewHolder) holder;
        v.name.setText(dto.getTitle());
        Glide.with(context).load(dto.getPic()).into(v.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.rew_image);
            name=itemView.findViewById(R.id.rew_name);

        }
    }
}
