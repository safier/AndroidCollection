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
public class EditTextActivity extends ActivityBase {

    public static final String TAG = "EditTextActivity";
    private ViewPager viewpage;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private EditTextAdapter editTextAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        viewpage = (ViewPager)findViewById(R.id.viewpage);
        EditTextOneFragment editTextOneFragment = new EditTextOneFragment();
        EditTextTwoFragment editTextTwoFragment = new EditTextTwoFragment();
        mFragments.add(editTextOneFragment);
        mFragments.add(editTextTwoFragment);
        editTextAdapter = new EditTextAdapter(getSupportFragmentManager());
        if (viewpage == null) {
            Log.e(TAG," viewpage == null");
            return;
        }
        if (editTextAdapter == null) {
            Log.e(TAG,"editTextAdapter == null");
            return;
        }
        viewpage.setAdapter(editTextAdapter);
    }

    public class EditTextAdapter extends FragmentPagerAdapter {


        public EditTextAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
