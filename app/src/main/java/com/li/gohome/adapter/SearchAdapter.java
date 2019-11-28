package com.li.gohome.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.li.gohome.R;
import com.li.gohome.baen.SearchModel;
import com.li.gohome.util.ConstantsUtil;
import com.li.gohome.util.KeyWordUtil;
import com.li.gohome.view.WebViewActivity;

import java.util.ArrayList;
import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<SearchModel.Data> datas = new ArrayList();
    String keyWord;
    Activity context;
    String[] TYPES = {
            "channelgroup",
            "gs",
            "plane",
            "train",
            "cruise",
            "district",
            "food",
            "hotel",
            "huodong",
            "shop",
            "sight",
            "ticket",
            "travelgroup"
    };
    int[] DrawableResTYPES = {
            R.drawable.type_channelgroup,
            R.drawable.type_channelgs,
            R.drawable.type_channelplane,
            R.drawable.type_channeltrain,
            R.drawable.type_cruise,
            R.drawable.type_district,
            R.drawable.type_food,
            R.drawable.type_hotel,
            R.drawable.type_huodong,
            R.drawable.type_shop,
            R.drawable.type_sight,
            R.drawable.type_ticket,
            R.drawable.type_travelgroup,

    };

    public SearchAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SearchItemViewHolder) {
            ((SearchItemViewHolder) holder).searchImage.setImageResource(imageType(datas.get(position).getType()));
            ((SearchItemViewHolder) holder).searchItem.setText(
                    KeyWordUtil.matcherSearchTitle(Color.GREEN, datas.get(position).getWord(), keyWord));
            Log.v("pe", "==" + datas.get(position).getPrice());
            if (datas.get(position).getPrice() == null) {
                ((SearchItemViewHolder) holder).searchSubItem.setVisibility(View.GONE);
            } else {
                ((SearchItemViewHolder) holder).searchSubItem.setText("¥" + datas.get(position).getPrice());
            }
            final String webViewUrl = datas.get(position).getUrl();
            ((SearchItemViewHolder) holder).searchLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intoWebView(webViewUrl);
                }
            });
        }
    }

    public int imageType(String type) {
        if (type == null) {
            return R.drawable.type_channeltrain;
        }
        int path = 0;
        for (int a = 0; a < TYPES.length; a++) {
            if (type.contains(TYPES[a])) {
                path = a;
            }
        }
        return DrawableResTYPES[path];
    }

    public void intoWebView(String url) {
        Intent startIntent = new Intent(context, WebViewActivity.class);
        startIntent.putExtra(ConstantsUtil.LOCAL_URL, url);
        context.startActivity(startIntent);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class SearchItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout searchLayout;
        ImageView searchImage;
        TextView searchItem;
        TextView searchSubItem;

        public SearchItemViewHolder(@NonNull View itemView) {
            super(itemView);
            searchLayout = itemView.findViewById(R.id.search_item_layout);
            searchImage = itemView.findViewById(R.id.search_image);
            searchItem = itemView.findViewById(R.id.search_text);
            searchSubItem = itemView.findViewById(R.id.search_sub_text);
        }
    }

    public void getData(SearchModel searchModel, String searchWord) {
        datas = searchModel.getData();
        keyWord = searchWord;
        notifyDataSetChanged();
    }


}
