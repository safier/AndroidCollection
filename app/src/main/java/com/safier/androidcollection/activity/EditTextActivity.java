package com.safier.androidcollection.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.safier.androidcollection.R;
import com.safier.androidcollection.fragment.edittext.EditTextOneFragment;
import com.safier.androidcollection.fragment.edittext.EditTextTwoFragment;
import com.vondear.rxui.activity.ActivityBase;

import java.util.ArrayList;

/**
 * @author safier
 * @date 2019/4/3
 */
public class EditTextActivity extends BaseActivity {

    @Override
    protected void initFragments() {
        EditTextOneFragment editTextOneFragment = new EditTextOneFragment();
        EditTextTwoFragment editTextTwoFragment = new EditTextTwoFragment();
        mFragments.add(editTextOneFragment);
        mFragments.add(editTextTwoFragment);
    }


}
