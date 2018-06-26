package com.limbo.sdk_demo.util;

import android.app.Activity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.limbo.sdk_demo.YunNa;
import com.limbo.sdk_demo.retrofit.RRetrofit;

/**
 * Created by wangqi on 2018/5/16.
 */

public class YunUtils {

    public static void setNetImage(String url, ImageView iv){
        Glide.with(YunNa.mContext).load((YunNa.mType== YunNa.YUN_TYPE.TYPE_CUSTOMER?
                RRetrofit.CUSTOMER_FILE_URL:RRetrofit.SERVICE_FILE_URL)+url).centerCrop().into(iv);
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public static void backgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }
}
