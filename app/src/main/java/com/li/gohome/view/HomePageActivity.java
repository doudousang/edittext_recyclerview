package com.li.gohome.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.li.gohome.R;
import com.li.gohome.adapter.HomePageAdapter;
import com.li.gohome.baen.HomeModel;
import com.li.gohome.baen.TravelModel;
import com.li.gohome.presenter.MainPresenter;
import com.li.gohome.util.ConstantsUtil;
import com.li.gohome.util.SPUtils;

public class HomePageActivity extends BaseActivity{
    HomePageAdapter adapter;
    Context context;

    public HomePageActivity(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainPresenter presenter = new MainPresenter(this);
        presenter.getNetWorkInfo();
        View view = inflater.inflate(R.layout.activity_main, null);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new HomePageAdapter();
        HomeModel homeModel = SPUtils.getInstance(context).get(ConstantsUtil.MODEL_DATA, HomeModel.class);
        if (homeModel != null) {
            adapter.clearData();
            adapter.addData(homeModel);
        }
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void getHomeModel(HomeModel homeModel) {
        if(adapter != null && homeModel != null){
            SPUtils.getInstance(context).put(ConstantsUtil.MODEL_DATA, homeModel);
            adapter.clearData();
            adapter.addData(homeModel);
        }
    }

}
