package com.li.gohome.view;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.li.gohome.R;
import com.li.gohome.adapter.SearchAdapter;
import com.li.gohome.baen.SearchModel;
import com.li.gohome.presenter.MainPresenter;

import java.util.ArrayList;

public class SearchPageActivity extends BaseActivity{
    String searchUrl = "https://m.ctrip.com/restapi/h5api/searchapp/search?source=mobileweb&action=autocomplete&contentType=json&keyword=";

    protected EditText searchEd;
    protected ImageView speak;
    MainPresenter presenter;
    RecyclerView recyclerView;
    SearchAdapter searchAdapter;

    Activity context;
    String searchString;

    public SearchPageActivity(Activity context) {
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_page, null);
        initView(view);
        initPermission();
        presenter = new MainPresenter(this);

        recyclerView = (RecyclerView)view.findViewById(R.id.searchRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        searchAdapter = new SearchAdapter(context);
        recyclerView.setAdapter(searchAdapter);

        speak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(context,SpeakPageActivity.class),1);
            }
        });

        searchEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                getSearchNet(s.toString());
                searchString = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return view;
    }

    public void getSearchNet(String str){
        presenter.getSearch(searchUrl+str);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.v("nn","nn");
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            String str = data.getStringExtra("result");
            searchEd.setText(str);
            getSearchNet(str);
        }
    }

    private void initView(View view) {
        searchEd = view.findViewById(R.id.searchEd);
        speak = view.findViewById(R.id.speak);
    }

    /**
     * android 6.0 以上需要动态申请权限
     */
    private void initPermission() {
        String permissions[] = {Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.INTERNET,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        ArrayList<String> toApplyList = new ArrayList<String>();

        for (String perm : permissions) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(context, perm)) {
                toApplyList.add(perm);
                // 进入到这里代表没有权限.

            }
        }
        String tmpList[] = new String[toApplyList.size()];
        if (!toApplyList.isEmpty()) {
            ActivityCompat.requestPermissions(context, toApplyList.toArray(tmpList), 123);
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // 此处为android 6.0以上动态授权的回调，用户自行实现。
    }

    @Override
    public void getSearchModel(SearchModel searchModel) {
        searchAdapter.getData(searchModel,searchString);
    }
}
