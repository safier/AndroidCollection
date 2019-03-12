package com.safier.androidcollection.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.safier.androidcollection.R;
import com.safier.androidcollection.adapter.HomeAdapter;
import com.safier.androidcollection.adapter.itemdecoration.HomeRecyclerViewItemDecoration;
import com.safier.androidcollection.bean.HomeItemBean;
import com.safier.androidcollection.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private List<HomeItemBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview= findViewById(R.id.recyclerview);
        initData();
        initView();
    }

    private void initData() {
        mDatas = new ArrayList<>();
        mDatas.add(new HomeItemBean("时崎狂三",R.drawable.tokisaki_kurumi,HomeActivity.class));
        mDatas.add(new HomeItemBean("蕾姆",R.drawable.rem,HomeActivity.class));
        mDatas.add(new HomeItemBean("艾米莉亚",R.drawable.emilia,HomeActivity.class));
        mDatas.add(new HomeItemBean("康娜",R.drawable.kanna_kamui,HomeActivity.class));
        mDatas.add(new HomeItemBean("薇尔莉特",R.drawable.violet_evergarden,HomeActivity.class));
        mDatas.add(new HomeItemBean("和泉纱雾",R.drawable.izumi_sagiri,HomeActivity.class));
        mDatas.add(new HomeItemBean("加藤惠",R.drawable.katou_megumi,HomeActivity.class));
        mDatas.add(new HomeItemBean("楪祈",R.drawable.yuzuriha_inori,HomeActivity.class));
        mDatas.add(new HomeItemBean("宫园薰",R.drawable.miyazono_kaori,HomeActivity.class));
        mDatas.add(new HomeItemBean("娑娜",R.drawable.sona_buvelle,HomeActivity.class));
    }
    private void initView() {
        recyclerview.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerview.addItemDecoration(new HomeRecyclerViewItemDecoration(ImageUtil.dp2px(5f)));
        HomeAdapter homeAdapter = new HomeAdapter(mDatas);
        recyclerview.setAdapter(homeAdapter);
    }

}
