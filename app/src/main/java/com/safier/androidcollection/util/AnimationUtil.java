package com.safier.androidcollection.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
/**
 * 动画相关工具类
 * @author safier
 * @date 2019/3/8
 */

public class AnimationUtil {


    /*以自身为轴做旋转*/
    public static ObjectAnimator rotateAnimation(View view, int duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", values);
        animator.setDuration(duration);
        animator.setInterpolator(new LinearInterpolator());
        return animator;
    }

    /*无限旋转*/
    @SuppressLint("WrongConstant")
    public static ObjectAnimator rotateAnimationRepeat(View view, int duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", values);
        animator.setDuration(duration);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatMode(ValueAnimator.INFINITE);
        return animator;
    }

    /*以Y轴做旋转*/
    public static ObjectAnimator rotateYAnimation(View view, int duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotationY", values);
        animator.setDuration(duration);
        animator.setInterpolator(new LinearInterpolator());
        return animator;
    }

    /*透明度变化*/
    public static ObjectAnimator alphaAnimation(View view, int duration, float... values) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", values);
        alpha.setDuration(duration);
        return alpha;
    }

    public static AnimatorSet rotateAlphaAnimatorSet(View view, int animTime) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimator = rotateAnimation(view, animTime, 0.0f, -180.0f);
        ObjectAnimator objectAnimator1 = alphaAnimation(view, animTime, 1.0f, 0.0f);
        animatorSet.play(objectAnimator).with(objectAnimator1);
        return animatorSet;
    }


    /**
     * 从控件所在位置移动到控件的底部
     *
     * @return
     */
    public static TranslateAnimation moveToViewBottom(long ms) {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        mHiddenAction.setDuration(ms);
        return mHiddenAction;
    }

    /**
     * 从控件的底部移动到控件所在位置
     *
     * @return
     */
    public static TranslateAnimation moveToViewLocation(long ms) {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mHiddenAction.setDuration(ms);
        return mHiddenAction;
    }

}
