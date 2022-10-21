package com.example.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMenuAdapter extends RecyclerView.Adapter<ListMenuAdapter.ListViewHolder> {
    private ArrayList<Menu> listMenu;

    private OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public ListMenuAdapter(ArrayList<Menu> list){
        this.listMenu = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Menu menu = listMenu.get(position);
        Glide.with(holder.itemView.getContext())
                .load(menu.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.tvName.setText(menu.getName());
        holder.tvDetail.setText(menu.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.onItemClicked(listMenu.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMenu.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        public ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_foto);
            tvName = itemview.findViewById(R.id.item_name);
            tvDetail = itemview.findViewById(R.id.item_detail);
        }
    }

    public interface OnItemClickCallBack{
        void onItemClicked(Menu data);
    }
}
