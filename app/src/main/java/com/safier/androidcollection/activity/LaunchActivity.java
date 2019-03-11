package com.safier.androidcollection.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.safier.androidcollection.R;
import com.safier.androidcollection.util.AnimationUtil;
import com.safier.androidcollection.util.JumpUtil;

import java.lang.ref.WeakReference;

/**
 * @author safier
 * @date 2019/3/8
 */
public class LaunchActivity extends AppCompatActivity {

    private ImageView mIvLaunch;
    public static final int DURATION = 4000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        mIvLaunch = findViewById(R.id.iv_launch);
        AnimationUtil.alphaAnimation(mIvLaunch,DURATION,0.2f,1.0f).start();
        jumpToHome();
    }

    private void jumpToHome() {
        new MyHandler(this).sendEmptyMessageDelayed(0,DURATION);
    }

    static class MyHandler extends Handler {
        WeakReference<Activity> mWeakReference;
        public MyHandler(Activity activity)
        {
            mWeakReference=new WeakReference<Activity>(activity);
        }
        @Override
        public void handleMessage(Message msg)
        {
            final Activity activity=mWeakReference.get();
            if(activity!=null)
            {
                JumpUtil.jumpHome(activity);
                activity.finish();
            }
        }
    }
}
