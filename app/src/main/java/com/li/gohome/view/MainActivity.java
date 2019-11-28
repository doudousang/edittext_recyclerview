package com.li.gohome.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.li.gohome.R;
import com.li.gohome.adapter.MainFragmentAdapter;
import com.li.gohome.util.ViewPagerSlide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPagerSlide viewPager;

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    private int[] drawables = {R.drawable.selector_home, R.drawable.selector_search, R.drawable.selector_phone, R.drawable.selector_me};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_page);

        fragments.add(new HomePageActivity(this));
        fragments.add(new SearchPageActivity(this));
        fragments.add(new TravelPhotoFragment(this));
        fragments.add(new Fragment1());

        titles.add("首页");
        titles.add("搜索");
        titles.add("旅拍");
        titles.add("我的");



        MainFragmentAdapter fragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(),
                fragments,titles);//viewpage的adapter
        viewPager.setSlide(false);
        viewPager.setAdapter(fragmentAdapter);//viewpage设置adapter
        tabLayout.setSelectedTabIndicatorHeight(0);//去掉下划线
        tabLayout.setupWithViewPager(viewPager);//viewpage和tablayout关联


        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setCustomView(getTabView(i));
        }
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView textView = tab.getCustomView().findViewById(R.id.text_view);
                textView.setTextColor(getResources().getColor(android.R.color.holo_blue_light));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                TextView textView = tab.getCustomView().findViewById(R.id.text_view);
                textView.setTextColor(getResources().getColor(android.R.color.darker_gray));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    // Tab自定义view
    public View getTabView(int position) {
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_item_view, null);
        TextView textView = (TextView) v.findViewById(R.id.text_view);
        textView.setText(titles.get(position));
        ImageView imageView = (ImageView) v.findViewById(R.id.image_view);
        imageView.setImageResource(drawables[position]);
        if (position == 0) {//首次进入设置text的颜色
            textView.setTextColor(v.getResources().getColor(android.R.color.holo_blue_light));
        }
        return v;
    }
}
