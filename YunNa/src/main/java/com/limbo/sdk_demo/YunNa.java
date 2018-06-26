package com.limbo.sdk_demo;

import android.content.Context;

import com.limbo.sdk_demo.bean.LoginBean;
import com.limbo.sdk_demo.inter.NetworkImp;
import com.limbo.sdk_demo.inter.ResultCallback;
import com.limbo.sdk_demo.manager.NetworkManager;

import java.io.File;
import java.util.Map;

/**
 * Created by wangqi on 2018/5/4.
 */

public class YunNa {

    // 实时存储的变量
    public static YUN_TYPE mType;
    public static Context mContext;
    public static LoginBean mLoginBean;

    // 私有 成员变量
    private static YunNa instance;
    private static NetworkImp networkImp;

    private YunNa() {
        if (YunNa.mType == null || YunNa.mContext == null) {
            throw new IllegalArgumentException("YunNa未初始化成功！请检查代码。");
        }
    }

    public static YunNa getInstance() {
        synchronized (YunNa.class) {
            if (instance == null) {
                instance = new YunNa();
            }
        }
        return instance;
    }

    /**
     * YunNa初始化
     */
    public static void init(Context context) {
        mContext = context;
        networkImp = new NetworkManager();
    }

    /**
     * 连接数据
     *
     * @param mobile
     * @param password
     * @param type     类型
     */
    public static void connect(String mobile, String password, YUN_TYPE type, ResultCallback<String> connectCallback) {
        mType = type;
        networkImp.connect(mobile, password, connectCallback);
    }


    /**
     * @param ownerAppKey      业主key
     * @param ownerAppSectet   业主Sectet
     * @param serviceAppKey    服务商key
     * @param serviceAppSectet 服务商Sectet
     * @param checkCallBack
     */
    public static void checkSdkSectet(String ownerAppKey, String ownerAppSectet, String serviceAppKey, String serviceAppSectet, ResultCallback<String> checkCallBack) {
        networkImp.checkSdkSectet(ownerAppKey, ownerAppSectet, serviceAppKey, serviceAppSectet, checkCallBack);
    }

    /**
     * 获取发起企业列表
     *
     * @param getCompanyCallback
     */
    public void getSendCompanyList(ResultCallback<String> getCompanyCallback) {
        networkImp.getSendCompanyList(getCompanyCallback);
    }

    /**
     * 获取处理企业列表
     *
     * @param getCompanyCallback
     */
    public void getReceiveCompanyList(ResultCallback<String> getCompanyCallback) {
        networkImp.getReceiveCompanyList(getCompanyCallback);
    }


    /**
     * 获取发起人
     *
     * @param ownerCompanyCode 发起企业code
     * @param resultCallback
     */
    public void getSendPersonList(String ownerCompanyCode, ResultCallback<String> resultCallback) {
        networkImp.getSendPersonList(ownerCompanyCode, resultCallback);
    }

    /**
     * 获取sla时间
     *
     * @param resultCallback
     */
    public void getSlaList(ResultCallback<String> resultCallback) {
        networkImp.getSlaList(resultCallback);
    }

    /**
     * 上传图片
     *
     * @param file           图片文件
     * @param resultCallback
     */
    public void uploadImg(File file, ResultCallback<String> resultCallback) {
        networkImp.uploadImg(file, resultCallback);
    }

    /**
     * @param companyCode    若当前为业主 则是处理企业code
     *                       若当前为服务商 则是发起企业code
     * @param sendUserId     发起人id，业主端可不传
     * @param levelId        故障等级id
     * @param days           SLA 天数
     * @param hours          SLA 小时
     * @param outsourceFlag  是否为外协工单 服务端可不传
     * @param title          简要内容
     * @param filenames      附件名称 多个以,隔开
     * @param attachPath     附件链接 多个以,隔开
     * @param attachSize     附件大小 多个以,隔开
     * @param resultCallback
     */
    public void sendWokrOrder(String companyCode, String sendUserId, String levelId, String days, String hours, String outsourceFlag,
                              String title, String filenames, String attachPath, String attachSize, String appkey,String secret ,ResultCallback<String> resultCallback) {
        networkImp.sendWorkOrder(companyCode, sendUserId, levelId, days, hours, outsourceFlag, title, filenames, attachPath, attachSize,  appkey, secret , resultCallback);
    }

    public void sendWokrOrder(Map<String, String> map, ResultCallback<String> resultCallback) {
        networkImp.sendWorkOrder(map, resultCallback);
    }


    public enum YUN_TYPE {
        TYPE_CUSTOMER, //业主
        TYPE_SERVICE  // 服务商
    }
}
