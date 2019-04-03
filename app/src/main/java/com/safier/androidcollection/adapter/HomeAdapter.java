package com.safier.androidcollection.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.safier.androidcollection.R;
import com.safier.androidcollection.bean.HomeItemBean;
import com.vondear.rxtool.RxActivityTool;

import java.util.List;

/**
 * @author safier
 * @date 2019/3/12
 */
public class HomeAdapter extends BaseQuickAdapter<HomeItemBean,BaseViewHolder> {


    public HomeAdapter( List data) {
        super(R.layout.item_recyclerview_home, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final HomeItemBean item) {
        helper.setImageResource(R.id.imageView,item.getImage());
        helper.setText(R.id.tv_name,item.getName());
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxActivityTool.skipActivity(mContext,item.getActivity());
            }
        });
    }
}
