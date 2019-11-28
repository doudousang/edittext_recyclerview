package com.li.gohome.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.li.gohome.R;
import com.li.gohome.baen.TravelModel;
import com.li.gohome.util.CircleImageView;
import com.li.gohome.util.MyImageView;

public class TravelTabFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    TravelModel travelModel;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v("sizee2","onCreateViewHolder==");
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.travel_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.v("sizee2","onBindViewHolder==");
        if(travelModel == null){
            return;
        }
        if (holder instanceof ItemHolder) {
            if(travelModel.getResultList().get(position).getArticle() != null) {
                ((ItemHolder) holder).travelImage.setImageURL(travelModel.getResultList().get(position).getArticle().getImages().get(0).getDynamicUrl());
                ((ItemHolder) holder).userImage.setImageURL(travelModel.getResultList().get(position).getArticle().getAuthor().getCoverImage().getDynamicUrl());
                ((ItemHolder) holder).articleTitle.setText(travelModel.getResultList().get(position).getArticle().getArticleTitle());
                ((ItemHolder) holder).userName.setText(travelModel.getResultList().get(position).getArticle().getAuthor().getNickName());
                ((ItemHolder) holder).zanCount.setText(travelModel.getResultList().get(position).getArticle().getLikeCount() + "");
            }
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        MyImageView travelImage;
        CircleImageView userImage;
        TextView articleTitle;
        TextView userName;
        TextView zanCount;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            travelImage = itemView.findViewById(R.id.travel_image);
            userImage = itemView.findViewById(R.id.user_image);
            articleTitle = itemView.findViewById(R.id.articleTitle);
            userName = itemView.findViewById(R.id.user_name);
            zanCount = itemView.findViewById(R.id.zanCount);
        }
    }

    public void getData(TravelModel travelModel){
        Log.v("sizee2","getData==");
        this.travelModel = travelModel;
        notifyDataSetChanged();
    }
}
