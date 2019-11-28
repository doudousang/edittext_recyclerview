package com.li.gohome.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.li.gohome.R;
import com.li.gohome.baen.SalesBox;
import com.li.gohome.util.ConstantsUtil;
import com.li.gohome.util.MyImageView;
import com.li.gohome.view.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    SalesBox salesbox;
    Context context;
    private List<String> iconDatas = new ArrayList<>();
    private List<String> urlDatas = new ArrayList<>();
    public static final int TITLE_TYPE = 0;
    public static final int IMAGE_BIG_TYPE = 1;
    public static final int IMAGE_SMALL_TYPE = 2;


    public SalesAdapter(SalesBox salesbox,Context context) {
        this.salesbox = salesbox;
        this.context = context;
        iconDatas.add(salesbox.getIcon());
        iconDatas.add(salesbox.getBigCard1().getIcon());
        iconDatas.add(salesbox.getBigCard2().getIcon());
        iconDatas.add(salesbox.getSmallCard1().getIcon());
        iconDatas.add(salesbox.getSmallCard2().getIcon());
        iconDatas.add(salesbox.getSmallCard3().getIcon());
        iconDatas.add(salesbox.getSmallCard4().getIcon());

        urlDatas.add(salesbox.getMoreUrl());
        urlDatas.add(salesbox.getBigCard1().getUrl());
        urlDatas.add(salesbox.getBigCard2().getUrl());
        urlDatas.add(salesbox.getSmallCard1().getUrl());
        urlDatas.add(salesbox.getSmallCard2().getUrl());
        urlDatas.add(salesbox.getSmallCard3().getUrl());
        urlDatas.add(salesbox.getSmallCard4().getUrl());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TITLE_TYPE) {
            return new TitleHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sales_title, parent, false));
        } else if (viewType == IMAGE_BIG_TYPE) {
            return new ImageBigHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sales_big_image, parent, false));
        }else if (viewType == IMAGE_SMALL_TYPE) {
            return new ImageSmallHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sales_small_image, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof TitleHolder) {
            ((TitleHolder) holder).imageView.setImageURL(salesbox.getIcon());
            ((TitleHolder) holder).textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intoWebView(urlDatas.get(position));
                }
            });
        } else if (holder instanceof ImageBigHolder) {
            ((ImageBigHolder) holder).imageView.setImageURL(iconDatas.get(position));
            ((ImageBigHolder) holder).imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intoWebView(urlDatas.get(position));
                }
            });
        } else if (holder instanceof ImageSmallHolder) {
            ((ImageSmallHolder) holder).imageView.setImageURL(iconDatas.get(position));
            ((ImageSmallHolder) holder).imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intoWebView(urlDatas.get(position));
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TITLE_TYPE;
        } else if (position == 1 || position == 2) {
            return IMAGE_BIG_TYPE;
        }else if(position > 2){
            return IMAGE_SMALL_TYPE;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return iconDatas.size();
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
                    if (TITLE_TYPE == getItemViewType(position)) {
                        return 2;
                    } else if (IMAGE_BIG_TYPE == getItemViewType(position)
                    || IMAGE_SMALL_TYPE == getItemViewType(position)) {
                        return 1;
                    } else {
                        return 2;
                    }
                }
            });
        }
    }

    public class TitleHolder extends RecyclerView.ViewHolder {
        MyImageView imageView;
        TextView textView;

        public TitleHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sales_title_left);
            textView = itemView.findViewById(R.id.sales_title_right);
        }
    }

    public class ImageBigHolder extends RecyclerView.ViewHolder {
        MyImageView imageView;

        public ImageBigHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sales_big_image);
        }
    }

    public class ImageSmallHolder extends RecyclerView.ViewHolder {
        MyImageView imageView;

        public ImageSmallHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sales_small_image);
        }
    }

    public void intoWebView(String url){
        Intent startIntent = new Intent(context, WebViewActivity.class);
        startIntent.putExtra(ConstantsUtil.LOCAL_URL, url);
        context.startActivity(startIntent);
    }
}
