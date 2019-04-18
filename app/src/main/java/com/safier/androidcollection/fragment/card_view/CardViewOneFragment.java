package com.safier.androidcollection.fragment.card_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mxn.soul.slidingcard_core.ContainerView;
import com.mxn.soul.slidingcard_core.SlidingCard;
import com.safier.androidcollection.R;
import com.safier.androidcollection.activity.CardViewActivity;
import com.safier.androidcollection.bean.PhotoContent;
import com.safier.androidcollection.fragment.BaseFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author safier
 * @date 2019/4/18
 */
public class CardViewOneFragment extends BaseFragment implements ContainerView.ContainerInterface {
    @BindView(R.id.contentview)
    ContainerView mContentview;
    private List<PhotoContent> dataList ;
    Unbinder unbinder;
    private CardViewActivity.MyTouchListener myTouchListener = new CardViewActivity.MyTouchListener() {
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            return !isRangeOfView(mContentview,event);
        }
    };

    @Override
    protected void initView()  {
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initData() throws Exception {
        dataList = new ArrayList<>();
        String[] titles = getResources().getStringArray(R.array.title);
        String[] imags = getResources().getStringArray(R.array.imgs);
        for (int i = 0; i < titles.length; i++) {
            PhotoContent photoContent = new PhotoContent(String.valueOf(i), titles[i], imags[i]);
            dataList.add(photoContent);
        }
        if (dataList == null || dataList.size() < 3) {
            throw  new Exception("list'size must be more than 3");
        }
        mContentview.initCardView(this,R.layout.sliding_card_item,R.id
                .sliding_card_content_view);
    }
    @Override
    protected int getLayout() {
        return R.layout.fragment_cardview_one;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((CardViewActivity)getActivity()).registerMyTouchListener(myTouchListener);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((CardViewActivity)getActivity()).unRegisterMyTouchListener(myTouchListener);
    }

    @Override
    public void initCard(SlidingCard card, int index) {
        ImageView mImageView = (ImageView) card.findViewById(R.id.user_imageview);
        TextView mTextView = (TextView) card.findViewById(R.id.user_text);
        if (dataList.get(index) != null) {
            mTextView.setText(dataList.get(index).getTitle());
            mImageView.setImageResource(getResourceByReflect(dataList.get(index).getUrl()));
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),dataList.get(0).getTitle(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public void exChangeCard() {
        PhotoContent photoContent = dataList.get(0);
        dataList.remove(0);
        dataList.add(photoContent);
    }

    public int getResourceByReflect(String imageName) {
        Class drawable = R.drawable.class;
        Field field;
        int r_id;
        try {
            field = drawable.getField(imageName);
            r_id = field.getInt(field.getName());
        } catch (NoSuchFieldException e) {
            r_id = R.drawable.img1;
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            r_id = R.drawable.img1;
            e.printStackTrace();
        }
        return r_id;
    }

    public boolean isRangeOfView(View view,MotionEvent ev) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        if (ev.getX() < x || ev.getX() > (x + view.getWidth()) || ev.getY() < y || ev.getY() > (y + view.getHeight())){
            return false;
        }
        return true;
    }
}
