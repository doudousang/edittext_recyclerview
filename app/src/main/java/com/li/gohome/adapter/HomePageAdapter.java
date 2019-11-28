package com.li.gohome.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.li.gohome.R;
import com.li.gohome.baen.CommonModel;
import com.li.gohome.baen.CommonModelListBean;
import com.li.gohome.baen.ExampleBaseBean;
import com.li.gohome.baen.GridItemBean;
import com.li.gohome.baen.GridNav;
import com.li.gohome.baen.HomeModel;
import com.li.gohome.baen.SalesBoxBean;
import com.li.gohome.util.ConstantsUtil;
import com.li.gohome.view.WebViewActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnBannerListener {
    List<ExampleBaseBean> datas = new ArrayList<>();
    List<String> bannerItemUrl = new ArrayList<>();
    Context context;
    //banner
    public static final int BANNER_TYPE = 0;
    //local
    public static final int LOCAL_TYPE = 1;
    //grid_hotel
    public static final int HOTEL_TYPE = 2;
    //grid_flight
    public static final int FLIGHT_TYPE = 3;
    //grid_travel
    public static final int TRAVEL_TYPE = 4;
    //subNav
    public static final int SUBNAV_TYPE = 5;
    //sales
    public static final int SALES_TYPE = 6;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        if (viewType == BANNER_TYPE) {
            return new BannerHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.top_layout, parent, false
                    ));
        } else if (viewType == LOCAL_TYPE) {
            return new LocalHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.local, parent, false));
        } else if (viewType == HOTEL_TYPE || viewType == FLIGHT_TYPE || viewType == TRAVEL_TYPE) {
            return new GridItemHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.grid_item, parent, false));
        } else if (viewType == SUBNAV_TYPE) {
            return new SubNavHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sub, parent, false));
        } else if (viewType == SALES_TYPE) {
            return new SalesHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sales_box, parent, false));
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerHolder) {
//放图片地址的集合
            List<String> list_path = new ArrayList<>();
            //放标题的集合
            List<String> list_title = new ArrayList<>();
            final CommonModelListBean bannerBean = (CommonModelListBean) datas.get(position);
            Log.v("kk", bannerBean.getCommonModelListBean().get(0).getIcon() + "==");
            for (int a = 0; a < bannerBean.getCommonModelListBean().size(); a++) {
                list_path.add(bannerBean.getCommonModelListBean().get(a).getIcon());
                list_title.add("好好学习" + a);
                bannerItemUrl.add(bannerBean.getCommonModelListBean().get(a).getUrl());
            }
            //设置内置样式，共有六种可以点入方法内逐一体验使用。
            ((BannerHolder) holder).banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            //设置图片加载器，图片加载器在下方
            ((BannerHolder) holder).banner.setImageLoader(new MyLoader());
            //设置图片网址或地址的集合
            ((BannerHolder) holder).banner.setImages(list_path);
            //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
            ((BannerHolder) holder).banner.setBannerAnimation(Transformer.Default);
            //设置轮播图的标题集合
            ((BannerHolder) holder).banner.setBannerTitles(list_title);
            //设置轮播间隔时间
            ((BannerHolder) holder).banner.setDelayTime(3000);
            //设置是否为自动轮播，默认是“是”。
            ((BannerHolder) holder).banner.isAutoPlay(true);
            //设置指示器的位置，小点点，左中右。
            ((BannerHolder) holder).banner.setIndicatorGravity(BannerConfig.CENTER)
                    //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                    .setOnBannerListener(this)
                    //必须最后调用的方法，启动轮播图。
                    .start();
        } else if (holder instanceof LocalHolder) {
            CommonModelListBean localBean = (CommonModelListBean) datas.get(position);
            RecyclerView recyclerView = ((LocalHolder) holder).localRecycler;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 5, RecyclerView.VERTICAL, false));
            recyclerView.setAdapter(new LocalAdapter(localBean.getCommonModelListBean(), LocalAdapter.LOCAL_TYPE, context));
        } else if (holder instanceof GridItemHolder) {
            final GridItemBean gridItemBean = (GridItemBean) datas.get(position);
            setGridLayoutBG(((GridItemHolder) holder).gridLayout, gridItemBean.getGridItemBean());
            mainItem(((GridItemHolder) holder).mainImage, ((GridItemHolder) holder).mainText, gridItemBean.getGridItemBean().getMainItem());
            gridItem(((GridItemHolder) holder).Item1, ((GridItemHolder) holder).Item2, ((GridItemHolder) holder).Item3,
                    ((GridItemHolder) holder).Item4, gridItemBean.getGridItemBean());
            setOnClick(((GridItemHolder) holder).mainLayout,gridItemBean.getGridItemBean().getMainItem().getUrl());
            setOnClick(((GridItemHolder) holder).item1Layout,gridItemBean.getGridItemBean().getItem1().getUrl());
            setOnClick(((GridItemHolder) holder).item2Layout,gridItemBean.getGridItemBean().getItem2().getUrl());
            setOnClick(((GridItemHolder) holder).item3Layout,gridItemBean.getGridItemBean().getItem3().getUrl());
            setOnClick(((GridItemHolder) holder).item4Layout,gridItemBean.getGridItemBean().getItem4().getUrl());

        } else if (holder instanceof SubNavHolder) {
            CommonModelListBean subNavBean = (CommonModelListBean) datas.get(position);
            RecyclerView recyclerView = ((SubNavHolder) holder).subNavRecycler;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 5, RecyclerView.VERTICAL, false));
            recyclerView.setAdapter(new LocalAdapter(subNavBean.getCommonModelListBean(), LocalAdapter.SUB_TYPE, context));
            recyclerView.addItemDecoration(new ItemDecoration());
        } else if (holder instanceof SalesHolder) {
            SalesBoxBean salesBoxBean = (SalesBoxBean) datas.get(position);
            RecyclerView recyclerView = ((SalesHolder) holder).salesRecycler;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 2, RecyclerView.VERTICAL, false));
            recyclerView.setAdapter(new SalesAdapter(salesBoxBean.getSalesboxBean(),context));
        }
    }

    @Override
    public int getItemCount() {
        Log.v("kk", datas.size() + "");
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (datas.size() > 0) {
            return datas.get(position).getViewType();
        }
        return super.getItemViewType(position);
    }

    @Override
    public void OnBannerClick(int position) {
        intoWebView(bannerItemUrl.get(position));
    }

    public class BannerHolder extends RecyclerView.ViewHolder {
        Banner banner;

        public BannerHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.top_item);
        }
    }

    public class LocalHolder extends RecyclerView.ViewHolder {
        RecyclerView localRecycler;

        public LocalHolder(@NonNull View itemView) {
            super(itemView);
            localRecycler = itemView.findViewById(R.id.local_recycler);
        }
    }

    public class GridItemHolder extends RecyclerView.ViewHolder {
        private LinearLayout gridLayout;
        private RelativeLayout mainLayout, item1Layout, item2Layout, item3Layout, item4Layout;
        private ImageView mainImage;
        private TextView mainText, Item1, Item2, Item3, Item4;

        public GridItemHolder(@NonNull View itemView) {
            super(itemView);
            gridLayout = itemView.findViewById(R.id.grid_item_layout);
            mainLayout = itemView.findViewById(R.id.main_layout);
            item1Layout = itemView.findViewById(R.id.item1_layout);
            item2Layout = itemView.findViewById(R.id.item2_layout);
            item3Layout = itemView.findViewById(R.id.item3_layout);
            item4Layout = itemView.findViewById(R.id.item4_layout);
            mainImage = itemView.findViewById(R.id.main_image);
            mainText = itemView.findViewById(R.id.main_item);
            Item1 = itemView.findViewById(R.id.item1);
            Item2 = itemView.findViewById(R.id.item2);
            Item3 = itemView.findViewById(R.id.item3);
            Item4 = itemView.findViewById(R.id.item4);
        }
    }

    public class SubNavHolder extends RecyclerView.ViewHolder {
        RecyclerView subNavRecycler;

        public SubNavHolder(@NonNull View itemView) {
            super(itemView);
            subNavRecycler = itemView.findViewById(R.id.sub_recycler);
        }
    }

    public class SalesHolder extends RecyclerView.ViewHolder {
        RecyclerView salesRecycler;

        public SalesHolder(@NonNull View itemView) {
            super(itemView);
            salesRecycler = itemView.findViewById(R.id.sales_recycler);
        }
    }

    public void clearData(){
        datas.clear();
    }

    public void addData(HomeModel model) {
        //banner
        CommonModelListBean bannerList = new CommonModelListBean();
        bannerList.setCommonModelListBean(model.getbannerList());
        bannerList.setViewType(BANNER_TYPE);
        datas.add(bannerList);
        //local
        CommonModelListBean localList = new CommonModelListBean();
        localList.setCommonModelListBean(model.getlocalNavList());
        localList.setViewType(LOCAL_TYPE);
        datas.add(localList);
        //grad_hotel
        GridItemBean gradHotel = new GridItemBean();
        gradHotel.setGridItemBean(model.getGridnav().getHotel());
        gradHotel.setViewType(HOTEL_TYPE);
        datas.add(gradHotel);
        //grad_flight
        GridItemBean gradFlight = new GridItemBean();
        gradFlight.setGridItemBean(model.getGridnav().getFlight());
        gradFlight.setViewType(FLIGHT_TYPE);
        datas.add(gradFlight);
        //grad_travel
        GridItemBean gradTravel = new GridItemBean();
        gradTravel.setGridItemBean(model.getGridnav().getTravel());
        gradTravel.setViewType(TRAVEL_TYPE);
        datas.add(gradTravel);
        //subNav
        CommonModelListBean subNavBean = new CommonModelListBean();
        subNavBean.setCommonModelListBean(model.getsubNavList());
        subNavBean.setViewType(SUBNAV_TYPE);
        datas.add(subNavBean);
        //sales
        SalesBoxBean salesBoxBean = new SalesBoxBean();
        salesBoxBean.setSalesboxBean(model.getSalesbox());
        salesBoxBean.setViewType(SALES_TYPE);
        datas.add(salesBoxBean);

        notifyDataSetChanged();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setGridLayoutBG(LinearLayout layout, GridNav.GridNavItem gridNavItem) {
        Log.v("mm", gridNavItem.getStartColor());
        GradientDrawable linearDrawableTop = getGrad(Color.parseColor("#" + gridNavItem.getStartColor()), Color.parseColor("#" + gridNavItem.getEndColor()));
        layout.setBackground(linearDrawableTop);
    }

    private void mainItem(ImageView imageView, TextView textView, CommonModel model) {
        Glide.with(context).load(model.getIcon()).into(imageView);
        textView.setText(model.getTitle());
    }

    private void gridItem(TextView item1, TextView item2, TextView item3, TextView item4, GridNav.GridNavItem gridNavItem) {
        item1.setText(gridNavItem.getItem1().getTitle());
        item2.setText(gridNavItem.getItem2().getTitle());
        item3.setText(gridNavItem.getItem3().getTitle());
        item4.setText(gridNavItem.getItem4().getTitle());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public GradientDrawable getGrad(int startColor, int endColor) {
        int[] colors = new int[]{startColor, endColor};
        GradientDrawable linearDrawable = new GradientDrawable();
        linearDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        linearDrawable.setColors(colors);
        linearDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        return linearDrawable;
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }

    public class ItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, 10);
        }
    }

    public void setOnClick(View view,String url){
        final String webViewUrl = url;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intoWebView(webViewUrl);
            }
        });
    }

    public void intoWebView(String url){
        Intent startIntent = new Intent(context, WebViewActivity.class);
        startIntent.putExtra(ConstantsUtil.LOCAL_URL, url);
        context.startActivity(startIntent);
    }
}
