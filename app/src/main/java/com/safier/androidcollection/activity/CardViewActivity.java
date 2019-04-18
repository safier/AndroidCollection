package com.safier.androidcollection.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.safier.androidcollection.fragment.card_view.CardViewOneFragment;
import com.vondear.rxui.activity.ActivityBase;

import java.util.ArrayList;

/**
 * @author safier
 * @date 2019/4/18
 */
public class CardViewActivity extends BaseActivity {

   private ArrayList<MyTouchListener> myTouchListeners = new ArrayList<>();
    @Override
    protected void initFragments() {
        mFragments.add(new CardViewOneFragment());
    }


    /**
     * 提供给Fragment通过getActivity()方法来注册自己的触摸事件的方法
     */
    public void registerMyTouchListener(MyTouchListener listener) {
        myTouchListeners.add(listener);
    }


    /**
     * 提供给Fragment通过getActivity()方法来取消注册自己的触摸事件的方法
     */
    public void unRegisterMyTouchListener(MyTouchListener listener) {
        myTouchListeners.remove(listener);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        for(MyTouchListener listener : myTouchListeners) {
            if (listener != null) {
                viewpage.setIsCanScroll(listener.onTouchEvent(ev));
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public interface MyTouchListener {
       boolean onTouchEvent(MotionEvent event);
    }
}
