package com.li.gohome.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.li.gohome.R;
import com.li.gohome.adapter.TravelTabFragmentAdapter;
import com.li.gohome.baen.TravelModel;
import com.li.gohome.presenter.MainPresenter;
import com.li.gohome.util.ConstantsUtil;
import com.li.gohome.util.SPUtils;

public class TravelTabFragment extends BaseActivity {
    TravelTabFragmentAdapter adapter;
    String groupChannelCode;
    Context context;

    public TravelTabFragment(Context context,String groupChannelCode) {
        this.context = context;
        this.groupChannelCode = groupChannelCode;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        MainPresenter presenter = new MainPresenter(this);
        presenter.getTravel(groupChannelCode);

        View view = inflater.inflate(R.layout.travel_tab_fragment, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.travel_tab_recycler);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager( 2, RecyclerView.VERTICAL));
        adapter = new TravelTabFragmentAdapter();
        TravelModel travelModel = SPUtils.getInstance(context).get(ConstantsUtil.TRAVEL_FRAGMENT_DATA, TravelModel.class);
        if(travelModel != null){
            adapter.getData(travelModel);
        }
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void getTravelModel(TravelModel travelModel) {
        if(travelModel!=null) {//滑动到不同的tab，都会请求一次getTravel，获取不同的结果。
            SPUtils.getInstance(context).put(ConstantsUtil.TRAVEL_FRAGMENT_DATA, travelModel);
            adapter.getData(travelModel);//所以，不改变请求的groupChannelCode，展示的图片也会改变。相当于刷新了。。
        }
        Log.v("abbb2", "==++++" + travelModel.getResultList().get(0).getArticle().getImages().get(0).getDynamicUrl());
    }

}
