package com.safier.androidcollection.activity;

import android.os.Bundle;

import com.safier.androidcollection.fragment.card_view.CardViewOneFragment;
import com.vondear.rxui.activity.ActivityBase;

/**
 * @author safier
 * @date 2019/4/18
 */
public class CardViewActivity extends BaseActivity {


    @Override
    protected void initFragments() {
        mFragments.add(new CardViewOneFragment());
    }
}
