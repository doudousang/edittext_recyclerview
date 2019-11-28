package com.li.gohome.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.li.gohome.R;
import com.li.gohome.adapter.MainFragmentAdapter;
import com.li.gohome.adapter.TravelFragmentAdapter;
import com.li.gohome.baen.TravelModel;
import com.li.gohome.baen.TravelTabModel;
import com.li.gohome.presenter.MainPresenter;
import com.li.gohome.util.ConstantsUtil;
import com.li.gohome.util.SPUtils;

import java.util.ArrayList;
import java.util.List;

public class TravelPhotoFragment extends BaseActivity {
    TextView textView;
    TabLayout tabLayout;
    ViewPager viewPager;

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    FragmentActivity context;
    TravelFragmentAdapter fragmentAdapter;

    public TravelPhotoFragment(FragmentActivity context) {
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainPresenter presenter = new MainPresenter(this);
        presenter.getTravelTab();
        View view = inflater.inflate(R.layout.travel_photo, null);
        tabLayout = view.findViewById(R.id.travel_tab_layout);
        viewPager = view.findViewById(R.id.tab_view_page);
        initTabPager();

        return view;
    }

    private void initTabPager() {
        TravelTabModel travelTabModel = SPUtils.getInstance(context).get(ConstantsUtil.TRAVEL_TAB_DATA, TravelTabModel.class);
        if(travelTabModel != null){
            titles.clear();
            fragments.clear();
            for (int a=0;a<travelTabModel.getTabs().size();a++){
                titles.add(travelTabModel.getTabs().get(a).getLabelName());
                fragments.add(new TravelTabFragment(context,travelTabModel.getTabs().get(a).getGroupChannelCode()));
            }
        }

        fragmentAdapter = new TravelFragmentAdapter(context.getSupportFragmentManager(),
                fragments, titles);//viewpage的adapter
        viewPager.setAdapter(fragmentAdapter);//viewpage设置adapter
        tabLayout.setupWithViewPager(viewPager);//viewpage和tablayout关联
    }


    @Override
    public void getTravelTabModel(TravelTabModel travelTabModel) {
        if(travelTabModel != null){
            SPUtils.getInstance(context).put(ConstantsUtil.TRAVEL_TAB_DATA, travelTabModel);
            titles.clear();
            fragments.clear();
            Log.v("size","=="+travelTabModel.getTabs().size());
            Log.v("size","==mm"+fragments.size());
            for (int a=0;a<travelTabModel.getTabs().size();a++){
                titles.add(travelTabModel.getTabs().get(a).getLabelName());
                fragments.add(new TravelTabFragment(context,travelTabModel.getTabs().get(a).getGroupChannelCode()));
            }
            fragmentAdapter.getData(fragments,titles);
        }
    }
}
