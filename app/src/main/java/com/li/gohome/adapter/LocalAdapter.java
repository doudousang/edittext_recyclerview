package com.li.gohome.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.li.gohome.R;
import com.li.gohome.baen.CommonModel;
import com.li.gohome.util.CircleImageView;
import com.li.gohome.util.ConstantsUtil;
import com.li.gohome.util.MyImageView;
import com.li.gohome.view.WebViewActivity;

import java.util.List;

public class LocalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<CommonModel> localList;
    int itemType;
    Context context;
    static int LOCAL_TYPE = 1;
    static int SUB_TYPE = 2;

    public LocalAdapter(List<CommonModel> LocalBean, int type, Context context) {
        this.localList = LocalBean;
        this.itemType = type;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return 1;
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(itemType == LOCAL_TYPE) {
            return new LocalItemHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.local_item, parent, false));
        }else if(itemType == SUB_TYPE){
            return new SubItemHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sub_item, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LocalItemHolder) {
            ((LocalItemHolder) holder).image.setImageURL(localList.get(position).getIcon());
            ((LocalItemHolder) holder).textView.setText(localList.get(position).getTitle());
            final String url = localList.get(position).getUrl();
            ((LocalItemHolder) holder).localLayout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    intoWebView(url);
                }
            });
        }else if(holder instanceof SubItemHolder){
            ((SubItemHolder) holder).image.setImageURL(localList.get(position).getIcon());
            ((SubItemHolder) holder).textView.setText(localList.get(position).getTitle());
            final String url = localList.get(position).getUrl();
            ((SubItemHolder) holder).subLayout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    intoWebView(url);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return localList.size();
    }

    public class LocalItemHolder extends RecyclerView.ViewHolder {
        ConstraintLayout localLayout;
        CircleImageView image;
        TextView textView;

        public LocalItemHolder(@NonNull View itemView) {
            super(itemView);
            localLayout = itemView.findViewById(R.id.local_layout);
            image = itemView.findViewById(R.id.local_image);
            textView = itemView.findViewById(R.id.local_text);
        }
    }

    public class SubItemHolder extends RecyclerView.ViewHolder {
        ConstraintLayout subLayout;
        MyImageView image;
        TextView textView;

        public SubItemHolder(@NonNull View itemView) {
            super(itemView);
            subLayout = itemView.findViewById(R.id.sub_layout);
            image = itemView.findViewById(R.id.sub_image);
            textView = itemView.findViewById(R.id.sub_text);
        }
    }

    public void intoWebView(String url){
        Intent startIntent = new Intent(context, WebViewActivity.class);
        startIntent.putExtra(ConstantsUtil.LOCAL_URL, url);
        context.startActivity(startIntent);
    }

}
