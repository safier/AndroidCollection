package com.safier.androidcollection.util;

import android.content.Context;
import android.content.Intent;

import com.safier.androidcollection.activity.HomeActivity;

/**
 * @author safier
 * @date 2019/3/11
 */
public class JumpUtil {

    public static void jumpHome(Context context) {
        context.startActivity(new Intent(context, HomeActivity.class));
    }
}
