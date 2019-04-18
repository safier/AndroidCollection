package com.safier.androidcollection.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.safier.androidcollection.R;
import com.safier.androidcollection.view.SlideViewPager;
import com.vondear.rxui.activity.ActivityBase;

import java.util.ArrayList;

/**
 * @author safier
 * @date 2019/4/18
 */
public abstract class BaseActivity extends ActivityBase {

    public  final String TAG = this.getClass().getSimpleName();
    public SlideViewPager viewpage;
    public ArrayList<Fragment> mFragments = new ArrayList<>();
    public MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        viewpage = (SlideViewPager)findViewById(R.id.viewpage);
        initFragments();
        if (mFragments != null && mFragments.size() > 0) {
            myAdapter = new MyAdapter(getSupportFragmentManager());
            viewpage.setAdapter(myAdapter);
        }
    }

    protected abstract void initFragments();

    public class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(FragmentManager fm) {
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
